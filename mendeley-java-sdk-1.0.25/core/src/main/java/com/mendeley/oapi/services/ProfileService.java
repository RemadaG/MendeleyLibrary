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
package com.mendeley.oapi.services;

import java.util.List;

import com.mendeley.oapi.schema.Profile;
import com.mendeley.oapi.schema.User;
import com.mendeley.oapi.schema.Profile.Section;


/**
 * The Interface ProfileService.
 */
public interface ProfileService extends MendeleyService {
	
	/**
	 * Gets the contacts.
	 * 
	 * @return the contacts
	 */
	public List<User> getContacts();
	
	/**
	 * Adds the contact.
	 * 
	 * @param userId the user id
	 */
	public void addContact(String userId);
	
	/**
	 * Gets the profile.
	 * 
	 * @param userId the user id
	 * 
	 * @return the profile
	 */
	public Profile getProfile(String userId);
	
	/**
	 * Gets the profile.
	 * 
	 * @param userId the user id
	 * @param section the section
	 * 
	 * @return the profile
	 */
	public Profile getProfile(String userId, Section section);
	
	/**
	 * Gets the profile.
	 * 
	 * @param userId the user id
	 * @param section the section
	 * @param subsection the subsection
	 * 
	 * @return the profile
	 */
	public Profile getProfile(String userId, Section section, Section subsection);
}
