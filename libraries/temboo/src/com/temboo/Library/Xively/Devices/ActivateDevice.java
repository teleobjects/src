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
ActivateDevice

Activates (or reactivates) a device given an authorization code. Returns the device API Key and Feed ID. 
*/
public class ActivateDevice extends Choreography {

	/**
	Create a new instance of the ActivateDevice Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ActivateDevice(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Xively/Devices/ActivateDevice"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (optional, string) Not required for first activation. If re-activating a device, either the original device APIKey returned from the first activation or the master APIKey is required.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the ActivationCode input for this Choreo. 

	@param String - (required, string) Activation code provided when pre-registering a device with a serial number.
	*/
	public void setActivationCode(String value) {
		this.inputs.setInput("ActivationCode", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ActivateDeviceResultSet run() {
		JSONObject result = super.runWithResults();
		return new ActivateDeviceResultSet(result);
	}
	
}
