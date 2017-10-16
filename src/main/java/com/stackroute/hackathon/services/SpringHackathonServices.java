package com.stackroute.hackathon.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.hackathon.repository.SpringHackathonRepository;
import com.stackroute.hackathon.exceptions.UserNotExistException;
import com.stackroute.hackathon.exceptions.UserAlreadyExistException;
import com.stackroute.hackathon.model.UserDetails;

@Service
public class SpringHackathonServices {
	
	@Autowired
	private SpringHackathonRepository shr;
	
	//-----------------------------START: Add User Method---------------------------------------------

	public void addDetails (UserDetails u)throws UserAlreadyExistException
	{
		if(shr.exists(u.getId())) {
			throw new UserAlreadyExistException (u.getUsername() + " Id already exist");
		}
		
		else
		shr.save(u);
	}
	
	//-----------------------------END: Add User Method-------------------------------------------------
	
   
	//----------------------------START: Getting All Details Method-------------------------------------
		public List<UserDetails> getAllDetails1() {
			
			List<UserDetails> l = new ArrayList();
			shr.findAll().forEach(l::add);
			return  l;
		

	}
	//-----------------------------END: Getting All Details Method---------------------------------------
	
		//-----------------------------START: Deleting by Id------------------------------------------
		public void delete(int id) throws UserNotExistException{
			if(shr.exists(id) == false) {
				throw new UserNotExistException(id + " does not exist");
			}
			else
			shr.delete(id);
			
			
		}
	//-----------------------------END: Deleting by Id--------------------------------------------
		
		
//		public UserDetails findById(int id) {
//			return shr.findOne(id);
//		}
//		public UserDetails findById( int id) {
//	        for(UserDetails user : ){
//	            if(user.getId() == id){
//	                return user;
//	            }
//	        }
//	        return null;
//	    }
		
//		public void update(int id) throws UserNotExistException{
//			if(shr.exists(id) == false) {
//				throw new UserNotExistException(id + " does not exist");
//			}
//			else
//			shr.save(id);
//			
//			
//		}
//
//		public User findById(int id) {
//	        for(User user : users){
//	            if(user.getId() == id){
//	                return user;
//	            }
//	        }
//	        return null;
//	    }
//
//		public static UserDetails findUser(int id) {
//			for(User user : users){
//	            if(user.getId() == id){
//	                return user;
//	            }
//	        }
//	        return null;
//		}

		
}
