package com.temboo.Library.Delicious;

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
AddBookmark

Adds a link bookmark to a Delicious account.
*/
public class AddBookmark extends Choreography {

	/**
	Create a new instance of the AddBookmark Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public AddBookmark(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Delicious/AddBookmark"));
	}

	/** 
	Set the value of the Description input for this Choreo. 

	@param String - (required, string) A description for the link to post.
	*/
	public void setDescription(String value) {
		this.inputs.setInput("Description", value);
	}


	/** 
	Set the value of the Notes input for this Choreo. 

	@param String - (optional, string) Descriptive notes for the posted link.
	*/
	public void setNotes(String value) {
		this.inputs.setInput("Notes", value);
	}


	/** 
	Set the value of the Password input for this Choreo. 

	@param String - (required, password) The password that corresponds to the specified Delicious account username.
	*/
	public void setPassword(String value) {
		this.inputs.setInput("Password", value);
	}


	/** 
	Set the value of the Replace input for this Choreo. 

	@param Integer - (optional, integer) Specify "1" to replace the post if the URL has already been posted. Set to "0" (don't replace) by default.
	*/
	public void setReplace(Integer value) {
		this.inputs.setInput("Replace", value);
	}

	/** 
	Set the value of the Replace input for this Choreo as a String. 

	@param String - (optional, integer) Specify "1" to replace the post if the URL has already been posted. Set to "0" (don't replace) by default.
	*/
	public void setReplace(String value) {
		this.inputs.setInput("Replace", value);	
	}
	/** 
	Set the value of the Shared input for this Choreo. 

	@param Integer - (optional, integer) Specify "1" to make the posted link private. Set to "0" (shared) by default.
	*/
	public void setShared(Integer value) {
		this.inputs.setInput("Shared", value);
	}

	/** 
	Set the value of the Shared input for this Choreo as a String. 

	@param String - (optional, integer) Specify "1" to make the posted link private. Set to "0" (shared) by default.
	*/
	public void setShared(String value) {
		this.inputs.setInput("Shared", value);	
	}
	/** 
	Set the value of the Tags input for this Choreo. 

	@param String - (optional, string) Add keyword tags to the posted link. Separate multiple tags with commas.
	*/
	public void setTags(String value) {
		this.inputs.setInput("Tags", value);
	}


	/** 
	Set the value of the URL input for this Choreo. 

	@param String - (required, string) The URL for the link to post.
	*/
	public void setURL(String value) {
		this.inputs.setInput("URL", value);
	}


	/** 
	Set the value of the Username input for this Choreo. 

	@param String - (required, string) A valid Delicious account username.
	*/
	public void setUsername(String value) {
		this.inputs.setInput("Username", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public AddBookmarkResultSet run() {
		JSONObject result = super.runWithResults();
		return new AddBookmarkResultSet(result);
	}
	
}
