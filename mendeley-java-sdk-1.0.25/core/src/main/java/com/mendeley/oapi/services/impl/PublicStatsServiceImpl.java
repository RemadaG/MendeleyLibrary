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
import com.mendeley.oapi.schema.Paper;
import com.mendeley.oapi.schema.Publication;
import com.mendeley.oapi.schema.Tag;
import com.mendeley.oapi.schema.User;
import com.mendeley.oapi.services.PublicStatsService;
import com.mendeley.oapi.services.constant.MendeleyApiUrls;
import com.mendeley.oapi.services.constant.ParameterNames;
import com.mendeley.oapi.services.constant.MendeleyApiUrls.MendeleyApiUrlBuilder;
import com.mendeley.oapi.services.oauth.MendeleyApiConsumer;

/**
 * The Class PublicStatsServiceImpl.
 */
public class PublicStatsServiceImpl extends BaseMendeleyPublicService implements PublicStatsService {

	/**
	 * Instantiates a new public stats service impl.
	 * 
	 * @param apiConsumer the api consumer
	 */
	public PublicStatsServiceImpl(MendeleyApiConsumer apiConsumer) {
		super(apiConsumer);
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.PublicStatsService#getAuthors()
	 */
	@Override
	public List<User> getAuthors() {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.PublicStatsApiUrls.GET_AUTHORS_URL);
        String                apiUrl  = builder.buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshallList(User.class, json);
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.PublicStatsService#getAuthors(java.lang.String)
	 */
	@Override
	public List<User> getAuthors(String disciplineId) {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.PublicStatsApiUrls.GET_AUTHORS_URL);
        String                apiUrl  = builder.withParameter(ParameterNames.DISCIPLINE_ID, disciplineId).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshallList(User.class, json);
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.PublicStatsService#getAuthors(java.lang.String, boolean)
	 */
	@Override
	public List<User> getAuthors(String disciplineId, boolean upandcoming) {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.PublicStatsApiUrls.GET_AUTHORS_URL);
        String                apiUrl  = builder.withParameter(ParameterNames.DISCIPLINE_ID, disciplineId).withParameter(ParameterNames.UPANDCOMING, String.valueOf(upandcoming)).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshallList(User.class, json);
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.PublicStatsService#getPapers()
	 */
	@Override
	public List<Paper> getPapers() {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.PublicStatsApiUrls.GET_PAPERS_URL);
        String                apiUrl  = builder.buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshallList(Paper.class, json);
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.PublicStatsService#getPapers(java.lang.String)
	 */
	@Override
	public List<Paper> getPapers(String disciplineId) {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.PublicStatsApiUrls.GET_PAPERS_URL);
        String                apiUrl  = builder.withParameter(ParameterNames.DISCIPLINE_ID, disciplineId).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshallList(Paper.class, json);
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.PublicStatsService#getPapers(java.lang.String, boolean)
	 */
	@Override
	public List<Paper> getPapers(String disciplineId,
			boolean upandcoming) {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.PublicStatsApiUrls.GET_PAPERS_URL);
        String                apiUrl  = builder.withParameter(ParameterNames.DISCIPLINE_ID, disciplineId).withParameter(ParameterNames.UPANDCOMING, String.valueOf(upandcoming)).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshallList(Paper.class, json);
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.PublicStatsService#getPublications()
	 */
	@Override
	public List<Publication> getPublications() {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.PublicStatsApiUrls.GET_PUBLICATIONS_URL);
        String                apiUrl  = builder.buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshallList(Publication.class, json);
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.PublicStatsService#getPublications(java.lang.String)
	 */
	@Override
	public List<Publication> getPublications(String disciplineId) {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.PublicStatsApiUrls.GET_PUBLICATIONS_URL);
        String                apiUrl  = builder.withParameter(ParameterNames.DISCIPLINE_ID, disciplineId).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshallList(Publication.class, json);
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.PublicStatsService#getPublications(java.lang.String, boolean)
	 */
	@Override
	public List<Publication> getPublications(String disciplineId,
			boolean upandcoming) {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.PublicStatsApiUrls.GET_PUBLICATIONS_URL);
        String                apiUrl  = builder.withParameter(ParameterNames.DISCIPLINE_ID, disciplineId).withParameter(ParameterNames.UPANDCOMING, String.valueOf(upandcoming)).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshallList(Publication.class, json);
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.PublicStatsService#getTags(java.lang.String)
	 */
	@Override
	public List<Tag> getTags(String disciplineId) {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.PublicStatsApiUrls.GET_TAGS_URL);
        String                apiUrl  = builder.buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshallList(Tag.class, json);
	}
}
