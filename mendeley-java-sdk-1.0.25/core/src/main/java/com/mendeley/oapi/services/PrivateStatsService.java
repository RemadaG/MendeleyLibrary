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

import com.mendeley.oapi.schema.Publication;
import com.mendeley.oapi.schema.Tag;
import com.mendeley.oapi.schema.User;


/**
 * The Interface PrivateStatsService.
 */
public interface PrivateStatsService extends MendeleyService {
	
	/**
	 * Gets the authors.
	 * 
	 * @return the authors
	 */
	public List<User> getAuthors();
	
	/**
	 * Gets the tags.
	 * 
	 * @return the tags
	 */
	public List<Tag> getTags();
	
	/**
	 * Gets the publications.
	 * 
	 * @return the publications
	 */
	public List<Publication> getPublications();
}
