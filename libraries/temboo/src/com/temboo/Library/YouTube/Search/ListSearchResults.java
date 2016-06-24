package com.temboo.Library.YouTube.Search;

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
ListSearchResults

Returns a list of search results that match the specified query parameters.
*/
public class ListSearchResults extends Choreography {

	/**
	Create a new instance of the ListSearchResults Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ListSearchResults(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/YouTube/Search/ListSearchResults"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (optional, string) The API Key provided by Google for simple API access when you do not need to access user data.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (optional, string) A valid access token retrieved during the OAuth process. This is required for OAuth authentication unless you provide the ClientID, ClientSecret, and RefreshToken to generate a new access token.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the ChannelID input for this Choreo. 

	@param String - (optional, string) Indicates that the response should only contain resources created by this channel.
	*/
	public void setChannelID(String value) {
		this.inputs.setInput("ChannelID", value);
	}


	/** 
	Set the value of the ChannelType input for this Choreo. 

	@param String - (optional, string) Restricts a search to a particular type of channel. Valid values are: "any" (returns all channels) and "show" (only retrieves shows).
	*/
	public void setChannelType(String value) {
		this.inputs.setInput("ChannelType", value);
	}


	/** 
	Set the value of the ClientID input for this Choreo. 

	@param String - (optional, string) The Client ID provided by Google. Required for OAuth authentication unless providing a valid AccessToken.
	*/
	public void setClientID(String value) {
		this.inputs.setInput("ClientID", value);
	}


	/** 
	Set the value of the ClientSecret input for this Choreo. 

	@param String - (optional, string) The Client Secret provided by Google. Required for OAuth authentication unless providing a valid AccessToken.
	*/
	public void setClientSecret(String value) {
		this.inputs.setInput("ClientSecret", value);
	}


	/** 
	Set the value of the Fields input for this Choreo. 

	@param String - (optional, string) Allows you to specify a subset of fields to include in the response using an xpath-like syntax (i.e. items/snippet/title).
	*/
	public void setFields(String value) {
		this.inputs.setInput("Fields", value);
	}


	/** 
	Set the value of the MaxResults input for this Choreo. 

	@param Integer - (optional, integer) The maximum number of results to return.
	*/
	public void setMaxResults(Integer value) {
		this.inputs.setInput("MaxResults", value);
	}

	/** 
	Set the value of the MaxResults input for this Choreo as a String. 

	@param String - (optional, integer) The maximum number of results to return.
	*/
	public void setMaxResults(String value) {
		this.inputs.setInput("MaxResults", value);	
	}
	/** 
	Set the value of the Order input for this Choreo. 

	@param String - (optional, string) Indicates how the results are sorted. Valid values are: date, rating, relevance, and viewCount.
	*/
	public void setOrder(String value) {
		this.inputs.setInput("Order", value);
	}


	/** 
	Set the value of the PageToken input for this Choreo. 

	@param String - (optional, string) The "nextPageToken" found in the response which is used to page through results.
	*/
	public void setPageToken(String value) {
		this.inputs.setInput("PageToken", value);
	}


	/** 
	Set the value of the Part input for this Choreo. 

	@param String - (optional, string) Specifies a comma-separated list of one or more search resource properties that the API response will include. Part names that you can pass are 'id' and 'snippet' (the default).
	*/
	public void setPart(String value) {
		this.inputs.setInput("Part", value);
	}


	/** 
	Set the value of the PublishedAfter input for this Choreo. 

	@param String - (optional, date) Returns only results created after the specified time (formatted as a RFC 3339 date-time i.e. 1970-01-01T00:00:00Z).
	*/
	public void setPublishedAfter(String value) {
		this.inputs.setInput("PublishedAfter", value);
	}


	/** 
	Set the value of the PublishedBefore input for this Choreo. 

	@param String - (optional, date) Returns only results created before the specified time (formatted as a RFC 3339 date-time i.e. 1970-01-01T00:00:00Z).
	*/
	public void setPublishedBefore(String value) {
		this.inputs.setInput("PublishedBefore", value);
	}


	/** 
	Set the value of the Query input for this Choreo. 

	@param String - (conditional, string) A query string for searching videos.
	*/
	public void setQuery(String value) {
		this.inputs.setInput("Query", value);
	}


	/** 
	Set the value of the RefreshToken input for this Choreo. 

	@param String - (optional, string) An OAuth refresh token used to generate a new access token when the original token is expired. Required for OAuth authentication unless providing a valid AccessToken.
	*/
	public void setRefreshToken(String value) {
		this.inputs.setInput("RefreshToken", value);
	}


	/** 
	Set the value of the RegionCode input for this Choreo. 

	@param String - (optional, string) Returns results for the specified country. The parameter value is an ISO 3166-1 alpha-2 country code.
	*/
	public void setRegionCode(String value) {
		this.inputs.setInput("RegionCode", value);
	}


	/** 
	Set the value of the RelatedToVideoID input for this Choreo. 

	@param String - (optional, string) Retrieves a list of videos that are related to this video id. When using this parameter, the Type parameter must be set to video.
	*/
	public void setRelatedToVideoID(String value) {
		this.inputs.setInput("RelatedToVideoID", value);
	}


	/** 
	Set the value of the TopicID input for this Choreo. 

	@param String - (optional, string) Returns only results associated with the specified topic.
	*/
	public void setTopicID(String value) {
		this.inputs.setInput("TopicID", value);
	}


	/** 
	Set the value of the Type input for this Choreo. 

	@param String - (optional, string) Restricts a search query to only retrieve a particular type of resource. The default value is: video,channel,playlist.
	*/
	public void setType(String value) {
		this.inputs.setInput("Type", value);
	}


	/** 
	Set the value of the VideoCaption input for this Choreo. 

	@param String - (optional, string) Returns filtered results based on whether videos have captions. Valid values are: any (the default), closedCaption (only returns videos with captions), or none (only returns videos without captions).
	*/
	public void setVideoCaption(String value) {
		this.inputs.setInput("VideoCaption", value);
	}


	/** 
	Set the value of the VideoCategoryID input for this Choreo. 

	@param String - (optional, string) Filters video search results based on their category.
	*/
	public void setVideoCategoryID(String value) {
		this.inputs.setInput("VideoCategoryID", value);
	}


	/** 
	Set the value of the VideoDefinition input for this Choreo. 

	@param String - (optional, string) Filters video results based high or standard definition. Valid values are: any, high, or standard.
	*/
	public void setVideoDefinition(String value) {
		this.inputs.setInput("VideoDefinition", value);
	}


	/** 
	Set the value of the VideoDimension input for this Choreo. 

	@param String - (optional, string) Restrict a search to only retrieve 2D or 3D videos. Valid values are: 2d, 3d, or any.
	*/
	public void setVideoDimension(String value) {
		this.inputs.setInput("VideoDimension", value);
	}


	/** 
	Set the value of the VideoDuration input for this Choreo. 

	@param String - (optional, string) Filters search results based on the video duration. Valid values are: any, long, medium, and short.
	*/
	public void setVideoDuration(String value) {
		this.inputs.setInput("VideoDuration", value);
	}


	/** 
	Set the value of the VideoEmbeddable input for this Choreo. 

	@param String - (optional, string) Filters search results to include only videos that can be embedded into a webpage. Valid values are: any (the default) or true (which will enable this filter).
	*/
	public void setVideoEmbeddable(String value) {
		this.inputs.setInput("VideoEmbeddable", value);
	}


	/** 
	Set the value of the VideoLicense input for this Choreo. 

	@param String - (optional, string) Filters search results to only include videos with a particular license. Valid values are: any, creativeCommon, and youtube.
	*/
	public void setVideoLicense(String value) {
		this.inputs.setInput("VideoLicense", value);
	}


	/** 
	Set the value of the VideoSyndicated input for this Choreo. 

	@param String - (optional, string) Filters search results for videos that can be played outside of youtube.com. Valid values are: any (the default) or true (which will enable this filter).
	*/
	public void setVideoSyndicated(String value) {
		this.inputs.setInput("VideoSyndicated", value);
	}


	/** 
	Set the value of the VideoType input for this Choreo. 

	@param String - (optional, string) Filters search results to a particular type of videos. Valid values are: any, episode, and movie.
	*/
	public void setVideoType(String value) {
		this.inputs.setInput("VideoType", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ListSearchResultsResultSet run() {
		JSONObject result = super.runWithResults();
		return new ListSearchResultsResultSet(result);
	}
	
}
