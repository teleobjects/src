package com.temboo.Library.Fitbit.Foods;

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
LogFood

Log a new food entry for a particular date.
*/
public class LogFood extends Choreography {

	/**
	Create a new instance of the LogFood Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public LogFood(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Fitbit/Foods/LogFood"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The Access Token retrieved during the OAuth process.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the AccessTokenSecret input for this Choreo. 

	@param String - (required, string) Deprecated (retained for backward compatibility only).
	*/
	public void setAccessTokenSecret(String value) {
		this.inputs.setInput("AccessTokenSecret", value);
	}


	/** 
	Set the value of the Amount input for this Choreo. 

	@param Integer - (required, integer) The amount of food consumed formatted like X.XX. Note that this input corresponds with the UnitId input.
	*/
	public void setAmount(Integer value) {
		this.inputs.setInput("Amount", value);
	}

	/** 
	Set the value of the Amount input for this Choreo as a String. 

	@param String - (required, integer) The amount of food consumed formatted like X.XX. Note that this input corresponds with the UnitId input.
	*/
	public void setAmount(String value) {
		this.inputs.setInput("Amount", value);	
	}
	/** 
	Set the value of the ConsumerKey input for this Choreo. 

	@param String - (required, string) Deprecated (retained for backward compatibility only).
	*/
	public void setConsumerKey(String value) {
		this.inputs.setInput("ConsumerKey", value);
	}


	/** 
	Set the value of the ConsumerSecret input for this Choreo. 

	@param String - (required, string) Deprecated (retained for backward compatibility only).
	*/
	public void setConsumerSecret(String value) {
		this.inputs.setInput("ConsumerSecret", value);
	}


	/** 
	Set the value of the Date input for this Choreo. 

	@param String - (required, date) The date that corresponds with the new log entry (in the format yyyy-MM-dd).
	*/
	public void setDate(String value) {
		this.inputs.setInput("Date", value);
	}


	/** 
	Set the value of the Favorite input for this Choreo. 

	@param Boolean - (optional, boolean) Set to 1 to add food to favorites after creating log entry. Defaults to 0 for false.
	*/
	public void setFavorite(Boolean value) {
		this.inputs.setInput("Favorite", value);
	}

	/** 
	Set the value of the Favorite input for this Choreo as a String. 

	@param String - (optional, boolean) Set to 1 to add food to favorites after creating log entry. Defaults to 0 for false.
	*/
	public void setFavorite(String value) {
		this.inputs.setInput("Favorite", value);	
	}
	/** 
	Set the value of the FoodID input for this Choreo. 

	@param Integer - (required, integer) The id of the food to create a log entry for.
	*/
	public void setFoodID(Integer value) {
		this.inputs.setInput("FoodID", value);
	}

	/** 
	Set the value of the FoodID input for this Choreo as a String. 

	@param String - (required, integer) The id of the food to create a log entry for.
	*/
	public void setFoodID(String value) {
		this.inputs.setInput("FoodID", value);	
	}
	/** 
	Set the value of the MealType input for this Choreo. 

	@param String - (required, string) The type of meal. Valid values: Breakfast, Morning Snack, Lunch, Afternoon Snack, Dinner, Anytime.
	*/
	public void setMealType(String value) {
		this.inputs.setInput("MealType", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that you want the response to be in: xml or json. Defaults to json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the UnitID input for this Choreo. 

	@param Integer - (required, integer) This id can be retrieved through other calls such as: Get Foods (Recent, Frequent, Favorite), Search Foods or Get Food Units.
	*/
	public void setUnitID(Integer value) {
		this.inputs.setInput("UnitID", value);
	}

	/** 
	Set the value of the UnitID input for this Choreo as a String. 

	@param String - (required, integer) This id can be retrieved through other calls such as: Get Foods (Recent, Frequent, Favorite), Search Foods or Get Food Units.
	*/
	public void setUnitID(String value) {
		this.inputs.setInput("UnitID", value);	
	}
	/** 
	Set the value of the UserID input for this Choreo. 

	@param String - (optional, string) The user's encoded id. Defaults to "-" (dash) which will return data for the user associated with the token credentials provided.
	*/
	public void setUserID(String value) {
		this.inputs.setInput("UserID", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public LogFoodResultSet run() {
		JSONObject result = super.runWithResults();
		return new LogFoodResultSet(result);
	}
	
}
