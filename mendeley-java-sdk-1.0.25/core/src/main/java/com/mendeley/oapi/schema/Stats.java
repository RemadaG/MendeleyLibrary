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
 * The Class Stats.
 */
public class Stats{
   	
	   /** The country. */
	   private List<Country> country;
   	
	   /** The discipline. */
	   private List<Discipline> discipline;
   	
	   /** The readers. */
	   private int readers;
   	
	   /** The status. */
	   private List<Status> status;

 	/**
	  * Gets the country.
	  * 
	  * @return the country
	  */
	 public List<Country> getCountry(){
		return this.country;
	}
	
	/**
	 * Sets the country.
	 * 
	 * @param country the new country
	 */
	public void setCountry(List<Country> country){
		this.country = country;
	}
 	
	 /**
	  * Gets the discipline.
	  * 
	  * @return the discipline
	  */
	 public List<Discipline> getDiscipline(){
		return this.discipline;
	}
	
	/**
	 * Sets the discipline.
	 * 
	 * @param discipline the new discipline
	 */
	public void setDiscipline(List<Discipline> discipline){
		this.discipline = discipline;
	}
 	
	 /**
	  * Gets the readers.
	  * 
	  * @return the readers
	  */
	 public int getReaders(){
		return this.readers;
	}
	
	/**
	 * Sets the readers.
	 * 
	 * @param readers the new readers
	 */
	public void setReaders(int readers){
		this.readers = readers;
	}
 	
	 /**
	  * Gets the status.
	  * 
	  * @return the status
	  */
	 public List<Status> getStatus(){
		return this.status;
	}
	
	/**
	 * Sets the status.
	 * 
	 * @param status the new status
	 */
	public void setStatus(List<Status> status){
		this.status = status;
	}
}
