package com.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

	@RequestMapping("/showForm")
	public String showForm() {
		return "helloWorld-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloWorld";
	}
	
	@RequestMapping("/processFormToUpper")
	public String processFormToUpperCase(HttpServletRequest request, Model model) {
		
		// read the request parameter from the HTML form
		String studentName = request.getParameter("studentName");
		
		// convert the data to upper case
		studentName = studentName.toUpperCase();
		
		// create a response message
		String result = "HELLO " + studentName;
		
		// add the message to the model
		model.addAttribute("message", result);
		
		// return view template
		return "helloWorld";
	}
}
