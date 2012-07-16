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
package com.mendeley.oapi.schema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mendeley.oapi.common.ValueEnum;

/**
 * The Class Document.
 */
public class Document extends SchemaEntity {

	/**
	 * The Enum Type.
	 */
	public enum Type implements ValueEnum {
		;
		
		
	    /** The Constant stringToEnum. */
		private static final Map<String, Type> stringToEnum = new HashMap<String, Type>();

		static { // Initialize map from constant name to enum constant
			for (Type op : values()) {
				stringToEnum.put(op.value(), op);
			}
		}
		
		/** The value. */
		private String value;

		/**
		 * Instantiates a new type.
		 * 
		 * @param value the value
		 */
		Type(String value) {
			this.value = value;
		}

		/* (non-Javadoc)
		 * @see com.mendeley.oapi.common.ValueEnum#value()
		 */
		@Override
		public String value() {
			return value;
		}

		/**
		 * From value.
		 * 
		 * @param value the value
		 * 
		 * @return the type
		 */
		public static Type fromValue(String value) {
			return stringToEnum.get(value);
		}
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3484450630735705441L;
	
	/** The id. */
	private String id;
	
	/** The title. */
	private String title;
	
	/** The document abstract. */
	private String documentAbstract;
	
	/** The publication outlet. */
	private String publicationOutlet;
	
	/** The year. */
	private int year;
	
	/** The mendeley url. */
	private String mendeleyUrl;
	
	/** The doi. */
	private String doi;
	
	/** The authors. */
	private String authors;
	
	/** The editors. */
	private List<String> editors = new ArrayList<String>();
	
	/** The keywords. */
	private List<String> keywords = new ArrayList<String>();
	
	/** The tags. */
	private List<String> tags = new ArrayList<String>();
	
	/** The issue. */
	private String issue;
	
	/** The volume. */
	private String volume;
	
	/** The pages. */
	private String pages;
	
	/** The type. */
	private Type type;
	
	/** The url. */
	private String url;
	
	/** The uuid. */
	private String uuid;
	
	/** The city. */
	private String city;
	
	/** The publisher. */
	private String publisher;
	
	/**
	 * Gets the title.
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Sets the title.
	 * 
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Gets the year.
	 * 
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 * Sets the year.
	 * 
	 * @param year the new year
	 */
	public void setYear(int year) {
		this.year = year;
	}
	
	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 * 
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Gets the publication outlet.
	 * 
	 * @return the publication outlet
	 */
	public String getPublicationOutlet() {
		return publicationOutlet;
	}
	
	/**
	 * Sets the publication outlet.
	 * 
	 * @param publicationOutlet the new publication outlet
	 */
	public void setPublicationOutlet(String publicationOutlet) {
		this.publicationOutlet = publicationOutlet;
	}
	
	/**
	 * Gets the mendeley url.
	 * 
	 * @return the mendeley url
	 */
	public String getMendeleyUrl() {
		return mendeleyUrl;
	}
	
	/**
	 * Sets the mendeley url.
	 * 
	 * @param mendeleyUrl the new mendeley url
	 */
	public void setMendeleyUrl(String mendeleyUrl) {
		this.mendeleyUrl = mendeleyUrl;
	}
	
	/**
	 * Gets the doi.
	 * 
	 * @return the doi
	 */
	public String getDoi() {
		return doi;
	}
	
	/**
	 * Sets the doi.
	 * 
	 * @param doi the new doi
	 */
	public void setDoi(String doi) {
		this.doi = doi;
	}
	
	/**
	 * Gets the authors.
	 * 
	 * @return the authors
	 */
	public String getAuthors() {
		return authors;
	}
	
	/**
	 * Sets the authors.
	 * 
	 * @param authors the new authors
	 */
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	
	/**
	 * Gets the abstract.
	 * 
	 * @return the abstract
	 */
	public String getAbstract() {
		return documentAbstract;
	}
	
	/**
	 * Sets the abstract.
	 * 
	 * @param documentAbstract the new abstract
	 */
	public void setAbstract(String documentAbstract) {
		this.documentAbstract = documentAbstract;
	}
	
	/**
	 * Gets the editors.
	 * 
	 * @return the editors
	 */
	public List<String> getEditors() {
		return editors;
	}
	
	/**
	 * Sets the editors.
	 * 
	 * @param editors the new editors
	 */
	public void setEditors(List<String> editors) {
		this.editors = editors;
	}
	
	/**
	 * Gets the keywords.
	 * 
	 * @return the keywords
	 */
	public List<String> getKeywords() {
		return keywords;
	}
	
	/**
	 * Sets the keywords.
	 * 
	 * @param keywords the new keywords
	 */
	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}
	
	/**
	 * Gets the tags.
	 * 
	 * @return the tags
	 */
	public List<String> getTags() {
		return tags;
	}
	
	/**
	 * Sets the tags.
	 * 
	 * @param tags the new tags
	 */
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	
	/**
	 * Gets the issue.
	 * 
	 * @return the issue
	 */
	public String getIssue() {
		return issue;
	}
	
	/**
	 * Sets the issue.
	 * 
	 * @param issue the new issue
	 */
	public void setIssue(String issue) {
		this.issue = issue;
	}
	
	/**
	 * Gets the volume.
	 * 
	 * @return the volume
	 */
	public String getVolume() {
		return volume;
	}
	
	/**
	 * Sets the volume.
	 * 
	 * @param volume the new volume
	 */
	public void setVolume(String volume) {
		this.volume = volume;
	}
	
	/**
	 * Gets the pages.
	 * 
	 * @return the pages
	 */
	public String getPages() {
		return pages;
	}
	
	/**
	 * Sets the pages.
	 * 
	 * @param pages the new pages
	 */
	public void setPages(String pages) {
		this.pages = pages;
	}
	
	/**
	 * Gets the type.
	 * 
	 * @return the type
	 */
	public Type getType() {
		return type;
	}
	
	/**
	 * Sets the type.
	 * 
	 * @param type the new type
	 */
	public void setType(Type type) {
		this.type = type;
	}
	
	/**
	 * Gets the url.
	 * 
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * Sets the url.
	 * 
	 * @param url the new url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * Gets the uuid.
	 * 
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}
	
	/**
	 * Sets the uuid.
	 * 
	 * @param uuid the new uuid
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	/**
	 * Gets the city.
	 * 
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * Sets the city.
	 * 
	 * @param city the new city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * Gets the publisher.
	 * 
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}
	
	/**
	 * Sets the publisher.
	 * 
	 * @param publisher the new publisher
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Document [authors=" + authors + ", city=" + city
				+ ", documentAbstract=" + documentAbstract + ", doi=" + doi
				+ ", editors=" + editors + ", id=" + id + ", issue=" + issue
				+ ", keywords=" + keywords + ", mendeleyUrl=" + mendeleyUrl
				+ ", pages=" + pages + ", publicationOutlet="
				+ publicationOutlet + ", publisher=" + publisher + ", tags="
				+ tags + ", title=" + title + ", type=" + type + ", url=" + url
				+ ", uuid=" + uuid + ", volume=" + volume + ", year=" + year
				+ "]";
	}
}
