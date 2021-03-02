package com.pi.MinuteBrico.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.pi.MinuteBrico.models.User;
import com.pi.MinuteBrico.repository.UserRepository;

@Service
@Transactional
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	public List<User> findAll() {
		return  userRepository.findAll();
	}
	public List<User> findBySearch(String searchText) {
		return userRepository.findByEmailContainingOrFirstNameContainingOrLastNameContaining(searchText,searchText,searchText);
	}
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	public Optional<User> findUserByEmailAndPassword(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}
}
