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
package com.mendeley.oapi.services.impl;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.mendeley.oapi.common.PagedList;
import com.mendeley.oapi.schema.Folder;
import com.mendeley.oapi.schema.Folder.Type;
import com.mendeley.oapi.services.FolderService;
import com.mendeley.oapi.services.constant.MendeleyApiUrls;
import com.mendeley.oapi.services.constant.ParameterNames;
import com.mendeley.oapi.services.constant.MendeleyApiUrls.MendeleyApiUrlBuilder;
import com.mendeley.oapi.services.oauth.MendeleyAccessToken;
import com.mendeley.oapi.services.oauth.MendeleyApiConsumer;

/**
 * The Class FolderServiceImpl.
 */
public class FolderServiceImpl extends BaseMendeleyPrivateService implements
		FolderService {

	/**
	 * Instantiates a new folder service impl.
	 * 
	 * @param apiConsumer the api consumer
	 * @param accessToken the access token
	 */
	public FolderServiceImpl(MendeleyApiConsumer apiConsumer,
			MendeleyAccessToken accessToken) {
		super(apiConsumer, accessToken);
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.FolderService#addDocumentToFolder(java.lang.String, java.lang.String)
	 */
	@Override
	public String addDocumentToFolder(String collectionId, String documentId) {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.FolderApiUrls.ADD_DOCUMENT_TO_FOLDER_URL);
        String                apiUrl  = builder.withField(ParameterNames.COLLECTION_ID, collectionId).withField(ParameterNames.DOCUMENT_ID, documentId).buildUrl();
        Map<String, String> parameters = new HashMap<String, String>();
        JsonElement json = unmarshall(callApiPost(apiUrl, parameters));
        return unmarshall(new TypeToken<String>(){}, json);
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.FolderService#createFolder(java.lang.String, com.mendeley.oapi.schema.Folder.Type)
	 */
	@Override
	public Folder createFolder(String name, Type type) {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.FolderApiUrls.CREATE_FOLDER_URL);
        String                apiUrl  = builder.buildUrl();
        Folder folder = new Folder();
        folder.setName(name);
//        folder.setType(type);
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put(ParameterNames.FOLDER, getGsonBuilder().create().toJson(folder));
        JsonElement json = unmarshall(callApiPost(apiUrl, parameters, HttpURLConnection.HTTP_CREATED));
        return unmarshall(new TypeToken<Folder>(){}, json);
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.FolderService#getFolderDocuments(java.lang.String)
	 */
	@Override
	public PagedList<String> getFolderDocuments(String collectionId) {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.FolderApiUrls.GET_FOLDER_DOCUMENTS_URL);
        String                apiUrl  = builder.withField(ParameterNames.ID, collectionId).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshallList(String.class, json, "document_ids");
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.FolderService#getFolderDocuments(java.lang.String, int, int)
	 */
	@Override
	public PagedList<String> getFolderDocuments(String collectionId,
			int page, int itemsPerPage) {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.FolderApiUrls.GET_FOLDER_DOCUMENTS_URL);
        String                apiUrl  = builder.withField(ParameterNames.ID, collectionId).withParameter(ParameterNames.PAGE, String.valueOf(page)).withParameter(ParameterNames.ITEMS, String.valueOf(itemsPerPage)).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshallList(String.class, json, "document_ids");
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.FolderService#getFolders()
	 */
	@Override
	public List<Folder> getFolders() {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.FolderApiUrls.GET_FOLDERS_URL);
        String                apiUrl  = builder.buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshallList(Folder.class, json);
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.FolderService#removeFolder(java.lang.String)
	 */
	@Override
	public void removeFolder(String collectionId) {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.FolderApiUrls.REMOVE_FOLDER_URL);
        String                apiUrl  = builder.withField(ParameterNames.ID, collectionId).buildUrl();
        callApiDelete(apiUrl, HttpURLConnection.HTTP_NO_CONTENT);
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.FolderService#removeDocumentFromFolder(java.lang.String, java.lang.String)
	 */
	@Override
	public void removeDocumentFromFolder(String collectionId,
			String documentId) {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.FolderApiUrls.REMOVE_DOCUMENT_FROM_FOLDER_URL);
        String                apiUrl  = builder.withField(ParameterNames.COLLECTION_ID, collectionId).withField(ParameterNames.DOCUMENT_ID, documentId).buildUrl();
        callApiDelete(apiUrl, HttpURLConnection.HTTP_NO_CONTENT);
	}
}
