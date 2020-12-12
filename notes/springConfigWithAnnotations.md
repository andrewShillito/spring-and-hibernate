# Spring configuration with java annotations
1. Enable component scanning in Spring config file

Enabling component scanning is achieved with `<context:component-scan base-package="your.base.package"/>` in the xml config.
The `<context:component-scan>` element allows child elements `<context:include-filter>` and `<context:exclude-filter>` which can be used to include/exclude classes from being registered with the spring container.

2. Use the `@Component` annotation in the Java class which we wish to add to the spring container

Add `@Component` annotation to required beans in the package so they will be automatically registered with the spring container.
If a bean id is stated explicitly, spring will generate a default id. Takes the class name and makes the first letter lower-case.
IE: TennisCoach default bean id = tennisCoach.

3. Spring will scan the locations configured and automatically register the annotation configured bean(s) there
4. Retrieve and access bean as normal from Spring container

#### Benefits
1. less verbose than xml configuration so saves code
2. minimizes required xml configuration
3. spring does more for you
4. spring configuration is visible in the code it impacts

## Dependency injection with annotation configuration

1. Auto-wiring for dependency injection using the `@Autowired` annotation

Spring will look for a class that matches the property by type (class or interface).
When it finds a match by class or interface, it will inject them into the beans that depend on them.
If there are multiple implementations of an interface, you can use the `@Qualifier` annotation to define which one you want.

There are 3 different types of auto-wired dependency injection
1. Constructor injection - injects dependency via constructor parameter
```
	private AnnotationFortuneService fortuneService;
	@Autowired
	public TennisCoach(AnnotationFortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
```

As of Spring Framework 4.3, an @Autowired annotation on such a constructor is no longer necessary if the target bean only defines one constructor. However, if several constructors are available, at least one must be annotated to teach the container which one to use.

2. Setter injection
```
	private AnnotationFortuneService fortuneService;
	@Autowired
	public void setFortuneService(AnnotationFortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
```


*Method injection* - the method used to inject dependency does not have to be named setFortuneService. It can have any name as long as it is configured with the `@Autowired` annotation.


3. Field injection

Field injection is applied directly to the field. `@Autowired` annotation is added directly to the field where the dependency is stored in the bean.

```
   @Autowired
	private AnnotationFortuneService fortuneService;
	// no need for setter method, spring will use reflection to set this field
```

