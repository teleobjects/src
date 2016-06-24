package com.temboo.Library.Flickr.Photos;

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
SearchPhotos

Returns a list of photos matching a search criteria.
*/
public class SearchPhotos extends Choreography {

	/**
	Create a new instance of the SearchPhotos Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public SearchPhotos(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Flickr/Photos/SearchPhotos"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by Flickr (AKA the OAuth Consumer Key).
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the Accuracy input for this Choreo. 

	@param Integer - (optional, integer) The accuracy level of the location information. Current range is 1-16. World level is 1, Country is ~3, Region is ~6, City is ~11, Street is ~16.
	*/
	public void setAccuracy(Integer value) {
		this.inputs.setInput("Accuracy", value);
	}

	/** 
	Set the value of the Accuracy input for this Choreo as a String. 

	@param String - (optional, integer) The accuracy level of the location information. Current range is 1-16. World level is 1, Country is ~3, Region is ~6, City is ~11, Street is ~16.
	*/
	public void setAccuracy(String value) {
		this.inputs.setInput("Accuracy", value);	
	}
	/** 
	Set the value of the BoundingBox input for this Choreo. 

	@param String - (optional, string) A comma-delimited list of 4 values defining the Bounding Box of the area that will be searched. These values represent the coordinates of the bottom-left corner and top-right corner of the box.
	*/
	public void setBoundingBox(String value) {
		this.inputs.setInput("BoundingBox", value);
	}


	/** 
	Set the value of the ContentType input for this Choreo. 

	@param Integer - (optional, integer) The content type setting. 1 = photos only, 2 = screenshots only, 3 = other, 4 = photos and screenshots, 5 = screenshots and other, 6 = photos and other, 7 = all.
	*/
	public void setContentType(Integer value) {
		this.inputs.setInput("ContentType", value);
	}

	/** 
	Set the value of the ContentType input for this Choreo as a String. 

	@param String - (optional, integer) The content type setting. 1 = photos only, 2 = screenshots only, 3 = other, 4 = photos and screenshots, 5 = screenshots and other, 6 = photos and other, 7 = all.
	*/
	public void setContentType(String value) {
		this.inputs.setInput("ContentType", value);	
	}
	/** 
	Set the value of the Extras input for this Choreo. 

	@param String - (optional, string) A comma-delimited list of extra information to fetch for each returned record. See documentation for more details on supported fields.
	*/
	public void setExtras(String value) {
		this.inputs.setInput("Extras", value);
	}


	/** 
	Set the value of the GeoContext input for this Choreo. 

	@param Integer - (optional, integer) A numeric value representing the photo's location info beyond latitude and longitude. 0 = not defined, 1 = indoors, 2 = outdoors.
	*/
	public void setGeoContext(Integer value) {
		this.inputs.setInput("GeoContext", value);
	}

	/** 
	Set the value of the GeoContext input for this Choreo as a String. 

	@param String - (optional, integer) A numeric value representing the photo's location info beyond latitude and longitude. 0 = not defined, 1 = indoors, 2 = outdoors.
	*/
	public void setGeoContext(String value) {
		this.inputs.setInput("GeoContext", value);	
	}
	/** 
	Set the value of the GroupID input for this Choreo. 

	@param String - (optional, string) The id of a group who's pool to search. If specified, only matching photos posted to the group's pool will be returned.
	*/
	public void setGroupID(String value) {
		this.inputs.setInput("GroupID", value);
	}


	/** 
	Set the value of the InGallery input for this Choreo. 

	@param Boolean - (optional, boolean) Limits the search to only photos that are in a gallery. Default is false.
	*/
	public void setInGallery(Boolean value) {
		this.inputs.setInput("InGallery", value);
	}

	/** 
	Set the value of the InGallery input for this Choreo as a String. 

	@param String - (optional, boolean) Limits the search to only photos that are in a gallery. Default is false.
	*/
	public void setInGallery(String value) {
		this.inputs.setInput("InGallery", value);	
	}
	/** 
	Set the value of the Latitude input for this Choreo. 

	@param BigDecimal - (conditional, decimal) A valid latitude, in decimal format, for performing geo queries (not required if providing another limiting search parameter).
	*/
	public void setLatitude(BigDecimal value) {
		this.inputs.setInput("Latitude", value);
	}

	/** 
	Set the value of the Latitude input for this Choreo as a String. 

	@param String - (conditional, decimal) A valid latitude, in decimal format, for performing geo queries (not required if providing another limiting search parameter).
	*/
	public void setLatitude(String value) {
		this.inputs.setInput("Latitude", value);	
	}
	/** 
	Set the value of the Longitude input for this Choreo. 

	@param BigDecimal - (conditional, decimal) A valid longitude, in decimal format, for performing geo queries (not required if providing another limiting search parameter).
	*/
	public void setLongitude(BigDecimal value) {
		this.inputs.setInput("Longitude", value);
	}

	/** 
	Set the value of the Longitude input for this Choreo as a String. 

	@param String - (conditional, decimal) A valid longitude, in decimal format, for performing geo queries (not required if providing another limiting search parameter).
	*/
	public void setLongitude(String value) {
		this.inputs.setInput("Longitude", value);	
	}
	/** 
	Set the value of the MaxTakenDate input for this Choreo. 

	@param String - (optional, date) The maximum taken date. Photos with an taken date less than or equal to this value will be returned. The date can be in the form of a mysql datetime or unix timestamp.
	*/
	public void setMaxTakenDate(String value) {
		this.inputs.setInput("MaxTakenDate", value);
	}


	/** 
	Set the value of the MaxUploadDate input for this Choreo. 

	@param String - (optional, date) The maximum upload date. Photos with an upload date less than or equal to this value will be returned. The date can be in the form of a unix timestamp or mysql datetime.
	*/
	public void setMaxUploadDate(String value) {
		this.inputs.setInput("MaxUploadDate", value);
	}


	/** 
	Set the value of the Media input for this Choreo. 

	@param String - (optional, string) Filter results by media type. Valid values are all (default), photos or videos.
	*/
	public void setMedia(String value) {
		this.inputs.setInput("Media", value);
	}


	/** 
	Set the value of the MinTakenDate input for this Choreo. 

	@param String - (optional, date) The minimum taken date. Photos with a taken date greater than or equal to this value will be returned. The date can be in the form of a mysql datetime or unix timestamp.
	*/
	public void setMinTakenDate(String value) {
		this.inputs.setInput("MinTakenDate", value);
	}


	/** 
	Set the value of the MinUploadDate input for this Choreo. 

	@param String - (optional, date) The minimum upload date. Photos with an upload date greater than or equal to this value will be returned. The date can be in the form of a unix timestamp or mysql datetime.
	*/
	public void setMinUploadDate(String value) {
		this.inputs.setInput("MinUploadDate", value);
	}


	/** 
	Set the value of the Page input for this Choreo. 

	@param Integer - (optional, integer) The page of results to return. Defaults to 1.
	*/
	public void setPage(Integer value) {
		this.inputs.setInput("Page", value);
	}

	/** 
	Set the value of the Page input for this Choreo as a String. 

	@param String - (optional, integer) The page of results to return. Defaults to 1.
	*/
	public void setPage(String value) {
		this.inputs.setInput("Page", value);	
	}
	/** 
	Set the value of the PerPage input for this Choreo. 

	@param Integer - (optional, integer) The number of photos to return per page. Defaults to 100.
	*/
	public void setPerPage(Integer value) {
		this.inputs.setInput("PerPage", value);
	}

	/** 
	Set the value of the PerPage input for this Choreo as a String. 

	@param String - (optional, integer) The number of photos to return per page. Defaults to 100.
	*/
	public void setPerPage(String value) {
		this.inputs.setInput("PerPage", value);	
	}
	/** 
	Set the value of the PlaceID input for this Choreo. 

	@param String - (optional, string) A Flickr place id.
	*/
	public void setPlaceID(String value) {
		this.inputs.setInput("PlaceID", value);
	}


	/** 
	Set the value of the Radius input for this Choreo. 

	@param Integer - (optional, integer) A valid radius used for geo queries, greater than zero and less than 20 miles (or 32 kilometers). Defaults to 5 (km).
	*/
	public void setRadius(Integer value) {
		this.inputs.setInput("Radius", value);
	}

	/** 
	Set the value of the Radius input for this Choreo as a String. 

	@param String - (optional, integer) A valid radius used for geo queries, greater than zero and less than 20 miles (or 32 kilometers). Defaults to 5 (km).
	*/
	public void setRadius(String value) {
		this.inputs.setInput("Radius", value);	
	}
	/** 
	Set the value of the RadiusUnits input for this Choreo. 

	@param String - (optional, string) The unit of measure when doing radial geo queries. Valid values are: "mi" (miles) and "km" (kilometers). The default is "km".
	*/
	public void setRadiusUnits(String value) {
		this.inputs.setInput("RadiusUnits", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are: xml and json. Defaults to json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the Sort input for this Choreo. 

	@param String - (optional, string) Defaults to date-posted-desc unless performing a geo query. Valid values are: date-posted-asc, date-posted-desc, date-taken-asc, date-taken-desc, interestingness-desc, interestingness-asc, relevance.
	*/
	public void setSort(String value) {
		this.inputs.setInput("Sort", value);
	}


	/** 
	Set the value of the TagMode input for this Choreo. 

	@param String - (optional, string) Use the mode 'any' to search using an OR combination of tags. Use 'all' for an AND combnation. Defaults to 'any'.
	*/
	public void setTagMode(String value) {
		this.inputs.setInput("TagMode", value);
	}


	/** 
	Set the value of the Tags input for this Choreo. 

	@param String - (optional, string) A comma-delimited list of tags. Photos with one or more of the tags listed will be returned. You can exclude results that match a term by prepending it with a hyphen.
	*/
	public void setTags(String value) {
		this.inputs.setInput("Tags", value);
	}


	/** 
	Set the value of the Text input for this Choreo. 

	@param String - (conditional, string) A keyword search against photo titles, descriptions, or tags. Prepend search term with a hyphen to exclude. Not required if providing another limiting search parameter.
	*/
	public void setText(String value) {
		this.inputs.setInput("Text", value);
	}


	/** 
	Set the value of the UserID input for this Choreo. 

	@param String - (optional, string) The ID of the user who's photo to search. If this parameter isn't passed, all public photos will be searched. A value of "me" will search against the authenticated user's photos.
	*/
	public void setUserID(String value) {
		this.inputs.setInput("UserID", value);
	}


	/** 
	Set the value of the WOEID input for this Choreo. 

	@param String - (optional, string) The unique 'Where on Earth ID' that uniquely represents spatial entities.
	*/
	public void setWOEID(String value) {
		this.inputs.setInput("WOEID", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public SearchPhotosResultSet run() {
		JSONObject result = super.runWithResults();
		return new SearchPhotosResultSet(result);
	}
	
}
