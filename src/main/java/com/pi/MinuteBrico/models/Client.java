package com.pi.MinuteBrico.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class Client {

	@Id
	private int clientID;
	private String birthday ;
	
	
	//private final AppUser user;
	
}
