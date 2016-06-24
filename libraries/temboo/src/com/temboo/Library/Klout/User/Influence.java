package com.temboo.Library.Klout.User;

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
Influence

Retrieves a user's influencers and influencees.
*/
public class Influence extends Choreography {

	/**
	Create a new instance of the Influence Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Influence(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Klout/User/Influence"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by Klout.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the KloutID input for this Choreo. 

	@param String - (required, string) The id for a Klout user to retrieve influencers and influencees for.
	*/
	public void setKloutID(String value) {
		this.inputs.setInput("KloutID", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public InfluenceResultSet run() {
		JSONObject result = super.runWithResults();
		return new InfluenceResultSet(result);
	}
	
}
