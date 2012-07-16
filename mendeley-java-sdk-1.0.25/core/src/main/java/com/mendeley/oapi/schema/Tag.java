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

/**
 * The Class Tag.
 */
public class Tag extends SchemaEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3484450630735705441L;
	
	/** The period. */
	private String period;
	
	/** The tags. */
	private String tags;
	
	/**
	 * Gets the period.
	 * 
	 * @return the period
	 */
	public String getPeriod() {
		return period;
	}
	
	/**
	 * Sets the period.
	 * 
	 * @param period the new period
	 */
	public void setPeriod(String period) {
		this.period = period;
	}
	
	/**
	 * Gets the tags.
	 * 
	 * @return the tags
	 */
	public String getTags() {
		return tags;
	}
	
	/**
	 * Sets the tags.
	 * 
	 * @param tags the new tags
	 */
	public void setTags(String tags) {
		this.tags = tags;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Tag [period=" + period + ", tags=" + tags + "]";
	}
}
