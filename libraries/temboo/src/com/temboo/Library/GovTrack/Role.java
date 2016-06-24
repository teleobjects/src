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
Role

Returns terms held in office by Members of Congress and U.S. Presidents.
*/
public class Role extends Choreography {

	/**
	Create a new instance of the Role Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Role(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/GovTrack/Role"));
	}

	/** 
	Set the value of the Current input for this Choreo. 

	@param String - (optional, string) Whether the role is currently held, or it is archival information. Filter operators allowed. Sortable.
	*/
	public void setCurrent(String value) {
		this.inputs.setInput("Current", value);
	}


	/** 
	Set the value of the District input for this Choreo. 

	@param String - (optional, string) For representatives, the number of their congressional district. 0 for at-large districts, -1 in historical data if the district is not known. Filter operators allowed. Sortable.
	*/
	public void setDistrict(String value) {
		this.inputs.setInput("District", value);
	}


	/** 
	Set the value of the EndDate input for this Choreo. 

	@param String - (optional, string) The date the role ended - when the person resigned, died, etc. (in YYYY-MM-DD format). Filter operators allowed. Sortable.
	*/
	public void setEndDate(String value) {
		this.inputs.setInput("EndDate", value);
	}


	/** 
	Set the value of the Fields input for this Choreo. 

	@param String - (optional, string) A comma separated list of fields to return in the response. Use double-underscores to span relationships (e.g. person__firstname).
	*/
	public void setFields(String value) {
		this.inputs.setInput("Fields", value);
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
	Set the value of the Party input for this Choreo. 

	@param String - (optional, string) The political party of the person. If the person changes party, it is usually the most recent party during this role. Filter operators allowed. Sortable.
	*/
	public void setParty(String value) {
		this.inputs.setInput("Party", value);
	}


	/** 
	Set the value of the Person input for this Choreo. 

	@param String - (optional, string) The person associated with this role. When using this filter, provide the id of the person which is returned when requesting a single role object.
	*/
	public void setPerson(String value) {
		this.inputs.setInput("Person", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are: json (the default) and xml.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the RoleID input for this Choreo. 

	@param String - (optional, string) Specify the ID number of a role object to retrieve the record for only that role. When using this input, all other filter parameters are ignored, and a single record is returned.
	*/
	public void setRoleID(String value) {
		this.inputs.setInput("RoleID", value);
	}


	/** 
	Set the value of the RoleType input for this Choreo. 

	@param String - (optional, string) The type of role (e.g. senator, representative, or president). Filter operators allowed. Sortable.
	*/
	public void setRoleType(String value) {
		this.inputs.setInput("RoleType", value);
	}


	/** 
	Set the value of the SenatorClass input for this Choreo. 

	@param Integer - (optional, integer) For senators, their election class, which determines which years they are up for election. Acceptable values: class1, class2, class3. Filter operators allowed. Sortable.
	*/
	public void setSenatorClass(Integer value) {
		this.inputs.setInput("SenatorClass", value);
	}

	/** 
	Set the value of the SenatorClass input for this Choreo as a String. 

	@param String - (optional, integer) For senators, their election class, which determines which years they are up for election. Acceptable values: class1, class2, class3. Filter operators allowed. Sortable.
	*/
	public void setSenatorClass(String value) {
		this.inputs.setInput("SenatorClass", value);	
	}
	/** 
	Set the value of the Sort input for this Choreo. 

	@param String - (optional, string) You can order the results by date using fieldname (ascending) or -fieldname (descending), where "fieldname" is either startdate or enddate.
	*/
	public void setSort(String value) {
		this.inputs.setInput("Sort", value);
	}


	/** 
	Set the value of the StartDate input for this Choreo. 

	@param String - (optional, string) The date the role began  - when the person took office (in YYYY-MM-DD format). Filter operators allowed. Sortable.
	*/
	public void setStartDate(String value) {
		this.inputs.setInput("StartDate", value);
	}


	/** 
	Set the value of the State input for this Choreo. 

	@param String - (optional, string) For senators and representatives, the two-letter USPS abbreviation for the state or territory they are serving. Filter operators allowed. Sortable.
	*/
	public void setState(String value) {
		this.inputs.setInput("State", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public RoleResultSet run() {
		JSONObject result = super.runWithResults();
		return new RoleResultSet(result);
	}
	
}
