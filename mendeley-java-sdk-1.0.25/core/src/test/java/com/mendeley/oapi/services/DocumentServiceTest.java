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
 * The Class DocumentServiceTest.
 */
public class DocumentServiceTest extends BaseMendeleyServiceTest {
	
	/** The service. */
	private DocumentService service;

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.BaseGitHubServiceTest#setUp()
	 */
	@Before
	public void setUp() throws Exception {
		super.setUp();
		service = factory.createDocumentService(authentication);
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
	 * Test create document.
	 */
	@Test
	public void testCreateDocument() {
		fail("Not yet implemented");
	}

	/**
	 * Test get authored publications.
	 */
	@Test
	public void testGetAuthoredPublications() {
		fail("Not yet implemented");
	}

	/**
	 * Test get document details.
	 */
	@Test
	public void testGetDocumentDetails() {
		fail("Not yet implemented");
	}

	/**
	 * Test get document ids.
	 */
	@Test
	public void testGetDocumentIds() {
		fail("Not yet implemented");
	}

	/**
	 * Test get document ids int int.
	 */
	@Test
	public void testGetDocumentIdsIntInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test remove document.
	 */
	@Test
	public void testRemoveDocument() {
		fail("Not yet implemented");
	}
}
