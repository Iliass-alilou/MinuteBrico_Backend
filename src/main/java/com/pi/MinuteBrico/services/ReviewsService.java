package com.pi.MinuteBrico.services;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.pi.MinuteBrico.models.Reviews;
import com.pi.MinuteBrico.repository.ReviewsRepository;

@Service
@Transactional
public class ReviewsService {

	/**
	 *@author iliass Alilou
	 */
	
	private final ReviewsRepository reviewsRepository;
	

	public ReviewsService(ReviewsRepository reviewsRepository) {
		super();
		this.reviewsRepository = reviewsRepository;
	}

	

	public Reviews saveReview(Reviews review) {
		return reviewsRepository.save(review);
		
	}
	
	
}
