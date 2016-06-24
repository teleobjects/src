package com.temboo.Library.LastFm.User;

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
GetPersonalTags

Retrieves a user's personal tags.
*/
public class GetPersonalTags extends Choreography {

	/**
	Create a new instance of the GetPersonalTags Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetPersonalTags(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/LastFm/User/GetPersonalTags"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (string) Your Last.fm API Key.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the Limit input for this Choreo. 

	@param Integer - (optional, integer) The number of results to fetch per page. Defaults to 50.
	*/
	public void setLimit(Integer value) {
		this.inputs.setInput("Limit", value);
	}

	/** 
	Set the value of the Limit input for this Choreo as a String. 

	@param String - (optional, integer) The number of results to fetch per page. Defaults to 50.
	*/
	public void setLimit(String value) {
		this.inputs.setInput("Limit", value);	
	}
	/** 
	Set the value of the Page input for this Choreo. 

	@param Integer - (optional, integer) The page number to fetch. Defaults to 1.
	*/
	public void setPage(Integer value) {
		this.inputs.setInput("Page", value);
	}

	/** 
	Set the value of the Page input for this Choreo as a String. 

	@param String - (optional, integer) The page number to fetch. Defaults to 1.
	*/
	public void setPage(String value) {
		this.inputs.setInput("Page", value);	
	}
	/** 
	Set the value of the Tag input for this Choreo. 

	@param String - (string) The tag you're interested in.
	*/
	public void setTag(String value) {
		this.inputs.setInput("Tag", value);
	}


	/** 
	Set the value of the TaggingType input for this Choreo. 

	@param String - (string) The type of items which have been tagged. Valid values are: artist, album, track.
	*/
	public void setTaggingType(String value) {
		this.inputs.setInput("TaggingType", value);
	}


	/** 
	Set the value of the User input for this Choreo. 

	@param String - (string) The user who performed the taggings.
	*/
	public void setUser(String value) {
		this.inputs.setInput("User", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetPersonalTagsResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetPersonalTagsResultSet(result);
	}
	
}
