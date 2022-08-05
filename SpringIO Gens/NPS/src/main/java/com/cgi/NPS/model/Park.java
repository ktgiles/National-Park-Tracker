package com.cgi.NPS.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Park {
	private String url;
	
	@Id
	private String fullName; 
	private String code; //"parkCode"
	private String latitude;
	private String longitude;
	private String latLong;
	private Object[] activities;
	private Object[] topics;
	
	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getLatitude() {
		return latitude;
	}


	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}


	public String getLongitude() {
		return longitude;
	}


	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}


	public String getLatLong() {
		return latLong;
	}


	public void setLatLong(String latLong) {
		this.latLong = latLong;
	}


	public Object[] getActivities() {
		return activities;
	}


	public void setActivities(Object[] activities) {
		this.activities = activities;
	}


	public Object[] getTopics() {
		return topics;
	}


	public void setTopics(Object[] topics) {
		this.topics = topics;
	}


	public String getStates() {
		return states;
	}


	public void setStates(String states) {
		this.states = states;
	}


	public String getDirectionsInfo() {
		return directionsInfo;
	}


	public void setDirectionsInfo(String directionsInfo) {
		this.directionsInfo = directionsInfo;
	}


	public String getDirectionsUrl() {
		return directionsUrl;
	}


	public void setDirectionsUrl(String directionsUrl) {
		this.directionsUrl = directionsUrl;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	String states;
	
	String directionsInfo;
	String directionsUrl;
	String designation;
	String name;
	
	
	public Park(
			String url,
			String fullName,
			String code, //"parkCode"
			String latitude,
			String longitude,
			String latLong,
			Object[] activities,
			Object[] topics,
			String states,
			String directionsInfo,
			String directionsUrl,
			String name,
			String designation) {
		
		this.url = url;
		this.fullName = fullName;
		this.code = code;
		this.latitude = latitude;
		this.longitude = longitude;
		this.latLong = latLong;
		this.activities = activities;
		this.topics = topics;
		this.states = states;
	
		this.directionsInfo = directionsInfo;
		this.directionsUrl = directionsUrl;
		this.name = name;
		this.designation = designation;
	}
	

}
