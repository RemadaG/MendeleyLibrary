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

import com.mendeley.oapi.schema.Paper;
import com.mendeley.oapi.schema.Publication;
import com.mendeley.oapi.schema.Tag;
import com.mendeley.oapi.schema.User;

/**
 * The Interface PublicStatsService.
 */
public interface PublicStatsService extends MendeleyService {
	
	/**
	 * Gets the authors.
	 * 
	 * @return the authors
	 */
	public List<User> getAuthors();
	
	/**
	 * Gets the authors.
	 * 
	 * @param disciplineId the discipline id
	 * 
	 * @return the authors
	 */
	public List<User> getAuthors(String disciplineId);
	
	/**
	 * Gets the authors.
	 * 
	 * @param disciplineId the discipline id
	 * @param upandcoming the upandcoming
	 * 
	 * @return the authors
	 */
	public List<User> getAuthors(String disciplineId, boolean upandcoming);
	
	/**
	 * Gets the tags.
	 * 
	 * @param disciplineId the discipline id
	 * 
	 * @return the tags
	 */
	public List<Tag> getTags(String disciplineId);
	
	/**
	 * Gets the publications.
	 * 
	 * @return the publications
	 */
	public List<Publication> getPublications();
	
	/**
	 * Gets the publications.
	 * 
	 * @param disciplineId the discipline id
	 * 
	 * @return the publications
	 */
	public List<Publication> getPublications(String disciplineId);
	
	/**
	 * Gets the publications.
	 * 
	 * @param disciplineId the discipline id
	 * @param upandcoming the upandcoming
	 * 
	 * @return the publications
	 */
	public List<Publication> getPublications(String disciplineId, boolean upandcoming);
	
	/**
	 * Gets the papers.
	 * 
	 * @return the papers
	 */
	public List<Paper> getPapers();
	
	/**
	 * Gets the papers.
	 * 
	 * @param disciplineId the discipline id
	 * 
	 * @return the papers
	 */
	public List<Paper> getPapers(String disciplineId);
	
	/**
	 * Gets the papers.
	 * 
	 * @param disciplineId the discipline id
	 * @param upandcoming the upandcoming
	 * 
	 * @return the papers
	 */
	public List<Paper> getPapers(String disciplineId, boolean upandcoming);
}
