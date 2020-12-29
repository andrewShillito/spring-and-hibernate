package com.springdemo.mvc;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Customer {

	private String firstName;
	
	@NotNull(message=UserMessages.ERROR_REQUIRED)
	@Size(min=1, message=UserMessages.ERROR_REQUIRED)
	@Size(min=2, message=UserMessages.ENTRY_TOO_SHORT)
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
