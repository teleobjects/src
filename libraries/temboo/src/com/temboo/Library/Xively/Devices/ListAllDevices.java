package com.temboo.Library.Xively.Devices;

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
ListAllDevices

Returns a paged list of devices belonging to a specific product.
*/
public class ListAllDevices extends Choreography {

	/**
	Create a new instance of the ListAllDevices Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ListAllDevices(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Xively/Devices/ListAllDevices"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by Xively.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the Activated input for this Choreo. 

	@param String - (optional, string) Filter for returning device serial numbers in the requested activation state. Valid values: "all" (default), "true" or "false".
	*/
	public void setActivated(String value) {
		this.inputs.setInput("Activated", value);
	}


	/** 
	Set the value of the Page input for this Choreo. 

	@param Integer - (optional, integer) Indicates which page of results you are requesting. Starts from 1.
	*/
	public void setPage(Integer value) {
		this.inputs.setInput("Page", value);
	}

	/** 
	Set the value of the Page input for this Choreo as a String. 

	@param String - (optional, integer) Indicates which page of results you are requesting. Starts from 1.
	*/
	public void setPage(String value) {
		this.inputs.setInput("Page", value);	
	}
	/** 
	Set the value of the PerPage input for this Choreo. 

	@param Integer - (optional, integer) Defines how many results to return per page (1 to 1000, default is 30).
	*/
	public void setPerPage(Integer value) {
		this.inputs.setInput("PerPage", value);
	}

	/** 
	Set the value of the PerPage input for this Choreo as a String. 

	@param String - (optional, integer) Defines how many results to return per page (1 to 1000, default is 30).
	*/
	public void setPerPage(String value) {
		this.inputs.setInput("PerPage", value);	
	}
	/** 
	Set the value of the ProductID input for this Choreo. 

	@param String - (required, string) The ID for the product you would like to retrieve the list of devices for.
	*/
	public void setProductID(String value) {
		this.inputs.setInput("ProductID", value);
	}


	/** 
	Set the value of the SerialNumber input for this Choreo. 

	@param String - (optional, string) Filter by providing an exact or partial serial number string. Letters are case-insensitive. Ex: inputting 'abc' will return serials that contain 'Abc',  'aBc' and 'abc', but not 'ab-c'.
	*/
	public void setSerialNumber(String value) {
		this.inputs.setInput("SerialNumber", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ListAllDevicesResultSet run() {
		JSONObject result = super.runWithResults();
		return new ListAllDevicesResultSet(result);
	}
	
}
