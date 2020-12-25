# Adding data to the Spring Model

The spring controller methods which handle request mappings are flexible in terms of the parameters they can accept. If we need to handle form data and add data to the Model, we can pass in the HttpServletRequest object and Model objects. This allows us to access and perform operations on form data. We can then put the resulting data following our operations into the Model where it can be accessed in our view templates.

# Adding js, css, and image resources
Step 1: Add the following entry to your Spring MVC configuration file: spring-mvc-demo-servlet.xml

You can place this entry anywhere in your Spring MVC config file.

`<mvc:resources mapping="/resources/**" location="/resources/"></mvc:resources>`

Step 2: Now in your view pages, you can access the static files using this syntax:

`<img src="${pageContext.request.contextPath}/resources/images/spring-logo.png">`

You need to use the JSP expression ${pageContext.request.contextPath} to access the correct root directory for your web application.