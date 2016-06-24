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
GetAllBookmarks

Returns all links posted to a Delicious account.
*/
public class GetAllBookmarks extends Choreography {

	/**
	Create a new instance of the GetAllBookmarks Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetAllBookmarks(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Delicious/GetAllBookmarks"));
	}

	/** 
	Set the value of the Count input for this Choreo. 

	@param Integer - (optional, integer) The number of bookmarks to return. Defaults to 15.
	*/
	public void setCount(Integer value) {
		this.inputs.setInput("Count", value);
	}

	/** 
	Set the value of the Count input for this Choreo as a String. 

	@param String - (optional, integer) The number of bookmarks to return. Defaults to 15.
	*/
	public void setCount(String value) {
		this.inputs.setInput("Count", value);	
	}
	/** 
	Set the value of the FromDate input for this Choreo. 

	@param String - (optional, date) Return only bookmarks posted on this date and later. Enter in YYYY-MM-DDThh:mm:ssZ format.
	*/
	public void setFromDate(String value) {
		this.inputs.setInput("FromDate", value);
	}


	/** 
	Set the value of the Meta input for this Choreo. 

	@param String - (optional, string) Specify "1" to include a change-detection signature for each item returned. Defaults to "0", or no meta attributes retained.
	*/
	public void setMeta(String value) {
		this.inputs.setInput("Meta", value);
	}


	/** 
	Set the value of the Password input for this Choreo. 

	@param String - (required, password) The password that corresponds to the specified Delicious account username.
	*/
	public void setPassword(String value) {
		this.inputs.setInput("Password", value);
	}


	/** 
	Set the value of the Tag input for this Choreo. 

	@param String - (optional, string) Return only bookmrks tagged with this keyword.
	*/
	public void setTag(String value) {
		this.inputs.setInput("Tag", value);
	}


	/** 
	Set the value of the ToDate input for this Choreo. 

	@param String - (optional, date) Return only bookmarks posted on this date and earlier. Enter in YYYY-MM-DDThh:mm:ssZ format.
	*/
	public void setToDate(String value) {
		this.inputs.setInput("ToDate", value);
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
	public GetAllBookmarksResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetAllBookmarksResultSet(result);
	}
	
}
