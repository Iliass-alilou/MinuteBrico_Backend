package com.pi.MinuteBrico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pi.MinuteBrico.models.Bricoleur;

import java.util.List;
import java.util.Optional;


public interface BricoleurRepository extends JpaRepository<Bricoleur, Long> {

	Optional<Bricoleur> findById(int id);
	List<Bricoleur> findByEmailContainingOrFirstNameContainingOrLastNameContaining(String email, String firstName,String lastName);
}
