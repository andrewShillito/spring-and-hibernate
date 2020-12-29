package com.springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Customer {

	private final int minFreePasses = 0;
	private final int maxFreePasses = 10;
	
	private String firstName;
	
	@NotNull(message=UserMessages.ERROR_REQUIRED)
	@Size(min=1, message=UserMessages.ERROR_REQUIRED)
	@Size(min=2, message=UserMessages.ENTRY_TOO_SHORT)
	private String lastName;

	@Min(value=minFreePasses, message=UserMessages.ERROR_GTE_THAN_ZERO)
	@Max(value=maxFreePasses, message=UserMessages.ERROR_LTE_PREFIX + maxFreePasses)
	private int freePasses;
	
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

	public int getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(int freePasses) {
		this.freePasses = freePasses;
	}
	
}
