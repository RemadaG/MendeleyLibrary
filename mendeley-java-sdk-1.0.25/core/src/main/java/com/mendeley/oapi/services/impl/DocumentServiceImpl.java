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

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.mendeley.oapi.common.PagedList;
import com.mendeley.oapi.schema.Document;
import com.mendeley.oapi.services.DocumentService;
import com.mendeley.oapi.services.constant.MendeleyApiUrls;
import com.mendeley.oapi.services.constant.ParameterNames;
import com.mendeley.oapi.services.constant.MendeleyApiUrls.MendeleyApiUrlBuilder;
import com.mendeley.oapi.services.oauth.MendeleyAccessToken;
import com.mendeley.oapi.services.oauth.MendeleyApiConsumer;

/**
 * The Class DocumentServiceImpl.
 */
public class DocumentServiceImpl extends BaseMendeleyPrivateService implements
		DocumentService {

	/**
	 * Instantiates a new document service impl.
	 * 
	 * @param apiConsumer the api consumer
	 * @param accessToken the access token
	 */
	public DocumentServiceImpl(MendeleyApiConsumer apiConsumer,
			MendeleyAccessToken accessToken) {
		super(apiConsumer, accessToken);
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.DocumentService#createDocument(com.mendeley.oapi.schema.Document)
	 */
	@Override
	public void createDocument(Document document) {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.DocumentApiUrls.CREATE_DOCUMENT_URL);
        String                apiUrl  = builder.buildUrl();
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put(ParameterNames.DOCUMENT, getGsonBuilder().create().toJson(document));
        callApiPost(apiUrl, parameters);
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.DocumentService#uploadFile(java.lang.String, java.io.InputStream)
	 */
	@Override
	public void uploadFile(String documentId, InputStream file) {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.DocumentApiUrls.UPLOAD_FILE_URL);
        String                apiUrl  = builder.withField(ParameterNames.ID, documentId).buildUrl();
        callApiPut(apiUrl, file, null, HttpURLConnection.HTTP_CREATED);
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.DocumentService#getAuthoredPublications()
	 */
	@Override
	public PagedList<String> getAuthoredDocumentIds() {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.DocumentApiUrls.GET_AUTHORED_PUBLICATIONS_URL);
        String                apiUrl  = builder.buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshallList(String.class, json, "document_ids");
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.DocumentService#getDocumentDetails(java.lang.String)
	 */
	@Override
	public Document getDocumentDetails(String documentId) {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.DocumentApiUrls.GET_DOCUMENT_DETAILS_URL);
        String                apiUrl  = builder.withField(ParameterNames.ID, documentId).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<Document>(){}, json);
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.DocumentService#getDocumentIds()
	 */
	@Override
	public PagedList<String> getDocumentIds() {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.DocumentApiUrls.GET_DOCUMENT_IDS_URL);
        String                apiUrl  = builder.buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshallList(String.class, json, "document_ids");
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.DocumentService#getDocumentIds(int, int)
	 */
	@Override
	public PagedList<String> getDocumentIds(int page, int itemsPerPage) {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.DocumentApiUrls.GET_DOCUMENT_IDS_URL);
        String                apiUrl  = builder.withParameter(ParameterNames.PAGE, String.valueOf(page)).withParameter(ParameterNames.ITEMS, String.valueOf(itemsPerPage)).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshallList(String.class, json, "document_ids");
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.DocumentService#removeDocument(java.lang.String)
	 */
	@Override
	public void removeDocument(String documentId) {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.DocumentApiUrls.REMOVE_DOCUMENT_URL);
        String                apiUrl  = builder.withField(ParameterNames.ID, documentId).buildUrl();
        callApiDelete(apiUrl, HttpURLConnection.HTTP_NO_CONTENT);
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.DocumentService#downloadFile(java.lang.String, java.lang.String)
	 */
	@Override
	public InputStream downloadFile(String documentId, String fileHash) {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.DocumentApiUrls.DOWNLOAD_FILE_URL);
        String                apiUrl  = builder.withField(ParameterNames.ID, documentId).withField(ParameterNames.FILE_HASH, fileHash).buildUrl();
		return callApiGet(apiUrl);
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.DocumentService#downloadFile(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public InputStream downloadFile(String documentId, String fileHash,
			String groupId) {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.DocumentApiUrls.DOWNLOAD_FILE_URL);
        String                apiUrl  = builder.withField(ParameterNames.ID, documentId).withField(ParameterNames.FILE_HASH, fileHash).buildUrl();
		return callApiGet(apiUrl);
	}
}
