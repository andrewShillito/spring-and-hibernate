# Bean Scopes
- **singleton**
  The default scope. Creates only one instance of the bean which is cached in memory and all requests for the bean
  will return a shared reference to the same bean. Meaning one object, many references. This would not work if for
  instance the bean stores state and should have different state in different situations.
    
- **prototype**
  Creates a new instance for each container request
	
- **request**
  Scoped to an http web request
    
- **session**
  Scoped to an http web session. Useful for a shopping cart where the cart is scoped to a specific user's http web session.
    
- **global-session**
  Scoped to a global http web session. Scoped web application-wide.