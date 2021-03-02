package com.pi.MinuteBrico.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pi.MinuteBrico.models.User;
import com.pi.MinuteBrico.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	@CrossOrigin()
	@GetMapping("/user")
	public List<User> index(@RequestParam(value = "search", required = false) String searchText) {
		if (searchText == null) {
			return userService.findAll();
		}
		return userService.findBySearch(searchText);
	}
	
	@CrossOrigin()
	@PostMapping("/user")
	public String create(@RequestBody Map<String, Object> userMap) {
		System.out.println(userMap);
		User user = new User(userMap);
		userService.saveUser(user);
		return "Utilisateur ajouté";

	}

	@CrossOrigin()
	@PostMapping("/signIn")
	public User signIn(@RequestBody Map<String, Object> userInfo) {
		Optional<User> user = userService.findUserByEmailAndPassword(userInfo.get("email").toString(),
				userInfo.get("password").toString());
		if (user.isPresent()) {
			return user.get();
		}
		return null;

	}
}
