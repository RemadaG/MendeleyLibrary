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

/**
 * The Class MendeleyException.
 */
public class MendeleyException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2392119987027760999L;

	/**
	 * Instantiates a new mendeley exception.
	 */
	public MendeleyException() {}

	/**
	 * Instantiates a new mendeley exception.
	 * 
	 * @param message the message
	 */
	public MendeleyException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new mendeley exception.
	 * 
	 * @param cause the cause
	 */
	public MendeleyException(Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new mendeley exception.
	 * 
	 * @param message the message
	 * @param cause the cause
	 */
	public MendeleyException(String message, Throwable cause) {
		super(message, cause);
	}
}
