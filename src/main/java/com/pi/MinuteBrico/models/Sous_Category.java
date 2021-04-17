package com.pi.MinuteBrico.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SousCategory")
public class Sous_Category {
	
	 @Id
	 @GeneratedValue
	 private int id;
	 private String name;
}
