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

import com.mendeley.oapi.services.impl.DocumentServiceImpl;
import com.mendeley.oapi.services.impl.FolderServiceImpl;
import com.mendeley.oapi.services.impl.PrivateGroupServiceImpl;
import com.mendeley.oapi.services.impl.PrivateStatsServiceImpl;
import com.mendeley.oapi.services.impl.ProfileServiceImpl;
import com.mendeley.oapi.services.impl.PublicGroupServiceImpl;
import com.mendeley.oapi.services.impl.PublicStatsServiceImpl;
import com.mendeley.oapi.services.impl.SearchServiceImpl;
import com.mendeley.oapi.services.oauth.MendeleyAccessToken;
import com.mendeley.oapi.services.oauth.MendeleyApiConsumer;




/**
 * A factory for creating MendeleyService objects.
 */
public class MendeleyServiceFactory {
	
	/** The api consumer. */
	private MendeleyApiConsumer apiConsumer;

    /**
     * Instantiates a new mendeley service factory.
     * 
     * @param apiConsumer the api consumer
     */
	private MendeleyServiceFactory(MendeleyApiConsumer apiConsumer) {
		this.apiConsumer = apiConsumer;
    }
	
    /**
     * New instance.
     * 
     * @param apiConsumer the api consumer
     * 
     * @return the mendeley service factory
     */
    public static MendeleyServiceFactory newInstance(MendeleyApiConsumer apiConsumer) {
        return new MendeleyServiceFactory(apiConsumer);
    }
    
    /**
     * New instance.
     * 
     * @param consumerKey the consumer key
     * @param consumerSecret the consumer secret
     * 
     * @return the mendeley service factory
     */
    public static MendeleyServiceFactory newInstance(String consumerKey, String consumerSecret) {
        return new MendeleyServiceFactory(new MendeleyApiConsumer(consumerKey, consumerSecret));
    }
    
    /**
     * Creates a new MendeleyService object.
     * 
     * @param accessToken the access token
     * 
     * @return the private stats service
     */
    public PrivateStatsService createPrivateStatsService(MendeleyAccessToken accessToken) {
    	return new PrivateStatsServiceImpl(apiConsumer, accessToken);
    }
    
    /**
     * Creates a new MendeleyService object.
     * 
     * @param accessToken the access token
     * 
     * @return the private group service
     */
    public PrivateGroupService createPrivateGroupService(MendeleyAccessToken accessToken) {
    	return new PrivateGroupServiceImpl(apiConsumer, accessToken);
    }
    
    /**
     * Creates a new MendeleyService object.
     * 
     * @param accessToken the access token
     * 
     * @return the folder service
     */
    public FolderService createFolderService(MendeleyAccessToken accessToken) {
    	return new FolderServiceImpl(apiConsumer, accessToken);
    }
    
    /**
     * Creates a new MendeleyService object.
     * 
     * @return the public group service
     */
    public PublicGroupService createPublicGroupService() {
    	return new PublicGroupServiceImpl(apiConsumer);
    }
    
    /**
     * Creates a new MendeleyService object.
     * 
     * @param accessToken the access token
     * 
     * @return the profile service
     */
    public ProfileService createProfileService(MendeleyAccessToken accessToken) {
    	return new ProfileServiceImpl(apiConsumer, accessToken);
    }
    
    /**
     * Creates a new MendeleyService object.
     * 
     * @return the public stats service
     */
    public PublicStatsService createPublicStatsService() {
    	return new PublicStatsServiceImpl(apiConsumer);    	
    }
    
    /**
     * Creates a new MendeleyService object.
     * 
     * @param accessToken the access token
     * 
     * @return the document service
     */
    public DocumentService createDocumentService(MendeleyAccessToken accessToken) {
    	return new DocumentServiceImpl(apiConsumer, accessToken);    	
    }
    
    /**
     * Creates a new MendeleyService object.
     * 
     * @return the search service
     */
    public SearchService createSearchService() {
    	return new SearchServiceImpl(apiConsumer);    	
    }
}
