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
 * The Class Profile.
 */
public class Profile extends SchemaEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3484450630735705441L;
	
	/** The Constant ME. */
	public static final String ME = "me";
	
	/**
	 * The Enum Section.
	 */
	public enum Section implements ValueEnum {
		
		/** The MAIN. */
		MAIN("main"), 
 /** The AWARDS. */
 AWARDS("awards"), 
 /** The CV. */
 CV("cv"), 
 /** The CONTACT. */
 CONTACT("contact"), 
 /** The CONSULTING. */
 CONSULTING("consulting"), 
 /** The EDUCATION. */
 EDUCATION("education"), 
 /** The EMPLOYMENT. */
 EMPLOYMENT("employment");
		
		
	    /** The Constant stringToEnum. */
		private static final Map<String, Section> stringToEnum = new HashMap<String, Section>();

		static { // Initialize map from constant name to enum constant
			for (Section op : values()) {
				stringToEnum.put(op.value(), op);
			}
		}
		
		/** The value. */
		private String value;

		/**
		 * Instantiates a new section.
		 * 
		 * @param value the value
		 */
		Section(String value) {
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
		 * @return the section
		 */
		public static Section fromValue(String value) {
			return stringToEnum.get(value);
		}
	}
	
	/** The main. */
	private User main;
	
	/** The awards. */
	private List<Award> awards = new ArrayList<Award>();
	
	/** The cv. */
	private CurriculumVitae cv;
	
	/** The contact. */
	private List<Contact> contact = new ArrayList<Contact>();
	
	/**
	 * Gets the main.
	 * 
	 * @return the main
	 */
	public User getMain() {
		return main;
	}
	
	/**
	 * Sets the main.
	 * 
	 * @param main the new main
	 */
	public void setMain(User main) {
		this.main = main;
	}
	
	/**
	 * Gets the awards.
	 * 
	 * @return the awards
	 */
	public List<Award> getAwards() {
		return awards;
	}
	
	/**
	 * Sets the awards.
	 * 
	 * @param awards the new awards
	 */
	public void setAwards(List<Award> awards) {
		this.awards = awards;
	}
	
	/**
	 * Gets the cv.
	 * 
	 * @return the cv
	 */
	public CurriculumVitae getCv() {
		return cv;
	}
	
	/**
	 * Sets the cv.
	 * 
	 * @param cv the new cv
	 */
	public void setCv(CurriculumVitae cv) {
		this.cv = cv;
	}
	
	/**
	 * Gets the contact.
	 * 
	 * @return the contact
	 */
	public List<Contact> getContact() {
		return contact;
	}
	
	/**
	 * Sets the contact.
	 * 
	 * @param contact the new contact
	 */
	public void setContact(List<Contact> contact) {
		this.contact = contact;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Profile [awards=" + awards + ", contact=" + contact + ", cv="
				+ cv + ", main=" + main + "]";
	}
}
