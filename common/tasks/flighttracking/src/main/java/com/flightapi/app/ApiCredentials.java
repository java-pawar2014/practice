package com.flightapi.app;

/**
 * @author bpawar
 *
 */
public final class ApiCredentials {

	private static final String appId = "e73aba2a";
	private static final String appKey = "2555787bb0117d52ae25521900f9b8ad";

	/**
	 * value of mandatory query parameter 'appId' for each request, make it configurable if required.
	 */
	public static final String getAppId() {
		return appId;
	}

	/**
	 * Value of mandatory query parameter 'appKey' for each request, make it configurable if required.
	 */
	public static final String getAppKey() {
		return appKey;
	}
}
