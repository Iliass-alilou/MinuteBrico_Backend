package com.pi.MinuteBrico.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;


@Entity
@Table(name="users")
public class AppUser implements Serializable ,UserDetails {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SequenceGenerator(
            name = "client_sequence",
            sequenceName = "client_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "client_sequence"
    )
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private AppUserRole appUserRole;
    
    
    private Boolean locked = false;
    private Boolean enabled = false;

    public AppUser(String firstName,
                   String lastName,
                   String email,
                   String password,
                   AppUserRole appUserRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.appUserRole = appUserRole;
    }
    
    public AppUser() {
    	
    }
    
    
    //Modification 
    public AppUser(Map<String,Object> userMap) {
		super();

		if (userMap.get("id") != null)
			
		this.id = (Long)userMap.get("id");
		this.firstName = (String) userMap.get("firstName");
		this.lastName = (String) userMap.get("lastName");
		this.email = (String) userMap.get("email");
		this.password = (String) userMap.get("password");		
		
	}
    
    
    
    

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority =
                new SimpleGrantedAuthority(appUserRole.name());
        return Collections.singletonList(authority);
    }
    
    
   
    
    public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	@Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

	public void setPassword(String password) {
		this.password = password;
	}

	

	@Override
	public String toString() {
		return "AppUser [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", appUserRole=" + appUserRole + ", locked=" + locked + ", enabled="
				+ enabled + "]";
	}

	
	
    
}
