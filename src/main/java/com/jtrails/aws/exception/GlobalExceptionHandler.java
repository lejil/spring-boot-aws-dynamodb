package com.jtrails.aws.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Lejil
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	// Handle other exceptions globally
	@ExceptionHandler(TravelServiceException.class)
	public ResponseEntity<ErrorResponse> handleTravelServiceException(TravelServiceException ex) {
		ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode(), ex.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.OK);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.OK);
	}
}