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
 * The Class MendeleyApiConsumer.
 */
public class MendeleyApiConsumer extends MendeleyOAuthToken {

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -508151196474695320L;

	/**
	 * Instantiates a new mendeley api consumer.
	 * 
	 * @param consumerKey the consumer key
	 * @param consumerSecret the consumer secret
	 */
    public MendeleyApiConsumer(String consumerKey, String consumerSecret) {
        super(consumerKey, consumerSecret);
    }
    
    /**
     * Gets the consumer key.
     * 
     * @return the consumer key
     */
    public String getConsumerKey() {
        return getToken();
    }

    /**
     * Sets the consumer key.
     * 
     * @param consumerKey the new consumer key
     */
    public void setConsumerKey(String consumerKey) {
        setToken(consumerKey);
    }

    /**
     * Gets the consumer secret.
     * 
     * @return the consumer secret
     */
    public String getConsumerSecret() {
        return getTokenSecret();
    }

    /**
     * Sets the consumer secret.
     * 
     * @param consumerSecret the new consumer secret
     */
    public void setConsumerSecret(String consumerSecret) {
        setTokenSecret(consumerSecret);
    }
}
