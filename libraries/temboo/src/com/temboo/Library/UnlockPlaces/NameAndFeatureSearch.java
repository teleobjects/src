package com.temboo.Library.UnlockPlaces;

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
NameAndFeatureSearch

Searches for names of places with a specified feature type.
*/
public class NameAndFeatureSearch extends Choreography {

	/**
	Create a new instance of the NameAndFeatureSearch Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public NameAndFeatureSearch(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/UnlockPlaces/NameAndFeatureSearch"));
	}

	/** 
	Set the value of the FeatureType input for this Choreo. 

	@param String - (required, string) The feature type that the place is (i.e. "Cities"). See http://unlock.edina.ac.uk/ws/supportedFeatureTypes?format=txt for a complete list of supported Feature Types.
	*/
	public void setFeatureType(String value) {
		this.inputs.setInput("FeatureType", value);
	}


	/** 
	Set the value of the Format input for this Choreo. 

	@param String - (optional, string) The format of the place search results. One of xml, kml, json, georss or txt. Defaults to "xml".
	*/
	public void setFormat(String value) {
		this.inputs.setInput("Format", value);
	}


	/** 
	Set the value of the Gazetteer input for this Choreo. 

	@param String - (optional, string) The place-name source to take locations from. The options are geonames, os, naturalearth or unlock which combines all the previous. Defaults to "unlock".
	*/
	public void setGazetteer(String value) {
		this.inputs.setInput("Gazetteer", value);
	}


	/** 
	Set the value of the MaxRows input for this Choreo. 

	@param Integer - (optional, integer) The maximum number of results to return. Defaults to 20. Cannot exceed 1000.
	*/
	public void setMaxRows(Integer value) {
		this.inputs.setInput("MaxRows", value);
	}

	/** 
	Set the value of the MaxRows input for this Choreo as a String. 

	@param String - (optional, integer) The maximum number of results to return. Defaults to 20. Cannot exceed 1000.
	*/
	public void setMaxRows(String value) {
		this.inputs.setInput("MaxRows", value);	
	}
	/** 
	Set the value of the Name input for this Choreo. 

	@param String - (required, string) One or more names of places to search for (separated by commas).
	*/
	public void setName(String value) {
		this.inputs.setInput("Name", value);
	}


	/** 
	Set the value of the StartRow input for this Choreo. 

	@param Integer - (optional, integer) The row to start results display from. Defaults to 1.
	*/
	public void setStartRow(Integer value) {
		this.inputs.setInput("StartRow", value);
	}

	/** 
	Set the value of the StartRow input for this Choreo as a String. 

	@param String - (optional, integer) The row to start results display from. Defaults to 1.
	*/
	public void setStartRow(String value) {
		this.inputs.setInput("StartRow", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public NameAndFeatureSearchResultSet run() {
		JSONObject result = super.runWithResults();
		return new NameAndFeatureSearchResultSet(result);
	}
	
}
