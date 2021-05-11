package com.pi.MinuteBrico.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
