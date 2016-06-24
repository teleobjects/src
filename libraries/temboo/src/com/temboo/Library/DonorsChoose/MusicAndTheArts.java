package com.temboo.Library.DonorsChoose;

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
MusicAndTheArts

Returns results for projects within the Music and The Arts category.
*/
public class MusicAndTheArts extends Choreography {

	/**
	Create a new instance of the MusicAndTheArts Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public MusicAndTheArts(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/DonorsChoose/MusicAndTheArts"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (optional, string) The APIKey provided by DonorsChoose.org. Defaults to the test  APIKey 'DONORSCHOOSE'.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the Index input for this Choreo. 

	@param Integer - (optional, integer) The number of the first row to return in the result. For example, if index=10, the results could show rows 10-59.
	*/
	public void setIndex(Integer value) {
		this.inputs.setInput("Index", value);
	}

	/** 
	Set the value of the Index input for this Choreo as a String. 

	@param String - (optional, integer) The number of the first row to return in the result. For example, if index=10, the results could show rows 10-59.
	*/
	public void setIndex(String value) {
		this.inputs.setInput("Index", value);	
	}
	/** 
	Set the value of the Max input for this Choreo. 

	@param Integer - (optional, integer) The max number of projects to return. Can return up to 50 rows at a time. Defaults to 10 when left empty.
	*/
	public void setMax(Integer value) {
		this.inputs.setInput("Max", value);
	}

	/** 
	Set the value of the Max input for this Choreo as a String. 

	@param String - (optional, integer) The max number of projects to return. Can return up to 50 rows at a time. Defaults to 10 when left empty.
	*/
	public void setMax(String value) {
		this.inputs.setInput("Max", value);	
	}
	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Can be set to xml or json. Defaults to xml.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the ShowCounts input for this Choreo. 

	@param Boolean - (optional, boolean) Set to 1 to return facet counts in the response
	*/
	public void setShowCounts(Boolean value) {
		this.inputs.setInput("ShowCounts", value);
	}

	/** 
	Set the value of the ShowCounts input for this Choreo as a String. 

	@param String - (optional, boolean) Set to 1 to return facet counts in the response
	*/
	public void setShowCounts(String value) {
		this.inputs.setInput("ShowCounts", value);	
	}
	/** 
	Set the value of the ShowSynopsis input for this Choreo. 

	@param Boolean - (optional, boolean) Set to 1 to show the synopsis for each project listing
	*/
	public void setShowSynopsis(Boolean value) {
		this.inputs.setInput("ShowSynopsis", value);
	}

	/** 
	Set the value of the ShowSynopsis input for this Choreo as a String. 

	@param String - (optional, boolean) Set to 1 to show the synopsis for each project listing
	*/
	public void setShowSynopsis(String value) {
		this.inputs.setInput("ShowSynopsis", value);	
	}
	/** 
	Set the value of the Subject input for this Choreo. 

	@param String - (optional, string) Enter a sub-category of Music & The Arts. When left empty, all Art & Music projects are returned.
	*/
	public void setSubject(String value) {
		this.inputs.setInput("Subject", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public MusicAndTheArtsResultSet run() {
		JSONObject result = super.runWithResults();
		return new MusicAndTheArtsResultSet(result);
	}
	
}
