package com.pi.MinuteBrico.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.pi.MinuteBrico.models.AppUser;
import com.pi.MinuteBrico.services.AppUserService;


@RestController
public class UserController {

	@Autowired
	private AppUserService userService;

	@GetMapping("/user")
	public List<AppUser> index(@RequestParam(value = "search", required = false) String searchText) {
		if (searchText == null) {
			return userService.findAll();
		}
		return userService.findBySearch(searchText);
	}
	
	
	@CrossOrigin()
	@PutMapping("/user/{id}")
	public AppUser update(@PathVariable String id, @RequestBody Map<String, String> body) {
		Long userId = Long.parseLong(id);
		Optional<AppUser> user = userService.findById(userId);
		if (user.isPresent()) {
			AppUser appUser = user.get();
			appUser.setFirstName(body.get("firstName"));
			appUser.setLastName(body.get("lastName"));
			appUser.setPassword(body.get("password"));

			return userService.saveUser(appUser);
		}
		return null;
	}

	
	
	@CrossOrigin()
	@PostMapping("/signIn")
	public AppUser signIn(@RequestBody Map<String, Object> userInfo) {
		Optional<AppUser> user = userService.findUserByEmailAndPassword(userInfo.get("email").toString(),
				userInfo.get("password").toString());
		if (user.isPresent()) {
			return user.get();
			//return "is registred";
		}
		//return "not registred";
		return null;
	}
	
}
