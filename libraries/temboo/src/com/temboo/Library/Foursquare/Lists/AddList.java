package com.temboo.Library.Foursquare.Lists;

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
AddList

Creates a new list.
*/
public class AddList extends Choreography {

	/**
	Create a new instance of the AddList Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public AddList(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Foursquare/Lists/AddList"));
	}

	/** 
	Set the value of the Collaborative input for this Choreo. 

	@param Boolean - (optional, boolean) A flag indicating that this list can be edited by friends. Set to 1 for true. Defaults to 0 (false).
	*/
	public void setCollaborative(Boolean value) {
		this.inputs.setInput("Collaborative", value);
	}

	/** 
	Set the value of the Collaborative input for this Choreo as a String. 

	@param String - (optional, boolean) A flag indicating that this list can be edited by friends. Set to 1 for true. Defaults to 0 (false).
	*/
	public void setCollaborative(String value) {
		this.inputs.setInput("Collaborative", value);	
	}
	/** 
	Set the value of the Description input for this Choreo. 

	@param String - (optional, string) The description of the list.
	*/
	public void setDescription(String value) {
		this.inputs.setInput("Description", value);
	}


	/** 
	Set the value of the Name input for this Choreo. 

	@param String - (required, string) The name of the list.
	*/
	public void setName(String value) {
		this.inputs.setInput("Name", value);
	}


	/** 
	Set the value of the OauthToken input for this Choreo. 

	@param String - (required, string) The Foursquare API OAuth token string.
	*/
	public void setOauthToken(String value) {
		this.inputs.setInput("OauthToken", value);
	}


	/** 
	Set the value of the PhotoID input for this Choreo. 

	@param String - (optional, string) The id of a photo that should be set as the list photo.
	*/
	public void setPhotoID(String value) {
		this.inputs.setInput("PhotoID", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that response should be in. Can be set to xml or json. Defaults to json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public AddListResultSet run() {
		JSONObject result = super.runWithResults();
		return new AddListResultSet(result);
	}
	
}
