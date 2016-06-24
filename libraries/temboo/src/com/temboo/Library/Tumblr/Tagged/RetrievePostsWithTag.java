package com.temboo.Library.Tumblr.Tagged;

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
RetrievePostsWithTag

Retrieves posts that have a given tag.
*/
public class RetrievePostsWithTag extends Choreography {

	/**
	Create a new instance of the RetrievePostsWithTag Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public RetrievePostsWithTag(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Tumblr/Tagged/RetrievePostsWithTag"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by Tumblr (AKA the OAuth Consumer Key).
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the Before input for this Choreo. 

	@param String - (optional, string) The timestamp of when you'd like to see posts before (e.g. 1363716547).
	*/
	public void setBefore(String value) {
		this.inputs.setInput("Before", value);
	}


	/** 
	Set the value of the Filter input for this Choreo. 

	@param String - (optional, string) Specifies the post format to return. Valid values are: text (plain text, no html) or raw (as entered by the user).
	*/
	public void setFilter(String value) {
		this.inputs.setInput("Filter", value);
	}


	/** 
	Set the value of the Limit input for this Choreo. 

	@param Integer - (optional, integer) The number of posts to return: 1- 20. Defaults to 20.
	*/
	public void setLimit(Integer value) {
		this.inputs.setInput("Limit", value);
	}

	/** 
	Set the value of the Limit input for this Choreo as a String. 

	@param String - (optional, integer) The number of posts to return: 1- 20. Defaults to 20.
	*/
	public void setLimit(String value) {
		this.inputs.setInput("Limit", value);	
	}
	/** 
	Set the value of the Offset input for this Choreo. 

	@param Integer - (optional, integer) The post number to start at. Defaults to 0.
	*/
	public void setOffset(Integer value) {
		this.inputs.setInput("Offset", value);
	}

	/** 
	Set the value of the Offset input for this Choreo as a String. 

	@param String - (optional, integer) The post number to start at. Defaults to 0.
	*/
	public void setOffset(String value) {
		this.inputs.setInput("Offset", value);	
	}
	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Can be set to xml or json. Defaults to json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the Tag input for this Choreo. 

	@param String - (required, string) The tag on the posts you'd like to retrieve.
	*/
	public void setTag(String value) {
		this.inputs.setInput("Tag", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public RetrievePostsWithTagResultSet run() {
		JSONObject result = super.runWithResults();
		return new RetrievePostsWithTagResultSet(result);
	}
	
}
