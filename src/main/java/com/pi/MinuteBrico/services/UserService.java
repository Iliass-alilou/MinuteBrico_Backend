/*package com.pi.MinuteBrico.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.pi.MinuteBrico.models.AppUser;
import com.pi.MinuteBrico.repository.UserRepository;


@Service
@Transactional
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	public List<AppUser> findAll() {
		return  userRepository.findAll();
	}
	public List<AppUser> findBySearch(String searchText) {
		return userRepository.findByEmailContainingOrFirstNameContainingOrLastNameContaining(searchText,searchText,searchText);
	}
	public AppUser saveUser(AppUser user) {
		return userRepository.save(user);
	}
	public Optional<AppUser> findUserByEmailAndPassword(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}
}*/
