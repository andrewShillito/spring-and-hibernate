package com.springdemo.mvc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Value("#{countryOptions}")
	private Map<String, String> countryOptions;
	
	@Value("#{languageOptions}")
	private Map<String, String> languageOptions;
	
	@Value("#{operatingSystems}")
	private Map<String, String> operatingSystems;
	
	@RequestMapping("/form")
	public String showForm(Model model) {
		
		// create a student object
		Student student = new Student();
		
		// add student object to the model
		model.addAttribute("student", student);
		
		model.addAttribute("countryOptions", countryOptions);
		model.addAttribute("languageOptions", languageOptions);
		model.addAttribute("operatingSystems", operatingSystems);
		
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student student) {
		student.setCountryName(countryOptions.get(student.getCountry()));
		return "student-confirmation";
	}
	
}
