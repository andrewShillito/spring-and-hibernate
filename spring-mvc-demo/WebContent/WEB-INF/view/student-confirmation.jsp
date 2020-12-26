<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
	
		<title>Student confirmation</title>
	
	</head>
	
	<body>
	
		The student ${student.firstName} ${student.lastName} is confirmed.
		
		<br />
		
		Country: ${student.countryName}
		
		<br />
		
		Favorite language: ${student.favoriteLanguage}
		
		<br />
		
		Operating systems: 
		<ul>
			<c:forEach var="os" items="${student.operatingSystems}">
				<li>${os}</li>
			</c:forEach>
		</ul> 
	
	</body>

</html>