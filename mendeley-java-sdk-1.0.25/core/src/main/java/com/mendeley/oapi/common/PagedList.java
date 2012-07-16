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
package com.mendeley.oapi.common;

import java.util.List;

/**
 * The Interface PagedList.
 */
public interface PagedList<E> extends List<E> {

	/**
	 * Total results.
	 * 
	 * @return the long
	 */
	public long totalResults();
	
	/**
	 * Total pages.
	 * 
	 * @return the long
	 */
	public long totalPages();
	
	/**
	 * Current page.
	 * 
	 * @return the long
	 */
	public long currentPage();
	
	/**
	 * Items per page.
	 * 
	 * @return the long
	 */
	public long itemsPerPage();
}
