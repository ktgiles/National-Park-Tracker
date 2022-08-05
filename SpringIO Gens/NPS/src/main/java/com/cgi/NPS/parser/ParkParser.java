package com.cgi.NPS.parser;

import java.util.ArrayList;
import java.util.List;

import com.cgi.NPS.model.Park;

//TODO - take out latLong attribute, description, weather, directionsInfo

public class ParkParser {
	
	public static String[] allNPS (String jsonString){
		
	
		String[] split = jsonString.split(",");
		
		for (String chunk: split) {
			
			String[] values = chunk.split("\":");
			
			for (int i = 0; i < values.length; i++) {
				values[i] = values[i].replaceAll("\"", "");
			}
		}
		
			
		return split;
		
	}
	
	public static List<Park> retrieveParks (String jsonString){
		String url = null;
		int urlCount = 0;
		String fullName = null; 
		String code = null; //"parkCode"
		String latitude = null;
		String longitude = null;
		String latLong = null;
		String flag = null;
		List<String> activityList = new ArrayList<>();
		Object[] activities = null;
		List<String> topicsList = new ArrayList<>();
		Object[] topics = null;
		String states = null;
		String directionsInfo = null;
		String directionsUrl = null;
		String name = null;
		String designation = null;
		
		List<Park> allParks = new ArrayList<>();
		List<Park> NP = new ArrayList<>();
	
		String[] split = jsonString.split(",");
		
		for (String chunk: split) {
							
			String[] values = chunk.split("\":");
			
			for (int i = 0; i < values.length; i++) {
				values[i] = values[i].replaceAll("\"", "");
			}
			
		
					
		switch(values[0]) {
		case "url": 
			if (urlCount == 0) {
				url = clean(values[1]);
				urlCount++;				
			} break;
			
		case "fullName": 
			fullName = clean(values[1]);
			break;
		
		case "parkCode":
			code = clean(values[1]);
			break;
			
		case "latitude":
			latitude = clean(values[1]);
			break;
			
		case "longitude":
			longitude = clean(values[1]);
			break;
		
		case "latLong":
			latLong = clean(values[1]);
			break;
			
		case "activities":
			flag = "activities";
			break;
			
		case "name":
			if (flag == "activities") {
				activityList.add(clean(values[1]));
			}
			if (flag == "topics") {
				topicsList.add(clean(values[1]));
			}
			if (flag == "name") {
				name = clean(values[1]);
			}
			break;
			
		case "topics":
			flag = "topics";
			break;
			
		case "states":
			states = clean(values[1]);
			flag = null;
			break;
			
		case "directionsInfo":
			directionsInfo = clean(values[1]);
			break;
			
		case "directionsUrl":
			directionsUrl = clean(values[1]);
			break;
			
		case "weatherInfo":
			flag = "name";
			break;
			
		case "designation":
			designation = clean(values[1]);
			
			//turn activities and topics lists to arrays
			activities = activityList.toArray();
			topics =  topicsList.toArray();
			
			//send info to constructor and create Park object			
			Park temp = new Park(url, fullName, code, latitude, longitude, latLong, activities, topics, states, directionsInfo, directionsUrl, name, designation);
			//add that Park object to a list of Park objects
			allParks.add(temp);
			
			//samoa, sequoia + kings canyon , new river gorge, and redwood aren't designated as national parks - this is a limitation of the data returned by NPS 
			//TODO - future iteration - find a way to handle this data discrepancy more gracefully
			//NOTE: Sequoia and Kings Canyon are combined by NPS, resulting in 62 (not 63) results - users have already complained about this to NPS but is another 
			//limitation of the data
			//IF national park, add to NP list
			if (temp.getDesignation().equals("National Park") ||  temp.getDesignation().equals("National Park & Preserve") 
					|| temp.getName().equals("National Park of American Samoa") || temp.getName().equals("New River Gorge") || temp.getName().equals("Sequoia & Kings Canyon") || temp.getName().equals("Redwood") ){
				NP.add(temp);
			}
//			System.out.println(temp.name);
//			System.out.println(temp.designation);
//			System.out.println("----------------"); 
			
			//reset all local variabls to null
			nullifyAll(url, fullName, code, latitude, longitude, latLong, activities, topics, states, directionsInfo, directionsUrl, name, designation);
			//reset url counter
			urlCount = 0;
			//reset flag 		
			flag = null;
			break;			
			}
		}
		
		System.out.println("total number of national parks is: " + NP.size());
		return NP;
	}
	
	
	public static void nullify(Object o) {
		o = null;
	}
	
	public static void nullifyAll(String url, String fullName, String code, String latitude, String longitude, String latLong, Object[] activities, Object[] topics, String states,
			String directionsInfo, String directionsUrl, String name, String designation) {
		nullify(url);
		nullify(fullName);
		nullify(code);
		nullify(latitude);
		nullify(longitude);
		nullify(latLong);
		nullify(activities);
		nullify(topics);
		nullify(states);
		nullify(directionsInfo);
		nullify(directionsUrl);
		nullify(name);
		nullify(designation);
	}
	
	public static String clean(String attribute) {
		return attribute.replaceAll("\"", "") // "
				.replaceAll("\\{", "") // {
				.replaceAll("\\}", "") // }
				.replaceAll("\\[", "") // [
				.replaceAll("\\]", "") // ]
				.replaceAll("\r", "") // /r
				.replaceAll("\n", ""); // /n 
 	}


	
}
