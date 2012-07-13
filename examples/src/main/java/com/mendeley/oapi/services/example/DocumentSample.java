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
import com.mendeley.oapi.services.DocumentService;
import com.mendeley.oapi.services.MendeleyServiceFactory;
import com.mendeley.oapi.services.oauth.MendeleyAccessToken;

/**
 * The Class DocumentSample.
 */
public class DocumentSample {

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
		DocumentService service = factory.createDocumentService(new MendeleyAccessToken(ACCESS_TOKEN, TOKEN_SECRET));
		List<String> documentIds = service.getDocumentIds();
		System.out.println(documentIds);
		Document document = service.getDocumentDetails(documentIds.get(0));
		printResult(document);
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
