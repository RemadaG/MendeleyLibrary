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

import org.junit.Test;

/**
 * The Class PublicStatsServiceTest.
 */
public class PublicStatsServiceTest extends BaseMendeleyServiceTest {
	
    /** The service. */
	private PublicStatsService service;
	
	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.BaseFacebookGraphApiTestCase#setUp()
	 */
	public void setUp() throws Exception {
		super.setUp();
		service = factory.createPublicStatsService();
	}

	/* (non-Javadoc)
	 * @see com.google.code.facebook.graph.client.BaseFacebookGraphApiTestCase#tearDown()
	 */
	public void tearDown() throws Exception {
		super.tearDown();
		service = null;
	}

	/**
	 * Test get authors.
	 */
	@Test
	public void testGetAuthors() {
		fail("Not yet implemented");
	}

	/**
	 * Test get authors string.
	 */
	@Test
	public void testGetAuthorsString() {
		fail("Not yet implemented");
	}

	/**
	 * Test get authors string boolean.
	 */
	@Test
	public void testGetAuthorsStringBoolean() {
		fail("Not yet implemented");
	}

	/**
	 * Test get papers.
	 */
	@Test
	public void testGetPapers() {
		fail("Not yet implemented");
	}

	/**
	 * Test get papers string.
	 */
	@Test
	public void testGetPapersString() {
		fail("Not yet implemented");
	}

	/**
	 * Test get papers string boolean.
	 */
	@Test
	public void testGetPapersStringBoolean() {
		fail("Not yet implemented");
	}

	/**
	 * Test get publications.
	 */
	@Test
	public void testGetPublications() {
		fail("Not yet implemented");
	}

	/**
	 * Test get publications string.
	 */
	@Test
	public void testGetPublicationsString() {
		fail("Not yet implemented");
	}

	/**
	 * Test get publications string boolean.
	 */
	@Test
	public void testGetPublicationsStringBoolean() {
		fail("Not yet implemented");
	}

	/**
	 * Test get tags.
	 */
	@Test
	public void testGetTags() {
		fail("Not yet implemented");
	}
}
