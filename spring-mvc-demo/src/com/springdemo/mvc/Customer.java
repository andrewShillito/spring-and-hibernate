package com.springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Customer {

	private final int minFreePasses = 0;
	private final int maxFreePasses = 10;
	
	private String firstName;
	
	@NotNull
	@Size(min=1, message=UserMessages.ERROR_REQUIRED)
	@Size(min=2, message=UserMessages.ERROR_ENTRY_TOO_SHORT)
	private String lastName;

	@NotNull
	@Min(value=minFreePasses, message=UserMessages.ERROR_GTE_THAN_ZERO)
	@Max(value=maxFreePasses, message=UserMessages.ERROR_LTE_PREFIX + maxFreePasses)
	private Integer freePasses;
	
	@Pattern(regexp="^[a-zA-Z0-9]{5}", message=UserMessages.ERROR_INVALID_FORMAT + " - must be 5 characters and/or digits.")
	private String postalCode;
	
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

	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
}
