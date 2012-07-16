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
import com.mendeley.oapi.schema.Folder;

/**
 * The Interface FolderService.
 */
public interface FolderService extends MendeleyService {
	
	/**
	 * Gets the folders.
	 * 
	 * @return the folders
	 */
	public List<Folder> getFolders();
	
	/**
	 * Gets the folder documents.
	 * 
	 * @param collectionId the collection id
	 * 
	 * @return the folder documents
	 */
	public PagedList<String> getFolderDocuments(String collectionId);
	
	/**
	 * Gets the folder documents.
	 * 
	 * @param collectionId the collection id
	 * @param page the page
	 * @param itemsPerPage the items per page
	 * 
	 * @return the folder documents
	 */
	public PagedList<String> getFolderDocuments(String collectionId, int page, int itemsPerPage);
	
	/**
	 * Adds the document to folder.
	 * 
	 * @param collectionId the collection id
	 * @param documentId the document id
	 * 
	 * @return the string
	 */
	public String addDocumentToFolder(String collectionId, String documentId);
	
	/**
	 * Creates the folder.
	 * 
	 * @param name the name
	 * @param type the type
	 * 
	 * @return the folder
	 */
	public Folder createFolder(String name, Folder.Type type);
	
	/**
	 * Removes the folder.
	 * 
	 * @param collectionId the collection id
	 */
	public void removeFolder(String collectionId);
	
	/**
	 * Removes the document from folder.
	 * 
	 * @param collectionId the collection id
	 * @param documentId the document id
	 */
	public void removeDocumentFromFolder(String collectionId, String documentId);
	
}
