package com.temboo.Library.Disqus.Forums;

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
CreateForum

Creates a new Forum (AKA  Disqus Site or Discussion)
*/
public class CreateForum extends Choreography {

	/**
	Create a new instance of the CreateForum Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CreateForum(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Disqus/Forums/CreateForum"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) A valid OAuth 2.0 access token.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the Forum input for this Choreo. 

	@param String - (required, string) Forum Short Name.   The short name must  be a unique identifier not currently in use by anyone else in the Disqus Community.  The short name will be also be used to create a unique Disqus Site URL.
	*/
	public void setForum(String value) {
		this.inputs.setInput("Forum", value);
	}


	/** 
	Set the value of the PublicKey input for this Choreo. 

	@param String - (required, string) The Public Key provided by Disqus (AKA the API Key).
	*/
	public void setPublicKey(String value) {
		this.inputs.setInput("PublicKey", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are: json (the default), jsonp, or rss.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the SiteName input for this Choreo. 

	@param String - (required, string) The Site Name of the forum you are creating.
	*/
	public void setSiteName(String value) {
		this.inputs.setInput("SiteName", value);
	}


	/** 
	Set the value of the Website input for this Choreo. 

	@param String - (required, string) The URL of the website associated with the forum
	*/
	public void setWebsite(String value) {
		this.inputs.setInput("Website", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CreateForumResultSet run() {
		JSONObject result = super.runWithResults();
		return new CreateForumResultSet(result);
	}
	
}
