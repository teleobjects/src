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
FlatFileOrderReport

Returns a tab-delimited flat file order report. The report shows orders from the previous 60 days.
*/
public class FlatFileOrderReport extends Choreography {

	/**
	Create a new instance of the FlatFileOrderReport Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public FlatFileOrderReport(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/Marketplace/Reports/FlatFileOrderReport"));
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
	Set the value of the EndDate input for this Choreo. 

	@param String - (optional, date) The end of a date range used for selecting the data to report, in ISO8601 date format (i.e. 2012-01-01).
	*/
	public void setEndDate(String value) {
		this.inputs.setInput("EndDate", value);
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
	Set the value of the StartDate input for this Choreo. 

	@param String - (optional, date) The start of a date range used for selecting the data to report, in ISO8601 date format (i.e. 2012-01-01).
	*/
	public void setStartDate(String value) {
		this.inputs.setInput("StartDate", value);
	}


	/** 
	Set the value of the TimeToWait input for this Choreo. 

	@param Integer - (optional, integer) By default, the Choreo will wait for 5 minutes to see if the report is ready for retrieval. Max is 120 minutes.
	*/
	public void setTimeToWait(Integer value) {
		this.inputs.setInput("TimeToWait", value);
	}

	/** 
	Set the value of the TimeToWait input for this Choreo as a String. 

	@param String - (optional, integer) By default, the Choreo will wait for 5 minutes to see if the report is ready for retrieval. Max is 120 minutes.
	*/
	public void setTimeToWait(String value) {
		this.inputs.setInput("TimeToWait", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public FlatFileOrderReportResultSet run() {
		JSONObject result = super.runWithResults();
		return new FlatFileOrderReportResultSet(result);
	}
	
}
