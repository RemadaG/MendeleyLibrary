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
package com.mendeley.oapi.services.oauth;


/**
 * A factory for creating MendeleyOAuthService objects.
 */
public class MendeleyOAuthServiceFactory {

    /** The instance. */
    private static MendeleyOAuthServiceFactory instance;

    /**
     * Instantiates a new mendeley o auth service factory.
     */
    private MendeleyOAuthServiceFactory() {}

    /**
     * Gets the single instance of MendeleyOAuthServiceFactory.
     * 
     * @return single instance of MendeleyOAuthServiceFactory
     */
    public static synchronized MendeleyOAuthServiceFactory getInstance() {
        if (instance == null) {
            instance = new MendeleyOAuthServiceFactory();
        }

        return instance;
    }

    /**
     * Creates a new MendeleyOAuthService object.
     * 
     * @param consumerKey the consumer key
     * @param consumerSecret the consumer secret
     * 
     * @return the mendeley o auth service
     */
    public MendeleyOAuthService createMendeleyOAuthService(String consumerKey, String consumerSecret) {
        return createMendeleyOAuthService(new MendeleyApiConsumer(consumerKey, consumerSecret));
    }

    /**
     * Creates a new MendeleyOAuthService object.
     * 
     * @param apiConsumer the api consumer
     * 
     * @return the mendeley o auth service
     */
    public MendeleyOAuthService createMendeleyOAuthService(MendeleyApiConsumer apiConsumer) {
    	validateConsumerKey(apiConsumer);
        return new MendeleyOAuthServiceImpl(apiConsumer);
    }
    
    /**
     * Validate consumer key.
     * 
     * @param apiConsumer the api consumer
     */
	private void validateConsumerKey(MendeleyApiConsumer apiConsumer) {
		if (apiConsumer == null) {
    		throw new IllegalArgumentException("api consumer cannot be null.");
    	}
    	if (apiConsumer.getConsumerKey() == null || apiConsumer.getConsumerKey().length() == 0) {
    		throw new IllegalArgumentException("consumer key cannot be null or empty.");
    	}
    	if (apiConsumer.getConsumerSecret() == null || apiConsumer.getConsumerSecret().length() == 0) {
    		throw new IllegalArgumentException("consumer secret cannot be null or empty.");
    	}
	}
}
