/*
 * Copyright 2011 Nabeel Mukhtar 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 * 
 */
package com.mendeley.oapi.schema;

import java.util.Date;

/**
 * The Class Employment.
 */
public class Employment extends SchemaEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3484450630735705441L;
	
	/** The position. */
	private String position;
	
	/** The institution. */
	private String institution;
	
	/** The location. */
	private String location;
	
	/** The classes taught. */
	private String classesTaught;
	
	/** The website. */
	private String website;
	
	/** The start date. */
	private Date startDate;
	
	/** The end date. */
	private Date endDate;
	
	/**
	 * Gets the position.
	 * 
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}
	
	/**
	 * Sets the position.
	 * 
	 * @param position the new position
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	
	/**
	 * Gets the institution.
	 * 
	 * @return the institution
	 */
	public String getInstitution() {
		return institution;
	}
	
	/**
	 * Sets the institution.
	 * 
	 * @param institution the new institution
	 */
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	
	/**
	 * Gets the location.
	 * 
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	
	/**
	 * Sets the location.
	 * 
	 * @param location the new location
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * Gets the classes taught.
	 * 
	 * @return the classes taught
	 */
	public String getClassesTaught() {
		return classesTaught;
	}
	
	/**
	 * Sets the classes taught.
	 * 
	 * @param classesTaught the new classes taught
	 */
	public void setClassesTaught(String classesTaught) {
		this.classesTaught = classesTaught;
	}
	
	/**
	 * Gets the website.
	 * 
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}
	
	/**
	 * Sets the website.
	 * 
	 * @param website the new website
	 */
	public void setWebsite(String website) {
		this.website = website;
	}
	
	/**
	 * Gets the start date.
	 * 
	 * @return the start date
	 */
	public Date getStartDate() {
		return startDate;
	}
	
	/**
	 * Sets the start date.
	 * 
	 * @param startDate the new start date
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	/**
	 * Gets the end date.
	 * 
	 * @return the end date
	 */
	public Date getEndDate() {
		return endDate;
	}
	
	/**
	 * Sets the end date.
	 * 
	 * @param endDate the new end date
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employment [classesTaught=" + classesTaught + ", endDate="
				+ endDate + ", institution=" + institution + ", location="
				+ location + ", position=" + position + ", startDate="
				+ startDate + ", website=" + website + "]";
	}
}
