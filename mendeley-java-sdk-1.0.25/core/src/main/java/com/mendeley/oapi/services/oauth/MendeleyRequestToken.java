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
 * The Class MendeleyRequestToken.
 */
public class MendeleyRequestToken extends MendeleyOAuthToken {

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1427085882101705465L;
	
	/** The authorization url. */
    private String authorizationUrl;

    /**
     * Instantiates a new mendeley request token.
     * 
     * @param token the token
     * @param tokenSecret the token secret
     */
    public MendeleyRequestToken(String token, String tokenSecret) {
        super(token, tokenSecret);
    }

    /**
     * Gets the authorization url.
     * 
     * @return the authorization url
     */
    public String getAuthorizationUrl() {
        return authorizationUrl;
    }

    /**
     * Sets the authorization url.
     * 
     * @param authorizationUrl the new authorization url
     */
    public void setAuthorizationUrl(String authorizationUrl) {
        this.authorizationUrl = authorizationUrl;
    }
}
