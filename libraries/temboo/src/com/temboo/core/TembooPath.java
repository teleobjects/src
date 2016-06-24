package com.temboo.core;

import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TembooPath represents an identifier for an object within the Temboo system, at a discrete 
 * virtual path location.
 * 
 * @author matthewflaming
 *
 */
public class TembooPath {

	// Exception message strings
	private static final String URI_INVALID_STRING_EXCEPTION = "A Temboo Path could not be created because the specified string was not valid";

	// the set of path segments which comprise this URI
	protected String[] pathArray;

	// the pattern used to validate proposed capability names
	private static Pattern validNamePattern = Pattern
			.compile("^\\w[\\w\\-\\.@]*$");

	/**
	 * Construct a new TembooPath representing the ordered set of path segments
	 * supplied as an argument
	 * 
	 * @param paths
	 * @throws URISyntaxException
	 */
	private TembooPath(String[] paths) throws URISyntaxException {
		// assert all segments valid
		for (String string : paths) {
			if (!isValidCapabilityName(string)) {
				throw new URISyntaxException(string,
						URI_INVALID_STRING_EXCEPTION);
			}
			if (string.length() == 0) {
				throw new URISyntaxException(string,
						URI_INVALID_STRING_EXCEPTION);
			}
		}
		this.pathArray = paths;
	}

	/**
	 * Construct a new TembooPath from the specified string, suppressing any errors.
	 * @param uriString
	 * @return
	 */
	public static TembooPath pathFromStringNoException(String uriString) {
		try {
			return uriFromString(uriString);
		} catch (URISyntaxException e) {
		}
		return null;
	}

	
	/**
	 * Construct a new TembooPath based on the passed-in string; the passed
	 * string will be parsed into path segments, eg "/foo/bar/blah" would return
	 * a TembooURI with a path length of 3
	 * 
	 * @param uriString
	 * @return
	 * @throws URISyntaxException
	 */
	public static TembooPath uriFromString(String uriString)
			throws URISyntaxException {
		TembooPath path = null;
		String myUriString = uriString;
		if (myUriString.startsWith("/")) {
			myUriString = myUriString.substring(1);
			if (myUriString.startsWith("/")) {
				throw new URISyntaxException(uriString,
						URI_INVALID_STRING_EXCEPTION);
			}
		}
		String[] paths = new String[0];
		if (myUriString.length() > 0) {
			paths = myUriString.split("/");
		}

		path = new TembooPath(paths);
		return path;
	}


	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (other instanceof TembooPath) {
			TembooPath otherUri = (TembooPath) other;
			if (this.pathArray.length != otherUri.pathArray.length) {
				return false;
			}

			if (!this.pathArray[0].equalsIgnoreCase(otherUri.pathArray[0])) {
				return false;
			}

			boolean result = true;
			for (int i = 1; i < this.pathArray.length; i++) {
				if (!this.pathArray[i].equals(otherUri.pathArray[i])) {
					return false;
				}
			}
			return result;
		}
		return false;
	}

	public int hashCode() {
		if (this.pathArray != null) {
			int hashCode = 1;
			hashCode = 31
					* hashCode
					+ (pathArray[0] == null ? 0 : pathArray[0].toLowerCase()
							.hashCode());
			for (int i = 1; i < pathArray.length; i++) {
				hashCode = 31 * hashCode
						+ (pathArray[i] == null ? 0 : pathArray[i].hashCode());
			}
			return hashCode;
		}
		return 0;
	}

	/**
	 * Return a string representation of this TembooPath.
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (String pathElement : pathArray) {
			sb.append("/");
			sb.append(pathElement);
		}
		return sb.toString();
	}

	/**
	 * Check whether the specified string is a valid local name for a
	 * capability; the string should be the rightmost segment of the proposed
	 * TembooPath (not a full TembooPath)
	 * 
	 * @param localName
	 * @return
	 */
	public static boolean isValidCapabilityName(String localName) {
		Matcher m = validNamePattern.matcher(localName);
		return m.matches();
	}

}