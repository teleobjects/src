package com.temboo.Library.RunKeeper.Friends;

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
RetrieveFriends

Returns the friends in a user's network.
*/
public class RetrieveFriends extends Choreography {

	/**
	Create a new instance of the RetrieveFriends Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public RetrieveFriends(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/RunKeeper/Friends/RetrieveFriends"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The Access Token retrieved after the final step in the OAuth process.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the Page input for this Choreo. 

	@param Integer - (optional, integer) The page of entries to return. This parameter is used in combination with the PageSize input to page through results. Defaults to 0 (the first page).
	*/
	public void setPage(Integer value) {
		this.inputs.setInput("Page", value);
	}

	/** 
	Set the value of the Page input for this Choreo as a String. 

	@param String - (optional, integer) The page of entries to return. This parameter is used in combination with the PageSize input to page through results. Defaults to 0 (the first page).
	*/
	public void setPage(String value) {
		this.inputs.setInput("Page", value);	
	}
	/** 
	Set the value of the PageSize input for this Choreo. 

	@param Integer - (optional, integer) The number entries to return per page. Defaults to 25.
	*/
	public void setPageSize(Integer value) {
		this.inputs.setInput("PageSize", value);
	}

	/** 
	Set the value of the PageSize input for this Choreo as a String. 

	@param String - (optional, integer) The number entries to return per page. Defaults to 25.
	*/
	public void setPageSize(String value) {
		this.inputs.setInput("PageSize", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public RetrieveFriendsResultSet run() {
		JSONObject result = super.runWithResults();
		return new RetrieveFriendsResultSet(result);
	}
	
}
