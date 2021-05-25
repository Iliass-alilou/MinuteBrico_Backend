package com.pi.MinuteBrico.models;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Category")
public class Category implements Serializable {
	/**
	 * @author iliass Alilou
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCtegory;    
	private String name;
	
	public Category() {
		
		
	}
	
	public Category(String name) {
		super();
		this.name = name;
	}



	public Long getId() {
		return idCtegory;
	}

	public void setId(Long id) {
		this.idCtegory = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Category [id=" + idCtegory + ", name=" + name + "]";
	}
	
}
