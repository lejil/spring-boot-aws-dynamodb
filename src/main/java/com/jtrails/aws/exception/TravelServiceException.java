package com.jtrails.aws.exception;

/**
 * @author Lejil
 *
 */

@SuppressWarnings("serial")
public class TravelServiceException extends RuntimeException {

	private int errorCode = 0;

	public TravelServiceException(String message) {
		super(message);
	}

	public TravelServiceException(int errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return this.errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

}