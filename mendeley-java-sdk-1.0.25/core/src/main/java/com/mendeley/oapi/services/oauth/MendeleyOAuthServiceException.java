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
 * The Class MendeleyOAuthServiceException.
 */
public class MendeleyOAuthServiceException extends RuntimeException {

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4345556572105572685L;

	/**
	 * Instantiates a new mendeley o auth service exception.
	 */
    public MendeleyOAuthServiceException() {
        super();
    }

    /**
     * Instantiates a new mendeley o auth service exception.
     * 
     * @param message the message
     */
    public MendeleyOAuthServiceException(String message) {
        super(message);
    }

    /**
     * Instantiates a new mendeley o auth service exception.
     * 
     * @param cause the cause
     */
    public MendeleyOAuthServiceException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new mendeley o auth service exception.
     * 
     * @param message the message
     * @param cause the cause
     */
    public MendeleyOAuthServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
