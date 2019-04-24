package com.sample.dcs.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

// TODO: Auto-generated Javadoc
/**
 * The Class ErrorDetails.
 */
@JsonInclude(Include.NON_NULL)
public class ErrorDetails {
	
	/** The timestamp. */
	private Date timestamp;
	
	/** The message. */
	private String message;
	
	/** The details. */
	private String details;

	/**
	 * Instantiates a new error details.
	 *
	 * @param timestamp the timestamp
	 * @param message the message
	 * @param details the details
	 */
	public ErrorDetails(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	/**
	 * Gets the timestamp.
	 *
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Gets the details.
	 *
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}
}