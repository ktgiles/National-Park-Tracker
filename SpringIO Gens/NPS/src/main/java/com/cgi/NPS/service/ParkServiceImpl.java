package com.cgi.NPS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.NPS.model.Park;
import com.cgi.NPS.repo.ParksRepo;

@Service
public class ParkServiceImpl implements ParkService{
	
	@Autowired
	private ParksRepo parksRepo;
	
//	public List<Park> searchParks(String search){
//		return parksRepo.getBySearch(search);
//		
//		
//	}

}
