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
CreateDevice

Creates a new device in a product batch for each serial number provided. When created, each device will be in a pre-registered state awaiting activation. Creating a non-product-affiliated device is not available through the Xively API, and can only be done through the browser-only Xively Developer Workbench.
*/
public class CreateDevice extends Choreography {

	/**
	Create a new instance of the CreateDevice Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CreateDevice(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Xively/Devices/CreateDevice"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by Xively.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the ProductID input for this Choreo. 

	@param String - (required, string) The product ID for the device you would like to add.
	*/
	public void setProductID(String value) {
		this.inputs.setInput("ProductID", value);
	}


	/** 
	Set the value of the SerialNumbers input for this Choreo. 

	@param String - (required, string) Comma-separated list of device serial numbers to add. Allowed characters: case-sensitive alphanumeric characters (Ab3) and the following characters: "+", "-", "_", and ":". Ex: abc:123,aBc-124.
	*/
	public void setSerialNumbers(String value) {
		this.inputs.setInput("SerialNumbers", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CreateDeviceResultSet run() {
		JSONObject result = super.runWithResults();
		return new CreateDeviceResultSet(result);
	}
	
}
