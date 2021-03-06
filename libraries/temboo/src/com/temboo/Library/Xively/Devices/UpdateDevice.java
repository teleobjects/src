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
UpdateDevice

Updates a single device's serial number. 
*/
public class UpdateDevice extends Choreography {

	/**
	Create a new instance of the UpdateDevice Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public UpdateDevice(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Xively/Devices/UpdateDevice"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by Xively.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the NewSerialNumber input for this Choreo. 

	@param String - (required, string) The new serial number you want to update the existing device to. Allowed characters: case-sensitive alphanumeric characters (Ab3) and certain characters: "+", "-", "_", and ":". Ex: abc:123,aBc-124.
	*/
	public void setNewSerialNumber(String value) {
		this.inputs.setInput("NewSerialNumber", value);
	}


	/** 
	Set the value of the ProductID input for this Choreo. 

	@param String - (required, string) The product ID for the device you would like to update.
	*/
	public void setProductID(String value) {
		this.inputs.setInput("ProductID", value);
	}


	/** 
	Set the value of the SerialNumber input for this Choreo. 

	@param String - (required, string) The existing serial number for the device you would like to update.
	*/
	public void setSerialNumber(String value) {
		this.inputs.setInput("SerialNumber", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public UpdateDeviceResultSet run() {
		JSONObject result = super.runWithResults();
		return new UpdateDeviceResultSet(result);
	}
	
}
