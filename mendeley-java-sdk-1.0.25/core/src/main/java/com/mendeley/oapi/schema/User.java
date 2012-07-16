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


/**
 * The Class User.
 */
public class User extends SchemaEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3484450630735705441L;
	
	/** The name. */
	private String name;
	
	/** The value. */
	private String value;
	
	/** The user id. */
	private String userId;
	
	/** The profile id. */
	private String profileId;
	
	/** The discipline id. */
	private String disciplineId;
	
	/** The discipline name. */
	private String disciplineName;
	
	/** The academic status. */
	private String academicStatus;
	
	/** The research interests. */
	private String researchInterests;
	
	/** The location. */
	private String location;
	
	/** The bio. */
	private String bio;
	
	/** The photo. */
	private String photo;
	
	/** The url. */
	private String url;
	
	/**
	 * Gets the user id.
	 * 
	 * @return the user id
	 */
	public String getUserId() {
		return userId;
	}
	
	/**
	 * Sets the user id.
	 * 
	 * @param userId the new user id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 * 
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the value.
	 * 
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	
	/**
	 * Sets the value.
	 * 
	 * @param value the new value
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	/**
	 * Gets the profile id.
	 * 
	 * @return the profile id
	 */
	public String getProfileId() {
		return profileId;
	}

	/**
	 * Sets the profile id.
	 * 
	 * @param profileId the new profile id
	 */
	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}
	
	/**
	 * Gets the discipline id.
	 * 
	 * @return the discipline id
	 */
	public String getDisciplineId() {
		return disciplineId;
	}

	/**
	 * Sets the discipline id.
	 * 
	 * @param disciplineId the new discipline id
	 */
	public void setDisciplineId(String disciplineId) {
		this.disciplineId = disciplineId;
	}

	/**
	 * Gets the discipline name.
	 * 
	 * @return the discipline name
	 */
	public String getDisciplineName() {
		return disciplineName;
	}

	/**
	 * Sets the discipline name.
	 * 
	 * @param disciplineName the new discipline name
	 */
	public void setDisciplineName(String disciplineName) {
		this.disciplineName = disciplineName;
	}

	/**
	 * Gets the academic status.
	 * 
	 * @return the academic status
	 */
	public String getAcademicStatus() {
		return academicStatus;
	}

	/**
	 * Sets the academic status.
	 * 
	 * @param academicStatus the new academic status
	 */
	public void setAcademicStatus(String academicStatus) {
		this.academicStatus = academicStatus;
	}

	/**
	 * Gets the research interests.
	 * 
	 * @return the research interests
	 */
	public String getResearchInterests() {
		return researchInterests;
	}

	/**
	 * Sets the research interests.
	 * 
	 * @param researchInterests the new research interests
	 */
	public void setResearchInterests(String researchInterests) {
		this.researchInterests = researchInterests;
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
	 * Gets the bio.
	 * 
	 * @return the bio
	 */
	public String getBio() {
		return bio;
	}

	/**
	 * Sets the bio.
	 * 
	 * @param bio the new bio
	 */
	public void setBio(String bio) {
		this.bio = bio;
	}

	/**
	 * Gets the photo.
	 * 
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * Sets the photo.
	 * 
	 * @param photo the new photo
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * Gets the url.
	 * 
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the url.
	 * 
	 * @param url the new url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [academicStatus=" + academicStatus + ", bio=" + bio
				+ ", disciplineId=" + disciplineId + ", disciplineName="
				+ disciplineName + ", location=" + location + ", name=" + name
				+ ", photo=" + photo + ", profileId=" + profileId
				+ ", researchInterests=" + researchInterests + ", url=" + url
				+ ", userId=" + userId + ", value=" + value + "]";
	}
}
