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
import com.temboo.core.Choreography.ResultSet;

	
/**
	A ResultSet with methods tailored to the values returned by the ListInventoryReport Choreo.
	The ResultSet object is used to retrieve the results of a Choreo execution.
*/
public  class ListInventoryReportResultSet extends ResultSet {
		
	public ListInventoryReportResultSet(JSONObject doc) {
		super(doc);
	}

	/** 
	Retrieve the value for the "Report" output from this Choreo execution

	@return String - (multiline) The report contents.
	*/
	public String getReport() {
		return this.getResultString("Report");
	}
	/** 
	Retrieve the value for the "GeneratedReportId" output from this Choreo execution

	@return String - (integer) The GeneratedReportId parsed from the Amazon response.
	*/
	public String getGeneratedReportId() {
		return this.getResultString("GeneratedReportId");
	}
	/** 
	Retrieve the value for the "ReportProcessingStatus" output from this Choreo execution

	@return String - (string) The status of the report request parsed from the Amazon response.
	*/
	public String getReportProcessingStatus() {
		return this.getResultString("ReportProcessingStatus");
	}
	/** 
	Retrieve the value for the "ReportRequestId" output from this Choreo execution

	@return String - (integer) The ReportRequestId parsed from the Amazon response. This id is used in GetReportRequestList.
	*/
	public String getReportRequestId() {
		return this.getResultString("ReportRequestId");
	}
}