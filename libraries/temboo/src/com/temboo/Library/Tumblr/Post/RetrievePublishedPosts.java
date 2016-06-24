package com.temboo.Library.Tumblr.Post;

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
RetrievePublishedPosts

Retrieves published posts using various search and filter parameters.
*/
public class RetrievePublishedPosts extends Choreography {

	/**
	Create a new instance of the RetrievePublishedPosts Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public RetrievePublishedPosts(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Tumblr/Post/RetrievePublishedPosts"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by Tumblr (AKA the OAuth Consumer Key).
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the BaseHostname input for this Choreo. 

	@param String - (required, string) The standard or custom blog hostname (i.e. temboo.tumblr.com).
	*/
	public void setBaseHostname(String value) {
		this.inputs.setInput("BaseHostname", value);
	}


	/** 
	Set the value of the Format input for this Choreo. 

	@param String - (optional, string) Specifies the post format to return. Valid values are: text (Plain text, no HTML), raw (As entered by user). HTML is returned when left null.
	*/
	public void setFormat(String value) {
		this.inputs.setInput("Format", value);
	}


	/** 
	Set the value of the ID input for this Choreo. 

	@param Integer - (optional, integer) The specified post ID in order to return a single post.
	*/
	public void setID(Integer value) {
		this.inputs.setInput("ID", value);
	}

	/** 
	Set the value of the ID input for this Choreo as a String. 

	@param String - (optional, integer) The specified post ID in order to return a single post.
	*/
	public void setID(String value) {
		this.inputs.setInput("ID", value);	
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
	Set the value of the NotesInfo input for this Choreo. 

	@param Boolean - (optional, boolean) Indicates whether to return notes information (specify true or false). Defaults to 0 (false).
	*/
	public void setNotesInfo(Boolean value) {
		this.inputs.setInput("NotesInfo", value);
	}

	/** 
	Set the value of the NotesInfo input for this Choreo as a String. 

	@param String - (optional, boolean) Indicates whether to return notes information (specify true or false). Defaults to 0 (false).
	*/
	public void setNotesInfo(String value) {
		this.inputs.setInput("NotesInfo", value);	
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
	Set the value of the ReblogInfo input for this Choreo. 

	@param Boolean - (optional, boolean) Indicates whether to return reblog information (specify 1 or 0). Defaults to 0 (false).
	*/
	public void setReblogInfo(Boolean value) {
		this.inputs.setInput("ReblogInfo", value);
	}

	/** 
	Set the value of the ReblogInfo input for this Choreo as a String. 

	@param String - (optional, boolean) Indicates whether to return reblog information (specify 1 or 0). Defaults to 0 (false).
	*/
	public void setReblogInfo(String value) {
		this.inputs.setInput("ReblogInfo", value);	
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

	@param String - (optional, string) Limits the response to posts with the specified tag.
	*/
	public void setTag(String value) {
		this.inputs.setInput("Tag", value);
	}


	/** 
	Set the value of the Type input for this Choreo. 

	@param String - (optional, string) The type of post to return. Specify one of the following:  text, quote, link, answer, video, audio, photo. When null, all types are returned.
	*/
	public void setType(String value) {
		this.inputs.setInput("Type", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public RetrievePublishedPostsResultSet run() {
		JSONObject result = super.runWithResults();
		return new RetrievePublishedPostsResultSet(result);
	}
	
}
