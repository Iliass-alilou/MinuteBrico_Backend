package com.pi.MinuteBrico.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pi.MinuteBrico.models.Bricoleur;
import com.pi.MinuteBrico.services.BricoleurService;


@RestController
public class BricoleurController {
	/**
	 * @author iliass Alilou
	 */

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
	public String create(@RequestBody /*Map<String, Object> bricoleurMap*/ Bricoleur bricoleur) {
		//System.out.println(bricoleurMap);
		//Bricoleur bricoleur = new Bricoleur(bricoleurMap);
		bricoleurService.saveBricoleur(bricoleur);
		return "Bricoleur ajouté";

	}
	
	
	@CrossOrigin()
	@PutMapping("/bricoleur/{id}")
	public Bricoleur update(@PathVariable String id, @RequestBody Bricoleur body) {
		Long bricoleurId = Long.parseLong(id);
		Optional<Bricoleur> bricoleur = bricoleurService.findById(bricoleurId);
		if (bricoleur.isPresent()) {
			Bricoleur b = bricoleur.get();
			b.setPhoto(body.getPhoto());
			b.setEmail(body.getEmail());
			b.setPassword(body.getPassword());
			b.setFirstName(body.getFirstName());
			b.setLastName(body.getLastName());
			b.setBirthDate(body.getBirthDate());
			b.setPhone(body.getPhone());
			b.setAdresse(body.getAdresse());
			b.setToken(body.getToken());
			b.setDescriptionProfil(body.getDescriptionProfil());
			
			b.setCategory(body.getCategory());
			b.setCertifications(body.getCertifications());
			b.setDiplomes(body.getDiplomes());
			b.setLangues(body.getLangues());
			b.setReviewsOnBrico(body.getReviewsOnBrico());

			return bricoleurService.saveBricoleur(b);
		}
		return null;
	}
	@CrossOrigin()
	@PutMapping("/bricoleurup/{token}")
	public Bricoleur updateadd(@PathVariable String token, @RequestBody Bricoleur body) {
		Optional<Bricoleur> bricoleur = bricoleurService.findByToken(token);
		if (bricoleur.isPresent()) {
			Bricoleur b = bricoleur.get();
			b.setPhoto(body.getPhoto());
			b.setFirstName(body.getFirstName());
			b.setLastName(body.getLastName());
			b.setAdresse(body.getAdresse());
			b.setLangues(body.getLangues());

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
