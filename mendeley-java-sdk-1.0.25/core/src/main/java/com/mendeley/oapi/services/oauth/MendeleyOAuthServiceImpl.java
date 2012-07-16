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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;

import oauth.signpost.OAuth;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthProvider;

import org.apache.http.HttpRequest;

import com.mendeley.oapi.services.constant.MendeleyApiUrls;
import com.mendeley.oapi.services.impl.MendeleyApiGateway;

/**
 * The Class MendeleyOAuthServiceImpl.
 */
class MendeleyOAuthServiceImpl extends MendeleyApiGateway implements MendeleyOAuthService {

    /** The api consumer. */
    private final MendeleyApiConsumer apiConsumer;

    /** The request headers. */
    private Map<String, String> requestHeaders;
    
    /**
     * Instantiates a new mendeley o auth service impl.
     * 
     * @param apiConsumer the api consumer
     */
    MendeleyOAuthServiceImpl(MendeleyApiConsumer apiConsumer) {
    	requestHeaders = new HashMap<String, String>();
    	this.apiConsumer = apiConsumer;
    }
    
    /* (non-Javadoc)
     * @see com.mendeley.oapi.services.impl.MendeleyApiGateway#setRequestHeaders(java.util.Map)
     */
    public void setRequestHeaders(Map<String, String> requestHeaders) {
    	if (requestHeaders == null) {
    		throw new IllegalArgumentException("request headers cannot be null.");
    	}
        this.requestHeaders = requestHeaders;
    }

    /* (non-Javadoc)
     * @see com.mendeley.oapi.services.impl.MendeleyApiGateway#getRequestHeaders()
     */
    public Map<String, String> getRequestHeaders() {
        return requestHeaders;
    }

    /* (non-Javadoc)
     * @see com.mendeley.oapi.services.impl.MendeleyApiGateway#addRequestHeader(java.lang.String, java.lang.String)
     */
    public void addRequestHeader(String headerName, String headerValue) {
        requestHeaders.put(headerName, headerValue);
    }

    /* (non-Javadoc)
     * @see com.mendeley.oapi.services.impl.MendeleyApiGateway#removeRequestHeader(java.lang.String)
     */
    public void removeRequestHeader(String headerName) {
        requestHeaders.remove(headerName);
    }
    
    /* (non-Javadoc)
     * @see com.mendeley.oapi.services.oauth.MendeleyOAuthService#getOAuthAccessToken(com.mendeley.oapi.services.oauth.MendeleyRequestToken, java.lang.String)
     */
    @Override
    public MendeleyAccessToken getOAuthAccessToken(MendeleyRequestToken requestToken, String oauthVerifier) {
    	if (requestToken == null) {
    		throw new IllegalArgumentException("request token cannot be null.");
    	}
        try {
        	final OAuthConsumer consumer = getOAuthConsumer();
        	final OAuthProvider provider = getOAuthProvider();
        	
        	consumer.setTokenWithSecret(requestToken.getToken(), requestToken.getTokenSecret());
            provider.retrieveAccessToken(consumer, oauthVerifier);

            MendeleyAccessToken accessToken = new MendeleyAccessToken(consumer.getToken(), consumer.getTokenSecret());
            
//            SortedSet<String> responseParameters = provider.getResponseParameters().get(ApplicationConstants.EXPIRATION_PARAMETER_NAME);
//            setTokenExpirationTime(accessToken, responseParameters);
            
            return accessToken;
        } catch (Exception e) {
            throw new MendeleyOAuthServiceException(e);
        }
    }

    /* (non-Javadoc)
     * @see com.mendeley.oapi.services.oauth.MendeleyOAuthService#getOAuthRequestToken()
     */
    @Override
    public MendeleyRequestToken getOAuthRequestToken() {
        try {
        	final OAuthConsumer consumer = getOAuthConsumer();
        	final OAuthProvider provider = getOAuthProvider();
        	
            String               authorizationUrl = provider.retrieveRequestToken(consumer, OAuth.OUT_OF_BAND);
            MendeleyRequestToken requestToken     = new MendeleyRequestToken(consumer.getToken(),
                                                        consumer.getTokenSecret());

            requestToken.setAuthorizationUrl(authorizationUrl);
            
//            SortedSet<String> responseParameters = provider.getResponseParameters().get(ApplicationConstants.EXPIRATION_PARAMETER_NAME);
//            setTokenExpirationTime(requestToken, responseParameters);

            return requestToken;
        } catch (Exception e) {
            throw new MendeleyOAuthServiceException(e);
        }
    }

    /* (non-Javadoc)
     * @see com.mendeley.oapi.services.oauth.MendeleyOAuthService#getOAuthRequestToken(java.lang.String)
     */
    @Override
    public MendeleyRequestToken getOAuthRequestToken(String callBackUrl) {
        try {
        	final OAuthConsumer consumer = getOAuthConsumer();
        	final OAuthProvider provider = getOAuthProvider();
        	
            String               authorizationUrl = provider.retrieveRequestToken(consumer, callBackUrl);
            MendeleyRequestToken requestToken     = new MendeleyRequestToken(consumer.getToken(),
                                                        consumer.getTokenSecret());

            requestToken.setAuthorizationUrl(authorizationUrl);

            return requestToken;
        } catch (Exception e) {
            throw new MendeleyOAuthServiceException(e);
        }
    }
    
    /* (non-Javadoc)
     * @see com.mendeley.oapi.services.oauth.MendeleyOAuthService#signRequestWithToken(java.net.HttpURLConnection, com.mendeley.oapi.services.oauth.MendeleyAccessToken)
     */
    @Override
    public void signRequestWithToken(HttpURLConnection request, MendeleyAccessToken accessToken) {
    	if (accessToken == null) {
    		throw new IllegalArgumentException("access token cannot be null.");
    	}
        try {
        	final OAuthConsumer consumer = getOAuthConsumer();
            consumer.setTokenWithSecret(accessToken.getToken(), accessToken.getTokenSecret());
            consumer.sign(request);
        } catch (Exception e) {
            throw new MendeleyOAuthServiceException(e);
        }
    }
    
    /* (non-Javadoc)
     * @see com.mendeley.oapi.services.oauth.MendeleyOAuthService#signRequestWithToken(org.apache.http.HttpRequest, com.mendeley.oapi.services.oauth.MendeleyAccessToken)
     */
    @Override
    public void signRequestWithToken(HttpRequest request, MendeleyAccessToken accessToken) {
    	if (accessToken == null) {
    		throw new IllegalArgumentException("access token cannot be null.");
    	}
        try {
        	final OAuthConsumer consumer = getOAuthConsumer();
        	consumer.setTokenWithSecret(accessToken.getToken(), accessToken.getTokenSecret());
            consumer.sign(request);
        } catch (Exception e) {
            throw new MendeleyOAuthServiceException(e);
        }
    }
    
    /* (non-Javadoc)
     * @see com.mendeley.oapi.services.oauth.MendeleyOAuthService#invalidateAccessToken(com.mendeley.oapi.services.oauth.MendeleyAccessToken)
     */
	@Override
	public void invalidateAccessToken(MendeleyAccessToken accessToken) {
    	if (accessToken == null) {
    		throw new IllegalArgumentException("access token cannot be null.");
    	}
        try {
            URL               url     = new URL(MendeleyApiUrls.OAuthUrls.AUTHORIZE_URL);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
        	
        	final OAuthConsumer consumer = getOAuthConsumer();
            consumer.setTokenWithSecret(accessToken.getToken(), accessToken.getTokenSecret());
            consumer.sign(request);
            request.connect();

            if (request.getResponseCode() != HttpURLConnection.HTTP_OK) {
            	throw new MendeleyOAuthServiceException(convertStreamToString(request.getErrorStream()));
            }
        } catch (Exception e) {
            throw new MendeleyOAuthServiceException(e);
        }
	}
    
    /**
     * Gets the o auth provider.
     * 
     * @return the o auth provider
     */
    protected OAuthProvider getOAuthProvider() {
    	OAuthProvider provider = new CommonsHttpOAuthProvider(MendeleyApiUrls.OAuthUrls.REQUEST_TOKEN_URL,
    			MendeleyApiUrls.OAuthUrls.ACCESS_TOKEN_URL, MendeleyApiUrls.OAuthUrls.AUTHORIZE_URL);
    	
    	provider.setOAuth10a(true);
//        for (String headerName : requestHeaders.keySet()) {
//        	provider.setRequestHeader(headerName, requestHeaders.get(headerName));
//        }
    	
    	return provider;
	}

    /**
     * Gets the o auth consumer.
     * 
     * @return the o auth consumer
     */
	protected OAuthConsumer getOAuthConsumer() {
		OAuthConsumer consumer = new CommonsHttpOAuthConsumer(apiConsumer.getConsumerKey(), apiConsumer.getConsumerSecret());
//		consumer.setMessageSigner(new HmacSha1MessageSigner());
//		consumer.setSigningStrategy(new AuthorizationHeaderSigningStrategy());
		return consumer;
	}
	
	/**
	 * Sets the token expiration time.
	 * 
	 * @param token the token
	 * @param responseParameters the response parameters
	 */
	protected void setTokenExpirationTime(MendeleyOAuthToken token,
			SortedSet<String> responseParameters) {
		if (responseParameters != null && !responseParameters.isEmpty()) {
			Calendar calendar = Calendar.getInstance();
			int secondsToLive = Integer.valueOf(responseParameters.first());
			calendar.add(Calendar.SECOND, secondsToLive);
			token.setExpirationTime(calendar.getTime());
		}
	}

	/**
	 * Convert stream to string.
	 * 
	 * @param is the is
	 * 
	 * @return the string
	 */
	protected static String convertStreamToString(InputStream is) {
        /*
         * To convert the InputStream to String we use the BufferedReader.readLine()
         * method. We iterate until the BufferedReader return null which means
         * there's no more data to read. Each line will appended to a StringBuilder
         * and returned as String.
         */
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
 
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
 
        return sb.toString();
    }

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.impl.MendeleyApiGateway#signRequest(java.net.HttpURLConnection)
	 */
	@Override
	protected void signRequest(HttpURLConnection request) {}
	
	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.impl.MendeleyApiGateway#signRequest(org.apache.http.HttpRequest)
	 */
	@Override
	protected void signRequest(HttpRequest request) {}
}
