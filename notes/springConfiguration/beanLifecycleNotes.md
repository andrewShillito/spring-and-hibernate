# Bean Lifecycle

Container Started -> Bean Instantiated -> Dependencies Injected -> Internal Spring Processing -> Any custom init method -> Bean ready for use

When container is shutdown -> Any custom destroy method -> End of application


## Custom code during bean initialization
- accomplished with the bean configuration property *init-method="yourInitMethod"*
- can call custom business logic methods
- can setup handles to resources ie: db, sockets, files, etc...

## Custom code during bean destruction
- accomplished with the bean configuration property *destroy-method="yourDestroyMethod"*
- can call custom business logic methods
- can cleanup/close handles to resources ie: db, sockets, files, etc...
- For prototype scoped beans Spring does not call the destroy method. Spring does not manage the complete lifecycle of a
  prototype bean.
  
#### Prototype lifecycle
Bean Instantiated -> Dependencies Injected -> Internal Spring Processing -> Any custom init method --> given to client code 
-> no further spring reference to that bean instance
This means that prototype scoped beans must be cleaned up by the client code (outside of standard java garbage collection)

## Method signatures of init-method and destroy-method functions
#### Access modifier
- can have any access modifier (public, protected, private)

#### Return type
- can have any return type but void is the most commonly used since the return value is discarded.

#### Method name
- can have any method name

#### Arguments
- the method cannot accept any arguments - must be no-arg