package com.sample.dcs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Data

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Builder
@Entity

/**
 * Instantiates a new employee.
 *
 * @param id the id
 * @param firstName the first name
 * @param lastName the last name
 * @param emailId the email id
 */
@AllArgsConstructor

/**
 * Instantiates a new employee.
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
public class Employee {

	/** The id. */
	@Id
	private Long id;
	
	/** The first name. */
	@Column(name = "first_name")
	private String firstName;

	/** The last name. */
	@Column(name = "last_name")
	private String lastName;

	/** The email id. */
	@Column(name = "email_id")
	private String emailId;
}
