package com.temboo.Library.NPR.StoryFinder;

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
Query

Queries the Story API for stories across all NPR media, including audio, text, images, and web-only content.
*/
public class Query extends Choreography {

	/**
	Create a new instance of the Query Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Query(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/NPR/StoryFinder/Query"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by NPR.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the Date input for this Choreo. 

	@param String - (optional, string) The exact date for which stories will be returned. Format: YYYY-MM-DD The special value current is also allowed. Cannot be used with StartDate or EndDate.
	*/
	public void setDate(String value) {
		this.inputs.setInput("Date", value);
	}


	/** 
	Set the value of the DateType input for this Choreo. 

	@param String - (optional, string) Controls the meaning of StartDate and EndDate. Values can be story or correction.
	*/
	public void setDateType(String value) {
		this.inputs.setInput("DateType", value);
	}


	/** 
	Set the value of the EndDate input for this Choreo. 

	@param String - (optional, string) The end date for which stories will be returned. Format: YYYY-MM-DD Can be used with StartDate to search a range. Cannot be used with Date. The meaning of this parameter can be modified with DateType.
	*/
	public void setEndDate(String value) {
		this.inputs.setInput("EndDate", value);
	}


	/** 
	Set the value of the Fields input for this Choreo. 

	@param String - (optional, string) Comma-delimited list of fields to be returned in the output for the results. List of fields can be made up of selectable fields or compilation fields. Defaults to all available fields.
	*/
	public void setFields(String value) {
		this.inputs.setInput("Fields", value);
	}


	/** 
	Set the value of the ID input for this Choreo. 

	@param String - (optional, string) Comma-delimited list of ID numbers corresponding to topics, music genres, programs, blogs, bios, music artists, and series.
	*/
	public void setID(String value) {
		this.inputs.setInput("ID", value);
	}


	/** 
	Set the value of the IDBoolean input for this Choreo. 

	@param String - (optional, string) Describes how IDs are searched. Allowed values: and, or, union.
	*/
	public void setIDBoolean(String value) {
		this.inputs.setInput("IDBoolean", value);
	}


	/** 
	Set the value of the NumResults input for this Choreo. 

	@param Integer - (optional, integer) The number of stories to be returned up to 20 maximum.
	*/
	public void setNumResults(Integer value) {
		this.inputs.setInput("NumResults", value);
	}

	/** 
	Set the value of the NumResults input for this Choreo as a String. 

	@param String - (optional, integer) The number of stories to be returned up to 20 maximum.
	*/
	public void setNumResults(String value) {
		this.inputs.setInput("NumResults", value);	
	}
	/** 
	Set the value of the OrgID input for this Choreo. 

	@param String - (optional, string) Comma-delimited list of ID numbers of local stations.
	*/
	public void setOrgID(String value) {
		this.inputs.setInput("OrgID", value);
	}


	/** 
	Set the value of the RequiredAssets input for this Choreo. 

	@param String - (optional, string) Comma-delimited list that limits the resulting set to contain only stories with a particular type of asset. Allowed values: audio, image, text, and correction.
	*/
	public void setRequiredAssets(String value) {
		this.inputs.setInput("RequiredAssets", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are xml (the default), and json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the SearchTerm input for this Choreo. 

	@param String - (optional, string) Term to search in NPR's search engine. Can be used with SearchType to specify which fields should be searched.
	*/
	public void setSearchTerm(String value) {
		this.inputs.setInput("SearchTerm", value);
	}


	/** 
	Set the value of the SearchType input for this Choreo. 

	@param String - (optional, string) Used with SearchTerm to specify which fields should be searched. Default searches all fields. Allowed values: main and full.
	*/
	public void setSearchType(String value) {
		this.inputs.setInput("SearchType", value);
	}


	/** 
	Set the value of the Sort input for this Choreo. 

	@param String - (optional, string) Determines the order in which the stories will be returned. Default is date descending. Other allowed values: date ascending, editor assigned, and featured.
	*/
	public void setSort(String value) {
		this.inputs.setInput("Sort", value);
	}


	/** 
	Set the value of the StartDate input for this Choreo. 

	@param String - (optional, string) The start date for which stories will be returned. Format: YYYY-MM-DD Can be used with EndDate to search a range. Cannot be used with Date. The meaning of this parameter can be modified with DateType.
	*/
	public void setStartDate(String value) {
		this.inputs.setInput("StartDate", value);
	}


	/** 
	Set the value of the StartNum input for this Choreo. 

	@param Integer - (optional, integer) Determines where in the result set to start returning stories.
	*/
	public void setStartNum(Integer value) {
		this.inputs.setInput("StartNum", value);
	}

	/** 
	Set the value of the StartNum input for this Choreo as a String. 

	@param String - (optional, integer) Determines where in the result set to start returning stories.
	*/
	public void setStartNum(String value) {
		this.inputs.setInput("StartNum", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public QueryResultSet run() {
		JSONObject result = super.runWithResults();
		return new QueryResultSet(result);
	}
	
}
