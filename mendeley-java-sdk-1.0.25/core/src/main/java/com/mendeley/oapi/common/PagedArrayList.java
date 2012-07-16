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

import java.util.ArrayList;


/**
 * The Class PagedArrayList.
 */
public class PagedArrayList<E> extends ArrayList<E> implements PagedList<E> {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5011544152511118680L;
	
	/** The cursor. */
	private Cursor cursor = new Cursor();
	
	/* (non-Javadoc)
	 * @see org.worldbank.api.common.PagedList#page()
	 */
	@Override
	public long totalResults() {
		return cursor.getTotalResults();
	}

	/* (non-Javadoc)
	 * @see org.worldbank.api.common.PagedList#pages()
	 */
	@Override
	public long totalPages() {
		return cursor.getTotalPages();
	}

	/* (non-Javadoc)
	 * @see org.worldbank.api.common.PagedList#perPage()
	 */
	@Override
	public long currentPage() {
		return cursor.getCurrentPage();
	}

	/* (non-Javadoc)
	 * @see org.worldbank.api.common.PagedList#total()
	 */
	@Override
	public long itemsPerPage() {
		return cursor.getItemsPerPage();
	}
	
	/**
	 * Gets the cursor.
	 * 
	 * @return the cursor
	 */
	public Cursor getCursor() {
		return cursor;
	}
	
	/**
	 * Sets the cursor.
	 * 
	 * @param cursor the new cursor
	 */
	public void setCursor(Cursor cursor) {
		this.cursor = cursor;
	}
	
	/**
	 * The Class Cursor.
	 */
	public static class Cursor {
		
		/** The total results. */
		private long totalResults;
		
		/** The total pages. */
		private long totalPages;
		
		/** The current page. */
		private long currentPage;
		
		/** The items per page. */
		private long itemsPerPage;

		/**
		 * Gets the total results.
		 * 
		 * @return the total results
		 */
		public long getTotalResults() {
			return totalResults;
		}

		/**
		 * Sets the total results.
		 * 
		 * @param totalResults the new total results
		 */
		public void setTotalResults(long totalResults) {
			this.totalResults = totalResults;
		}

		/**
		 * Gets the total pages.
		 * 
		 * @return the total pages
		 */
		public long getTotalPages() {
			return totalPages;
		}

		/**
		 * Sets the total pages.
		 * 
		 * @param totalPages the new total pages
		 */
		public void setTotalPages(long totalPages) {
			this.totalPages = totalPages;
		}

		/**
		 * Gets the current page.
		 * 
		 * @return the current page
		 */
		public long getCurrentPage() {
			return currentPage;
		}

		/**
		 * Sets the current page.
		 * 
		 * @param currentPage the new current page
		 */
		public void setCurrentPage(long currentPage) {
			this.currentPage = currentPage;
		}

		/**
		 * Gets the items per page.
		 * 
		 * @return the items per page
		 */
		public long getItemsPerPage() {
			return itemsPerPage;
		}

		/**
		 * Sets the items per page.
		 * 
		 * @param itemsPerPage the new items per page
		 */
		public void setItemsPerPage(long itemsPerPage) {
			this.itemsPerPage = itemsPerPage;
		}
	}
}
