package com.pi.MinuteBrico.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pi.MinuteBrico.models.AppUser;
import com.pi.MinuteBrico.models.Reviews;
import com.pi.MinuteBrico.services.ReviewsService;

@RestController
public class ReviewsController {

	/**
	 *@author iliass Alilou
	 */
	@Autowired
	private ReviewsService reviewsService;
	
	@CrossOrigin()
	@PostMapping("/Review_on_Brico")
	public String create(@RequestBody  Reviews review) {
		reviewsService.saveReview(review);
		return "Review ajouté";
	}
	@CrossOrigin
	@GetMapping("/Review_on_Brico")
	public List<Reviews> index(@RequestParam(value = "search", required = false) String searchText) {
		return reviewsService.findAll();
		
		/*if (searchText == null) {
			return reviewsService.findAll();
		}
		return reviewsService.findBySearch(searchText);*/
	}
	
}
