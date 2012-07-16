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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The Class PrivateGroupServiceTest.
 */
public class PrivateGroupServiceTest extends BaseMendeleyServiceTest {
	
	/** The service. */
	private PrivateGroupService service;

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.BaseGitHubServiceTest#setUp()
	 */
	@Before
	public void setUp() throws Exception {
		super.setUp();
		service = factory.createPrivateGroupService(authentication);
	}

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.BaseGitHubServiceTest#tearDown()
	 */
	@After
	public void tearDown() throws Exception {
		super.tearDown();
		service = null;
	}

	/**
	 * Test create group.
	 */
	@Test
	public void testCreateGroup() {
		fail("Not yet implemented");
	}

	/**
	 * Test delete group.
	 */
	@Test
	public void testDeleteGroup() {
		fail("Not yet implemented");
	}

	/**
	 * Test get group details.
	 */
	@Test
	public void testGetGroupDetails() {
		fail("Not yet implemented");
	}

	/**
	 * Test get group people.
	 */
	@Test
	public void testGetGroupPeople() {
		fail("Not yet implemented");
	}

	/**
	 * Test get groups.
	 */
	@Test
	public void testGetGroups() {
		fail("Not yet implemented");
	}

	/**
	 * Test leave group.
	 */
	@Test
	public void testLeaveGroup() {
		fail("Not yet implemented");
	}

	/**
	 * Test unfollow group.
	 */
	@Test
	public void testUnfollowGroup() {
		fail("Not yet implemented");
	}
}
