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

import java.util.HashMap;
import java.util.Map;

import com.mendeley.oapi.common.ValueEnum;

/**
 * The Class Group.
 */
public class Group extends SchemaEntity {

	/**
	 * The Enum MembershipType.
	 */
	public enum MembershipType implements ValueEnum {
		
		/** The ADMINS. */
		ADMINS("admins"), 
 
 /** The FOLLOWERS. */
 FOLLOWERS("followers"), 
 
 /** The MEMBERS. */
 MEMBERS("members"), 
 
 /** The OWNER. */
 OWNER("owner");
		
	    /** The Constant stringToEnum. */
		private static final Map<String, MembershipType> stringToEnum = new HashMap<String, MembershipType>();

		static { // Initialize map from constant name to enum constant
			for (MembershipType op : values()) {
				stringToEnum.put(op.value(), op);
			}
		}
		
		/** The value. */
		private String value;
		
		/**
		 * Instantiates a new membership type.
		 * 
		 * @param value the value
		 */
		MembershipType(String value) {
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
		 * @return the membership type
		 */
		public static MembershipType fromValue(String value) {
			return stringToEnum.get(value);
		}
	}

	/**
	 * The Enum Type.
	 */
	public enum Type implements ValueEnum {
		
		/** The PRIVATE. */
		PRIVATE("private"),
		
		/** The INVITE. */
		INVITE("invite"), 
		
		/** The OPEN. */
		OPEN("open"),
 
 /** The PUBLIC. */
 PUBLIC("public");
		
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
	
	/** The disciplines. */
	private Discipline disciplines;
	
	/** The id. */
	private String id;
	
	/** The name. */
	private String name;
	
	/** The owner. */
	private String owner;
	
	/** The public url. */
	private String publicUrl;
	
	/** The total documents. */
	private int totalDocuments;
	
	/** The people. */
	private Map<MembershipType, Integer> people = new HashMap<MembershipType, Integer>();
	
	/** The size. */
	private int size;
	
	/** The type. */
	private Type type;
	
	/**
	 * Gets the disciplines.
	 * 
	 * @return the disciplines
	 */
	public Discipline getDisciplines() {
		return disciplines;
	}
	
	/**
	 * Sets the disciplines.
	 * 
	 * @param disciplines the new disciplines
	 */
	public void setDisciplines(Discipline disciplines) {
		this.disciplines = disciplines;
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
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 * 
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the owner.
	 * 
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}
	
	/**
	 * Sets the owner.
	 * 
	 * @param owner the new owner
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	/**
	 * Gets the public url.
	 * 
	 * @return the public url
	 */
	public String getPublicUrl() {
		return publicUrl;
	}
	
	/**
	 * Sets the public url.
	 * 
	 * @param publicUrl the new public url
	 */
	public void setPublicUrl(String publicUrl) {
		this.publicUrl = publicUrl;
	}
	
	/**
	 * Gets the total documents.
	 * 
	 * @return the total documents
	 */
	public int getTotalDocuments() {
		return totalDocuments;
	}
	
	/**
	 * Sets the total documents.
	 * 
	 * @param totalDocuments the new total documents
	 */
	public void setTotalDocuments(int totalDocuments) {
		this.totalDocuments = totalDocuments;
	}
	
	/**
	 * Gets the people.
	 * 
	 * @return the people
	 */
	public Map<MembershipType, Integer> getPeople() {
		return people;
	}
	
	/**
	 * Sets the people.
	 * 
	 * @param people the people
	 */
	public void setPeople(Map<MembershipType, Integer> people) {
		this.people = people;
	}
	
	/**
	 * Gets the size.
	 * 
	 * @return the size
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Sets the size.
	 * 
	 * @param size the new size
	 */
	public void setSize(int size) {
		this.size = size;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Group [disciplines=" + disciplines + ", id=" + id + ", name="
				+ name + ", owner=" + owner + ", people=" + people
				+ ", publicUrl=" + publicUrl + ", size=" + size
				+ ", totalDocuments=" + totalDocuments + ", type=" + type + "]";
	}
}
