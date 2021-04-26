package com.pi.MinuteBrico.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.pi.MinuteBrico.models.Bricoleur;
import com.pi.MinuteBrico.repository.BricoleurRepository;

@Service
@Transactional
public class BricoleurService {

	private final BricoleurRepository bricoleurRepository;
	
	
	public BricoleurService(BricoleurRepository bricoleurRepository) {
		super();
		this.bricoleurRepository = bricoleurRepository;
	}


	public List<Bricoleur> findAll() {
		return  bricoleurRepository.findAll();
	}
	
	public List<Bricoleur> findBySearch(String searchText) {
		return bricoleurRepository.findByEmailContainingOrFirstNameContainingOrLastNameContaining(searchText,searchText,searchText);
	}
	
	public Optional<Bricoleur> findById(Long id) {
		return bricoleurRepository.findById(id);
	}

	public Optional<Bricoleur> findByToken(String token) {
		return bricoleurRepository.findByToken(token);
	}
	
	public Bricoleur saveBricoleur(Bricoleur bricoleur) {
		return bricoleurRepository.save(bricoleur);
	}
	
	public boolean deleteById(Long id) {
		try {
			bricoleurRepository.deleteById(id);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

}
