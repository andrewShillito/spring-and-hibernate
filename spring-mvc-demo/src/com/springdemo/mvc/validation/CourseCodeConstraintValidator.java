package com.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

	private String coursePrefix;
	
	@Override
	public void initialize(CourseCode constraintAnnotation) {
		coursePrefix = constraintAnnotation.value();
	}
	
	@Override
	public boolean isValid(String courseCode, ConstraintValidatorContext constraintValidatorContext) {
		// if null courseCode then this validation returns true as courseCode is optional
		
		if (courseCode != null) {
			return courseCode.startsWith(coursePrefix);	
		}
		
		return true;
	}
}
