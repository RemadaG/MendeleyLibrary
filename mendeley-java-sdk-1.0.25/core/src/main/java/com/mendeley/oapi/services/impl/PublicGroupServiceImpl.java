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
import java.util.Map;

import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.mendeley.oapi.common.PagedList;
import com.mendeley.oapi.schema.Document;
import com.mendeley.oapi.schema.Group;
import com.mendeley.oapi.schema.User;
import com.mendeley.oapi.schema.Group.MembershipType;
import com.mendeley.oapi.services.PublicGroupService;
import com.mendeley.oapi.services.constant.MendeleyApiUrls;
import com.mendeley.oapi.services.constant.ParameterNames;
import com.mendeley.oapi.services.constant.MendeleyApiUrls.MendeleyApiUrlBuilder;
import com.mendeley.oapi.services.oauth.MendeleyApiConsumer;

/**
 * The Class PublicGroupServiceImpl.
 */
public class PublicGroupServiceImpl extends BaseMendeleyPublicService implements
		PublicGroupService {

	/**
	 * Instantiates a new public group service impl.
	 * 
	 * @param apiConsumer the api consumer
	 */
	public PublicGroupServiceImpl(MendeleyApiConsumer apiConsumer) {
		super(apiConsumer);
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.PublicGroupService#getGroupDetails(java.lang.String)
	 */
	@Override
	public Group getGroupDetails(String groupId) {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.PublicGroupApiUrls.GET_GROUP_DETAILS_URL);
        String                apiUrl  = builder.withField(ParameterNames.ID, groupId).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<Group>(){}, json);
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.PublicGroupService#getGroupDocuments()
	 */
	@Override
	public PagedList<Document> getGroupDocuments(String groupId) {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.PublicGroupApiUrls.GET_GROUP_DOCUMENTS_URL);
        String                apiUrl  = builder.withField(ParameterNames.ID, groupId).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshallList(Document.class, json, "documents");
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.PublicGroupService#getGroupDocuments(boolean)
	 */
	@Override
	public PagedList<Document> getGroupDocuments(String groupId, boolean details) {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.PublicGroupApiUrls.GET_GROUP_DOCUMENTS_URL);
        String                apiUrl  = builder.withField(ParameterNames.ID, groupId).withParameter(ParameterNames.DETAILS, String.valueOf(details)).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshallList(Document.class, json, "documents");
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.PublicGroupService#getGroupDocuments(boolean, int, int)
	 */
	@Override
	public PagedList<Document> getGroupDocuments(String groupId, boolean details, int page,
			int itemsPerPage) {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.PublicGroupApiUrls.GET_GROUP_DOCUMENTS_URL);
        String                apiUrl  = builder.withField(ParameterNames.ID, groupId).withParameter(ParameterNames.DETAILS, String.valueOf(details)).withParameter(ParameterNames.PAGE, String.valueOf(page)).withParameter(ParameterNames.ITEMS, String.valueOf(itemsPerPage)).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshallList(Document.class, json, "documents");
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.PublicGroupService#getGroupPeople(java.lang.String)
	 */
	@Override
	public Map<MembershipType, List<User>> getGroupPeople(String groupId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.PublicGroupService#getGroups()
	 */
	@Override
	public PagedList<Group> getGroups() {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.PublicGroupApiUrls.GET_GROUPS_URL);
        String                apiUrl  = builder.buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshallList(Group.class, json, "groups");
	}

}
