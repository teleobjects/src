package com.temboo.core;

import processing.data.JSONArray;
import processing.data.JSONObject;

import java.io.StringReader;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.Map.Entry;

/**
 * Choreography is the base class used to execute Choreos on the Temboo platform.
 */
public class Choreography extends TembooResource {

	// The InputSet object used internally to this Choreo instance, to store user-specified
	// input values and arguments
	protected InputSet inputs;
	
	
	public Choreography(TembooSession session, TembooPath uri) {
		super(session, uri);
		this.inputs = new InputSet();
	}

	/**
	 * Specify the Credential object to be used when running this choreo.
	 * @param credentialName
	 */
    public void setCredential(String credentialName) {
        this.inputs.setCredential(credentialName);
    }
    /**
     * Specify the Profile object to be used when running this choreo.
     * @param profileName
     */

    public void addProfile(String profileName) {
        this.inputs.setCredential(profileName);
    }

    /**
     * Add an output filter to the results.
     * @param filterName
     * @param path
     * @param outputVariableSource
     */
    public void addOutputFilter(String filterName, String path, String outputVariableSource) {
        this.inputs.addOutputFilter(filterName, path, outputVariableSource);
    }

    /**
	 * Execute the choreography, wait for the choreo to complete 
	 * and return a ResultSet containing the execution results.
	 * @return
	 */
	protected ResultSet run() throws TembooException {
		JSONObject document = runWithResults();
		return new ResultSet(document);
	}

	/**
	 * Execute the choreography, and return immediately, discarding the execution results.
	 * @return
	 * @throws TembooException
	 */
	public String runNoResults() {

		try {
			return runNoResults(this.inputs, false);
		} catch(Exception e) {
			System.out.println("An error occurred while running " + this.uri.toString() + ":");
			System.out.println(e.getMessage());
		}
		return null;
		
	}
	

	/**
	 * Execute the choreography asynchronously and return a ChoreographyExecution 
	 * object which may be used to monitor the status of the running execution, or to obtain choreography results.
	 * @return
	 * @throws TembooException
	 */
	public ChoreographyExecution runAsync() {
		
		try {
			String exec_id = runNoResults(this.inputs, true);
			return new ChoreographyExecution(session, exec_id);
		} catch(Exception e) {
			System.out.println("An error occurred while running " + this.uri.toString() + ":");
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	
	/**
	 * Execute the choreography synchronously and return a 
	 * Document object representing the result data.
	 */
	protected JSONObject runWithResults() {
		try {
			byte[] xml = this.inputs.formatInputs();
			
			HashMap<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("source_id", session.CLIENT_IDENTIFIER);
			return session.postContent(getPath(), xml, paramMap);		
		} catch(Exception e) {
			System.out.println("An error occurred while running " + this.uri.toString() + ":");
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	
	/**
	 * Internal convenience method used to perform asynchronous choreography executions
	 * @param choreoInputs
	 * @param storeChoreoResults
	 * @return
	 * @throws TembooException
	 */
	private String runNoResults(InputSet choreoInputs, boolean storeChoreoResults) throws TembooException {
		String id = null;
		if (null == choreoInputs) {
			choreoInputs = new InputSet();
		}
		try {
			byte[] xml = choreoInputs.formatInputs();
			HashMap<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("mode", "async");
			paramMap.put("source_id", session.CLIENT_IDENTIFIER);
			if(storeChoreoResults)
				paramMap.put("store_results", "true");
			
			JSONObject result = session.postContent(getPath(), xml, paramMap);
			id = result.getString("id");

		} catch (Exception e) {
			throw new TembooException(e);
		}
		return id;
}


	static String getStaticBasePath() {
		return TembooSession.BASE_PATH + "/choreos";
	}

	protected String getBasePath() {
		return getStaticBasePath();
	}


	protected class InputSet {
		private final Map<String, String> inputs = new HashMap<String, String>();
		private String credential = null;
        private final List<OutputFilter> outputFilters = new ArrayList<OutputFilter>();

        final DecimalFormat decimalFormat = new DecimalFormat("########################.########################");

		
		/**
		 * Specify the Credential object to be used when running this choreo.
		 * @param credentialName
		 */
		public void setCredential(String credentialName) {
			credential = credentialName;
		}

		/**
		 * Set the named input to the specified value
		 * @param name
		 * @param value
		 */
		public void setInput(String name, String value) {
			inputs.put(name, value);
		}

		/**
		 * Set the named input to the specified value
		 * @param name
		 * @param value
		 */
		public void setInput(String name, BigDecimal value) {
			if (value == null) {
				inputs.put(name, "0");
			}
			String stringValue = decimalFormat.format(value.stripTrailingZeros());
			inputs.put(name, stringValue);
		}

		/**
		 * Set the named input to the specified value
		 * @param name
		 * @param value
		 */
		public void setInput(String name, Integer value) {
			if (value == null) {
				inputs.put(name, "0");
			}
			String stringValue = value.toString();
			inputs.put(name, stringValue);
		}

		/**
		 * Set the named input to the specified value
		 * @param name
		 * @param value
		 */
		public void setInput(String name, Boolean value) {
			if (value == null) {
				inputs.put(name, Boolean.toString(false));
			}
			String stringValue = value.toString();
			inputs.put(name, stringValue);
		}

        public void addOutputFilter(String filterName, String path, String outputVariableSource) {
            outputFilters.add(new OutputFilter(filterName, path, outputVariableSource));
        }

        private byte[] formatInputs() throws TembooException {
			try {

                JSONObject allInputs = new JSONObject();

				// coalesce everything into one hashmap
                JSONArray inputList = new JSONArray();
				
				
				if (null != credential) 
					allInputs.setString("preset", credential);

                int i = 0;
				for (Entry<String, String> entry : inputs.entrySet()) {
					String name = entry.getKey();
					String value = entry.getValue();
					JSONObject input = new JSONObject();
					input.setString("name", name);
					input.setString("value", value);
					inputList.setJSONObject(i++, input);
				}
				
				allInputs.setJSONArray("inputs", inputList);


                JSONArray outputList = new JSONArray();
                i = 0;
                for (OutputFilter filter : outputFilters) {
                    JSONObject output = new JSONObject();
                    output.setString("name", filter.getFilterName());
                    output.setString("variable", filter.getOutputVariableSource());
                    output.setString("path", filter.getPath());
                    outputList.setJSONObject(i++, output);
                }

                allInputs.setJSONArray("outputFilters", outputList);

                return allInputs.toString().getBytes();
			
			} catch (Exception e) {
				throw new TembooException(e);
			}			
		}
	}

	public static class ResultSet {

		/**
		 * Represents the possible completion statuses of a choreo		 *
		 */
		public enum Status {
			SUCCESS, ERROR, TERMINATED_MANUALLY, TERMINATED_LIMIT, RUNNING
		}

		private String id = "";
		private Status status = Status.ERROR;
		private Date startTime = null, endTime = null;
		private Map<String, Object> outputs = new HashMap<String, Object>();

		public static Object getJSONFromString(String str) {
            if (str.trim().startsWith("{")) {
                return new JSONObject(new StringReader(str));
            } else {
                return new JSONArray(new StringReader(str));
            }
		}

		public static JSONObject getJSONObject(Object json, String key) {
			JSONObject toReturn = null;

			try {
				if(json != null && (json instanceof JSONObject))
					toReturn = ((JSONObject) json).getJSONObject(key);
			} catch(Exception e) {
			}
			if(toReturn == null)
				toReturn = new JSONObject();
			
			return toReturn;
		}

		protected ResultSet(JSONObject doc) {
			try {
				if (doc != null) {
					JSONObject execution = doc.getJSONObject("execution");
					id = execution.getString("id");
					String statusString = execution.getString("status");
	
					status = Status.valueOf(statusString);
					String timeStr = execution.getString("starttime");
					startTime = new Date(Long.parseLong(timeStr));
					timeStr = execution.getString("endtime");
					endTime = new Date(Long.parseLong(timeStr));
	
					JSONObject outputList = doc.getJSONObject("output");
				
					Set<String> keys = outputList.keys();
					for(String k : keys) {
                        try {
                            outputs.put(k, outputList.getString(k));
                        } catch (Exception e) {
                            try {
                                outputs.put(k, outputList.getJSONArray(k));
                            } catch (Exception e2) {
                                ;
                            }
                        }
					}
				}
			} catch(Exception e) {
				System.out.println("An error occurred while parsing the data from the Temboo server.");
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}

		// get the completion status of the choreo (success, error, manually
		// terminated, etc.)
		public Status getCompletionStatus() {
			return status;
		}

		// get the start time of the choreo (in UTC)
		public Date getStartTime() {
			return startTime;
		}

		// get the completion time of the choreo (in UTC)
		public Date getCompletionTime() {
			return endTime;
		}

		// get the execution id
		public String getId() {
			return id;
		}

		// get the exception that was thrown during execution, if any; returns
		// null if execution was successful
		public TembooException getException() {
			return null;
		}

		// get the value of the named output
		public String getResultString(String key) {
			return outputs.get(key).toString();
		}

        // get the value of the named output as list
        public JSONArray getResultList(String key) {
            final Object o = outputs.get(key);
            if (o instanceof JSONArray) {
                return (JSONArray) o;
            } else {
                JSONArray list = new JSONArray();
                if (o instanceof String) {
                    list.setString(0, (String) o);
                }
                return list;
            }
        }

        // get the set of output names for this execution
		public Iterator<String> keySet() {
			return outputs.keySet().iterator();
		}

		public Map<String, Object> getOutputs() {
			return outputs;
		}
	}

    private static class OutputFilter {
        final String filterName;
        final String path;
        final String outputVariableSource;
        protected OutputFilter(String theFilterName, String thePath, String theOutputVariableSource) {
            filterName = theFilterName;
            path = thePath;
            outputVariableSource = theOutputVariableSource;
        }

        public String getFilterName() {
            return filterName;
        }

        public String getPath() {
            return path;
        }

        public String getOutputVariableSource() {
            return outputVariableSource;
        }
    }

}
