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

import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.mendeley.oapi.common.PagedList;
import com.mendeley.oapi.schema.Category;
import com.mendeley.oapi.schema.Document;
import com.mendeley.oapi.schema.Document.Type;
import com.mendeley.oapi.services.SearchService;
import com.mendeley.oapi.services.constant.MendeleyApiUrls;
import com.mendeley.oapi.services.constant.ParameterNames;
import com.mendeley.oapi.services.constant.MendeleyApiUrls.MendeleyApiUrlBuilder;
import com.mendeley.oapi.services.oauth.MendeleyApiConsumer;

/**
 * The Class SearchServiceImpl.
 */
public class SearchServiceImpl extends BaseMendeleyPublicService implements
		SearchService {

	/**
	 * Instantiates a new search service impl.
	 * 
	 * @param apiConsumer the api consumer
	 */
	public SearchServiceImpl(MendeleyApiConsumer apiConsumer) {
		super(apiConsumer);
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.SearchService#getDocumentDetails(java.lang.String)
	 */
	@Override
	public Document getDocumentDetails(String documentId) {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.SearchApiUrls.GET_DOCUMENT_DETAILS_URL);
        String                apiUrl  = builder.withField(ParameterNames.ID, documentId).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<Document>(){}, json);
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.SearchService#getDocumentDetails(java.lang.String, com.mendeley.oapi.schema.Document.Type)
	 */
	@Override
	public Document getDocumentDetails(String documentId, Type type) {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.SearchApiUrls.GET_DOCUMENT_DETAILS_URL);
        String                apiUrl  = builder.withField(ParameterNames.ID, documentId).withParameterEnum(ParameterNames.TYPE, type).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<Document>(){}, json);
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.SearchService#getDocumentsByAuthor(java.lang.String)
	 */
	@Override
	public PagedList<Document> getDocumentsByAuthor(String authorName) {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.SearchApiUrls.GET_DOCUMENTS_BY_AUTHOR_URL);
        String                apiUrl  = builder.withField(ParameterNames.NAME, authorName).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshallList(Document.class, json, "documents");
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.SearchService#getDocumentsByAuthor(java.lang.String, int)
	 */
	@Override
	public PagedList<Document> getDocumentsByAuthor(String authorName, int year) {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.SearchApiUrls.GET_DOCUMENTS_BY_AUTHOR_URL);
        String                apiUrl  = builder.withField(ParameterNames.NAME, authorName).withParameter(ParameterNames.YEAR, String.valueOf(year)).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshallList(Document.class, json, "documents");
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.SearchService#getDocumentsByAuthor(java.lang.String, int, int)
	 */
	@Override
	public PagedList<Document> getDocumentsByAuthor(String authorName,
			int page, int itemsPerPage) {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.SearchApiUrls.GET_DOCUMENTS_BY_AUTHOR_URL);
        String                apiUrl  = builder.withField(ParameterNames.NAME, authorName).withParameter(ParameterNames.PAGE, String.valueOf(page)).withParameter(ParameterNames.ITEMS, String.valueOf(itemsPerPage)).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshallList(Document.class, json, "documents");
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.SearchService#getDocumentsByTag(java.lang.String)
	 */
	@Override
	public PagedList<Document> getDocumentsByTag(String tag) {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.SearchApiUrls.GET_DOCUMENTS_BY_TAG_URL);
        String                apiUrl  = builder.withField(ParameterNames.TAG, tag).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshallList(Document.class, json, "documents");
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.SearchService#getDocumentsByTag(java.lang.String, int, int)
	 */
	@Override
	public PagedList<Document> getDocumentsByTag(String tag, int page,
			int itemsPerPage) {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.SearchApiUrls.GET_DOCUMENTS_BY_TAG_URL);
        String                apiUrl  = builder.withField(ParameterNames.TAG, tag).withParameter(ParameterNames.PAGE, String.valueOf(page)).withParameter(ParameterNames.ITEMS, String.valueOf(itemsPerPage)).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshallList(Document.class, json, "documents");
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.SearchService#getDocumentsByTag(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public PagedList<Document> getDocumentsByTag(String tag, String category,
			String subCategory) {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.SearchApiUrls.GET_DOCUMENTS_BY_TAG_URL);
        String                apiUrl  = builder.withField(ParameterNames.TAG, tag).withParameter(ParameterNames.CATEGORY, category).withParameter(ParameterNames.SUB_CATEGORY, subCategory).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshallList(Document.class, json, "documents");
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.SearchService#getRelatedDocuments(java.lang.String)
	 */
	@Override
	public PagedList<Document> getRelatedDocuments(String documentId) {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.SearchApiUrls.GET_RELATED_DOCUMENTS_URL);
        String                apiUrl  = builder.withField(ParameterNames.ID, documentId).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshallList(Document.class, json, "documents");
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.SearchService#search(java.lang.String[])
	 */
	@Override
	public PagedList<Document> search(String... terms) {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.SearchApiUrls.SEARCH_URL);
        String                apiUrl  = builder.withField(ParameterNames.TERMS, toString(terms)).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshallList(Document.class, json, "documents");
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.SearchService#search(java.lang.String, int, int)
	 */
	@Override
	public PagedList<Document> search(String terms, int page, int itemsPerPage) {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.SearchApiUrls.SEARCH_URL);
        String                apiUrl  = builder.withField(ParameterNames.TERMS, terms).withParameter(ParameterNames.PAGE, String.valueOf(page)).withParameter(ParameterNames.ITEMS, String.valueOf(itemsPerPage)).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshallList(Document.class, json, "documents");
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.SearchService#getCategories()
	 */
	@Override
	public List<Category> getCategories() {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.SearchApiUrls.GET_CATEGORIES_URL);
        String                apiUrl  = builder.buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshallList(Category.class, json);
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.SearchService#getSubCategories(java.lang.String)
	 */
	@Override
	public List<Category> getSubCategories(String categoryId) {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.SearchApiUrls.GET_SUB_CATEGORIES_URL);
        String                apiUrl  = builder.withField(ParameterNames.ID, categoryId).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshallList(Category.class, json);
	}
}
