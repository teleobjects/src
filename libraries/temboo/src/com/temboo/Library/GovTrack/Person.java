package com.temboo.Library.GovTrack;

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
Person

Returns members of Congress and U.S. Presidents since the founding of the nation.
*/
public class Person extends Choreography {

	/**
	Create a new instance of the Person Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Person(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/GovTrack/Person"));
	}

	/** 
	Set the value of the Fields input for this Choreo. 

	@param String - (optional, string) A comma separated list of fields to return in the response. Use double-underscores to span relationships (e.g. person__firstname).
	*/
	public void setFields(String value) {
		this.inputs.setInput("Fields", value);
	}


	/** 
	Set the value of the Gender input for this Choreo. 

	@param String - (optional, string) The person's gender (male or female). For historical data, gender is sometimes not specified. Filter operators allowed. Sortable.
	*/
	public void setGender(String value) {
		this.inputs.setInput("Gender", value);
	}


	/** 
	Set the value of the LastName input for this Choreo. 

	@param String - (optional, string) The representative's last name. Filter operators allowed. Sortable.
	*/
	public void setLastName(String value) {
		this.inputs.setInput("LastName", value);
	}


	/** 
	Set the value of the Limit input for this Choreo. 

	@param Integer - (optional, integer) Results are paged 100 per call by default. Set the limit input to a high value to get all of the results at once.
	*/
	public void setLimit(Integer value) {
		this.inputs.setInput("Limit", value);
	}

	/** 
	Set the value of the Limit input for this Choreo as a String. 

	@param String - (optional, integer) Results are paged 100 per call by default. Set the limit input to a high value to get all of the results at once.
	*/
	public void setLimit(String value) {
		this.inputs.setInput("Limit", value);	
	}
	/** 
	Set the value of the Offset input for this Choreo. 

	@param Integer - (optional, integer) Offset the results by the number given, useful for paging through results.
	*/
	public void setOffset(Integer value) {
		this.inputs.setInput("Offset", value);
	}

	/** 
	Set the value of the Offset input for this Choreo as a String. 

	@param String - (optional, integer) Offset the results by the number given, useful for paging through results.
	*/
	public void setOffset(String value) {
		this.inputs.setInput("Offset", value);	
	}
	/** 
	Set the value of the PersonID input for this Choreo. 

	@param Integer - (optional, integer) The ID number for a person to retrieve. When using this input, all other filter parameters are ignored, and a single record is returned.
	*/
	public void setPersonID(Integer value) {
		this.inputs.setInput("PersonID", value);
	}

	/** 
	Set the value of the PersonID input for this Choreo as a String. 

	@param String - (optional, integer) The ID number for a person to retrieve. When using this input, all other filter parameters are ignored, and a single record is returned.
	*/
	public void setPersonID(String value) {
		this.inputs.setInput("PersonID", value);	
	}
	/** 
	Set the value of the Query input for this Choreo. 

	@param String - (conditional, string) Filters according to a full-text search on the object.
	*/
	public void setQuery(String value) {
		this.inputs.setInput("Query", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are: json (the default) and xml.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the Sort input for this Choreo. 

	@param String - (optional, string) You can order the results using fieldname (ascending) or -fieldname (descending) where "fieldname" is one of the variables that is listed as 'Sortable' in the description. Ex: '-lastname'
	*/
	public void setSort(String value) {
		this.inputs.setInput("Sort", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public PersonResultSet run() {
		JSONObject result = super.runWithResults();
		return new PersonResultSet(result);
	}
	
}
