package com.temboo.Library.Xively.ReadWriteData;

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
WriteFeedMetadata

Allows you to easily update the metadata of your feed.
*/
public class WriteFeedMetadata extends Choreography {

	/**
	Create a new instance of the WriteFeedMetadata Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public WriteFeedMetadata(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Xively/ReadWriteData/WriteFeedMetadata"));
	}

	/** 
	Set the value of the FeedData input for this Choreo. 

	@param String - (optional, any) Custom data body for the new feed in JSON or XML format (set by FeedType). See documentation for how to write your own feed. If custom FeedData is used, all other optional inputs are ignored.
	*/
	public void setFeedData(String value) {
		this.inputs.setInput("FeedData", value);
	}


	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by Xively.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the Description input for this Choreo. 

	@param String - (optional, string) A description of the feed. Leave empty to keep existing Description. Type "BLANK" to clear existing Description.
	*/
	public void setDescription(String value) {
		this.inputs.setInput("Description", value);
	}


	/** 
	Set the value of the Email input for this Choreo. 

	@param String - (optional, string) Contact Email. Leave empty to keep existing Email. Type "BLANK" to clear existing Email.
	*/
	public void setEmail(String value) {
		this.inputs.setInput("Email", value);
	}


	/** 
	Set the value of the FeedID input for this Choreo. 

	@param Integer - (required, integer) The ID for the feed that you would like to update.
	*/
	public void setFeedID(Integer value) {
		this.inputs.setInput("FeedID", value);
	}

	/** 
	Set the value of the FeedID input for this Choreo as a String. 

	@param String - (required, integer) The ID for the feed that you would like to update.
	*/
	public void setFeedID(String value) {
		this.inputs.setInput("FeedID", value);	
	}
	/** 
	Set the value of the FeedType input for this Choreo. 

	@param String - (optional, string) The type of feed that is being provided for custom FeedData. Valid values are "json" (the default) and "xml".
	*/
	public void setFeedType(String value) {
		this.inputs.setInput("FeedType", value);
	}


	/** 
	Set the value of the Icon input for this Choreo. 

	@param String - (optional, string) The URL of an icon which is relevant to this feed. Leave empty to keep existing Icon. Type "BLANK" to clear existing Icon.
	*/
	public void setIcon(String value) {
		this.inputs.setInput("Icon", value);
	}


	/** 
	Set the value of the Private input for this Choreo. 

	@param Boolean - (optional, boolean) Specifies whether or not the feed is private to the creator of the feed. If 'true' the feed is private, if 'false' the feed is public. Leave empty to keep existing settings.
	*/
	public void setPrivate(Boolean value) {
		this.inputs.setInput("Private", value);
	}

	/** 
	Set the value of the Private input for this Choreo as a String. 

	@param String - (optional, boolean) Specifies whether or not the feed is private to the creator of the feed. If 'true' the feed is private, if 'false' the feed is public. Leave empty to keep existing settings.
	*/
	public void setPrivate(String value) {
		this.inputs.setInput("Private", value);	
	}
	/** 
	Set the value of the Tags input for this Choreo. 

	@param String - (optional, string) Comma-separated list of searchable tags (the characters ', ", and commas are not allowed). Tags input overwrites previous tags, enter "BLANK" to clear all tags. Ex: "power,energy".
	*/
	public void setTags(String value) {
		this.inputs.setInput("Tags", value);
	}


	/** 
	Set the value of the Title input for this Choreo. 

	@param String - (optional, string) A descriptive name for the feed. Leave empty to keep existing Title. Type "BLANK" to clear existing Title.
	*/
	public void setTitle(String value) {
		this.inputs.setInput("Title", value);
	}


	/** 
	Set the value of the Website input for this Choreo. 

	@param String - (optional, string) The URL of a website which is relevant to this feed. Leave empty to keep existing Website. Type "BLANK" to clear existing Website. Ex.: http://www.homepage.com.
	*/
	public void setWebsite(String value) {
		this.inputs.setInput("Website", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public WriteFeedMetadataResultSet run() {
		JSONObject result = super.runWithResults();
		return new WriteFeedMetadataResultSet(result);
	}
	
}
