package com.stackroute.hackathon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.hackathon.exceptions.UserAlreadyExistException;
import com.stackroute.hackathon.exceptions.UserNotExistException;
import com.stackroute.hackathon.model.UserDetails;
import com.stackroute.hackathon.services.SpringHackathonServices;

@RestController
@RequestMapping(value ="/users")
public class SpringHackathonControllers {
	
	@Autowired
	private SpringHackathonServices shs;
	
	//-------------------------------------START: Using POST for adding new User---------------------------------------------------
	@RequestMapping(value="/add", method = RequestMethod.POST)
    public ResponseEntity addNewUser(RequestEntity<UserDetails>  u) throws Exception  {
		try {
			
		if( u.getBody().getEmailid() == null || u.getBody().getUsername()== null) {
			
			return new ResponseEntity<String>("Insufficient parameter",HttpStatus.PARTIAL_CONTENT);
			
		}
		else
		    {
		
			shs.addDetails(u.getBody());
			return new ResponseEntity<String>("User saved successfully",HttpStatus.OK);
			
		    }
		}
		catch(UserAlreadyExistException uaee)
		{
		
			System.out.println(uaee.getMessage());
			return new ResponseEntity<String>("Data already exists",HttpStatus.CONFLICT);
		}
    	
    }
//---------------------------------------END: Using POST for adding new User-----------------------------
	
//	----------------------------START: Using GET for getting All Users-----------------------------------
    @RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity getAllDetails () {
    	
    	if(shs.getAllDetails1() == null) {
    		
    		return new ResponseEntity<String>("Empty Database", HttpStatus.PARTIAL_CONTENT);
    	}
    	
    	else 
    	{
    		return new ResponseEntity<List<UserDetails>> (shs.getAllDetails1(), HttpStatus.OK);
   
        }

	}
//  ------------------------------END: Using GET for getting All Users-----------------------------
    
// -------------------------------START: Using DELETE for deleting User by Id-----------------------
    
    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteById (@PathVariable int id) {
    	
    	try {
    		shs.delete(id);
    		 return new ResponseEntity<String> ("Succesful Deletion of User", HttpStatus.OK);
    	}
    	catch (UserNotExistException unee) {
    		System.out.println(unee.getMessage());
    		return new ResponseEntity<String> ("User Data doesnot exist", HttpStatus.NOT_FOUND);
    	}
    }
    
// ---------------------------------END: Using DELETE for deleting User by Id----------------------- 
    
//----------------------------------START: Using PUT for updating a User-----------------------------
    
//    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<UserDetails> updateUser(@PathVariable("id") int id, @RequestBody UserDetails user) {
//        System.out.println("Updating User " + id);
//         
//        UserDetails currentUser = SpringHackathonServices.findById(id);
//         
//        if (currentUser==null) {
//            System.out.println("User with id " + id + " not found");
//            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//        }
// 
//        currentUser.setName(user.getName());
//        currentUser.setAge(user.getAge());
//        currentUser.setSalary(user.getSalary());
//         
//        userService.updateUser(currentUser);
//        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
//    }
//@RequestMapping(value="/update/{id}", method = RequestMethod.PUT)    
//public ResponseEntity updateById (@PathVariable int id, @RequestBody UserDetails user) {
//    	
//    	try {
//    		 UserDetails currentUser = SpringHackathonServices.findUser(id);
//    		 currentUser.setName(user.getName());
//             currentUser.setEmailid(user.getEmailid());
//             currentUser.setUsername(user.getUsername());
//    		 shs.update(id);
//    		 return new ResponseEntity<String> ("Succesful Update of User", HttpStatus.OK);
//    		 }
//    	
//    	catch (UserNotExistException unee) {
//    		System.out.println(unee.getMessage());
//    		return new ResponseEntity<String> ("User Data doesnot exist", HttpStatus.NOT_FOUND);
//    	}
//	}	
//    
}
