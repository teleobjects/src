package com.temboo.Library.CorpWatch.Company;

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
GetCompanyHistory

Returns a complete set of basic records for a given company, covering all the years for which information is available.
*/
public class GetCompanyHistory extends Choreography {

	/**
	Create a new instance of the GetCompanyHistory Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetCompanyHistory(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/CorpWatch/Company/GetCompanyHistory"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (optional, string) The APIKey from CorpWatch if you have one.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the CWID input for this Choreo. 

	@param String - (required, string) CoprWatch ID for the company. Format looks like: cw_8484.
	*/
	public void setCWID(String value) {
		this.inputs.setInput("CWID", value);
	}


	/** 
	Set the value of the ResponseType input for this Choreo. 

	@param String - (optional, string) Specify json or xml for the type of response to be returned. Defaults to xml.
	*/
	public void setResponseType(String value) {
		this.inputs.setInput("ResponseType", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetCompanyHistoryResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetCompanyHistoryResultSet(result);
	}
	
}
