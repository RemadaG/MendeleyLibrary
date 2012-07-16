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

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;

import com.mendeley.oapi.services.MendeleyException;
import com.mendeley.oapi.services.constant.ApplicationConstants;

/**
 * The Class MendeleyApiGateway.
 */
public abstract class MendeleyApiGateway {

	/**
	 * The Enum HttpMethod.
	 */
	public enum HttpMethod {

		/** The GET. */
		GET,

		/** The POST. */
		POST,

		/** The PUT. */
		PUT,

		/** The PATCH. */
		PATCH,

		/** The DELETE. */
		DELETE;
	}

	/** The logger. */
	protected final Logger logger = Logger.getLogger(getClass()
			.getCanonicalName());

	/** The Constant GZIP_ENCODING. */
	private static final String GZIP_ENCODING = "gzip";

	/** The Constant REFERRER. */
	private static final String REFERRER = "Referer";

	/** The request headers. */
	protected Map<String, String> requestHeaders = new HashMap<String, String>();

	/** The request parameters. */
	protected Map<String, String> requestParameters = new HashMap<String, String>();

	/** The user ip address. */
	protected String userIpAddress;

	/** The api version. */
	protected String apiVersion = ApplicationConstants.DEFAULT_API_VERSION;

	/**
	 * Gets the api version.
	 * 
	 * @return the api version
	 */
	public String getApiVersion() {
		return apiVersion;
	}

	/**
	 * Sets the api version.
	 * 
	 * @param apiVersion the new api version
	 */
	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}

	/**
	 * Sets the request headers.
	 * 
	 * @param requestHeaders the request headers
	 */
	public void setRequestHeaders(Map<String, String> requestHeaders) {
		this.requestHeaders = requestHeaders;
	}

	/**
	 * Gets the request headers.
	 * 
	 * @return the request headers
	 */
	public Map<String, String> getRequestHeaders() {
		return requestHeaders;
	}

	/**
	 * Adds the request header.
	 * 
	 * @param headerName the header name
	 * @param headerValue the header value
	 */
	public void addRequestHeader(String headerName, String headerValue) {
		requestHeaders.put(headerName, headerValue);
	}

	/**
	 * Removes the request header.
	 * 
	 * @param headerName the header name
	 */
	public void removeRequestHeader(String headerName) {
		requestHeaders.remove(headerName);
	}

	/**
	 * Sets the referrer.
	 * 
	 * @param referrer the new referrer
	 */
	public void setReferrer(String referrer) {
		requestHeaders.put(REFERRER, referrer);
	}

	/**
	 * Sets the user ip address.
	 * 
	 * @param userIpAddress the new user ip address
	 */
	public void setUserIpAddress(String userIpAddress) {
		this.userIpAddress = userIpAddress;
	}

	/**
	 * Convert stream to string.
	 * 
	 * @param is the is
	 * 
	 * @return the string
	 */
	protected static String convertStreamToString(InputStream is) {
		/*
		 * To convert the InputStream to String we use the
		 * BufferedReader.readLine() method. We iterate until the BufferedReader
		 * return null which means there's no more data to read. Each line will
		 * appended to a StringBuilder and returned as String.
		 */
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();

		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return sb.toString();
	}

	/**
	 * Call api get.
	 * 
	 * @param apiUrl the api url
	 * 
	 * @return the input stream
	 */
	protected InputStream callApiGet(String apiUrl) {
		return callApiGet(apiUrl, HttpURLConnection.HTTP_OK);
	}

	/**
	 * Call api get.
	 * 
	 * @param apiUrl the api url
	 * @param expected the expected
	 * 
	 * @return the input stream
	 */
	// protected InputStream callApiGet(String apiUrl, int expected) {
	// try {
	// URL url = new URL(apiUrl);
	// if (!requestParameters.isEmpty()) {
	// if (url.getQuery() == null) {
	// url = new URL(apiUrl + "?" + getParametersString(requestParameters));
	// } else {
	// url = new URL(apiUrl + "&" + getParametersString(requestParameters));
	// }
	// }
	//	        
	// HttpURLConnection request = (HttpURLConnection) url.openConnection();
	//	
	// if (ApplicationConstants.CONNECT_TIMEOUT > -1) {
	// request.setConnectTimeout(ApplicationConstants.CONNECT_TIMEOUT);
	// }
	//	
	// if (ApplicationConstants.READ_TIMEOUT > -1) {
	// request.setReadTimeout(ApplicationConstants.READ_TIMEOUT);
	// }
	//	
	// for (String headerName : requestHeaders.keySet()) {
	// request.setRequestProperty(headerName, requestHeaders.get(headerName));
	// }
	//	        
	// signRequest(request);
	// request.connect();
	//	        
	// if (request.getResponseCode() != expected) {
	// throw new
	// MendeleyException(convertStreamToString(getWrappedInputStream(request.getErrorStream(),
	// GZIP_ENCODING.equalsIgnoreCase(request.getContentEncoding()))));
	// } else {
	// return getWrappedInputStream(request.getInputStream(),
	// GZIP_ENCODING.equalsIgnoreCase(request.getContentEncoding()));
	// }
	// } catch (IOException e) {
	// throw new MendeleyException(e);
	// }
	// }

	protected InputStream callApiGet(String apiUrl, int expected) {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		try {
			HttpGet httpget = new HttpGet(apiUrl);
			if (!requestParameters.isEmpty()) {
				HttpParams params = httpget.getParams();
				for (String name : requestParameters.keySet()) {
					params.setParameter(name, requestParameters.get(name));
				}
			}

			for (String headerName : requestHeaders.keySet()) {
				httpget.addHeader(headerName, requestHeaders.get(headerName));
			}

			signRequest(httpget);
			HttpResponse response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();

			if (response.getStatusLine().getStatusCode() != expected) {
				throw new MendeleyException(convertStreamToString(getWrappedInputStream(entity)));
			} else {
				return getWrappedInputStream(entity);
			}
		} catch (IOException e) {
			throw new MendeleyException(e);
		} finally {
			// When HttpClient instance is no longer needed,
			// shut down the connection manager to ensure
			// immediate deallocation of all system resources
			// httpclient.getConnectionManager().shutdown();
		}
	}

	/**
	 * Call api post.
	 * 
	 * @param apiUrl the api url
	 * @param parameters the parameters
	 * 
	 * @return the input stream
	 */
	protected InputStream callApiPost(String apiUrl,
			Map<String, String> parameters) {
		return callApiPost(apiUrl, parameters, HttpURLConnection.HTTP_OK);
	}

	/**
	 * Call api post.
	 * 
	 * @param apiUrl the api url
	 * @param parameters the parameters
	 * @param expected the expected
	 * 
	 * @return the input stream
	 */
	// protected InputStream callApiPost(String apiUrl, Map<String, String>
	// parameters, int expected) {
	// try {
	// URL url = new URL(apiUrl);
	// HttpURLConnection request = (HttpURLConnection) url.openConnection();
	//
	// if (ApplicationConstants.CONNECT_TIMEOUT > -1) {
	// request.setConnectTimeout(ApplicationConstants.CONNECT_TIMEOUT);
	// }
	//
	// if (ApplicationConstants.READ_TIMEOUT > -1) {
	// request.setReadTimeout(ApplicationConstants.READ_TIMEOUT);
	// }
	//            
	// for (String headerName : requestHeaders.keySet()) {
	// request.setRequestProperty(headerName, requestHeaders.get(headerName));
	// }
	//            
	// parameters.putAll(requestParameters);
	//
	// request.setRequestMethod(HttpMethod.POST.name());
	// request.setDoOutput(true);
	// request.setRequestProperty("Content-Type",
	// "application/x-www-form-urlencoded");
	//            
	//            
	// signRequest(request);
	//
	// PrintStream out = new PrintStream(new
	// BufferedOutputStream(request.getOutputStream()));
	//            
	// out.print(getParametersString(parameters));
	// out.flush();
	// out.close();
	//
	// request.connect();
	//            
	// if (request.getResponseCode() != expected) {
	// throw new
	// MendeleyException(convertStreamToString(getWrappedInputStream(request.getErrorStream(),
	// GZIP_ENCODING.equalsIgnoreCase(request.getContentEncoding()))));
	// } else {
	// return getWrappedInputStream(request.getInputStream(),
	// GZIP_ENCODING.equalsIgnoreCase(request.getContentEncoding()));
	// }
	// } catch (IOException e) {
	// throw new MendeleyException(e);
	// } finally {
	// }
	// }
	protected InputStream callApiPost(String apiUrl,
			Map<String, String> parameters, int expected) {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		try {
			HttpPost httpost = new HttpPost(apiUrl);

			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			for (String name : parameters.keySet()) {
				nvps.add(new BasicNameValuePair(name, parameters.get(name)));
			}

			for (String headerName : requestHeaders.keySet()) {
				httpost.addHeader(headerName, requestHeaders.get(headerName));
			}

			httpost.setEntity(new Rfc3986FormEntity(nvps, HTTP.UTF_8));

			signRequest(httpost);

			HttpResponse response = httpclient.execute(httpost);
			HttpEntity entity = response.getEntity();

			if (response.getStatusLine().getStatusCode() != expected) {
				throw new MendeleyException(convertStreamToString(getWrappedInputStream(entity)));
			} else {
				return getWrappedInputStream(entity);
			}
		} catch (IOException e) {
			throw new MendeleyException(e);
		} finally {
			// When HttpClient instance is no longer needed,
			// shut down the connection manager to ensure
			// immediate deallocation of all system resources
			// httpclient.getConnectionManager().shutdown();
		}

	}

	/**
	 * Call api delete.
	 * 
	 * @param apiUrl the api url
	 * 
	 * @return the input stream
	 */
	protected InputStream callApiDelete(String apiUrl) {
		return callApiDelete(apiUrl, HttpURLConnection.HTTP_OK);
	}

	/**
	 * Call api delete.
	 * 
	 * @param apiUrl the api url
	 * @param expected the expected
	 * 
	 * @return the input stream
	 */
//	protected InputStream callApiDelete(String apiUrl, int expected) {
//		try {
//			URL url = new URL(apiUrl);
//
//			HttpURLConnection request = (HttpURLConnection) url
//					.openConnection();
//
//			if (ApplicationConstants.CONNECT_TIMEOUT > -1) {
//				request.setConnectTimeout(ApplicationConstants.CONNECT_TIMEOUT);
//			}
//
//			if (ApplicationConstants.READ_TIMEOUT > -1) {
//				request.setReadTimeout(ApplicationConstants.READ_TIMEOUT);
//			}
//
//			for (String headerName : requestHeaders.keySet()) {
//				request.setRequestProperty(headerName, requestHeaders
//						.get(headerName));
//			}
//
//			request.setRequestMethod(HttpMethod.DELETE.name());
//
//			signRequest(request);
//
//			request.connect();
//
//			if (request.getResponseCode() != expected) {
//				throw new MendeleyException(
//						convertStreamToString(getWrappedInputStream(request
//								.getErrorStream(), GZIP_ENCODING
//								.equalsIgnoreCase(request.getContentEncoding()))));
//			} else {
//				return getWrappedInputStream(request.getInputStream(),
//						GZIP_ENCODING.equalsIgnoreCase(request
//								.getContentEncoding()));
//			}
//		} catch (IOException e) {
//			throw new MendeleyException(e);
//		}
//	}


	protected InputStream callApiDelete(String apiUrl, int expected) {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		try {
			HttpDelete httpdelete = new HttpDelete(apiUrl);

			signRequest(httpdelete);

			HttpResponse response = httpclient.execute(httpdelete);
			HttpEntity entity = response.getEntity();

			if (response.getStatusLine().getStatusCode() != expected) {
				throw new MendeleyException(convertStreamToString(getWrappedInputStream(entity)));
			} else {
				return getWrappedInputStream(entity);
			}
		} catch (IOException e) {
			throw new MendeleyException(e);
		}
	}
	
	/**
	 * Sign request.
	 * 
	 * @param request the request
	 */
	protected abstract void signRequest(HttpURLConnection request);

	/**
	 * Sign request.
	 * 
	 * @param request the request
	 */
	protected abstract void signRequest(HttpRequest request);

	/**
	 * Call api put.
	 * 
	 * @param apiUrl the api url
	 * @param content the content
	 * @param contentType the content type
	 * @param expected the expected
	 * 
	 * @return the input stream
	 */
//	protected String getParametersString(Map<String, String> parameters) {
//		StringBuilder builder = new StringBuilder();
//		for (Iterator<Map.Entry<String, String>> iterator = parameters
//				.entrySet().iterator(); iterator.hasNext();) {
//			Map.Entry<String, String> entry = iterator.next();
//			builder.append(entry.getKey());
//			builder.append("=");
//			builder.append(encodeUrl(entry.getValue()));
//			if (iterator.hasNext()) {
//				builder.append("&");
//			}
//		}
//
//		return builder.toString();
//	}

	/**
	 * Call api method.
	 * 
	 * @param apiUrl
	 *            the api url
	 * @param xmlContent
	 *            the xml content
	 * @param contentType
	 *            the content type
	 * @param method
	 *            the method
	 * @param expected
	 *            the expected
	 * 
	 * @return the input stream
	 */
//	protected InputStream callApiMethod(String apiUrl, String xmlContent,
//			String contentType, HttpMethod method, int expected) {
//		try {
//			URL url = new URL(apiUrl);
//			HttpURLConnection request = (HttpURLConnection) url
//					.openConnection();
//
//			if (ApplicationConstants.CONNECT_TIMEOUT > -1) {
//				request.setConnectTimeout(ApplicationConstants.CONNECT_TIMEOUT);
//			}
//
//			if (ApplicationConstants.READ_TIMEOUT > -1) {
//				request.setReadTimeout(ApplicationConstants.READ_TIMEOUT);
//			}
//
//			for (String headerName : requestHeaders.keySet()) {
//				request.setRequestProperty(headerName, requestHeaders
//						.get(headerName));
//			}
//
//			request.setRequestMethod(method.name());
//			request.setDoOutput(true);
//
//			if (contentType != null) {
//				request.setRequestProperty("Content-Type", contentType);
//			}
//
//			signRequest(request);
//
//			if (xmlContent != null) {
//				PrintStream out = new PrintStream(new BufferedOutputStream(
//						request.getOutputStream()));
//
//				out.print(xmlContent);
//				out.flush();
//				out.close();
//			}
//
//			request.connect();
//
//			if (request.getResponseCode() != expected) {
//				throw new MendeleyException(
//						convertStreamToString(getWrappedInputStream(request
//								.getErrorStream(), GZIP_ENCODING
//								.equalsIgnoreCase(request.getContentEncoding()))));
//			} else {
//				return getWrappedInputStream(request.getInputStream(),
//						GZIP_ENCODING.equalsIgnoreCase(request
//								.getContentEncoding()));
//			}
//		} catch (IOException e) {
//			throw new MendeleyException(e);
//		}
//	}

	/**
	 * Call api method.
	 * 
	 * @param apiUrl
	 *            the api url
	 * @param xmlContent
	 *            the xml content
	 * @param contentType
	 *            the content type
	 * @param method
	 *            the method
	 * @param expected
	 *            the expected
	 * 
	 * @return the input stream
	 */
	protected InputStream callApiPut(String apiUrl, InputStream content,
			String contentType, int expected) {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		try {
			HttpPut httput = new HttpPut(apiUrl);

			for (String headerName : requestHeaders.keySet()) {
				httput.addHeader(headerName, requestHeaders.get(headerName));
			}

			httput.setEntity(new InputStreamEntity(content, -1L));

			signRequest(httput);

			HttpResponse response = httpclient.execute(httput);
			HttpEntity entity = response.getEntity();

			if (response.getStatusLine().getStatusCode() != expected) {
				throw new MendeleyException(convertStreamToString(getWrappedInputStream(entity)));
			} else {
				return getWrappedInputStream(entity);
			}
		} catch (IOException e) {
			throw new MendeleyException(e);
		} finally {
			// When HttpClient instance is no longer needed,
			// shut down the connection manager to ensure
			// immediate deallocation of all system resources
			// httpclient.getConnectionManager().shutdown();
		}
	}

	/**
	 * Copy stream.
	 * 
	 * @param in the in
	 * @param out the out
	 * 
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void copyStream(InputStream in, OutputStream out)
			throws IOException {
		try {
			// Transfer bytes from in to out
			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
		} finally {
			closeStream(in);
			closeStream(out);
		}
	}

	/**
	 * Close stream.
	 * 
	 * @param is the is
	 */
	protected void closeStream(Closeable is) {
		try {
			if (is != null) {
				is.close();
			}
		} catch (IOException e) {
			logger.log(Level.SEVERE, "An error occurred while closing stream.",
					e);
		}
	}

	/**
	 * Close connection.
	 * 
	 * @param connection the connection
	 */
	protected void closeConnection(HttpURLConnection connection) {
		try {
			if (connection != null) {
				connection.disconnect();
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE,
					"An error occurred while disconnecting connection.", e);
		}
	}

	/**
	 * Gets the wrapped input stream.
	 * 
	 * @param entity the entity
	 * 
	 * @return the wrapped input stream
	 * 
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected InputStream getWrappedInputStream(HttpEntity entity)
			throws IOException {
		Header contentEncoding = entity.getContentEncoding();
		if (contentEncoding != null && contentEncoding.getValue().contains(GZIP_ENCODING)) {
			return new BufferedInputStream(new GZIPInputStream(entity.getContent()));
		} else {
			return new BufferedInputStream(entity.getContent());
		}
	}

	/**
	 * The Class Rfc3986FormEntity.
	 */
//	private static String encodeUrl(String original) {
//		try {
//			return URLEncoder.encode(original,
//					ApplicationConstants.CONTENT_ENCODING);
//		} catch (UnsupportedEncodingException e) {
//			// should never be here..
//			return original;
//		}
//	}

	public static class Rfc3986FormEntity extends StringEntity {

		/**
		 * Instantiates a new rfc3986 form entity.
		 * 
		 * @param parameters the parameters
		 * @param encoding the encoding
		 * 
		 * @throws UnsupportedEncodingException the unsupported encoding exception
		 */
		public Rfc3986FormEntity(
				final List<? extends NameValuePair> parameters,
				final String encoding) throws UnsupportedEncodingException {
			super(Rfc3986FormEntity.format(parameters, encoding), encoding);
			setContentType(URLEncodedUtils.CONTENT_TYPE
					+ HTTP.CHARSET_PARAM
					+ (encoding != null ? encoding
							: HTTP.DEFAULT_CONTENT_CHARSET));
		}

		/**
		 * Format.
		 * 
		 * @param parameters the parameters
		 * @param encoding the encoding
		 * 
		 * @return the string
		 */
		private static String format(List<? extends NameValuePair> parameters,
				String encoding) {
			String encoded = URLEncodedUtils.format(parameters, encoding);
			return (encoded == null) ? null : encoded.replaceAll("\\+", "%20");
		}

		/**
		 * Instantiates a new rfc3986 form entity.
		 * 
		 * @param parameters the parameters
		 * 
		 * @throws UnsupportedEncodingException the unsupported encoding exception
		 */
		public Rfc3986FormEntity(final List<? extends NameValuePair> parameters)
				throws UnsupportedEncodingException {
			this(parameters, HTTP.DEFAULT_CONTENT_CHARSET);
		}
	}
}
