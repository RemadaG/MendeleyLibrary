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
 * The Class SearchServiceTest.
 */
public class SearchServiceTest extends BaseMendeleyServiceTest {
	
	/** The service. */
	private SearchService service;

	/* (non-Javadoc)
	 * @see com.github.api.v2.services.BaseGitHubServiceTest#setUp()
	 */
	@Before
	public void setUp() throws Exception {
		super.setUp();
		service = factory.createSearchService();
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
	 * Test get document details string.
	 */
	@Test
	public void testGetDocumentDetailsString() {
		fail("Not yet implemented");
	}

	/**
	 * Test get document details string type.
	 */
	@Test
	public void testGetDocumentDetailsStringType() {
		fail("Not yet implemented");
	}

	/**
	 * Test get documents by author string.
	 */
	@Test
	public void testGetDocumentsByAuthorString() {
		fail("Not yet implemented");
	}

	/**
	 * Test get documents by author string int.
	 */
	@Test
	public void testGetDocumentsByAuthorStringInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test get documents by author string int int.
	 */
	@Test
	public void testGetDocumentsByAuthorStringIntInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test get documents by tag string.
	 */
	@Test
	public void testGetDocumentsByTagString() {
		fail("Not yet implemented");
	}

	/**
	 * Test get documents by tag string int int.
	 */
	@Test
	public void testGetDocumentsByTagStringIntInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test get documents by tag string string string.
	 */
	@Test
	public void testGetDocumentsByTagStringStringString() {
		fail("Not yet implemented");
	}

	/**
	 * Test get related documents.
	 */
	@Test
	public void testGetRelatedDocuments() {
		fail("Not yet implemented");
	}

	/**
	 * Test search string array.
	 */
	@Test
	public void testSearchStringArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test search string int int.
	 */
	@Test
	public void testSearchStringIntInt() {
		fail("Not yet implemented");
	}
}
