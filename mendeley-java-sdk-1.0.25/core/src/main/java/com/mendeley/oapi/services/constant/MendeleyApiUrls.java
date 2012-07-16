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
package com.mendeley.oapi.services.constant;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mendeley.oapi.common.ValueEnum;

/**
 * The Class MendeleyApiUrls.
 */
public final class MendeleyApiUrls {

    /** The Constant API_URLS_FILE. */
    public static final String API_URLS_FILE = "MendeleyApiUrls.properties";

    /** The Constant logger. */
    private static final Logger logger = Logger.getLogger(MendeleyApiUrls.class.getCanonicalName());
    
    /** The Constant mendeleyApiUrls. */
    private static final Properties mendeleyApiUrls = new Properties();

    static {
        try {
            mendeleyApiUrls.load(MendeleyApiUrls.class.getResourceAsStream(API_URLS_FILE));
        } catch (IOException e) {
        	logger.log(Level.SEVERE, "An error occurred while loading urls.", e);
        }
    }
    
    /**
     * The Interface OAuthUrls.
     */
    public static interface OAuthUrls {
    	
	    /** The Constant AUTHORIZE_URL. */
	    public static final String AUTHORIZE_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.oauthService.authorize");
    	
	    /** The Constant REQUEST_TOKEN_URL. */
	    public static final String REQUEST_TOKEN_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.oauthService.requestToken");
	    
	    /** The Constant ACCESS_TOKEN_URL. */
	    public static final String ACCESS_TOKEN_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.oauthService.accessToken");
    }
    
    /**
     * The Interface ProfileApiUrls.
     */
    public static interface ProfileApiUrls {
    	
	    /** The Constant GET_CONTACTS_URL. */
	    public static final String GET_CONTACTS_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.profileService.getContacts");
	    
    	/** The Constant ADD_CONTACT_URL. */
    	public static final String ADD_CONTACT_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.profileService.addContact");

    	/** The Constant GET_PROFILE_URL. */
    	public static final String GET_PROFILE_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.profileService.getProfile");
    }

    /**
     * The Interface CollectionApiUrls.
     */
    public static interface CollectionApiUrls {
    	
	    /** The Constant GET_COLLECTIONS_URL. */
	    public static final String GET_COLLECTIONS_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.collectionService.getCollections");
    	
	    /** The Constant GET_COLLECTION_DOCUMENTS_URL. */
	    public static final String GET_COLLECTION_DOCUMENTS_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.collectionService.getCollectionDocuments");
    	
	    /** The Constant ADD_DOCUMENT_TO_COLLECTION_URL. */
	    public static final String ADD_DOCUMENT_TO_COLLECTION_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.collectionService.addDocumentToCollection");
    	
	    /** The Constant CREATE_COLLECTION_URL. */
	    public static final String CREATE_COLLECTION_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.collectionService.createCollection");
    	
	    /** The Constant REMOVE_COLLECTION_URL. */
	    public static final String REMOVE_COLLECTION_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.collectionService.removeCollection");
    	
	    /** The Constant REMOVE_DOCUMENT_FROM_COLLECTION_URL. */
	    public static final String REMOVE_DOCUMENT_FROM_COLLECTION_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.collectionService.removeDocumentFromCollection");
    }
    
    /**
     * The Interface FolderApiUrls.
     */
    public static interface FolderApiUrls {
    	
	    /** The Constant GET_FOLDERS_URL. */
	    public static final String GET_FOLDERS_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.folderService.getFolders");
    	
	    /** The Constant GET_FOLDER_DOCUMENTS_URL. */
	    public static final String GET_FOLDER_DOCUMENTS_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.folderService.getFolderDocuments");
    	
	    /** The Constant ADD_DOCUMENT_TO_FOLDER_URL. */
	    public static final String ADD_DOCUMENT_TO_FOLDER_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.folderService.addDocumentToFolder");
    	
	    /** The Constant CREATE_FOLDER_URL. */
	    public static final String CREATE_FOLDER_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.folderService.createFolder");
    	
	    /** The Constant REMOVE_FOLDER_URL. */
	    public static final String REMOVE_FOLDER_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.folderService.removeFolder");
    	
	    /** The Constant REMOVE_DOCUMENT_FROM_FOLDER_URL. */
	    public static final String REMOVE_DOCUMENT_FROM_FOLDER_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.folderService.removeDocumentFromFolder");
    }
    
    /**
     * The Interface PrivateGroupApiUrls.
     */
    public static interface PrivateGroupApiUrls {
    	
	    /** The Constant GET_GROUPS_URL. */
	    public static final String GET_GROUPS_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.privateGroupService.getGroups");
    	
	    /** The Constant GET_GROUP_DETAILS_URL. */
	    public static final String GET_GROUP_DETAILS_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.privateGroupService.getGroupDetails");
    	
	    /** The Constant GET_GROUP_PEOPLE_URL. */
	    public static final String GET_GROUP_PEOPLE_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.privateGroupService.getGroupPeople");
	    
    	/** The Constant CREATE_GROUP_URL. */
    	public static final String CREATE_GROUP_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.privateGroupService.createGroup");
	    
    	/** The Constant DELETE_GROUP_URL. */
    	public static final String DELETE_GROUP_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.privateGroupService.deleteGroup");
	    
    	/** The Constant LEAVE_GROUP_URL. */
    	public static final String LEAVE_GROUP_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.privateGroupService.leaveGroup");
	    
    	/** The Constant UNFOLLOW_GROUP_URL. */
    	public static final String UNFOLLOW_GROUP_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.privateGroupService.unfollowGroup");
    }
    
    /**
     * The Interface SharedCollectionApiUrls.
     */
    public static interface SharedCollectionApiUrls {
    	
	    /** The Constant GET_COLLECTIONS_URL. */
	    public static final String GET_COLLECTIONS_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.sharedCollectionService.getCollections");
    	
	    /** The Constant GET_COLLECTION_DOCUMENTS_URL. */
	    public static final String GET_COLLECTION_DOCUMENTS_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.sharedCollectionService.getCollectionDocuments");
    	
	    /** The Constant ADD_DOCUMENT_TO_COLLECTION_URL. */
	    public static final String ADD_DOCUMENT_TO_COLLECTION_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.sharedCollectionService.addDocumentToCollection");
    	
	    /** The Constant CREATE_COLLECTION_URL. */
	    public static final String CREATE_COLLECTION_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.sharedCollectionService.createCollection");
    	
	    /** The Constant REMOVE_COLLECTION_URL. */
	    public static final String REMOVE_COLLECTION_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.sharedCollectionService.removeCollection");
    	
	    /** The Constant REMOVE_DOCUMENT_FROM_COLLECTION_URL. */
	    public static final String REMOVE_DOCUMENT_FROM_COLLECTION_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.sharedCollectionService.removeDocumentFromCollection");
    }
    
    /**
     * The Interface PublicGroupApiUrls.
     */
    public static interface PublicGroupApiUrls {
    	
	    /** The Constant GET_GROUPS_URL. */
	    public static final String GET_GROUPS_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.publicGroupService.getGroups");
    	
	    /** The Constant GET_GROUP_DETAILS_URL. */
	    public static final String GET_GROUP_DETAILS_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.publicGroupService.getGroupDetails");
    	
	    /** The Constant GET_GROUP_PEOPLE_URL. */
	    public static final String GET_GROUP_PEOPLE_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.publicGroupService.getGroupPeople");
	    
	    /** The Constant GET_GROUP_DOCUMENTS_URL. */
    	public static final String GET_GROUP_DOCUMENTS_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.publicGroupService.getGroupDocuments");
    	
    }
    
    /**
     * The Interface PrivateStatsApiUrls.
     */
    public static interface PrivateStatsApiUrls {
    	
	    /** The Constant GET_AUTHORS_URL. */
	    public static final String GET_AUTHORS_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.privateStatsService.getAuthors");
    	
	    /** The Constant GET_PUBLICATIONS_URL. */
	    public static final String GET_PUBLICATIONS_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.privateStatsService.getPublications");
    	
	    /** The Constant GET_TAGS_URL. */
	    public static final String GET_TAGS_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.privateStatsService.getTags");
    }
    
    /**
     * The Interface PublicStatsApiUrls.
     */
    public static interface PublicStatsApiUrls {
    	
	    /** The Constant GET_AUTHORS_URL. */
	    public static final String GET_AUTHORS_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.publicStatsService.getAuthors");
    	
	    /** The Constant GET_PUBLICATIONS_URL. */
	    public static final String GET_PUBLICATIONS_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.publicStatsService.getPublications");
	    
	    /** The Constant GET_PAPERS_URL. */
    	public static final String GET_PAPERS_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.publicStatsService.getPapers");
    	
	    /** The Constant GET_TAGS_URL. */
	    public static final String GET_TAGS_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.publicStatsService.getTags");
    }
    
    /**
     * The Interface SearchApiUrls.
     */
    public static interface SearchApiUrls {
    	
	    /** The Constant SEARCH_URL. */
	    public static final String SEARCH_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.searchService.search");
    	
	    /** The Constant GET_DOCUMENT_DETAILS_URL. */
	    public static final String GET_DOCUMENT_DETAILS_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.searchService.getDocumentDetails");
    	
	    /** The Constant GET_RELATED_DOCUMENTS_URL. */
	    public static final String GET_RELATED_DOCUMENTS_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.searchService.getRelatedDocuments");
	    
	    /** The Constant GET_DOCUMENTS_BY_AUTHOR_URL. */
    	public static final String GET_DOCUMENTS_BY_AUTHOR_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.searchService.getDocumentsByAuthor");
	    
    	/** The Constant GET_DOCUMENTS_BY_TAG_URL. */
    	public static final String GET_DOCUMENTS_BY_TAG_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.searchService.getDocumentsByTag");
	    
    	/** The Constant GET_CATEGORIES_URL. */
    	public static final String GET_CATEGORIES_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.searchService.getCategories");
	    
    	/** The Constant GET_SUB_CATEGORIES_URL. */
    	public static final String GET_SUB_CATEGORIES_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.searchService.getSubCategories");
    }
    
    
    /**
     * The Interface DocumentApiUrls.
     */
    public static interface DocumentApiUrls {
	    
    	/** The Constant GET_DOCUMENT_IDS_URL. */
	    public static final String GET_DOCUMENT_IDS_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.documentService.getDocumentIds");

	    /** The Constant GET_AUTHORED_PUBLICATIONS_URL. */
	    public static final String GET_AUTHORED_PUBLICATIONS_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.documentService.getAuthoredPublications");

	    /** The Constant GET_DOCUMENT_DETAILS_URL. */
	    public static final String GET_DOCUMENT_DETAILS_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.documentService.getDocumentDetails");

	    /** The Constant CREATE_DOCUMENT_URL. */
	    public static final String CREATE_DOCUMENT_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.documentService.createDocument");

	    /** The Constant REMOVE_DOCUMENT_URL. */
	    public static final String REMOVE_DOCUMENT_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.documentService.removeDocument");
	    
	    /** The Constant UPLOAD_FILE_URL. */
    	public static final String UPLOAD_FILE_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.documentService.uploadFile");

	    /** The Constant DOWNLOAD_FILE_URL. */
    	public static final String DOWNLOAD_FILE_URL = mendeleyApiUrls.getProperty("com.mendeley.oapi.services.documentService.downloadFile");
    }
    
    /**
     * Instantiates a new mendeley api urls.
     */
    private MendeleyApiUrls() {}

    /**
     * The Class MendeleyApiUrlBuilder.
     */
    public static class MendeleyApiUrlBuilder {
        
        /** The Constant API_URLS_PLACEHOLDER_START. */
        private static final char API_URLS_PLACEHOLDER_START = '{';

        /** The Constant API_URLS_PLACEHOLDER_END. */
        private static final char API_URLS_PLACEHOLDER_END = '}';
        
    	/** The url format. */
	    private String urlFormat;
	    
    	/** The parameters map. */
	    private Map<String, String> parametersMap = new HashMap<String, String>();
    	
		/** The fields map. */
		private Map<String, String> fieldsMap = new HashMap<String, String>();
	    
    	/**
	     * Instantiates a new mendeley api url builder.
	     * 
	     * @param urlFormat the url format
	     */
	    public MendeleyApiUrlBuilder(String urlFormat) {
    		this.urlFormat = urlFormat;
    	}
	    
    	/**
	     * With parameter.
	     * 
	     * @param name the name
	     * @param value the value
	     * 
	     * @return the mendeley api url builder
	     */
	    public MendeleyApiUrlBuilder withParameter(String name, String value) {
	    	if (value != null && value.length() > 0) {
	    		parametersMap.put(name, encodeUrl(value));
	    	}
    		
    		return this;
    	}
    	
    	/**
	     * With parameter enum.
	     * 
	     * @param name the name
	     * @param value the value
	     * 
	     * @return the mendeley api url builder
	     */
	    public MendeleyApiUrlBuilder withParameterEnum(String name, ValueEnum value) {
	    	withParameter(name, value.value());
    		
    		return this;
    	}
	    
    	/**
	     * With parameter enum set.
	     * 
	     * @param name the name
	     * @param enumSet the enum set
	     * @param separator the separator
	     * 
	     * @return the mendeley api url builder
	     */
	    public MendeleyApiUrlBuilder withParameterEnumSet(String name, Set<? extends ValueEnum> enumSet, String separator) {
	    	StringBuilder builder = new StringBuilder();
	    	
	    	for (Iterator<? extends ValueEnum> iterator = enumSet.iterator(); iterator.hasNext();) {
	    		builder.append(encodeUrl(iterator.next().value()));
	    		if (iterator.hasNext()) {
	    			builder.append(separator);
	    		}
			}
	    	
	    	parametersMap.put(name, builder.toString());
	    	
    		return this;
    	}
	    
		/**
		 * With empty field.
		 * 
		 * @param name the name
		 * 
		 * @return the mendeley api url builder
		 */
		public MendeleyApiUrlBuilder withEmptyField(String name) {
			fieldsMap.put(name, "");

			return this;
		}

		/**
		 * With field.
		 * 
		 * @param name the name
		 * @param value the value
		 * 
		 * @return the mendeley api url builder
		 */
		public MendeleyApiUrlBuilder withField(String name, String value) {
			withField(name, value, false);

			return this;
		}

		/**
		 * With field.
		 * 
		 * @param name the name
		 * @param value the value
		 * @param escape the escape
		 * 
		 * @return the mendeley api url builder
		 */
		public MendeleyApiUrlBuilder withField(String name, String value,
				boolean escape) {
			if (escape) {
				fieldsMap.put(name, encodeUrl(value));
			} else {
				fieldsMap.put(name, value);
			}

			return this;
		}

		/**
		 * With field enum.
		 * 
		 * @param name the name
		 * @param value the value
		 * 
		 * @return the mendeley api url builder
		 */
		public MendeleyApiUrlBuilder withFieldEnum(String name, ValueEnum value) {
			if (value.value() == null || value.value().length() == 0) {
				fieldsMap.put(name, "");
			} else {
				fieldsMap.put(name, value.value());
			}

			return this;
		}
	    
    	
		/**
		 * Builds the url.
		 * 
		 * @return the string
		 */
		public String buildUrl() {
			StringBuilder urlBuilder = new StringBuilder();
			StringBuilder placeHolderBuilder = new StringBuilder();
			boolean placeHolderFlag = false;
			boolean firstParameter = true;
			for (int i = 0; i < urlFormat.length(); i++) {
				if (urlFormat.charAt(i) == API_URLS_PLACEHOLDER_START) {
					placeHolderBuilder = new StringBuilder();
					placeHolderFlag = true;
				} else if (placeHolderFlag
						&& urlFormat.charAt(i) == API_URLS_PLACEHOLDER_END) {
					String placeHolder = placeHolderBuilder.toString();
					if (fieldsMap.containsKey(placeHolder)) {
						urlBuilder.append(fieldsMap.get(placeHolder));
					} else if (parametersMap.containsKey(placeHolder)) {
						StringBuilder builder = new StringBuilder();
						if (firstParameter) {
							firstParameter = false;
						} else {
							builder.append("&");
						}
						builder.append(placeHolder);
						builder.append("=");
						builder.append(parametersMap.get(placeHolder));
						urlBuilder.append(builder.toString());
					} else {
						// we did not find a binding for the placeholder.
						// skip it.
						// urlBuilder.append(API_URLS_PLACEHOLDER_START);
						// urlBuilder.append(placeHolder);
						// urlBuilder.append(API_URLS_PLACEHOLDER_END);
					}
					placeHolderFlag = false;
				} else if (placeHolderFlag) {
					placeHolderBuilder.append(urlFormat.charAt(i));
				} else {
					urlBuilder.append(urlFormat.charAt(i));
				}
			}


			logger.log(Level.FINE, "URL generated: " + urlBuilder.toString());
			
			return urlBuilder.toString();
		}
    	
        /**
         * Encode url.
         * 
         * @param original the original
         * 
         * @return the string
         */
        private static String encodeUrl(String original) {
        	try {
    			return URLEncoder.encode(original, ApplicationConstants.CONTENT_ENCODING);
    		} catch (UnsupportedEncodingException e) {
    			// should never be here..
    			return original;
    		}
        }
    }
}
