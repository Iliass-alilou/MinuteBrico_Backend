package com.pi.MinuteBrico.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pi.MinuteBrico.models.AppUser;

import com.pi.MinuteBrico.services.AppUserService;


@RestController
@CrossOrigin
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
	
	
	/*@CrossOrigin()
	@PostMapping("/user")
	public String create(@RequestBody Map<String, Object> userMap) {
		System.out.println(userMap);
		User user = new User(userMap);
		userService.saveUser(user);
		return "Utilisateur ajouté";

	}*/

	/*@CrossOrigin()
	@PostMapping("/signIn")
	public AppUser signIn(@RequestBody Map<String, Object> userInfo) {
		Optional<AppUser> user = userService.findUserByEmailAndPassword(userInfo.get("email").toString(),
				userInfo.get("password").toString());
		if (user.isPresent()) {
			return user.get();
		}
		return null;

	}*/
}
