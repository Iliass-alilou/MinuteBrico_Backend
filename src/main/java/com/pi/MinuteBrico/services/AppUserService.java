package com.pi.MinuteBrico.services;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pi.MinuteBrico.models.AppUser;
import com.pi.MinuteBrico.models.Bricoleur;
import com.pi.MinuteBrico.registration.token.ConfirmationToken;
import com.pi.MinuteBrico.registration.token.ConfirmationTokenService;
import com.pi.MinuteBrico.repository.AppUserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AppUserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG =
            "user with email %s not found";

    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    
    public AppUserService(AppUserRepository appUserRepository, BCryptPasswordEncoder bCryptPasswordEncoder,
			ConfirmationTokenService confirmationTokenService) {
		super();
		this.appUserRepository = appUserRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.confirmationTokenService = confirmationTokenService;
	}

	@Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                String.format(USER_NOT_FOUND_MSG, email)));
    }

    public String signUpUser(AppUser appUser) {
        boolean userExists = appUserRepository
                .findByEmail(appUser.getEmail())
                .isPresent();

        if (userExists) {
            // TODO check of attributes are the same and
            // TODO if email not confirmed send confirmation email.

            throw new IllegalStateException("email already taken");
        }

       /*String encodedPassword = bCryptPasswordEncoder
                .encode(appUser.getPassword());*/
        
        String encodedPassword = appUser.getPassword();

        appUser.setPassword(encodedPassword);

        appUserRepository.save(appUser);

        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                appUser
        );

        confirmationTokenService.saveConfirmationToken(
                confirmationToken);

//        TODO: SEND EMAIL

        return token;
    }
    
    

    public int enableAppUser(String email) {
        return appUserRepository.enableAppUser(email);
    }
    
    
    // all methodes that will be aplicated on users
    
    public List<AppUser> findAll() {
		return  appUserRepository.findAll();
	}
    
    public List<AppUser> findBySearch(String searchText) {
		return appUserRepository.findByEmailContainingOrFirstNameContainingOrLastNameContaining(searchText,searchText,searchText);
	}

	public Optional<AppUser> findUserByEmailAndPassword(String email, String password) {
		return appUserRepository.findByEmailAndPassword(email, password);
	}
	
	public Optional<AppUser> findById(Long id) {
		return appUserRepository.findById(id);
	}
	   
	public AppUser saveUser(AppUser user) {
		return appUserRepository.save(user);
	}
}

