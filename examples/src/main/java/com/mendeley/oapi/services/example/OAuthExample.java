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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.mendeley.oapi.services.oauth.MendeleyAccessToken;
import com.mendeley.oapi.services.oauth.MendeleyOAuthService;
import com.mendeley.oapi.services.oauth.MendeleyOAuthServiceFactory;
import com.mendeley.oapi.services.oauth.MendeleyRequestToken;

/**
 * The Class OAuthExample.
 */
public class OAuthExample {
	
	/** The Constant CONSUMER_KEY. */
	private static final String CONSUMER_KEY = "";
	
	/** The Constant CONSUMER_SECRET. */
	private static final String CONSUMER_SECRET = "";
	
	/**
	 * The main method.
	 * 
	 * @param args the arguments
	 * 
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws IOException {
		final MendeleyOAuthService oauthService = MendeleyOAuthServiceFactory.getInstance().createMendeleyOAuthService(CONSUMER_KEY, CONSUMER_SECRET);
		
		System.out.println("Fetching request token from Mendeley...");
		
		MendeleyRequestToken requestToken = oauthService.getOAuthRequestToken();
		
        String authUrl = requestToken.getAuthorizationUrl();

        System.out.println("Request token: " + requestToken.getToken());
        System.out.println("Token secret: " + requestToken.getTokenSecret());
        System.out.println("Expiration time: " + requestToken.getExpirationTime());

        System.out.println("Now visit:\n" + authUrl
                + "\n... and grant this app authorization");
        System.out.println("Enter the PIN code and hit ENTER when you're done:");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String pin = br.readLine();

        System.out.println("Fetching access token from Mendeley...");
        
        MendeleyAccessToken accessToken = oauthService.getOAuthAccessToken(requestToken, pin);

        System.out.println("Access token: " + accessToken.getToken());
        System.out.println("Token secret: " + accessToken.getTokenSecret());
	}

}
