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
package com.mendeley.oapi.services.example;

import java.util.List;

import com.mendeley.oapi.schema.Group;
import com.mendeley.oapi.services.MendeleyServiceFactory;
import com.mendeley.oapi.services.PublicGroupService;

/**
 * The Class PublicGroupApiSample.
 */
public class PublicGroupApiSample {

	/** The Constant CONSUMER_KEY. */
	private static final String CONSUMER_KEY = "";
	
	/** The Constant CONSUMER_SECRET. */
	private static final String CONSUMER_SECRET = "";
	
    /**
     * The main method.
     * 
     * @param args the arguments
     * 
     * @throws Exception the exception
     */
	public static void main(String[] args) throws Exception {
		MendeleyServiceFactory factory = MendeleyServiceFactory.newInstance(CONSUMER_KEY, CONSUMER_SECRET);
		PublicGroupService service = factory.createPublicGroupService();
		List<Group> groups = service.getGroups();
		for (Group group : groups) {
			printResult(group);
		}
	}
    
	/**
	 * Prints the result.
	 * 
	 * @param group the group
	 */
	private static void printResult(Group group) {
		System.out.println(group);
	}
}
