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

import com.mendeley.oapi.schema.Group;
import com.mendeley.oapi.schema.User;


/**
 * The Interface PrivateGroupService.
 */
public interface PrivateGroupService extends MendeleyService {
	
	/**
	 * Gets the groups.
	 * 
	 * @return the groups
	 */
	public List<Group> getGroups();
	
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
	 * Creates the group.
	 * 
	 * @param name the name
	 * @param type the type
	 * 
	 * @return the group
	 */
	public Group createGroup(String name, Group.Type type);
	
	/**
	 * Delete group.
	 * 
	 * @param groupId the group id
	 */
	public void deleteGroup(String groupId);
	
	/**
	 * Leave group.
	 * 
	 * @param groupId the group id
	 */
	public void leaveGroup(String groupId);
	
	/**
	 * Unfollow group.
	 * 
	 * @param groupId the group id
	 */
	public void unfollowGroup(String groupId);
}
