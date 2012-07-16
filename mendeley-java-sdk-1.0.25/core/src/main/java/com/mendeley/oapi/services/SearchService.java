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

import java.util.List;

import com.mendeley.oapi.common.PagedList;
import com.mendeley.oapi.schema.Category;
import com.mendeley.oapi.schema.Document;


/**
 * The Interface SearchService.
 */
public interface SearchService extends MendeleyService {
	
	/**
	 * Search.
	 * 
	 * @param terms the terms
	 * 
	 * @return the paged list< document>
	 */
	public PagedList<Document> search(String... terms);
	
	/**
	 * Search.
	 * 
	 * @param terms the terms
	 * @param page the page
	 * @param itemsPerPage the items per page
	 * 
	 * @return the paged list< document>
	 */
	public PagedList<Document> search(String terms, int page, int itemsPerPage);
	
	/**
	 * Gets the document details.
	 * 
	 * @param documentId the document id
	 * 
	 * @return the document details
	 */
	public Document getDocumentDetails(String documentId);
	
	/**
	 * Gets the document details.
	 * 
	 * @param documentId the document id
	 * @param type the type
	 * 
	 * @return the document details
	 */
	public Document getDocumentDetails(String documentId, Document.Type type);
	
	/**
	 * Gets the related documents.
	 * 
	 * @param documentId the document id
	 * 
	 * @return the related documents
	 */
	public PagedList<Document> getRelatedDocuments(String documentId);
	
	/**
	 * Gets the documents by author.
	 * 
	 * @param authorName the author name
	 * 
	 * @return the documents by author
	 */
	public PagedList<Document> getDocumentsByAuthor(String authorName);
	
	/**
	 * Gets the documents by author.
	 * 
	 * @param authorName the author name
	 * @param year the year
	 * 
	 * @return the documents by author
	 */
	public PagedList<Document> getDocumentsByAuthor(String authorName, int year);
	
	/**
	 * Gets the documents by author.
	 * 
	 * @param authorName the author name
	 * @param page the page
	 * @param itemsPerPage the items per page
	 * 
	 * @return the documents by author
	 */
	public PagedList<Document> getDocumentsByAuthor(String authorName, int page, int itemsPerPage);
	
	/**
	 * Gets the documents by tag.
	 * 
	 * @param tag the tag
	 * 
	 * @return the documents by tag
	 */
	public PagedList<Document> getDocumentsByTag(String tag);
	
	/**
	 * Gets the documents by tag.
	 * 
	 * @param tag the tag
	 * @param page the page
	 * @param itemsPerPage the items per page
	 * 
	 * @return the documents by tag
	 */
	public PagedList<Document> getDocumentsByTag(String tag, int page, int itemsPerPage);
	
	/**
	 * Gets the documents by tag.
	 * 
	 * @param tag the tag
	 * @param category the category
	 * @param subCategory the sub category
	 * 
	 * @return the documents by tag
	 */
	public PagedList<Document> getDocumentsByTag(String tag, String category, String subCategory);
	
	/**
	 * Gets the categories.
	 * 
	 * @return the categories
	 */
	public List<Category> getCategories();
	
	/**
	 * Gets the sub categories.
	 * 
	 * @param categoryId the category id
	 * 
	 * @return the sub categories
	 */
	public List<Category> getSubCategories(String categoryId);
}
