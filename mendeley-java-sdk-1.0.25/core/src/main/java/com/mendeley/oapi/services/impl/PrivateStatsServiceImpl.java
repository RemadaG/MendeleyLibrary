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
import com.mendeley.oapi.schema.Publication;
import com.mendeley.oapi.schema.Tag;
import com.mendeley.oapi.schema.User;
import com.mendeley.oapi.services.PrivateStatsService;
import com.mendeley.oapi.services.constant.MendeleyApiUrls;
import com.mendeley.oapi.services.constant.MendeleyApiUrls.MendeleyApiUrlBuilder;
import com.mendeley.oapi.services.oauth.MendeleyAccessToken;
import com.mendeley.oapi.services.oauth.MendeleyApiConsumer;

/**
 * The Class PrivateStatsServiceImpl.
 */
public class PrivateStatsServiceImpl extends BaseMendeleyPrivateService implements
		PrivateStatsService {

	/**
	 * Instantiates a new private stats service impl.
	 * 
	 * @param apiConsumer the api consumer
	 * @param accessToken the access token
	 */
	public PrivateStatsServiceImpl(MendeleyApiConsumer apiConsumer,
			MendeleyAccessToken accessToken) {
		super(apiConsumer, accessToken);
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.PrivateStatsService#getAuthors()
	 */
	@Override
	public List<User> getAuthors() {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.PrivateStatsApiUrls.GET_AUTHORS_URL);
        String                apiUrl  = builder.buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshallList(User.class, json);
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.PrivateStatsService#getPublications()
	 */
	@Override
	public List<Publication> getPublications() {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.PrivateStatsApiUrls.GET_PUBLICATIONS_URL);
        String                apiUrl  = builder.buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshallList(Publication.class, json);
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.PrivateStatsService#getTags()
	 */
	@Override
	public List<Tag> getTags() {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.PrivateStatsApiUrls.GET_TAGS_URL);
        String                apiUrl  = builder.buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshallList(Tag.class, json);
	}

}
