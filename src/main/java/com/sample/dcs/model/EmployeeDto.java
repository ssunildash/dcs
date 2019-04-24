package com.sample.dcs.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Builder

/**
 * Instantiates a new employee dto.
 *
 * @param id the id
 * @param firstName the first name
 * @param lastName the last name
 * @param emailId the email id
 */
@AllArgsConstructor

/**
 * Instantiates a new employee dto.
 */
@NoArgsConstructor

/**
 * Sets the email id.
 *
 * @param emailId the new email id
 */
@Setter

/**
 * Gets the email id.
 *
 * @return the email id
 */
@Getter
@JsonInclude(Include.NON_NULL)
public class EmployeeDto {
	
	/** The id. */
	private Long id;
	
	/** The first name. */
	private String firstName;
	
	/** The last name. */
	private String lastName;
	
	/** The email id. */
	private String emailId;
}
