package com.pi.MinuteBrico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pi.MinuteBrico.models.Bricoleur;

import java.util.List;
import java.util.Optional;

@Repository
public interface BricoleurRepository extends JpaRepository<Bricoleur, Long> {
	Optional<Bricoleur> findByToken(String token);
	Optional<Bricoleur> findById(int id);
	List<Bricoleur> findByEmailContainingOrFirstNameContainingOrLastNameContaining(String email, String firstName,String lastName);
}
