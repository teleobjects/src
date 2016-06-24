package com.temboo.Library.EnviroFacts.Toxins;

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
ChemicalSearch

Retrieves information about specific chemicals released by EPA-regulated facilities.
*/
public class ChemicalSearch extends Choreography {

	/**
	Create a new instance of the ChemicalSearch Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ChemicalSearch(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/EnviroFacts/Toxins/ChemicalSearch"));
	}

	/** 
	Set the value of the ChemicalID input for this Choreo. 

	@param String - (required, string) EPA ID number of a chemical. Chemical IDs from a given facility can be found by first running the ChemActivityByFacility or ToxinReleaseByFacility Choreos.
	*/
	public void setChemicalID(String value) {
		this.inputs.setInput("ChemicalID", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ChemicalSearchResultSet run() {
		JSONObject result = super.runWithResults();
		return new ChemicalSearchResultSet(result);
	}
	
}
