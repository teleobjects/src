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
Columns

Retrieves a list of NPR column titles and corresponding IDs. Also used to look up the IDs of specific NPR columns by specifying the title as an optional parameter.
*/
public class Columns extends Choreography {

	/**
	Create a new instance of the Columns Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Columns(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/NPR/StoryFinder/Columns"));
	}

	/** 
	Set the value of the Column input for this Choreo. 

	@param String - (optional, string) The specific column title to return. Multiple column titles can be specified separated by commas (i.e. Book Reviews,My Guilty Pleasure). Column IDs are returned when this input is used.
	*/
	public void setColumn(String value) {
		this.inputs.setInput("Column", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are xml (the default), and json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the StoryCountAll input for this Choreo. 

	@param Integer - (optional, integer) Returns only items with at least this number of associated stories.
	*/
	public void setStoryCountAll(Integer value) {
		this.inputs.setInput("StoryCountAll", value);
	}

	/** 
	Set the value of the StoryCountAll input for this Choreo as a String. 

	@param String - (optional, integer) Returns only items with at least this number of associated stories.
	*/
	public void setStoryCountAll(String value) {
		this.inputs.setInput("StoryCountAll", value);	
	}
	/** 
	Set the value of the StoryCountMonth input for this Choreo. 

	@param Integer - (optional, integer) Returns only items with at least this number of associated stories published in the last month.
	*/
	public void setStoryCountMonth(Integer value) {
		this.inputs.setInput("StoryCountMonth", value);
	}

	/** 
	Set the value of the StoryCountMonth input for this Choreo as a String. 

	@param String - (optional, integer) Returns only items with at least this number of associated stories published in the last month.
	*/
	public void setStoryCountMonth(String value) {
		this.inputs.setInput("StoryCountMonth", value);	
	}
	/** 
	Set the value of the StoryCountToday input for this Choreo. 

	@param Integer - (optional, integer) Returns only items with at least this number of associated stories published today.
	*/
	public void setStoryCountToday(Integer value) {
		this.inputs.setInput("StoryCountToday", value);
	}

	/** 
	Set the value of the StoryCountToday input for this Choreo as a String. 

	@param String - (optional, integer) Returns only items with at least this number of associated stories published today.
	*/
	public void setStoryCountToday(String value) {
		this.inputs.setInput("StoryCountToday", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ColumnsResultSet run() {
		JSONObject result = super.runWithResults();
		return new ColumnsResultSet(result);
	}
	
}
