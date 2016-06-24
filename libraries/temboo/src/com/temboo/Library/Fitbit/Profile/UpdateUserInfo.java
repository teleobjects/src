package com.temboo.Library.Fitbit.Profile;

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
UpdateUserInfo

Updates a user's profile data.
*/
public class UpdateUserInfo extends Choreography {

	/**
	Create a new instance of the UpdateUserInfo Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public UpdateUserInfo(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Fitbit/Profile/UpdateUserInfo"));
	}

	/** 
	Set the value of the AboutMe input for this Choreo. 

	@param String - (optional, string) The user's About Me string.
	*/
	public void setAboutMe(String value) {
		this.inputs.setInput("AboutMe", value);
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
	Set the value of the Birthday input for this Choreo. 

	@param String - (optional, date) Date of Birth; in the format yyyy-MM-dd.
	*/
	public void setBirthday(String value) {
		this.inputs.setInput("Birthday", value);
	}


	/** 
	Set the value of the City input for this Choreo. 

	@param String - (optional, string) The user's city information.
	*/
	public void setCity(String value) {
		this.inputs.setInput("City", value);
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
	Set the value of the Country input for this Choreo. 

	@param String - (optional, string) The two-character code for the user's country.
	*/
	public void setCountry(String value) {
		this.inputs.setInput("Country", value);
	}


	/** 
	Set the value of the FoodLocale input for this Choreo. 

	@param String - (optional, string) Food Database Locale; in the format "xx_XX".
	*/
	public void setFoodLocale(String value) {
		this.inputs.setInput("FoodLocale", value);
	}


	/** 
	Set the value of the FullName input for this Choreo. 

	@param String - (optional, string) The user's full name.
	*/
	public void setFullName(String value) {
		this.inputs.setInput("FullName", value);
	}


	/** 
	Set the value of the Gender input for this Choreo. 

	@param String - (optional, string) The user's gender (MALE/FEMALE/NA).
	*/
	public void setGender(String value) {
		this.inputs.setInput("Gender", value);
	}


	/** 
	Set the value of the GlucoseUnit input for this Choreo. 

	@param BigDecimal - (optional, decimal) The blood glucose unit of measurement being used. Valid values are: en_US, any,  METRIC.
	*/
	public void setGlucoseUnit(BigDecimal value) {
		this.inputs.setInput("GlucoseUnit", value);
	}

	/** 
	Set the value of the GlucoseUnit input for this Choreo as a String. 

	@param String - (optional, decimal) The blood glucose unit of measurement being used. Valid values are: en_US, any,  METRIC.
	*/
	public void setGlucoseUnit(String value) {
		this.inputs.setInput("GlucoseUnit", value);	
	}
	/** 
	Set the value of the Height input for this Choreo. 

	@param BigDecimal - (optional, decimal) The user's height; in the format X.XX (inches).
	*/
	public void setHeight(BigDecimal value) {
		this.inputs.setInput("Height", value);
	}

	/** 
	Set the value of the Height input for this Choreo as a String. 

	@param String - (optional, decimal) The user's height; in the format X.XX (inches).
	*/
	public void setHeight(String value) {
		this.inputs.setInput("Height", value);	
	}
	/** 
	Set the value of the HeightUnit input for this Choreo. 

	@param BigDecimal - (optional, decimal) The height unit being used. Valid values are: en_US, any,  METRIC.
	*/
	public void setHeightUnit(BigDecimal value) {
		this.inputs.setInput("HeightUnit", value);
	}

	/** 
	Set the value of the HeightUnit input for this Choreo as a String. 

	@param String - (optional, decimal) The height unit being used. Valid values are: en_US, any,  METRIC.
	*/
	public void setHeightUnit(String value) {
		this.inputs.setInput("HeightUnit", value);	
	}
	/** 
	Set the value of the Locale input for this Choreo. 

	@param String - (optional, string) Locale of website (country/language); one of the locales, currently – (en_US, fr_FR, de_DE, es_ES, en_GB, en_AU, en_NZ, ja_JP).
	*/
	public void setLocale(String value) {
		this.inputs.setInput("Locale", value);
	}


	/** 
	Set the value of the Nickname input for this Choreo. 

	@param String - (optional, string) The user's nickname.
	*/
	public void setNickname(String value) {
		this.inputs.setInput("Nickname", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that you want the response to be in: xml or json. Defaults to json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the State input for this Choreo. 

	@param String - (optional, string) The two-character state abbreviation for the user.
	*/
	public void setState(String value) {
		this.inputs.setInput("State", value);
	}


	/** 
	Set the value of the StrideLengthRunning input for this Choreo. 

	@param BigDecimal - (optional, decimal) Running stride length; in the format X.XX.
	*/
	public void setStrideLengthRunning(BigDecimal value) {
		this.inputs.setInput("StrideLengthRunning", value);
	}

	/** 
	Set the value of the StrideLengthRunning input for this Choreo as a String. 

	@param String - (optional, decimal) Running stride length; in the format X.XX.
	*/
	public void setStrideLengthRunning(String value) {
		this.inputs.setInput("StrideLengthRunning", value);	
	}
	/** 
	Set the value of the StrideLengthWalking input for this Choreo. 

	@param BigDecimal - (optional, decimal) Walking stride length; in the format X.XX.
	*/
	public void setStrideLengthWalking(BigDecimal value) {
		this.inputs.setInput("StrideLengthWalking", value);
	}

	/** 
	Set the value of the StrideLengthWalking input for this Choreo as a String. 

	@param String - (optional, decimal) Walking stride length; in the format X.XX.
	*/
	public void setStrideLengthWalking(String value) {
		this.inputs.setInput("StrideLengthWalking", value);	
	}
	/** 
	Set the value of the Timezone input for this Choreo. 

	@param String - (optional, string) The user's timezone; in the format "America/Los_Angeles"
	*/
	public void setTimezone(String value) {
		this.inputs.setInput("Timezone", value);
	}


	/** 
	Set the value of the UserID input for this Choreo. 

	@param String - (optional, string) The user's encoded id. Defaults to "-" (dash) which will return data for the user associated with the token credentials provided.
	*/
	public void setUserID(String value) {
		this.inputs.setInput("UserID", value);
	}


	/** 
	Set the value of the WaterUnit input for this Choreo. 

	@param BigDecimal - (optional, decimal) The water unit being used. Valid values are: en_US, any,  METRIC.
	*/
	public void setWaterUnit(BigDecimal value) {
		this.inputs.setInput("WaterUnit", value);
	}

	/** 
	Set the value of the WaterUnit input for this Choreo as a String. 

	@param String - (optional, decimal) The water unit being used. Valid values are: en_US, any,  METRIC.
	*/
	public void setWaterUnit(String value) {
		this.inputs.setInput("WaterUnit", value);	
	}
	/** 
	Set the value of the WeightUnit input for this Choreo. 

	@param String - (optional, string) The weight unit being used. Valid values are: en_US, any,  METRIC.
	*/
	public void setWeightUnit(String value) {
		this.inputs.setInput("WeightUnit", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public UpdateUserInfoResultSet run() {
		JSONObject result = super.runWithResults();
		return new UpdateUserInfoResultSet(result);
	}
	
}
