package com.temboo.Library.Twitter.Search;

/*
Copyright 2014 Temboo, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

import processing.data.JSONArray;
import processing.data.JSONObject;
import java.math.BigDecimal;
import com.temboo.core.Choreography;
import com.temboo.core.Choreography.ResultSet;
import com.temboo.core.TembooException;
import com.temboo.core.TembooPath;
import com.temboo.core.TembooSession;

/** 
Tweets

Retrieves a collection of relevant Tweets matching a specified query.
*/
public class Tweets extends Choreography {

	/**
	Create a new instance of the Tweets Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Tweets(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Twitter/Search/Tweets"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The Access Token provided by Twitter or retrieved during the OAuth process.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the AccessTokenSecret input for this Choreo. 

	@param String - (required, string) The Access Token Secret provided by Twitter or retrieved during the OAuth process.
	*/
	public void setAccessTokenSecret(String value) {
		this.inputs.setInput("AccessTokenSecret", value);
	}


	/** 
	Set the value of the ConsumerKey input for this Choreo. 

	@param String - (required, string) The API Key (or Consumer Key) provided by Twitter.
	*/
	public void setConsumerKey(String value) {
		this.inputs.setInput("ConsumerKey", value);
	}


	/** 
	Set the value of the ConsumerSecret input for this Choreo. 

	@param String - (required, string) The API Secret (or Consumer Secret) provided by Twitter.
	*/
	public void setConsumerSecret(String value) {
		this.inputs.setInput("ConsumerSecret", value);
	}


	/** 
	Set the value of the Count input for this Choreo. 

	@param Integer - (optional, integer) Specifies the number of records to retrieve. Must be less than or equal to 200. Defaults to 20.
	*/
	public void setCount(Integer value) {
		this.inputs.setInput("Count", value);
	}

	/** 
	Set the value of the Count input for this Choreo as a String. 

	@param String - (optional, integer) Specifies the number of records to retrieve. Must be less than or equal to 200. Defaults to 20.
	*/
	public void setCount(String value) {
		this.inputs.setInput("Count", value);	
	}
	/** 
	Set the value of the Geocode input for this Choreo. 

	@param String - (optional, string) Returns tweets by users located within a given radius of the given latitude/longitude. Formatted like: 37.781157,-122.398720,1mi.
	*/
	public void setGeocode(String value) {
		this.inputs.setInput("Geocode", value);
	}


	/** 
	Set the value of the IncludeEntities input for this Choreo. 

	@param Boolean - (optional, boolean) The "entities" node containing extra metadata will not be included when set to false.
	*/
	public void setIncludeEntities(Boolean value) {
		this.inputs.setInput("IncludeEntities", value);
	}

	/** 
	Set the value of the IncludeEntities input for this Choreo as a String. 

	@param String - (optional, boolean) The "entities" node containing extra metadata will not be included when set to false.
	*/
	public void setIncludeEntities(String value) {
		this.inputs.setInput("IncludeEntities", value);	
	}
	/** 
	Set the value of the Language input for this Choreo. 

	@param String - (optional, string) Restricts tweets to the given language, given by an ISO 639-1 code.
	*/
	public void setLanguage(String value) {
		this.inputs.setInput("Language", value);
	}


	/** 
	Set the value of the MaxId input for this Choreo. 

	@param String - (optional, string) Returns results with an ID less than (older than) or equal to the specified ID.
	*/
	public void setMaxId(String value) {
		this.inputs.setInput("MaxId", value);
	}


	/** 
	Set the value of the Query input for this Choreo. 

	@param String - (required, string) A search query of up to 1,000 characters.
	*/
	public void setQuery(String value) {
		this.inputs.setInput("Query", value);
	}


	/** 
	Set the value of the ResultType input for this Choreo. 

	@param String - (optional, string) Specifies what type of search results you want to receive. The default is "mixed." Valid values are: mixed, recent, and popular.
	*/
	public void setResultType(String value) {
		this.inputs.setInput("ResultType", value);
	}


	/** 
	Set the value of the SinceId input for this Choreo. 

	@param String - (optional, string) Returns results with an ID greater than (more recent than) the specified ID.
	*/
	public void setSinceId(String value) {
		this.inputs.setInput("SinceId", value);
	}


	/** 
	Set the value of the Until input for this Choreo. 

	@param String - (optional, date) Returns tweets generated before the given date. Date should be formatted as YYYY-MM-DD.
	*/
	public void setUntil(String value) {
		this.inputs.setInput("Until", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public TweetsResultSet run() {
		JSONObject result = super.runWithResults();
		return new TweetsResultSet(result);
	}
	
}
