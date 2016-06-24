package com.temboo.Library.RunKeeper.Nutrition;

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
RetrieveEntry

Retrieves a nutrition entry from a user's feed.
*/
public class RetrieveEntry extends Choreography {

	/**
	Create a new instance of the RetrieveEntry Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public RetrieveEntry(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/RunKeeper/Nutrition/RetrieveEntry"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The Access Token retrieved after the final step in the OAuth process.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the EntryID input for this Choreo. 

	@param String - (required, string) This can be the individual id of the nutrition entry, or you can pass the full uri for the entry as returned from the RetrieveEntries Choreo (i.e. /nutrition/-12985593-1350950400000).
	*/
	public void setEntryID(String value) {
		this.inputs.setInput("EntryID", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public RetrieveEntryResultSet run() {
		JSONObject result = super.runWithResults();
		return new RetrieveEntryResultSet(result);
	}
	
}
