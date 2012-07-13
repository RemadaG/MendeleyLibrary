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

import com.mendeley.oapi.schema.Publication;
import com.mendeley.oapi.services.MendeleyServiceFactory;
import com.mendeley.oapi.services.PrivateStatsService;
import com.mendeley.oapi.services.oauth.MendeleyAccessToken;

/**
 * The Class PrivateStatsApiSample.
 */
public class PrivateStatsApiSample {

	/** The Constant CONSUMER_KEY. */
	private static final String CONSUMER_KEY = "";
	
	/** The Constant CONSUMER_SECRET. */
	private static final String CONSUMER_SECRET = "";
	
	/** The Constant ACCESS_TOKEN. */
	private static final String ACCESS_TOKEN = "";
	
	/** The Constant TOKEN_SECRET. */
	private static final String TOKEN_SECRET = "";
	
    /**
     * The main method.
     * 
     * @param args the arguments
     */
	public static void main(String[] args) {
		MendeleyServiceFactory factory = MendeleyServiceFactory.newInstance(CONSUMER_KEY, CONSUMER_SECRET);
		PrivateStatsService service = factory.createPrivateStatsService(new MendeleyAccessToken(ACCESS_TOKEN, TOKEN_SECRET));
		List<Publication> publications = service.getPublications();
		for (Publication publication : publications) {
			printResult(publication);
		}
	}
    

	/**
	 * Prints the result.
	 * 
	 * @param publication the publication
	 */
	private static void printResult(Publication publication) {
		System.out.println(publication);
	}
}
