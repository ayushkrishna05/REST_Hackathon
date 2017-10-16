package com.stackroute.hackathon.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity(name="userdata")
public class UserDetails {
        
	    @Id
	    private int id;
	    private String name;
	   	private String username;
	    private String emailid;
	    
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getEmailid() {
			return emailid;
		}
		public void setEmailid(String emailid) {
			this.emailid = emailid;
		}
	    
	    
//       public UserDetails() {
//    	   
//       }
//	   public UserDetails(int id, String repos, String username, String url) {
//	        
//	        this.id = id;
//	        this.repos = repos;
//	        this.username = username;
//	        this.url = url;
//	    }

	    

	  

	 
	}