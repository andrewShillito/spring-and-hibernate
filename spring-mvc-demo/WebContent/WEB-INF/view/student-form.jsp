<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
	
		<title>Student registration form</title>
	
	</head>
	
	<body>
	
		<form:form action="processForm" modelAttribute="student">
		
			First name: <form:input path="firstName"/>
		
			<br/>
			
			Last name: <form:input path="lastName"/>
		
			<br/>
		
			Country <form:select path="country">
			
				<form:options items="${countryOptions}"/>
				
			</form:select>
			
			<br/>
			
			Favorite language: <form:radiobuttons path="favoriteLanguage" items="${languageOptions}"/>
			
			<br/>	
			
			Favorite OS: <form:checkboxes path="operatingSystems" items="${operatingSystems}"/>
			
			<br/>	
		
		<input type="submit" value="Submit"/>
		
		</form:form>
	
	
	</body>

</html>