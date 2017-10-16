package com.stackroute.hackathon.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.stackroute.hackathon.model.UserDetails;

public interface SpringHackathonRepository extends CrudRepository<UserDetails,Integer>{

}

