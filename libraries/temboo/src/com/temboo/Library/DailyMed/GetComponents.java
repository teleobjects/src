package com.temboo.Library.DailyMed;

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
GetComponents

Returns imprint data associated with a given National Drug Code (NDC) in the DailyMed database.
*/
public class GetComponents extends Choreography {

	/**
	Create a new instance of the GetComponents Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetComponents(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/DailyMed/GetComponents"));
	}

	/** 
	Set the value of the SetID input for this Choreo. 

	@param String - (required, string) The unique ID assigned by DailyMed to each drug. You can find the SetID of a drug by first running the SearchByName or SearchByNDC Choreos.
	*/
	public void setSetID(String value) {
		this.inputs.setInput("SetID", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetComponentsResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetComponentsResultSet(result);
	}
	
}
