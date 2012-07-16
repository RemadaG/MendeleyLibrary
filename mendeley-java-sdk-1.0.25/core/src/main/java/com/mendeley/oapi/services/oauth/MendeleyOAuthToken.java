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

import java.io.Serializable;
import java.util.Date;

/**
 * The Class MendeleyOAuthToken.
 */
public abstract class MendeleyOAuthToken implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4249791194912997698L;
	
    /** The token. */
    private String token;

    /** The token secret. */
    private String tokenSecret;
    
    /** The expiration time. */
    private Date expirationTime;

    /**
     * Instantiates a new mendeley o auth token.
     * 
     * @param token the token
     * @param tokenSecret the token secret
     */
    public MendeleyOAuthToken(String token, String tokenSecret) {
        this.token       = token;
        this.tokenSecret = tokenSecret;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime  = 31;
        int       result = 1;

        result = prime * result + ((token == null)
                                   ? 0
                                   : token.hashCode());
        result = prime * result + ((tokenSecret == null)
                                   ? 0
                                   : tokenSecret.hashCode());

        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final MendeleyOAuthToken other = (MendeleyOAuthToken) obj;

        if (token == null) {
            if (other.token != null) {
                return false;
            }
        } else if (!token.equals(other.token)) {
            return false;
        }

        if (tokenSecret == null) {
            if (other.tokenSecret != null) {
                return false;
            }
        } else if (!tokenSecret.equals(other.tokenSecret)) {
            return false;
        }

        return true;
    }

	/**
	 * Gets the token.
	 * 
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * Sets the token.
	 * 
	 * @param token the new token
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * Gets the token secret.
	 * 
	 * @return the token secret
	 */
	public String getTokenSecret() {
		return tokenSecret;
	}

	/**
	 * Sets the token secret.
	 * 
	 * @param tokenSecret the new token secret
	 */
	public void setTokenSecret(String tokenSecret) {
		this.tokenSecret = tokenSecret;
	}

	/**
	 * Gets the expiration time.
	 * 
	 * @return the expiration time
	 */
	public Date getExpirationTime() {
		return expirationTime;
	}

	/**
	 * Sets the expiration time.
	 * 
	 * @param expirationTime the new expiration time
	 */
	public void setExpirationTime(Date expirationTime) {
		this.expirationTime = expirationTime;
	}
}
