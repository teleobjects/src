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
Bill

Retrieves bills and resolutions in the U.S. Congress since 1973 (the 93rd Congress).
*/
public class Bill extends Choreography {

	/**
	Create a new instance of the Bill Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Bill(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/GovTrack/Bill"));
	}

	/** 
	Set the value of the BillID input for this Choreo. 

	@param Integer - (optional, integer) The ID number of the bill to retrieve. When using this input, all other filter parameters are ignored, and a single record is returned.
	*/
	public void setBillID(Integer value) {
		this.inputs.setInput("BillID", value);
	}

	/** 
	Set the value of the BillID input for this Choreo as a String. 

	@param String - (optional, integer) The ID number of the bill to retrieve. When using this input, all other filter parameters are ignored, and a single record is returned.
	*/
	public void setBillID(String value) {
		this.inputs.setInput("BillID", value);	
	}
	/** 
	Set the value of the BillType input for this Choreo. 

	@param String - (optional, string) The bill's type (e.g. house_resolution, senate_bill, house_bill, etc). Filter operators allowed. Sortable.
	*/
	public void setBillType(String value) {
		this.inputs.setInput("BillType", value);
	}


	/** 
	Set the value of the CoSponsors input for this Choreo. 

	@param String - (optional, string) The bill's cosponsors. When using this filter, provide the id of the cosponsor which is returned when requesting a single bill object. Filter operators allowed. Sortable.
	*/
	public void setCoSponsors(String value) {
		this.inputs.setInput("CoSponsors", value);
	}


	/** 
	Set the value of the Committees input for this Choreo. 

	@param String - (optional, string) Committees to which the bill has been referred. When using this filter, provide the id of the committee which is returned when requesting a single bill object. Filter operators allowed. Sortable.
	*/
	public void setCommittees(String value) {
		this.inputs.setInput("Committees", value);
	}


	/** 
	Set the value of the Congress input for this Choreo. 

	@param String - (optional, string) The number of the congress in which the bill was introduced. The current congress is 113. Filter operators allowed. Sortable.
	*/
	public void setCongress(String value) {
		this.inputs.setInput("Congress", value);
	}


	/** 
	Set the value of the CurrentStatus input for this Choreo. 

	@param String - (optional, string) The current status of the bill (e.g. passed_bill, prov_kill_veto, introduced, etc). Filter operators allowed. Sortable.
	*/
	public void setCurrentStatus(String value) {
		this.inputs.setInput("CurrentStatus", value);
	}


	/** 
	Set the value of the CurrentStatusDate input for this Choreo. 

	@param String - (optional, string) The date of the last major action on the bill corresponding to the CurrentStatus (in YYYY-MM-DD format). Filter operators allowed. Sortable.
	*/
	public void setCurrentStatusDate(String value) {
		this.inputs.setInput("CurrentStatusDate", value);
	}


	/** 
	Set the value of the Fields input for this Choreo. 

	@param String - (optional, string) A comma separated list of fields to return in the response. Use double-underscores to span relationships (e.g. person__firstname).
	*/
	public void setFields(String value) {
		this.inputs.setInput("Fields", value);
	}


	/** 
	Set the value of the IntroducedDate input for this Choreo. 

	@param String - (optional, string) The date the bill was introduced (in YYYY-MM-DD format). Filter operators allowed. Sortable.
	*/
	public void setIntroducedDate(String value) {
		this.inputs.setInput("IntroducedDate", value);
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
	Set the value of the Number input for this Choreo. 

	@param String - (optional, string) The bill's number. This is different from the BillID. Filter operators allowed. Sortable.
	*/
	public void setNumber(String value) {
		this.inputs.setInput("Number", value);
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

	@param String - (optional, string) You can order the results using fieldname (ascending) or -fieldname (descending) where "fieldname" is one of the variables that is listed as 'Sortable' in the description. Ex: '-congress'
	*/
	public void setSort(String value) {
		this.inputs.setInput("Sort", value);
	}


	/** 
	Set the value of the Sponsor input for this Choreo. 

	@param String - (optional, string) The ID of the sponsor of the bill. Filter operators allowed. Sortable.
	*/
	public void setSponsor(String value) {
		this.inputs.setInput("Sponsor", value);
	}


	/** 
	Set the value of the Terms input for this Choreo. 

	@param String - (optional, string) Subject areas associated with the bill. When using this filter, provide the id of the term which is returned when requesting a single bill object. Filter operators allowed. Sortable.
	*/
	public void setTerms(String value) {
		this.inputs.setInput("Terms", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public BillResultSet run() {
		JSONObject result = super.runWithResults();
		return new BillResultSet(result);
	}
	
}
