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

import java.net.HttpURLConnection;

import org.apache.http.HttpRequest;

import com.mendeley.oapi.services.MendeleyService;

/**
 * The Interface MendeleyOAuthService.
 */
public interface MendeleyOAuthService extends MendeleyService {

    /**
     * Gets the o auth request token.
     * 
     * @return the o auth request token
     */
    public MendeleyRequestToken getOAuthRequestToken();

    /**
     * Gets the o auth request token.
     * 
     * @param callBackUrl the call back url
     * 
     * @return the o auth request token
     */
    public MendeleyRequestToken getOAuthRequestToken(String callBackUrl);
    
    /**
     * Gets the o auth access token.
     * 
     * @param requestToken the request token
     * @param oauthVerifier the oauth verifier
     * 
     * @return the o auth access token
     */
    public MendeleyAccessToken getOAuthAccessToken(MendeleyRequestToken requestToken, String oauthVerifier);

    /**
     * Sign request with token.
     * 
     * @param request the request
     * @param accessToken the access token
     */
    public void signRequestWithToken(HttpURLConnection request, MendeleyAccessToken accessToken);
    
    /**
     * Sign request with token.
     * 
     * @param request the request
     * @param accessToken the access token
     */
    public void signRequestWithToken(HttpRequest request, MendeleyAccessToken accessToken);
    
    /**
     * Invalidate access token.
     * 
     * @param accessToken the access token
     */
    public void invalidateAccessToken(MendeleyAccessToken accessToken);
}
