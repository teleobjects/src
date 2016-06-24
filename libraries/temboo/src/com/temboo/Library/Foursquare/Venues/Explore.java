package com.temboo.Library.Foursquare.Venues;

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
Explore

Returns a list of recommended venues near the current location.
*/
public class Explore extends Choreography {

	/**
	Create a new instance of the Explore Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Explore(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Foursquare/Venues/Explore"));
	}

	/** 
	Set the value of the AccuracyOfCoordinates input for this Choreo. 

	@param Integer - (optional, integer) Accuracy of latitude and longitude, in meters.
	*/
	public void setAccuracyOfCoordinates(Integer value) {
		this.inputs.setInput("AccuracyOfCoordinates", value);
	}

	/** 
	Set the value of the AccuracyOfCoordinates input for this Choreo as a String. 

	@param String - (optional, integer) Accuracy of latitude and longitude, in meters.
	*/
	public void setAccuracyOfCoordinates(String value) {
		this.inputs.setInput("AccuracyOfCoordinates", value);	
	}
	/** 
	Set the value of the Altitude input for this Choreo. 

	@param Integer - (optional, integer) Altitude of the user's location, in meters.
	*/
	public void setAltitude(Integer value) {
		this.inputs.setInput("Altitude", value);
	}

	/** 
	Set the value of the Altitude input for this Choreo as a String. 

	@param String - (optional, integer) Altitude of the user's location, in meters.
	*/
	public void setAltitude(String value) {
		this.inputs.setInput("Altitude", value);	
	}
	/** 
	Set the value of the AltitudeAccuracy input for this Choreo. 

	@param Integer - (optional, integer) Accuracy of the user's altitude, in meters.
	*/
	public void setAltitudeAccuracy(Integer value) {
		this.inputs.setInput("AltitudeAccuracy", value);
	}

	/** 
	Set the value of the AltitudeAccuracy input for this Choreo as a String. 

	@param String - (optional, integer) Accuracy of the user's altitude, in meters.
	*/
	public void setAltitudeAccuracy(String value) {
		this.inputs.setInput("AltitudeAccuracy", value);	
	}
	/** 
	Set the value of the ClientID input for this Choreo. 

	@param String - (conditional, string) Your Foursquare client ID, obtained after registering at Foursquare. Required unless using the OauthToken input.
	*/
	public void setClientID(String value) {
		this.inputs.setInput("ClientID", value);
	}


	/** 
	Set the value of the ClientSecret input for this Choreo. 

	@param String - (conditional, string) Your Foursquare client secret, obtained after registering at Foursquare. Required unless using the OauthToken input.
	*/
	public void setClientSecret(String value) {
		this.inputs.setInput("ClientSecret", value);
	}


	/** 
	Set the value of the Day input for this Choreo. 

	@param String - (optional, string) When set to "any", results for any day of the week are returned. Results that are targeted to the current day of the week are returned by default.
	*/
	public void setDay(String value) {
		this.inputs.setInput("Day", value);
	}


	/** 
	Set the value of the FriendsVisits input for this Choreo. 

	@param String - (optional, string) Limits results to places the acting user's friends have or haven't been. Valid values are: "visited" or "notvisited". 
	*/
	public void setFriendsVisits(String value) {
		this.inputs.setInput("FriendsVisits", value);
	}


	/** 
	Set the value of the Intent input for this Choreo. 

	@param String - (optional, string) Used in combination with the LastVenue input.  Return venues users often visit after a given venue when setting to "nextVenues" and providing a venue ID for the LastVenue input.
	*/
	public void setIntent(String value) {
		this.inputs.setInput("Intent", value);
	}


	/** 
	Set the value of the LastVenue input for this Choreo. 

	@param String - (optional, string) A venue ID to use when Intent = "nextVenues", which returns venues users often visit after a given venue. See Choreo notes for more details about the use of this input.
	*/
	public void setLastVenue(String value) {
		this.inputs.setInput("LastVenue", value);
	}


	/** 
	Set the value of the Latitude input for this Choreo. 

	@param BigDecimal - (conditional, decimal) The latitude point of the user's location. Required unless the Near parameter is provided.
	*/
	public void setLatitude(BigDecimal value) {
		this.inputs.setInput("Latitude", value);
	}

	/** 
	Set the value of the Latitude input for this Choreo as a String. 

	@param String - (conditional, decimal) The latitude point of the user's location. Required unless the Near parameter is provided.
	*/
	public void setLatitude(String value) {
		this.inputs.setInput("Latitude", value);	
	}
	/** 
	Set the value of the Limit input for this Choreo. 

	@param Integer - (optional, integer) Number of results to return, up to 50.
	*/
	public void setLimit(Integer value) {
		this.inputs.setInput("Limit", value);
	}

	/** 
	Set the value of the Limit input for this Choreo as a String. 

	@param String - (optional, integer) Number of results to return, up to 50.
	*/
	public void setLimit(String value) {
		this.inputs.setInput("Limit", value);	
	}
	/** 
	Set the value of the Longitude input for this Choreo. 

	@param BigDecimal - (conditional, decimal) The longitude point of the user's location. Required unless the Near parameter is provided.
	*/
	public void setLongitude(BigDecimal value) {
		this.inputs.setInput("Longitude", value);
	}

	/** 
	Set the value of the Longitude input for this Choreo as a String. 

	@param String - (conditional, decimal) The longitude point of the user's location. Required unless the Near parameter is provided.
	*/
	public void setLongitude(String value) {
		this.inputs.setInput("Longitude", value);	
	}
	/** 
	Set the value of the Near input for this Choreo. 

	@param String - (conditional, string) A string naming a place in the world. If the near string is not geocodable, returns a failed_geocode error. Required unless provided Latitude and Longitude.
	*/
	public void setNear(String value) {
		this.inputs.setInput("Near", value);
	}


	/** 
	Set the value of the Novelty input for this Choreo. 

	@param String - (optional, string) Pass "new" or "old" to limit results to places the acting user hasn't been or has been, respectively. Omitting this parameter returns a mixture of both new and old.
	*/
	public void setNovelty(String value) {
		this.inputs.setInput("Novelty", value);
	}


	/** 
	Set the value of the OauthToken input for this Choreo. 

	@param String - (conditional, string) The Foursquare API OAuth token string. Required unless specifying the ClientID and ClientSecret.
	*/
	public void setOauthToken(String value) {
		this.inputs.setInput("OauthToken", value);
	}


	/** 
	Set the value of the Offset input for this Choreo. 

	@param Integer - (optional, integer) Used with the Limit input to page through results.
	*/
	public void setOffset(Integer value) {
		this.inputs.setInput("Offset", value);
	}

	/** 
	Set the value of the Offset input for this Choreo as a String. 

	@param String - (optional, integer) Used with the Limit input to page through results.
	*/
	public void setOffset(String value) {
		this.inputs.setInput("Offset", value);	
	}
	/** 
	Set the value of the OpenNow input for this Choreo. 

	@param Boolean - (optional, boolean) Set to 1 to only include venues that are open now. Defaults to 0.
	*/
	public void setOpenNow(Boolean value) {
		this.inputs.setInput("OpenNow", value);
	}

	/** 
	Set the value of the OpenNow input for this Choreo as a String. 

	@param String - (optional, boolean) Set to 1 to only include venues that are open now. Defaults to 0.
	*/
	public void setOpenNow(String value) {
		this.inputs.setInput("OpenNow", value);	
	}
	/** 
	Set the value of the Price input for this Choreo. 

	@param String - (optional, string) A comma separated list of price points. Currently the valid range of price points are: [1,2,3,4]. See Choreo notes for more details about the use of this parameter.
	*/
	public void setPrice(String value) {
		this.inputs.setInput("Price", value);
	}


	/** 
	Set the value of the Query input for this Choreo. 

	@param String - (optional, string) A search term to be applied against tips, category, etc. at a venue.
	*/
	public void setQuery(String value) {
		this.inputs.setInput("Query", value);
	}


	/** 
	Set the value of the Radius input for this Choreo. 

	@param Integer - (optional, integer) Radius to search within, in meters. If radius is not specified, a suggested radius will be used depending on the density of venues in the area.
	*/
	public void setRadius(Integer value) {
		this.inputs.setInput("Radius", value);
	}

	/** 
	Set the value of the Radius input for this Choreo as a String. 

	@param String - (optional, integer) Radius to search within, in meters. If radius is not specified, a suggested radius will be used depending on the density of venues in the area.
	*/
	public void setRadius(String value) {
		this.inputs.setInput("Radius", value);	
	}
	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that response should be in. Can be set to xml or json. Defaults to json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the Saved input for this Choreo. 

	@param Boolean - (optional, boolean) Set to 1 to only include venues that the user has saved on their To-Do list or to another list. Defaults to 0.
	*/
	public void setSaved(Boolean value) {
		this.inputs.setInput("Saved", value);
	}

	/** 
	Set the value of the Saved input for this Choreo as a String. 

	@param String - (optional, boolean) Set to 1 to only include venues that the user has saved on their To-Do list or to another list. Defaults to 0.
	*/
	public void setSaved(String value) {
		this.inputs.setInput("Saved", value);	
	}
	/** 
	Set the value of the Section input for this Choreo. 

	@param String - (optional, string) One of food, drinks, coffee, shops, arts, outdoors, sights, trending, specials, nextVenues , or topPicks. Choosing one of these limits results to venues with categories matching these terms.
	*/
	public void setSection(String value) {
		this.inputs.setInput("Section", value);
	}


	/** 
	Set the value of the SortByDistance input for this Choreo. 

	@param Boolean - (optional, boolean) Set to 1 to sort the results by distance instead of relevance. Default to 0.
	*/
	public void setSortByDistance(Boolean value) {
		this.inputs.setInput("SortByDistance", value);
	}

	/** 
	Set the value of the SortByDistance input for this Choreo as a String. 

	@param String - (optional, boolean) Set to 1 to sort the results by distance instead of relevance. Default to 0.
	*/
	public void setSortByDistance(String value) {
		this.inputs.setInput("SortByDistance", value);	
	}
	/** 
	Set the value of the Specials input for this Choreo. 

	@param Boolean - (optional, boolean) Set to 1 to only include venues that have a special. Defaults to 0.
	*/
	public void setSpecials(Boolean value) {
		this.inputs.setInput("Specials", value);
	}

	/** 
	Set the value of the Specials input for this Choreo as a String. 

	@param String - (optional, boolean) Set to 1 to only include venues that have a special. Defaults to 0.
	*/
	public void setSpecials(String value) {
		this.inputs.setInput("Specials", value);	
	}
	/** 
	Set the value of the Time input for this Choreo. 

	@param String - (optional, string) When set to "any", results for any time of day are returned. Results that are targeted to the current time of day are returned by default.
	*/
	public void setTime(String value) {
		this.inputs.setInput("Time", value);
	}


	/** 
	Set the value of the VenuePhotos input for this Choreo. 

	@param Boolean - (optional, boolean) Set to 1 to include a photo for each venue in response, if one is available. Default is 0 (no photos).
	*/
	public void setVenuePhotos(Boolean value) {
		this.inputs.setInput("VenuePhotos", value);
	}

	/** 
	Set the value of the VenuePhotos input for this Choreo as a String. 

	@param String - (optional, boolean) Set to 1 to include a photo for each venue in response, if one is available. Default is 0 (no photos).
	*/
	public void setVenuePhotos(String value) {
		this.inputs.setInput("VenuePhotos", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ExploreResultSet run() {
		JSONObject result = super.runWithResults();
		return new ExploreResultSet(result);
	}
	
}
