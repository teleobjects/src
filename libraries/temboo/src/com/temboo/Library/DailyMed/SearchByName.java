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
SearchByName

Returns a list of drugs in the DailyMed database associated with a given drug name.
*/
public class SearchByName extends Choreography {

	/**
	Create a new instance of the SearchByName Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public SearchByName(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/DailyMed/SearchByName"));
	}

	/** 
	Set the value of the DrugName input for this Choreo. 

	@param String - (required, string) The name of the drug you want to find.
	*/
	public void setDrugName(String value) {
		this.inputs.setInput("DrugName", value);
	}


	/** 
	Set the value of the LabelType input for this Choreo. 

	@param String - (optional, string) Filter results by a specified type. Acceptable values: rxonly, otc, human, human/rxonly, human/otc, animal. See documentation for more information.
	*/
	public void setLabelType(String value) {
		this.inputs.setInput("LabelType", value);
	}


	/** 
	Set the value of the OutputFormat input for this Choreo. 

	@param String - (optional, string) Defaults to XML format when nothing is specified. Acceptable values: xml or json.
	*/
	public void setOutputFormat(String value) {
		this.inputs.setInput("OutputFormat", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public SearchByNameResultSet run() {
		JSONObject result = super.runWithResults();
		return new SearchByNameResultSet(result);
	}
	
}
