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
GetReportList

Returns a list of reports that were created in the previous 90 days.
*/
public class GetReportList extends Choreography {

	/**
	Create a new instance of the GetReportList Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetReportList(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/Marketplace/Reports/GetReportList"));
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
	Set the value of the Acknowledged input for this Choreo. 

	@param Boolean - (optional, boolean) A Boolean value that indicates if an order report has been acknowledged by a prior call to UpdateReportAcknowledgements. Set to "true" to list order reports that have been acknowledged.
	*/
	public void setAcknowledged(Boolean value) {
		this.inputs.setInput("Acknowledged", value);
	}

	/** 
	Set the value of the Acknowledged input for this Choreo as a String. 

	@param String - (optional, boolean) A Boolean value that indicates if an order report has been acknowledged by a prior call to UpdateReportAcknowledgements. Set to "true" to list order reports that have been acknowledged.
	*/
	public void setAcknowledged(String value) {
		this.inputs.setInput("Acknowledged", value);	
	}
	/** 
	Set the value of the AvailableFromDate input for this Choreo. 

	@param String - (optional, date) The earliest date you are looking for, in ISO8601 date format (i.e. 2012-01-01).
	*/
	public void setAvailableFromDate(String value) {
		this.inputs.setInput("AvailableFromDate", value);
	}


	/** 
	Set the value of the AvailableToDate input for this Choreo. 

	@param String - (optional, date) The most recent date you are looking for, in ISO8601 date format (i.e. 2012-01-01).
	*/
	public void setAvailableToDate(String value) {
		this.inputs.setInput("AvailableToDate", value);
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
	Set the value of the MaxCount input for this Choreo. 

	@param Integer - (optional, integer) A non-negative integer that represents the maximum number of report requests to return. Defaults to 10. Max is 100.
	*/
	public void setMaxCount(Integer value) {
		this.inputs.setInput("MaxCount", value);
	}

	/** 
	Set the value of the MaxCount input for this Choreo as a String. 

	@param String - (optional, integer) A non-negative integer that represents the maximum number of report requests to return. Defaults to 10. Max is 100.
	*/
	public void setMaxCount(String value) {
		this.inputs.setInput("MaxCount", value);	
	}
	/** 
	Set the value of the ReportRequestId input for this Choreo. 

	@param Integer - (optional, integer) A ReportRequestId value. If you pass a ReportRequestId value, other query conditions are ignored.
	*/
	public void setReportRequestId(Integer value) {
		this.inputs.setInput("ReportRequestId", value);
	}

	/** 
	Set the value of the ReportRequestId input for this Choreo as a String. 

	@param String - (optional, integer) A ReportRequestId value. If you pass a ReportRequestId value, other query conditions are ignored.
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
	public GetReportListResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetReportListResultSet(result);
	}
	
}
