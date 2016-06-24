package com.temboo.Library.Twitter.Search;

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
import com.temboo.core.Choreography.ResultSet;

	
/**
	A ResultSet with methods tailored to the values returned by the LatestTweet Choreo.
	The ResultSet object is used to retrieve the results of a Choreo execution.
*/
public  class LatestTweetResultSet extends ResultSet {
		
	public LatestTweetResultSet(JSONObject doc) {
		super(doc);
	}

	/** 
	Retrieve the value for the "ID" output from this Choreo execution

	@return String - (string) The Tweet ID.
	*/
	public String getID() {
		return this.getResultString("ID");
	}
	/** 
	Retrieve the value for the "Limit" output from this Choreo execution

	@return String - (integer) The rate limit ceiling for this particular request.
	*/
	public String getLimit() {
		return this.getResultString("Limit");
	}
	/** 
	Retrieve the value for the "Remaining" output from this Choreo execution

	@return String - (integer) The number of requests left for the 15 minute window.
	*/
	public String getRemaining() {
		return this.getResultString("Remaining");
	}
	/** 
	Retrieve the value for the "Reset" output from this Choreo execution

	@return String - (date) The remaining window before the rate limit resets in UTC epoch seconds.
	*/
	public String getReset() {
		return this.getResultString("Reset");
	}
	/** 
	Retrieve the value for the "ScreenName" output from this Choreo execution

	@return String - (string) The screen name of the user who posted this Tweet.
	*/
	public String getScreenName() {
		return this.getResultString("ScreenName");
	}
	/** 
	Retrieve the value for the "Text" output from this Choreo execution

	@return String - (string) The Tweet text.
	*/
	public String getText() {
		return this.getResultString("Text");
	}
	/** 
	Retrieve the value for the "Response" output from this Choreo execution

	@return String - (json) The response from Twitter.
	*/
	public String getResponse() {
		return this.getResultString("Response");
	}
}