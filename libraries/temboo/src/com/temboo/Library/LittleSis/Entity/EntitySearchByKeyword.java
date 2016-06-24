package com.temboo.Library.LittleSis.Entity;

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
EntitySearchByKeyword

Retrieves Entities (people or organizations) in LittleSis that match a given keyword search.
*/
public class EntitySearchByKeyword extends Choreography {

	/**
	Create a new instance of the EntitySearchByKeyword Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public EntitySearchByKeyword(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/LittleSis/Entity/EntitySearchByKeyword"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key obtained from LittleSis.org.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the Keywords input for this Choreo. 

	@param String - (required, string) Enter search text.
	*/
	public void setKeywords(String value) {
		this.inputs.setInput("Keywords", value);
	}


	/** 
	Set the value of the Number input for this Choreo. 

	@param Integer - (optional, integer) Specifies what number of results to show. Used in conjunction with Page parameter, a Number of 20 and a Page of 6 will show results 100-120.
	*/
	public void setNumber(Integer value) {
		this.inputs.setInput("Number", value);
	}

	/** 
	Set the value of the Number input for this Choreo as a String. 

	@param String - (optional, integer) Specifies what number of results to show. Used in conjunction with Page parameter, a Number of 20 and a Page of 6 will show results 100-120.
	*/
	public void setNumber(String value) {
		this.inputs.setInput("Number", value);	
	}
	/** 
	Set the value of the Page input for this Choreo. 

	@param Integer - (optional, integer) Specifies what page of results to show. Used in conjunction with Number parameter. A number of 20 and a Page of 6 will show results 100-120.
	*/
	public void setPage(Integer value) {
		this.inputs.setInput("Page", value);
	}

	/** 
	Set the value of the Page input for this Choreo as a String. 

	@param String - (optional, integer) Specifies what page of results to show. Used in conjunction with Number parameter. A number of 20 and a Page of 6 will show results 100-120.
	*/
	public void setPage(String value) {
		this.inputs.setInput("Page", value);	
	}
	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) Format of the response returned by LittleSis.org. Acceptable inputs: xml or json. Defaults to xml
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the SearchAll input for this Choreo. 

	@param Integer - (optional, integer) Enter 1 to search a record's description and summary fields. When not specified, only the name and aliases fields of each record will be searched.
	*/
	public void setSearchAll(Integer value) {
		this.inputs.setInput("SearchAll", value);
	}

	/** 
	Set the value of the SearchAll input for this Choreo as a String. 

	@param String - (optional, integer) Enter 1 to search a record's description and summary fields. When not specified, only the name and aliases fields of each record will be searched.
	*/
	public void setSearchAll(String value) {
		this.inputs.setInput("SearchAll", value);	
	}
	/** 
	Set the value of the TypeIDs input for this Choreo. 

	@param String - (optional, string) You can specify a TypeIDs value to limit the search results to only those of a given type. Obtain all possible types and type ID's by first running the GetTypes Choreo.
	*/
	public void setTypeIDs(String value) {
		this.inputs.setInput("TypeIDs", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public EntitySearchByKeywordResultSet run() {
		JSONObject result = super.runWithResults();
		return new EntitySearchByKeywordResultSet(result);
	}
	
}
