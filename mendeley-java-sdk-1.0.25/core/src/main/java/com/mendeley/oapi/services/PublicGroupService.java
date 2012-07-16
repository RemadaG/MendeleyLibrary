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
import java.util.Map;

import com.mendeley.oapi.common.PagedList;
import com.mendeley.oapi.schema.Document;
import com.mendeley.oapi.schema.Group;
import com.mendeley.oapi.schema.User;

/**
 * The Interface PublicGroupService.
 */
public interface PublicGroupService extends MendeleyService {
	
	/**
	 * Gets the groups.
	 * 
	 * @return the groups
	 */
	public PagedList<Group> getGroups();
	
	/**
	 * Gets the group people.
	 * 
	 * @param groupId the group id
	 * 
	 * @return the group people
	 */
	public Map<Group.MembershipType, List<User>> getGroupPeople(String groupId);
	
	/**
	 * Gets the group details.
	 * 
	 * @param groupId the group id
	 * 
	 * @return the group details
	 */
	public Group getGroupDetails(String groupId);
	
	/**
	 * Gets the group documents.
	 * 
	 * @param groupId the group id
	 * 
	 * @return the group documents
	 */
	public PagedList<Document> getGroupDocuments(String groupId);
	
	/**
	 * Gets the group documents.
	 * 
	 * @param groupId the group id
	 * @param details the details
	 * 
	 * @return the group documents
	 */
	public PagedList<Document> getGroupDocuments(String groupId, boolean details);
	
	/**
	 * Gets the group documents.
	 * 
	 * @param groupId the group id
	 * @param details the details
	 * @param page the page
	 * @param itemsPerPage the items per page
	 * 
	 * @return the group documents
	 */
	public PagedList<Document> getGroupDocuments(String groupId, boolean details, int page, int itemsPerPage);
}
