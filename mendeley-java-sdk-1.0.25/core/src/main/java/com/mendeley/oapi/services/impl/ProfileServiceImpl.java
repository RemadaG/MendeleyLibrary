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

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonElement;
import com.mendeley.oapi.schema.Profile;
import com.mendeley.oapi.schema.User;
import com.mendeley.oapi.schema.Profile.Section;
import com.mendeley.oapi.services.ProfileService;
import com.mendeley.oapi.services.constant.MendeleyApiUrls;
import com.mendeley.oapi.services.constant.ParameterNames;
import com.mendeley.oapi.services.constant.MendeleyApiUrls.MendeleyApiUrlBuilder;
import com.mendeley.oapi.services.oauth.MendeleyAccessToken;
import com.mendeley.oapi.services.oauth.MendeleyApiConsumer;

/**
 * The Class ProfileServiceImpl.
 */
public class ProfileServiceImpl extends BaseMendeleyPrivateService implements
		ProfileService {

	/**
	 * Instantiates a new profile service impl.
	 * 
	 * @param apiConsumer the api consumer
	 * @param accessToken the access token
	 */
	public ProfileServiceImpl(MendeleyApiConsumer apiConsumer,
			MendeleyAccessToken accessToken) {
		super(apiConsumer, accessToken);
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.ProfileService#addContact(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void addContact(String userId) {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.ProfileApiUrls.ADD_CONTACT_URL);
        String                apiUrl  = builder.withField(ParameterNames.ID, userId).buildUrl();
        callApiPost(apiUrl, (Map<String, String>) Collections.EMPTY_MAP);
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.ProfileService#getContacts()
	 */
	@Override
	public List<User> getContacts() {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.ProfileApiUrls.GET_CONTACTS_URL);
        String                apiUrl  = builder.buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshallList(User.class, json);
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.ProfileService#getProfile(java.lang.String)
	 */
	@Override
	public Profile getProfile(String userId) {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.ProfileApiUrls.GET_PROFILE_URL);
        String                apiUrl  = builder.withField(ParameterNames.ID, userId).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));

        return unmarshall(Profile.class, json);
	}
	
	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.ProfileService#getProfile(java.lang.String, com.mendeley.oapi.schema.Profile.Section)
	 */
	@Override
	public Profile getProfile(String userId, Section section) {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.ProfileApiUrls.GET_PROFILE_URL);
        String                apiUrl  = builder.withField(ParameterNames.ID, userId).withParameterEnum(ParameterNames.SECTION, section).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(Profile.class, json);
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.ProfileService#getProfile(java.lang.String, com.mendeley.oapi.schema.Profile.Section, com.mendeley.oapi.schema.Profile.Section)
	 */
	@Override
	public Profile getProfile(String userId, Section section, Section subsection) {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.ProfileApiUrls.GET_PROFILE_URL);
        String                apiUrl  = builder.withField(ParameterNames.ID, userId).withParameterEnum(ParameterNames.SECTION, section).withParameterEnum(ParameterNames.SUBSECTION, subsection).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(Profile.class, json);
	}
}
