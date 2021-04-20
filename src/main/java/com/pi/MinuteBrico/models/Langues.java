package com.pi.MinuteBrico.models;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Langue")
public class Langues {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String name_language;
	private String niveau;
	
	
	public Langues(Map<String,Object> langeMap) {
		if (langeMap.get("id") != null)	
			
		this.Id = (int )langeMap.get("Id");
		this.name_language = (String) langeMap.get("name_language");
		this.niveau = (String) langeMap.get("niveau");
		
		
		
	}
	
	public Langues() {
		
	}
	
	public Langues(String name_language,
			       String niveau) {
		super();
		this.name_language = name_language;
		this.niveau = niveau;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName_language() {
		return name_language;
	}

	public void setName_language(String name_language) {
		this.name_language = name_language;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	
	
	
}
