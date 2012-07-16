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
package com.mendeley.oapi.services.impl;

import java.net.HttpURLConnection;

import org.apache.http.HttpRequest;

import com.mendeley.oapi.services.MendeleyAuthenticator;
import com.mendeley.oapi.services.MendeleyException;
import com.mendeley.oapi.services.MendeleyService;
import com.mendeley.oapi.services.constant.MendeleyApiUrls.MendeleyApiUrlBuilder;
import com.mendeley.oapi.services.oauth.MendeleyAccessToken;
import com.mendeley.oapi.services.oauth.MendeleyApiConsumer;
import com.mendeley.oapi.services.oauth.MendeleyOAuthService;
import com.mendeley.oapi.services.oauth.MendeleyOAuthServiceFactory;

/**
 * The Class BaseMendeleyPrivateService.
 */
public abstract class BaseMendeleyPrivateService extends BaseMendeleyPublicService implements MendeleyService, MendeleyAuthenticator {
	
	/** The access token. */
	protected MendeleyAccessToken accessToken;
	
	/**
	 * Instantiates a new base mendeley private service.
	 * 
	 * @param apiConsumer the api consumer
	 * @param accessToken the access token
	 */
	public BaseMendeleyPrivateService(MendeleyApiConsumer apiConsumer, MendeleyAccessToken accessToken) {
		super(apiConsumer);
		this.accessToken = accessToken;
	}

    /* (non-Javadoc)
     * @see com.mendeley.oapi.services.MendeleyAuthenticator#setAccessToken(com.mendeley.oapi.services.oauth.MendeleyAccessToken)
     */
    public void setAccessToken(MendeleyAccessToken accessToken) {
    	this.accessToken = accessToken;
    }
    
	/**
	 * Creates the mendeley api url builder.
	 * 
	 * @param urlFormat the url format
	 * 
	 * @return the mendeley api url builder
	 */
	protected MendeleyApiUrlBuilder createMendeleyApiUrlBuilder(String urlFormat) {
		return new MendeleyApiUrlBuilder(urlFormat);
	}
	
	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.impl.BaseMendeleyPublicService#signRequest(java.net.HttpURLConnection)
	 */
	protected void signRequest(HttpURLConnection request) {
		if (apiConsumer != null && accessToken != null) {
            MendeleyOAuthService oAuthService =
            	MendeleyOAuthServiceFactory.getInstance().createMendeleyOAuthService(apiConsumer.getConsumerKey(),
                    apiConsumer.getConsumerSecret());
            oAuthService.signRequestWithToken(request, accessToken);
		} else {
			throw new MendeleyException("Authentication parameters are incomplete.");
		}
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.impl.BaseMendeleyPublicService#signRequest(org.apache.http.HttpRequest)
	 */
	protected void signRequest(HttpRequest request) {
		if (apiConsumer != null && accessToken != null) {
            MendeleyOAuthService oAuthService =
            	MendeleyOAuthServiceFactory.getInstance().createMendeleyOAuthService(apiConsumer.getConsumerKey(),
                    apiConsumer.getConsumerSecret());
            oAuthService.signRequestWithToken(request, accessToken);
		} else {
			throw new MendeleyException("Authentication parameters are incomplete.");
		}
	}
}
