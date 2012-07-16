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

import java.io.InputStream;

import com.mendeley.oapi.common.PagedList;
import com.mendeley.oapi.schema.Document;



/**
 * The Interface DocumentService.
 */
public interface DocumentService extends MendeleyService {
	
	/**
	 * Gets the document ids.
	 * 
	 * @return the document ids
	 */
	public PagedList<String> getDocumentIds();
	
	/**
	 * Gets the document ids.
	 * 
	 * @param page the page
	 * @param itemsPerPage the items per page
	 * 
	 * @return the document ids
	 */
	public PagedList<String> getDocumentIds(int page, int itemsPerPage);
	
	/**
	 * Gets the authored document ids.
	 * 
	 * @return the authored document ids
	 */
	public PagedList<String> getAuthoredDocumentIds();
	
	/**
	 * Gets the document details.
	 * 
	 * @param documentId the document id
	 * 
	 * @return the document details
	 */
	public Document getDocumentDetails(String documentId);
	
	/**
	 * Creates the document.
	 * 
	 * @param document the document
	 */
	public void createDocument(Document document);
	
	/**
	 * Removes the document.
	 * 
	 * @param documentId the document id
	 */
	public void removeDocument(String documentId);
	
	/**
	 * Upload file.
	 * 
	 * @param documentId the document id
	 * @param file the file
	 */
	public void uploadFile(String documentId, InputStream file);
	
	/**
	 * Download file.
	 * 
	 * @param documentId the document id
	 * @param fileHash the file hash
	 * 
	 * @return the input stream
	 */
	public InputStream downloadFile(String documentId, String fileHash);
	
	/**
	 * Download file.
	 * 
	 * @param documentId the document id
	 * @param fileHash the file hash
	 * @param groupId the group id
	 * 
	 * @return the input stream
	 */
	public InputStream downloadFile(String documentId, String fileHash, String groupId);
}
