package com.temboo.Library.Genability.TariffData;

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
GetTimeOfUseGroupIntervals

Returns all the Intervals for a Time of Use Group within a given date range.
*/
public class GetTimeOfUseGroupIntervals extends Choreography {

	/**
	Create a new instance of the GetTimeOfUseGroupIntervals Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetTimeOfUseGroupIntervals(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Genability/TariffData/GetTimeOfUseGroupIntervals"));
	}

	/** 
	Set the value of the AppID input for this Choreo. 

	@param String - (required, string) The App ID provided by Genability.
	*/
	public void setAppID(String value) {
		this.inputs.setInput("AppID", value);
	}


	/** 
	Set the value of the AppKey input for this Choreo. 

	@param String - (required, string) The App Key provided by Genability.
	*/
	public void setAppKey(String value) {
		this.inputs.setInput("AppKey", value);
	}


	/** 
	Set the value of the FromDateTime input for this Choreo. 

	@param String - (optional, date) The starting date and time of the requested Intervals (in ISO 8601 format). Defaults to current date if not specified.
	*/
	public void setFromDateTime(String value) {
		this.inputs.setInput("FromDateTime", value);
	}


	/** 
	Set the value of the LSEID input for this Choreo. 

	@param Integer - (required, integer) Used to retrieve a TOU Group for a specific LSE.
	*/
	public void setLSEID(Integer value) {
		this.inputs.setInput("LSEID", value);
	}

	/** 
	Set the value of the LSEID input for this Choreo as a String. 

	@param String - (required, integer) Used to retrieve a TOU Group for a specific LSE.
	*/
	public void setLSEID(String value) {
		this.inputs.setInput("LSEID", value);	
	}
	/** 
	Set the value of the PageCount input for this Choreo. 

	@param Integer - (optional, integer) The number of results to return. Defaults to 25.
	*/
	public void setPageCount(Integer value) {
		this.inputs.setInput("PageCount", value);
	}

	/** 
	Set the value of the PageCount input for this Choreo as a String. 

	@param String - (optional, integer) The number of results to return. Defaults to 25.
	*/
	public void setPageCount(String value) {
		this.inputs.setInput("PageCount", value);	
	}
	/** 
	Set the value of the PageStart input for this Choreo. 

	@param Integer - (optional, integer) The page number to begin the result set from. Defaults to 1.
	*/
	public void setPageStart(Integer value) {
		this.inputs.setInput("PageStart", value);
	}

	/** 
	Set the value of the PageStart input for this Choreo as a String. 

	@param String - (optional, integer) The page number to begin the result set from. Defaults to 1.
	*/
	public void setPageStart(String value) {
		this.inputs.setInput("PageStart", value);	
	}
	/** 
	Set the value of the TOUGroupID input for this Choreo. 

	@param Integer - (required, integer) Used to retrieve a TOU Group by its ID.
	*/
	public void setTOUGroupID(Integer value) {
		this.inputs.setInput("TOUGroupID", value);
	}

	/** 
	Set the value of the TOUGroupID input for this Choreo as a String. 

	@param String - (required, integer) Used to retrieve a TOU Group by its ID.
	*/
	public void setTOUGroupID(String value) {
		this.inputs.setInput("TOUGroupID", value);	
	}
	/** 
	Set the value of the ToDateTime input for this Choreo. 

	@param String - (optional, date) The ending date and time of the requested Intervals (in ISO 8601 format). If not specified, defaults to one week ahead of the current date.
	*/
	public void setToDateTime(String value) {
		this.inputs.setInput("ToDateTime", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetTimeOfUseGroupIntervalsResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetTimeOfUseGroupIntervalsResultSet(result);
	}
	
}
