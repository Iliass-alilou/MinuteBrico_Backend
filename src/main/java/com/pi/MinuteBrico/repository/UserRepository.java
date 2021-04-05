package com.pi.MinuteBrico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pi.MinuteBrico.models.AppUser;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<AppUser, Long> {
	Optional<AppUser> findByEmailAndPassword(String email, String password);
	Optional<AppUser> findById(int id);
	List<AppUser> findByEmailContainingOrFirstNameContainingOrLastNameContaining(String email, String firstName,String lastName);


}
