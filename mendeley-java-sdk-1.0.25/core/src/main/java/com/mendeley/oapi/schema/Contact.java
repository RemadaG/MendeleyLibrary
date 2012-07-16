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

/**
 * The Class Contact.
 */
public class Contact extends SchemaEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3484450630735705441L;
	
	/** The address. */
	private String address;
	
	/** The email. */
	private String email;
	
	/** The im. */
	private String im;
	
	/** The fax. */
	private String fax;
	
	/** The mobile. */
	private String mobile;
	
	/** The phone. */
	private String phone;
	
	/** The webpage. */
	private String webpage;
	
	/** The zipcode. */
	private String zipcode;
	
	/**
	 * Gets the address.
	 * 
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * Sets the address.
	 * 
	 * @param address the new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * Gets the email.
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email.
	 * 
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Gets the im.
	 * 
	 * @return the im
	 */
	public String getIm() {
		return im;
	}
	
	/**
	 * Sets the im.
	 * 
	 * @param im the new im
	 */
	public void setIm(String im) {
		this.im = im;
	}
	
	/**
	 * Gets the fax.
	 * 
	 * @return the fax
	 */
	public String getFax() {
		return fax;
	}
	
	/**
	 * Sets the fax.
	 * 
	 * @param fax the new fax
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	/**
	 * Gets the mobile.
	 * 
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}
	
	/**
	 * Sets the mobile.
	 * 
	 * @param mobile the new mobile
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	/**
	 * Gets the phone.
	 * 
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	
	/**
	 * Sets the phone.
	 * 
	 * @param phone the new phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * Gets the webpage.
	 * 
	 * @return the webpage
	 */
	public String getWebpage() {
		return webpage;
	}
	
	/**
	 * Sets the webpage.
	 * 
	 * @param webpage the new webpage
	 */
	public void setWebpage(String webpage) {
		this.webpage = webpage;
	}
	
	/**
	 * Gets the zipcode.
	 * 
	 * @return the zipcode
	 */
	public String getZipcode() {
		return zipcode;
	}
	
	/**
	 * Sets the zipcode.
	 * 
	 * @param zipcode the new zipcode
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Contact [address=" + address + ", email=" + email + ", fax="
				+ fax + ", im=" + im + ", mobile=" + mobile + ", phone="
				+ phone + ", webpage=" + webpage + ", zipcode=" + zipcode + "]";
	}
}
