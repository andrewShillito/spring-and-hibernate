# Spring MVC
**M**odel objects, **V**iew templates, **C**ontroller classes

**Overall workflow of the MVC framework.**
1. Web browser makes request to server. 
2. Front Controller receives this request and delegates to controller code.
3. Controller prepares a model which is sent back to the front controller.
4. The front controller forwards the model over to the view template.
5. The view template renders a response (ie: jsp, thymeleaf, velocity).
6. The response is returned to the user's browser.

**Spring MVC benefits**
- Leverages spring IOC and DI
- Helps manage application state for web requests
- Processes form data: validation, conversion, etc...
- Has flexible configuration for the view layer

**Components of Spring MVC Application**
- A set of web pages to layout UI components
- A collection of Spring Beans (controllers, services, etc...)
- Spring configuration (XML, Annotations, or Java)

**Front Controller**
- Front controller is known as DispatcherServlet
- The front controller delegates to the controller and is part of the spring framework