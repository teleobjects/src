package com.temboo.Library.Facebook.Actions.Video.Rates;

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
UpdateRating

Updates an existing video rating action.
*/
public class UpdateRating extends Choreography {

	/**
	Create a new instance of the UpdateRating Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public UpdateRating(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Facebook/Actions/Video/Rates/UpdateRating"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The access token retrieved from the final step of the OAuth process.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the ActionID input for this Choreo. 

	@param String - (required, string) The id of the action to update.
	*/
	public void setActionID(String value) {
		this.inputs.setInput("ActionID", value);
	}


	/** 
	Set the value of the EndTime input for this Choreo. 

	@param String - (optional, date) The time that the user ended the action (e.g. 2013-06-24T18:53:35+0000).
	*/
	public void setEndTime(String value) {
		this.inputs.setInput("EndTime", value);
	}


	/** 
	Set the value of the Episode input for this Choreo. 

	@param String - (optional, string) The URL or ID for an Open Graph object representing an episode.
	*/
	public void setEpisode(String value) {
		this.inputs.setInput("Episode", value);
	}


	/** 
	Set the value of the ExpiresIn input for this Choreo. 

	@param Integer - (optional, integer) The amount of time (in milliseconds) from the publish_time that the action will expire.
	*/
	public void setExpiresIn(Integer value) {
		this.inputs.setInput("ExpiresIn", value);
	}

	/** 
	Set the value of the ExpiresIn input for this Choreo as a String. 

	@param String - (optional, integer) The amount of time (in milliseconds) from the publish_time that the action will expire.
	*/
	public void setExpiresIn(String value) {
		this.inputs.setInput("ExpiresIn", value);	
	}
	/** 
	Set the value of the Message input for this Choreo. 

	@param String - (optional, string) A message attached to this action. Setting this parameter requires enabling of message capabilities.
	*/
	public void setMessage(String value) {
		this.inputs.setInput("Message", value);
	}


	/** 
	Set the value of the Movie input for this Choreo. 

	@param String - (optional, string) The URL or ID for an Open Graph object representing a movie.
	*/
	public void setMovie(String value) {
		this.inputs.setInput("Movie", value);
	}


	/** 
	Set the value of the Other input for this Choreo. 

	@param String - (optional, string) The URL or ID for an Open Graph object representing any general video content.
	*/
	public void setOther(String value) {
		this.inputs.setInput("Other", value);
	}


	/** 
	Set the value of the Place input for this Choreo. 

	@param String - (optional, string) The URL or ID for an Open Graph object representing the location associated with this action.
	*/
	public void setPlace(String value) {
		this.inputs.setInput("Place", value);
	}


	/** 
	Set the value of the RatingNormalizedValue input for this Choreo. 

	@param BigDecimal - (optional, decimal) The rating expressed as a decimal value between 0 and 1.0.
	*/
	public void setRatingNormalizedValue(BigDecimal value) {
		this.inputs.setInput("RatingNormalizedValue", value);
	}

	/** 
	Set the value of the RatingNormalizedValue input for this Choreo as a String. 

	@param String - (optional, decimal) The rating expressed as a decimal value between 0 and 1.0.
	*/
	public void setRatingNormalizedValue(String value) {
		this.inputs.setInput("RatingNormalizedValue", value);	
	}
	/** 
	Set the value of the RatingScale input for this Choreo. 

	@param Integer - (optional, integer) The highest possible value in the rating scale.
	*/
	public void setRatingScale(Integer value) {
		this.inputs.setInput("RatingScale", value);
	}

	/** 
	Set the value of the RatingScale input for this Choreo as a String. 

	@param String - (optional, integer) The highest possible value in the rating scale.
	*/
	public void setRatingScale(String value) {
		this.inputs.setInput("RatingScale", value);	
	}
	/** 
	Set the value of the RatingValue input for this Choreo. 

	@param BigDecimal - (optional, decimal) The value of the book rating.
	*/
	public void setRatingValue(BigDecimal value) {
		this.inputs.setInput("RatingValue", value);
	}

	/** 
	Set the value of the RatingValue input for this Choreo as a String. 

	@param String - (optional, decimal) The value of the book rating.
	*/
	public void setRatingValue(String value) {
		this.inputs.setInput("RatingValue", value);	
	}
	/** 
	Set the value of the Review input for this Choreo. 

	@param String - (optional, string) The URL or ID for an Open Graph object representing a book review.
	*/
	public void setReview(String value) {
		this.inputs.setInput("Review", value);
	}


	/** 
	Set the value of the ReviewText input for this Choreo. 

	@param String - (optional, string) The text content of the book review.
	*/
	public void setReviewText(String value) {
		this.inputs.setInput("ReviewText", value);
	}


	/** 
	Set the value of the TVShow input for this Choreo. 

	@param String - (optional, string) The URL or ID for an Open Graph object representing a TV show.
	*/
	public void setTVShow(String value) {
		this.inputs.setInput("TVShow", value);
	}


	/** 
	Set the value of the Tags input for this Choreo. 

	@param String - (optional, string) A comma separated list of other profile IDs that also performed this action.
	*/
	public void setTags(String value) {
		this.inputs.setInput("Tags", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public UpdateRatingResultSet run() {
		JSONObject result = super.runWithResults();
		return new UpdateRatingResultSet(result);
	}
	
}
