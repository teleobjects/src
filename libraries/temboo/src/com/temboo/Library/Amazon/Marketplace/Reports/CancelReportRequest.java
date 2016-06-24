package com.temboo.Library.Amazon.Marketplace.Reports;

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
CancelReportRequest

Cancels one or more report requests.
*/
public class CancelReportRequest extends Choreography {

	/**
	Create a new instance of the CancelReportRequest Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CancelReportRequest(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/Marketplace/Reports/CancelReportRequest"));
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
	Set the value of the MWSAuthToken input for this Choreo. 

	@param String - (optional, string) The Amazon MWS authorization token for the given seller and developer.
	*/
	public void setMWSAuthToken(String value) {
		this.inputs.setInput("MWSAuthToken", value);
	}


	/** 
	Set the value of the ReportProcessingStatus input for this Choreo. 

	@param String - (optional, string) A report processing status by which to filter report requests. Valid values are: _SUBMITTED_, _IN_PROGRESS_, _CANCELLED_, _DONE_, _DONE_NO_DATA_.
	*/
	public void setReportProcessingStatus(String value) {
		this.inputs.setInput("ReportProcessingStatus", value);
	}


	/** 
	Set the value of the ReportRequestId input for this Choreo. 

	@param String - (optional, string) A ReportRequestId value. If you pass in a ReportRequestId value, other query conditions are ignored.
	*/
	public void setReportRequestId(String value) {
		this.inputs.setInput("ReportRequestId", value);
	}


	/** 
	Set the value of the ReportType input for this Choreo. 

	@param String - (optional, string) A ReportType enumeration value (i.e. GET_ORDERS_DATA_).
	*/
	public void setReportType(String value) {
		this.inputs.setInput("ReportType", value);
	}


	/** 
	Set the value of the RequestedFromDate input for this Choreo. 

	@param String - (optional, date) The start of the date range used for selecting the data to report, in ISO8601 date format (i.e. 2012-01-01).
	*/
	public void setRequestedFromDate(String value) {
		this.inputs.setInput("RequestedFromDate", value);
	}


	/** 
	Set the value of the RequestedToDate input for this Choreo. 

	@param String - (optional, date) The end of the date range used for selecting the data to report, in ISO8601 date format (i.e. 2012-01-01).
	*/
	public void setRequestedToDate(String value) {
		this.inputs.setInput("RequestedToDate", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are "xml" (the default) and "json".
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CancelReportRequestResultSet run() {
		JSONObject result = super.runWithResults();
		return new CancelReportRequestResultSet(result);
	}
	
}
