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
package com.mendeley.oapi.schema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mendeley.oapi.common.ValueEnum;

/**
 * The Class Paper.
 */
public class Paper extends SchemaEntity {

	/**
	 * The Enum Type.
	 */
	public enum Type implements ValueEnum {
		;
		
	    /** The Constant stringToEnum. */
		private static final Map<String, Type> stringToEnum = new HashMap<String, Type>();

		static { // Initialize map from constant name to enum constant
			for (Type op : values()) {
				stringToEnum.put(op.value(), op);
			}
		}
		
		/** The value. */
		private String value;

		/**
		 * Instantiates a new type.
		 * 
		 * @param value the value
		 */
		Type(String value) {
			this.value = value;
		}
		
		/* (non-Javadoc)
		 * @see com.mendeley.oapi.common.ValueEnum#value()
		 */
		@Override
		public String value() {
			return value;
		}

		/**
		 * From value.
		 * 
		 * @param value the value
		 * 
		 * @return the type
		 */
		public static Type fromValue(String value) {
			return stringToEnum.get(value);
		}
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3484450630735705441L;
	
	/** The title. */
	private String title;
	
	/** The value. */
	private String value;
	
	/** The publication. */
	private String publication;
	
	/** The year. */
	private int year;
	
	/** The link. */
	private String link;
	
	/** The authors. */
	private List<String> authors = new ArrayList<String>();
	
	/**
	 * Gets the title.
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Sets the title.
	 * 
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Gets the value.
	 * 
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	
	/**
	 * Sets the value.
	 * 
	 * @param value the new value
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	/**
	 * Gets the publication.
	 * 
	 * @return the publication
	 */
	public String getPublication() {
		return publication;
	}
	
	/**
	 * Sets the publication.
	 * 
	 * @param publication the new publication
	 */
	public void setPublication(String publication) {
		this.publication = publication;
	}
	
	/**
	 * Gets the year.
	 * 
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 * Sets the year.
	 * 
	 * @param year the new year
	 */
	public void setYear(int year) {
		this.year = year;
	}
	
	/**
	 * Gets the link.
	 * 
	 * @return the link
	 */
	public String getLink() {
		return link;
	}
	
	/**
	 * Sets the link.
	 * 
	 * @param link the new link
	 */
	public void setLink(String link) {
		this.link = link;
	}
	
	/**
	 * Gets the authors.
	 * 
	 * @return the authors
	 */
	public List<String> getAuthors() {
		return authors;
	}
	
	/**
	 * Sets the authors.
	 * 
	 * @param authors the new authors
	 */
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Paper [authors=" + authors + ", link=" + link
				+ ", publication=" + publication + ", title=" + title
				+ ", value=" + value + ", year=" + year + "]";
	}
}
