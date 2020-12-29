<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer confirmation page</title>
</head>
<body>

	The customer <i>${customer.firstName} ${customer.lastName}</i> is confirmed. 
	
	<br /><br />
	
	Free passes: ${customer.freePasses}
	
	<br /><br />
	
	Postal code: ${customer.postalCode}

</body>
</html>