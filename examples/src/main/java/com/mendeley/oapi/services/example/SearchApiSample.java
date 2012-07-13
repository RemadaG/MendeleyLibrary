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

import com.mendeley.oapi.schema.Document;
import com.mendeley.oapi.services.MendeleyServiceFactory;
import com.mendeley.oapi.services.SearchService;

/**
 * The Class SearchApiSample.
 */
public class SearchApiSample {

	/** The Constant CONSUMER_KEY. */
	private static final String CONSUMER_KEY = "";
	
	/** The Constant CONSUMER_SECRET. */
	private static final String CONSUMER_SECRET = "";

    /**
     * The main method.
     * 
     * @param args the arguments
     */
	public static void main(String[] args) {
		MendeleyServiceFactory factory = MendeleyServiceFactory.newInstance(CONSUMER_KEY, CONSUMER_SECRET);
		SearchService service = factory.createSearchService();
		List<Document> documents = service.search("hadoop");
		for (Document document : documents) {
			printResult(document);
		}
	}
    
	/**
	 * Prints the result.
	 * 
	 * @param document the document
	 */
	private static void printResult(Document document) {
		System.out.println(document);
	}
}
