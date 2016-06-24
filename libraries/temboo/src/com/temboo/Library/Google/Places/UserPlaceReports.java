package com.temboo.Library.Google.Places;

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
UserPlaceReports

Add a new Place to Google Places.
*/
public class UserPlaceReports extends Choreography {

	/**
	Create a new instance of the UserPlaceReports Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public UserPlaceReports(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Google/Places/UserPlaceReports"));
	}

	/** 
	Set the value of the POSTForm input for this Choreo. 

	@param String - (optional, json) A JSON request body containing the information about the place. This can be specified as an alternative to specifying individual place properties. See Choreo notes for details about formatting.
	*/
	public void setPOSTForm(String value) {
		this.inputs.setInput("POSTForm", value);
	}


	/** 
	Set the value of the Accuracy input for this Choreo. 

	@param BigDecimal - (conditional, decimal) The accuracy of the location signal on which this request is based, expressed in meters.
	*/
	public void setAccuracy(BigDecimal value) {
		this.inputs.setInput("Accuracy", value);
	}

	/** 
	Set the value of the Accuracy input for this Choreo as a String. 

	@param String - (conditional, decimal) The accuracy of the location signal on which this request is based, expressed in meters.
	*/
	public void setAccuracy(String value) {
		this.inputs.setInput("Accuracy", value);	
	}
	/** 
	Set the value of the Address input for this Choreo. 

	@param String - (optional, string) The address of the place you wish to add.
	*/
	public void setAddress(String value) {
		this.inputs.setInput("Address", value);
	}


	/** 
	Set the value of the Key input for this Choreo. 

	@param String - (required, string) The API Key provided by Google.
	*/
	public void setKey(String value) {
		this.inputs.setInput("Key", value);
	}


	/** 
	Set the value of the Language input for this Choreo. 

	@param String - (conditional, string) The language in which the place's name is being reported.
	*/
	public void setLanguage(String value) {
		this.inputs.setInput("Language", value);
	}


	/** 
	Set the value of the Latitude input for this Choreo. 

	@param BigDecimal - (required, decimal) The latitude point for the place you wish to add (e.g., 38.898717).
	*/
	public void setLatitude(BigDecimal value) {
		this.inputs.setInput("Latitude", value);
	}

	/** 
	Set the value of the Latitude input for this Choreo as a String. 

	@param String - (required, decimal) The latitude point for the place you wish to add (e.g., 38.898717).
	*/
	public void setLatitude(String value) {
		this.inputs.setInput("Latitude", value);	
	}
	/** 
	Set the value of the Longitude input for this Choreo. 

	@param BigDecimal - (required, decimal) The longitude coordinate for the place you wish to add (e.g., -77.035974).
	*/
	public void setLongitude(BigDecimal value) {
		this.inputs.setInput("Longitude", value);
	}

	/** 
	Set the value of the Longitude input for this Choreo as a String. 

	@param String - (required, decimal) The longitude coordinate for the place you wish to add (e.g., -77.035974).
	*/
	public void setLongitude(String value) {
		this.inputs.setInput("Longitude", value);	
	}
	/** 
	Set the value of the Name input for this Choreo. 

	@param String - (required, string) The full text name of the place
	*/
	public void setName(String value) {
		this.inputs.setInput("Name", value);
	}


	/** 
	Set the value of the PhoneNumber input for this Choreo. 

	@param String - (optional, string) The phone number associated with the place.
	*/
	public void setPhoneNumber(String value) {
		this.inputs.setInput("PhoneNumber", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that response should be in. Can be set to xml or json. Defaults to json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the Sensor input for this Choreo. 

	@param Boolean - (optional, boolean) Indicates whether or not the directions request is from a device with a location sensor. Value must be either 1 or 0. Defaults to 0 (false).
	*/
	public void setSensor(Boolean value) {
		this.inputs.setInput("Sensor", value);
	}

	/** 
	Set the value of the Sensor input for this Choreo as a String. 

	@param String - (optional, boolean) Indicates whether or not the directions request is from a device with a location sensor. Value must be either 1 or 0. Defaults to 0 (false).
	*/
	public void setSensor(String value) {
		this.inputs.setInput("Sensor", value);	
	}
	/** 
	Set the value of the Types input for this Choreo. 

	@param String - (required, json) A JSON array of categories in which this place belongs.
	*/
	public void setTypes(String value) {
		this.inputs.setInput("Types", value);
	}


	/** 
	Set the value of the Website input for this Choreo. 

	@param String - (optional, string) A URL pointing to the authoritative website for this Place, such as a business home page.
	*/
	public void setWebsite(String value) {
		this.inputs.setInput("Website", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public UserPlaceReportsResultSet run() {
		JSONObject result = super.runWithResults();
		return new UserPlaceReportsResultSet(result);
	}
	
}
