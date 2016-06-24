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
VoteAndVoter

Retrieves how people voted on roll call votes in the U.S. Congress since 1789. 
*/
public class VoteAndVoter extends Choreography {

	/**
	Create a new instance of the VoteAndVoter Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public VoteAndVoter(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/GovTrack/VoteAndVoter"));
	}

	/** 
	Set the value of the Created input for this Choreo. 

	@param String - (optional, string) The date (and in recent history also the time) on which the vote was held (in YYYY-MM-DD format). Filter operators allowed. Sortable.
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
	Set the value of the ObjectID input for this Choreo. 

	@param Integer - (optional, integer) The ID of the resource to retrieve. When using this input, all other filter parameters are ignored, and a single record is returned.
	*/
	public void setObjectID(Integer value) {
		this.inputs.setInput("ObjectID", value);
	}

	/** 
	Set the value of the ObjectID input for this Choreo as a String. 

	@param String - (optional, integer) The ID of the resource to retrieve. When using this input, all other filter parameters are ignored, and a single record is returned.
	*/
	public void setObjectID(String value) {
		this.inputs.setInput("ObjectID", value);	
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
	Set the value of the Option input for this Choreo. 

	@param String - (optional, string) The way a particular person voted. The value corresponds to the key of an option returned on the Vote Choreo. Filter operators allowed. Sortable.
	*/
	public void setOption(String value) {
		this.inputs.setInput("Option", value);
	}


	/** 
	Set the value of the Person input for this Choreo. 

	@param String - (optional, string) The person making this vote. This is an ID number. Filter operators allowed. Sortable.
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
	Set the value of the Sort input for this Choreo. 

	@param String - (optional, string) You can order the results by date using fieldname (ascending) or -fieldname (descending), where "fieldname" is either startdate or enddate.
	*/
	public void setSort(String value) {
		this.inputs.setInput("Sort", value);
	}


	/** 
	Set the value of the Vote input for this Choreo. 

	@param String - (optional, string) The ID number of the vote that this was part of. This is in the form of an ID number. Filter operators allowed. Sortable.
	*/
	public void setVote(String value) {
		this.inputs.setInput("Vote", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public VoteAndVoterResultSet run() {
		JSONObject result = super.runWithResults();
		return new VoteAndVoterResultSet(result);
	}
	
}
