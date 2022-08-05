package com.cgi.NPS.controller;

import com.cgi.NPS.model.Park;
import com.cgi.NPS.parser.*;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api")
public class ParksController {
	
//	@RequestMapping(value = "/home", method = RequestMethod.GET)
//	public String getHomeHandler() {
//		return "Welcome to home page";
//	}
	
	@GetMapping(value="/parks")
	private List<Park> getParks() {
		String uri = "https://developer.nps.gov/api/v1/parks?limit=500&api_key=6JrUeoLYWgsCSMZ6WJkjSMitc8mq8HzeXTB3dvOk";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);				
		List<Park> all = ParkParser.retrieveParks(result);
		return all;
	}
	
	@GetMapping(value="/{search}")
	private List<Park> searchParks(@PathVariable("search") String search) {
		
		return null;
		
	}

}
