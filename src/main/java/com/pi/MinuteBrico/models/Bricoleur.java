package com.pi.MinuteBrico.models;

import java.util.Map;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;




@Entity
@Table(name = "Bricoleur")
public class Bricoleur implements Serializable  {

	/**
	 *@author iliass Alilou
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String photo;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String phone;
	private String birthDate;
	private String adresse;
	
	@OneToMany(/*fetch = FetchType.LAZY , targetEntity = Category.class,*/ cascade = CascadeType.ALL)
	@JoinColumn(name = "Category_Bricoleur",referencedColumnName = "id")
	private List<Category> category ;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "Certification_Bricoleur",referencedColumnName = "id")
	private List<Certification> certifications;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "diplomes_Bricoleur",referencedColumnName = "id")
	private List<Diplomes> diplomes;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "langues_Bricoleur",referencedColumnName = "id")
	private List<Langues> langues;
	
	

	public Bricoleur() {
		
	}
	public Bricoleur(String photo,
					 String firstName, 
					 String lastName, 
					 String email, 
					 String phone, 
					 String birthDate,
					 String adresse,
					 String password
			         ) {
		super();
		this.photo = photo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.birthDate = birthDate;
		this.adresse = adresse;
		this.password=password;
	}


	/*public Bricoleur(Map<String,Object> bricoleurMap) {
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
		this.category=(List<Category>)bricoleurMap.get("category");
	}*/
	
	public Bricoleur(Bricoleur bricoleurMap) {
		super();

		if (bricoleurMap.getId() != null)
			
		this.id = (Long)bricoleurMap.getId();
		this.photo = (String) bricoleurMap.getPhoto();
		this.firstName = (String) bricoleurMap.getFirstName();
		this.lastName = (String) bricoleurMap.getLastName();
		this.email = (String) bricoleurMap.getEmail();
		this.phone = (String) bricoleurMap.getPhone();		
		this.birthDate = (String) bricoleurMap.getBirthDate();		
		this.adresse = (String) bricoleurMap.getAdresse();
		this.password=(String)bricoleurMap.getPassword();
		
		this.category=(List<Category>)bricoleurMap.getCategory();
		this.certifications=(List<Certification>)bricoleurMap.getCertifications();
		this.diplomes=(List<Diplomes>)bricoleurMap.getDiplomes();
		this.langues=(List<Langues>)bricoleurMap.getLangues();
	
	}
	
	
	
	
	
	public List<Langues> getLangues() {
		return langues;
	}
	public void setLangues(List<Langues> langues) {
		this.langues = langues;
	}
	
	public List<Diplomes> getDiplomes() {
		return diplomes;
	}
	public void setDiplomes(List<Diplomes> diplomes) {
		this.diplomes = diplomes;
	}
	public List<Certification> getCertifications() {
		return certifications;
	}
	public void setCertifications(List<Certification> certifications) {
		this.certifications = certifications;
	}
	public List<Category> getCategory() {
		return category;
	}



	public void setCategory(List<Category> category) {
		this.category = category;
	}

	


	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
		return "Bricoleur [id=" + id + ", password=" + password + ", photo=" + photo + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", phone=" + phone + ", birthDate=" + birthDate
				+ ", adresse=" + adresse + ", category=" + category + ", certifications=" + certifications
				+ ", diplomes=" + diplomes + ", langues=" + langues + "]";
	}


	
	
}
