package com.temboo.Library.Utilities.DataConversions;

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
RSSToJSON

Retrieves a specified RSS Feed, and converts it to JSON format.
*/
public class RSSToJSON extends Choreography {

	/**
	Create a new instance of the RSSToJSON Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public RSSToJSON(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Utilities/DataConversions/RSSToJSON"));
	}

	/** 
	Set the value of the RSSFeed input for this Choreo. 

	@param String - (required, string) The URL for an RSS feed that you wish to convert to JSON.
	*/
	public void setRSSFeed(String value) {
		this.inputs.setInput("RSSFeed", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public RSSToJSONResultSet run() {
		JSONObject result = super.runWithResults();
		return new RSSToJSONResultSet(result);
	}
	
}
