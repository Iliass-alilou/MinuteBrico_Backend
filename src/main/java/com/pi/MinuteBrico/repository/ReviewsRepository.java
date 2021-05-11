package com.pi.MinuteBrico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pi.MinuteBrico.models.Reviews;

@Repository
public interface ReviewsRepository extends JpaRepository<Reviews, Long> {

	/**
	 *@author iliass Alilou
	 */
}
