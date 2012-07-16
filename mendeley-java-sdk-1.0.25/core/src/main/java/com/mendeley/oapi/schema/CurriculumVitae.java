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

import java.util.List;

/**
 * The Class CurriculumVitae.
 */
public class CurriculumVitae extends SchemaEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3484450630735705441L;
	
	/** The consulting. */
	private List<String> consulting;
	
	/** The education. */
	private List<Education> education;
	
	/** The employment. */
	private List<Employment> employment;
	
	/**
	 * Gets the consulting.
	 * 
	 * @return the consulting
	 */
	public List<String> getConsulting() {
		return consulting;
	}
	
	/**
	 * Sets the consulting.
	 * 
	 * @param consulting the new consulting
	 */
	public void setConsulting(List<String> consulting) {
		this.consulting = consulting;
	}
	
	/**
	 * Gets the education.
	 * 
	 * @return the education
	 */
	public List<Education> getEducation() {
		return education;
	}
	
	/**
	 * Sets the education.
	 * 
	 * @param education the new education
	 */
	public void setEducation(List<Education> education) {
		this.education = education;
	}
	
	/**
	 * Gets the employment.
	 * 
	 * @return the employment
	 */
	public List<Employment> getEmployment() {
		return employment;
	}
	
	/**
	 * Sets the employment.
	 * 
	 * @param employment the new employment
	 */
	public void setEmployment(List<Employment> employment) {
		this.employment = employment;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CurriculumVitae [consulting=" + consulting + ", education="
				+ education + ", employment=" + employment + "]";
	}
}
