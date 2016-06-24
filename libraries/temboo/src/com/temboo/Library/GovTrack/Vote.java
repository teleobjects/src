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
Vote

Returns roll call votes in the U.S. Congress since 1789.
*/
public class Vote extends Choreography {

	/**
	Create a new instance of the Vote Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Vote(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/GovTrack/Vote"));
	}

	/** 
	Set the value of the Chamber input for this Choreo. 

	@param String - (optional, string) The chamber in which the vote was held. Valid values are: house or senate. Filter operators allowed but only when filtering by Congress as well. Sortable.
	*/
	public void setChamber(String value) {
		this.inputs.setInput("Chamber", value);
	}


	/** 
	Set the value of the Congress input for this Choreo. 

	@param String - (optional, string) The number of the congress in which the vote took place. The current congress is 113. Filter operators allowed. Sortable.
	*/
	public void setCongress(String value) {
		this.inputs.setInput("Congress", value);
	}


	/** 
	Set the value of the Created input for this Choreo. 

	@param String - (optional, string) The date (and in recent history also the time) on which the vote was held. Filter operators allowed. Sortable.
	*/
	public void setCreated(String value) {
		this.inputs.setInput("Created", value);
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
	Set the value of the Number input for this Choreo. 

	@param String - (optional, string) The number of the vote, unique to a Congress and session pair. Filter operators allowed. Sortable.
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
	Set the value of the RelatedAmendment input for this Choreo. 

	@param String - (optional, string) The ID of a related amendment. Filter operators allowed. Sortable.
	*/
	public void setRelatedAmendment(String value) {
		this.inputs.setInput("RelatedAmendment", value);
	}


	/** 
	Set the value of the RelatedBill input for this Choreo. 

	@param String - (optional, string) A bill related to this vote. Filter operators allowed. Sortable.
	*/
	public void setRelatedBill(String value) {
		this.inputs.setInput("RelatedBill", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are: json (the default) and xml.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the Session input for this Choreo. 

	@param String - (optional, string) The session of congress. Filter operators allowed. Sortable.
	*/
	public void setSession(String value) {
		this.inputs.setInput("Session", value);
	}


	/** 
	Set the value of the Sort input for this Choreo. 

	@param String - (optional, string) You can order the results using created (ascending) or -created (descending) for the dates that each vote was held.
	*/
	public void setSort(String value) {
		this.inputs.setInput("Sort", value);
	}


	/** 
	Set the value of the VoteID input for this Choreo. 

	@param Integer - (optional, integer) The ID of a vote object to retrieve. When using this input, all other filter parameters are ignored, and a single record is returned.
	*/
	public void setVoteID(Integer value) {
		this.inputs.setInput("VoteID", value);
	}

	/** 
	Set the value of the VoteID input for this Choreo as a String. 

	@param String - (optional, integer) The ID of a vote object to retrieve. When using this input, all other filter parameters are ignored, and a single record is returned.
	*/
	public void setVoteID(String value) {
		this.inputs.setInput("VoteID", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public VoteResultSet run() {
		JSONObject result = super.runWithResults();
		return new VoteResultSet(result);
	}
	
}
