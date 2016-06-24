package com.temboo.core;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.DefaultHttpClient;
import processing.data.JSONObject;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.Properties;


public class TembooSession {
	 
	// The client identifier for this Java SDK version
	protected final String CLIENT_IDENTIFIER;
	
	// The base path used to make requests to the Temboo REST API
	protected static final String BASE_PATH = "/arcturus-web/api-1.0";
	
	// Organization name and credentials for the Temboo session
	private final String organization;
	private final String name;
	private final String password;

	public TembooSession(String organization, String name, String password) {
		this.organization = organization;
		this.name = name;
		this.password = password;
        String client="unknown";
        try {
            Properties p = new Properties();
            p.load(TembooSession.class.getResourceAsStream("temboo-version.properties"));
            client = p.getProperty("sdkVersion");
        } catch (Exception e1) {
            System.err.println("Problem reading version number from jar/temboo-version.properties");
        } finally {
            CLIENT_IDENTIFIER = client;
        }

    }

	private String getHost() {
		return organization + ".temboolive.com";
	}

	public Choreography getChoreography(TembooPath uri) {
		return new Choreography(this, uri);
	}
	
	protected JSONObject getContent(String path) throws TembooException {
		return getContent(path, null);
	}
	
	protected JSONObject getContent(String path, Map<String, String> paramMap) throws TembooException {
		try {
			URI uri = URIUtils.createURI("https", getHost(), -1, path, getQueryString(paramMap),
					null);

			UsernamePasswordCredentials creds = new UsernamePasswordCredentials(
					name, password);

			HttpGet httpGet = new HttpGet(uri);
			httpGet.addHeader("Accept", "application/json");
			httpGet.addHeader("Content-Type", "application/json");
			httpGet.addHeader("x-temboo-domain", organization + "/master");
			httpGet.addHeader(BasicScheme
					.authenticate(creds, "US-ASCII", false));

			
			HttpClient httpclient = new DefaultHttpClient();
			HttpResponse response = httpclient.execute(httpGet);
			if (response.getStatusLine().getStatusCode() == 200) {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					ByteArrayOutputStream os = new ByteArrayOutputStream();
					entity.writeTo(os);
					os.close();
					
					return new JSONObject(new StringReader(new String(os.toByteArray(), "utf-8")));
				}
			} else {
				String message = errorResponse(response);
				throw new TembooHttpException(message, response.getStatusLine().getStatusCode());
			}
		} catch(UnknownHostException e) {
			throw new TembooException("Unable to connect to the Temboo server. Make sure your Temboo Account Name is correct.");
		} catch (IOException e) {
			throw new TembooException(e);
		} catch (URISyntaxException e) {
			throw new TembooException(e);
		}
		return null;
	}

	private String errorResponse(HttpResponse response) throws IOException {
		String message = "An http error occurred";
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			entity.writeTo(os);
			os.close();
			message = os.toString();
		}
		return message;
	}


	protected JSONObject postContent(String path, byte[] bytes) throws TembooException {
		return postContent(path, bytes, null);
	}

	/**
	 * Perform a POST operation to the Temboo server REST API with the specified data,
	 * and return the response as a JSON object.
	 * 
	 * @param path - the REST API path/collection to which the data should be posted
	 * @param bytes - the POST body data to be sent
	 * @param paramMap - the collection of querystring parameters to be sent
	 * @return
	 * @throws TembooException
	 */
	protected JSONObject postContent(String path, byte[] bytes, Map<String, String> paramMap)
			throws TembooException {
		try {
			URI uri = URIUtils.createURI("https", getHost(), -1, path, getQueryString(paramMap),
					null);

			UsernamePasswordCredentials creds = new UsernamePasswordCredentials(
					name, password);

			HttpPost httpPost = new HttpPost(uri);
			httpPost.addHeader("Accept", "application/json");
			httpPost.addHeader("Content-Type", "application/json");
			httpPost.addHeader("x-temboo-domain", organization + "/master");
			httpPost.addHeader(BasicScheme.authenticate(creds, "US-ASCII",
					false));
			ByteArrayEntity dataEntity = new ByteArrayEntity(bytes);
			httpPost.setEntity(dataEntity);

			HttpClient httpclient = new DefaultHttpClient();
			HttpResponse response = httpclient.execute(httpPost);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode >= 200 && statusCode < 300) {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					if (entity != null) {
						return parseHttpEntityAsJson(entity);
					}
				}
			}
			else {
				// See if we can extract a more precise error message from JSON returned by Temboo
				String detailMsg = null;
				String message = errorResponse(response);
				try {
					JSONObject errorData = new JSONObject(new StringReader(message));
					JSONObject executionData = errorData.getJSONObject("execution");
					detailMsg = executionData.getString("lasterror");
				} catch(Exception e) {
					// Nothing
				}
				if(detailMsg != null) 
					throw new TembooException(detailMsg);
				else
					throw new TembooException(message);
			}
		} catch(UnknownHostException e) {
			throw new TembooException("Unable to connect to the Temboo server. Make sure your Temboo Account Name is correct.");
		} catch (IOException e) {
			throw new TembooException(e);
		} catch (URISyntaxException e) {
			throw new TembooException(e);
		}
		return null;
	}
	

	/**
	 * Create a URL querystring from the set of specified key/value pairs
	 * @param params
	 * @return
	 * @throws Exception
	 */
	private String getQueryString(Map<String, String> params) {
		if(null == params)
			return null;
		
		StringBuilder sb = new StringBuilder();
	
		for (Map.Entry<String, String> entry : params.entrySet()) {
			String name = entry.getKey();
			String value = entry.getValue();
			sb.append(URLEncode(name));
			sb.append("=");
			sb.append(URLEncode(value));
			sb.append("&");
		}
		String query = sb.toString();
		if(query.endsWith("&"))
			return query.substring(0, query.length() - 1);
		else
			return query;
	}
	
	
	/**
	 * URL encode a string
	 * @param source
	 * @return
	 * @throws Exception
	 */
	private static String URLEncode(String source) {
		try {
			String s = java.net.URLEncoder.encode(source, "UTF-8");
			
			// this is a terrible hack, to work around the fact that Java encodes spaces as "+" rather than %20
			// unfortunately, there doesn't seem to be a better solution without going to a strange 3rd party lib
			return s.replaceAll("\\+", "%20");
		} catch(Exception e) {
			return "";
		}
	}

	/**
	 * Convert an HttpEntity into a JSON object
	 * @param entity
	 * @return
	 */
	private JSONObject parseHttpEntityAsJson(HttpEntity entity) throws IOException {
		if (entity != null) {
			InputStream stream = entity.getContent();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(stream, "utf-8"));
			StringBuilder sb = new StringBuilder();
			String line = null;
			
			while((line = br.readLine()) != null)
				sb.append(line);
			
			br.close();
			String s = sb.toString();			
			return new JSONObject(new StringReader(sb.toString()));
		}
		return null;
	}
}
