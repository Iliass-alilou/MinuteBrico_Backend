package com.pi.MinuteBrico.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pi.MinuteBrico.models.Bricoleur;
import com.pi.MinuteBrico.services.BricoleurService;


@RestController
public class BricoleurController {

	@Autowired
	private BricoleurService bricoleurService;

	// ! @route GET /user?search=iliass
	// ! @desc returns all users, and search by email if search param provided
	// ! @access public
	@CrossOrigin()
	@GetMapping("/bricoleur")
	public List<Bricoleur> index(@RequestParam(value = "search", required = false) String searchText) {
		if (searchText == null) {
			return bricoleurService.findAll();
		}
		return bricoleurService.findBySearch(searchText);

	}
	

	@CrossOrigin()
	@GetMapping("/bricoleur/{id}")
	public Optional<Bricoleur> userById(@PathVariable String id) {
		Long bricoleurId = Long.parseLong(id);
		return bricoleurService.findById(bricoleurId);
	}
	
	@CrossOrigin()
	@PostMapping("/bricoleur")
	public String create(@RequestBody Map<String, Object> bricoleurMap) {
		System.out.println(bricoleurMap);
		Bricoleur bricoleur = new Bricoleur(bricoleurMap);
		bricoleurService.saveBricoleur(bricoleur);
		return "Bricoleur ajouté";

	}
	
	// ! @route PUT /bricoleur/id
		// ! @desc modifies user in database. Body parameters needed :
		// email, firstname, lastname, age, password, role
		// ! @access public
		@CrossOrigin()
		@PutMapping("/bricoleur/{id}")
		public Bricoleur update(@PathVariable String id, @RequestBody Map<String, String> body) {
			Long bricoleurId = Long.parseLong(id);
			Optional<Bricoleur> bricoleur = bricoleurService.findById(bricoleurId);
			if (bricoleur.isPresent()) {
				Bricoleur b = bricoleur.get();
				b.setPhoto(body.get("photo"));
				b.setEmail(body.get("email"));
				b.setFirstName(body.get("firstName"));
				b.setLastName(body.get("lastName"));
				b.setBirthDate(body.get("birthDate"));
				b.setPhone(body.get("phone"));
				b.setAdresse(body.get("adresse"));

				return bricoleurService.saveBricoleur(b);
			}
			return null;
		}
		
		// ! @route DELETE /user/id
		// ! @desc deletes user with param id
		// ! @access public
		@CrossOrigin()
		@DeleteMapping("bricoleur/{id}")
		public boolean delete(@PathVariable String id) {
			Long bricoleurId = Long.parseLong(id);
			return bricoleurService.deleteById(bricoleurId);
		}
	
}