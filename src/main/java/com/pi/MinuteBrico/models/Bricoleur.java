package com.pi.MinuteBrico.models;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Bricoleur")
public class Bricoleur  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SequenceGenerator(
            name = "Bricoleur_sequence",
            sequenceName = "Bricoleur_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Bricoleur_sequence"
    )
	private Long id; 
	
	//sera de type Byte just for testing post man now
	private String photo;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String birthDate;
	private String adresse;
	
	// private Certification certification;
	// private Diplomes diplomes;
	// private Langues langues;
	
	

	public Bricoleur() {
		
	}


	public Bricoleur(String photo,
			         String firstName,
			         String lastName,
			         String email,
			         String phone,
			         String birthDate,
			         String adresse) {
		super();
		this.photo = photo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.birthDate = birthDate;
		this.adresse = adresse;
	}

	
	
	
	public Bricoleur(Map<String,Object> bricoleurMap) {
		super();

		if (bricoleurMap.get("id") != null)
			
		this.id = (Long)bricoleurMap.get("id");
		this.photo = (String) bricoleurMap.get("photo");
		this.firstName = (String) bricoleurMap.get("firstName");
		this.lastName = (String) bricoleurMap.get("lastName");
		this.email = (String) bricoleurMap.get("email");
		this.phone = (String) bricoleurMap.get("phone");		
		this.birthDate = (String) bricoleurMap.get("birthDate");		
		this.adresse = (String) bricoleurMap.get("adresse");
	}
	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}



	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Bricoleur [id=" + id + ", photo=" + photo + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", phone=" + phone + ", birthDate=" + birthDate + ", adresse=" + adresse + "]";
	}


	

	
}
