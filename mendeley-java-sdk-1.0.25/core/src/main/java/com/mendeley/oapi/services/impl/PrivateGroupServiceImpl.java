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
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.mendeley.oapi.schema.Group;
import com.mendeley.oapi.schema.User;
import com.mendeley.oapi.schema.Group.MembershipType;
import com.mendeley.oapi.schema.Group.Type;
import com.mendeley.oapi.services.PrivateGroupService;
import com.mendeley.oapi.services.constant.MendeleyApiUrls;
import com.mendeley.oapi.services.constant.ParameterNames;
import com.mendeley.oapi.services.constant.MendeleyApiUrls.MendeleyApiUrlBuilder;
import com.mendeley.oapi.services.oauth.MendeleyAccessToken;
import com.mendeley.oapi.services.oauth.MendeleyApiConsumer;

/**
 * The Class PrivateGroupServiceImpl.
 */
public class PrivateGroupServiceImpl extends BaseMendeleyPrivateService implements
		PrivateGroupService {

	/**
	 * Instantiates a new private group service impl.
	 * 
	 * @param apiConsumer the api consumer
	 * @param accessToken the access token
	 */
	public PrivateGroupServiceImpl(MendeleyApiConsumer apiConsumer,
			MendeleyAccessToken accessToken) {
		super(apiConsumer, accessToken);
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.PrivateGroupService#createGroup(java.lang.String, com.mendeley.oapi.schema.Group.Type)
	 */
	@Override
	public Group createGroup(String name, Type type) {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.PrivateGroupApiUrls.CREATE_GROUP_URL);
        String                apiUrl  = builder.buildUrl();
        Group group = new Group();
        group.setName(name);
        group.setType(type);
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put(ParameterNames.GROUP, getGsonBuilder().create().toJson(group));
        JsonElement json = unmarshall(callApiPost(apiUrl, parameters, HttpURLConnection.HTTP_CREATED));
        return unmarshall(new TypeToken<Group>(){}, json);
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.PrivateGroupService#deleteGroup(java.lang.String)
	 */
	@Override
	public void deleteGroup(String groupId) {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.PrivateGroupApiUrls.DELETE_GROUP_URL);
        String                apiUrl  = builder.withField(ParameterNames.ID, groupId).buildUrl();
        callApiDelete(apiUrl, HttpURLConnection.HTTP_NO_CONTENT);
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.PrivateGroupService#getGroupDetails(java.lang.String)
	 */
	@Override
	public Group getGroupDetails(String groupId) {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.PrivateGroupApiUrls.GET_GROUP_DETAILS_URL);
        String                apiUrl  = builder.withField(ParameterNames.ID, groupId).buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshall(new TypeToken<Group>(){}, json);
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.PrivateGroupService#getGroupPeople(java.lang.String)
	 */
	@Override
	public Map<MembershipType, List<User>> getGroupPeople(String groupId) {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.PrivateGroupApiUrls.GET_GROUP_PEOPLE_URL);
        String                apiUrl  = builder.withField(ParameterNames.ID, groupId).buildUrl();
        JsonObject json = unmarshall(callApiGet(apiUrl)).getAsJsonObject();
        Map<MembershipType, List<User>> groupPeople = new HashMap<MembershipType, List<User>>();
        for (MembershipType type : MembershipType.values()) {
        	if (json.get(type.value()) != null) {
        		groupPeople.put(type, unmarshall(new TypeToken<List<User>>(){}, json.get(type.value())));
        	}
        }
		return groupPeople;
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.PrivateGroupService#getGroups()
	 */
	@Override
	public List<Group> getGroups() {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.PrivateGroupApiUrls.GET_GROUPS_URL);
        String                apiUrl  = builder.buildUrl();
        JsonElement json = unmarshall(callApiGet(apiUrl));
        
        return unmarshallList(Group.class, json);
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.PrivateGroupService#leaveGroup(java.lang.String)
	 */
	@Override
	public void leaveGroup(String groupId) {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.PrivateGroupApiUrls.LEAVE_GROUP_URL);
        String                apiUrl  = builder.withField(ParameterNames.ID, groupId).buildUrl();
        callApiDelete(apiUrl, HttpURLConnection.HTTP_NO_CONTENT);
	}

	/* (non-Javadoc)
	 * @see com.mendeley.oapi.services.PrivateGroupService#unfollowGroup(java.lang.String)
	 */
	@Override
	public void unfollowGroup(String groupId) {
		MendeleyApiUrlBuilder builder = createMendeleyApiUrlBuilder(MendeleyApiUrls.PrivateGroupApiUrls.UNFOLLOW_GROUP_URL);
        String                apiUrl  = builder.withField(ParameterNames.ID, groupId).buildUrl();
        callApiDelete(apiUrl, HttpURLConnection.HTTP_NO_CONTENT);
	}

}
