package com.temboo.Library.Amazon.Marketplace.Feeds;

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
GetFeedSubmissionList

Returns a list of all feed submissions submitted in the previous 90 days.
*/
public class GetFeedSubmissionList extends Choreography {

	/**
	Create a new instance of the GetFeedSubmissionList Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetFeedSubmissionList(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/Marketplace/Feeds/GetFeedSubmissionList"));
	}

	/** 
	Set the value of the AWSAccessKeyId input for this Choreo. 

	@param String - (required, string) The Access Key ID provided by Amazon Web Services.
	*/
	public void setAWSAccessKeyId(String value) {
		this.inputs.setInput("AWSAccessKeyId", value);
	}


	/** 
	Set the value of the AWSMarketplaceId input for this Choreo. 

	@param String - (required, string) The Marketplace ID provided by Amazon Web Services.
	*/
	public void setAWSMarketplaceId(String value) {
		this.inputs.setInput("AWSMarketplaceId", value);
	}


	/** 
	Set the value of the AWSMerchantId input for this Choreo. 

	@param String - (required, string) The Merchant ID provided by Amazon Web Services.
	*/
	public void setAWSMerchantId(String value) {
		this.inputs.setInput("AWSMerchantId", value);
	}


	/** 
	Set the value of the AWSSecretKeyId input for this Choreo. 

	@param String - (required, string) The Secret Key ID provided by Amazon Web Services.
	*/
	public void setAWSSecretKeyId(String value) {
		this.inputs.setInput("AWSSecretKeyId", value);
	}


	/** 
	Set the value of the Endpoint input for this Choreo. 

	@param String - (conditional, string) The base URL for the MWS endpoint. Defaults to mws.amazonservices.co.uk.
	*/
	public void setEndpoint(String value) {
		this.inputs.setInput("Endpoint", value);
	}


	/** 
	Set the value of the FeedProcessingStatusList input for this Choreo. 

	@param String - (optional, string) A comma separated list of one or more feed processing statuses by which to filter the list of feed submissions.
	*/
	public void setFeedProcessingStatusList(String value) {
		this.inputs.setInput("FeedProcessingStatusList", value);
	}


	/** 
	Set the value of the FeedSubmissionIdList input for this Choreo. 

	@param String - (optional, string) A comma separated list of FeedSubmmissionId values. If you pass in FeedSubmmissionId values in a request, other query conditions are ignored.
	*/
	public void setFeedSubmissionIdList(String value) {
		this.inputs.setInput("FeedSubmissionIdList", value);
	}


	/** 
	Set the value of the FeedTypeList input for this Choreo. 

	@param String - (optional, string) A comma separated list of one or more FeedType enumeration values by which to filter the list of feed submissions.
	*/
	public void setFeedTypeList(String value) {
		this.inputs.setInput("FeedTypeList", value);
	}


	/** 
	Set the value of the MWSAuthToken input for this Choreo. 

	@param String - (optional, string) The Amazon MWS authorization token for the given seller and developer.
	*/
	public void setMWSAuthToken(String value) {
		this.inputs.setInput("MWSAuthToken", value);
	}


	/** 
	Set the value of the MaxCount input for this Choreo. 

	@param Integer - (optional, integer) A non-negative integer that indicates the maximum number of feed submissions to return in the list. Defaults to 10. Max is 100.
	*/
	public void setMaxCount(Integer value) {
		this.inputs.setInput("MaxCount", value);
	}

	/** 
	Set the value of the MaxCount input for this Choreo as a String. 

	@param String - (optional, integer) A non-negative integer that indicates the maximum number of feed submissions to return in the list. Defaults to 10. Max is 100.
	*/
	public void setMaxCount(String value) {
		this.inputs.setInput("MaxCount", value);	
	}
	/** 
	Set the value of the SubmittedFromDate input for this Choreo. 

	@param String - (optional, date) The earliest submission date that you are looking for, in ISO8601 date format (i.e. 2012-01-01).
	*/
	public void setSubmittedFromDate(String value) {
		this.inputs.setInput("SubmittedFromDate", value);
	}


	/** 
	Set the value of the SubmittedToDate input for this Choreo. 

	@param String - (optional, date) The latest submission date that you are looking for, in ISO8601 date format (i.e. 2012-01-01).
	*/
	public void setSubmittedToDate(String value) {
		this.inputs.setInput("SubmittedToDate", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetFeedSubmissionListResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetFeedSubmissionListResultSet(result);
	}
	
}
