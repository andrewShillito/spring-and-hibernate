# Spring configuration with java annotations
1. Enable component scanning in Spring config file

Enabling component scanning is achieved with `<context:component-scan base-package="your.base.package"/>` in the xml config
The `<context:component-scan>` element allows child elements `<context:include-filter>` and `<context:exclude-filter>` which can be used to include/exclude classes from being registered with the spring container

2. Use the `@Component` annotation in the Java class which we wish to add to the spring container

Add `@Component` annotation to required beans in the package so they will be automatically registered with the spring container.
If a bean id is stated explicitly, spring will generate a default id. Takes the class name and makes the first letter lower-case.
IE: TennisCoach default bean id = tennisCoach

3. Spring will scan the locations configured and automatically register the annotation configured bean(s) there
4. Retrieve and access bean as normal from Spring container

#### Benefits
1. less verbose than xml configuration so saves code
2. minimizes required xml configuration
3. spring does more for you
4. spring configuration is visible in the code it impacts
