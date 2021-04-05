package com.pi.MinuteBrico.models;

import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="missions")
public class Mission {

	//penser ici a generer des sequences
	
	
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int id;
		private String title;
		private String state;
		private String adresse;
		private int etatMission;
		private String image;
		private int duree;
		private String description;
		private String domaine;
		private String ville;
		
		/* @ManyToOne
		 @JoinColumn(
		            nullable = false,
		            name = "app_user_id"
		    )
		private AppUser appUser;*/
		
	    public Mission() {
			
		}
	    
	    public Mission(int id,String description,int etatMission,String state,int Duree,String domaine,String ville,String adresse,String title /*,AppUser appUser*/) {
			setId(id);
			setDescription(description);
			setState(state);
			setDuree(Duree);
			setDomaine(domaine);
			setVille(ville);
			setAdresse(adresse);
			setEtatMission(etatMission);
			setImage(image);
			setTitle(title);
			//setAppUser(appUser);
		}
	    
	    public Mission(Map<String,Object> userMap) {
			if (userMap.get("id") != null)	
				
			this.id = (int )userMap.get("id");
			this.state = (String) userMap.get("state");
			this.duree = (int) userMap.get("duree");
			this.domaine = (String) userMap.get("domaine");
			this.description = (String) userMap.get("description");
			this.ville=(String) userMap.get("ville");
			this.adresse=(String) userMap.get("adresse");
			this.etatMission=(int) userMap.get("etatMission");
			this.image=(String) userMap.get("image");
			this.title=(String) userMap.get("title");
			//this.appUser=(AppUser)userMap.get("appUser");
		}
		


	    //getters and setters
	    
            
	    
		public String getImage() {
			return image;
		}
		/*public AppUser getAppUser() {
			return appUser;
		}

		public void setAppUser(AppUser appUser) {
			this.appUser = appUser;
		}*/

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public void setImage(String image) {
			this.image = image;
		}
		
		public int getEtatMission() {
			return etatMission;
		}
		public void setEtatMission(int etatMission) {
			this.etatMission = etatMission;
		}
			
		
		public String getDomaine() {
			return domaine;
		}
		public void setDomaine(String domaine) {
			this.domaine = domaine;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getAdresse() {
			return adresse;
		}
		public void setAdresse(String adresse) {
			this.adresse = adresse;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		
		public String getState() {
			return state;
		} 
		public void setState(String state) {
			this.state = state;
		}
		public int getDuree() {
			return duree;
		}
		public void setDuree(int duree) {
			this.duree = duree;
		}
		public String getVille() {
			return ville;
		}
		public void setVille(String ville) {
			this.ville = ville;
		}
		
		@Override
		public String toString() {
			return "Mission [id=" + id +  ", state=" + state + ", duree=" + duree + "]";
		}
}
