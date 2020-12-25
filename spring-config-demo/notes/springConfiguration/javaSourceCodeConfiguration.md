# Spring Configuration with Java Source Code

To configure spring application context and beans without writing xml config files, we first have to write a java configuration class.
To do this, we use the `@Configuration` annotation and optionally the `@ComponentScan` annotation which would setup the scan paths. We can either declare beans in the configuration explicitly using the `@Bean` annotation (especially useful for bringing beans from outside libraries or APIs into the application context) or using component scanning. Furthermore, if we want to inject values from properties files, we can use the `@PropertySource` annotation to define a properties file from which to read values. Note the usage of the `@Bean` annotated `javaConfigFortuneService()` method in the injection of the `FortuneService` dependency for the `TrackCoach`. This is constructor dependency injection configured using java source code. Additionally, it is important to note, that except for the first call of `javaConfigFortuneService()` or other similar bean construction methods, the `@Bean` will intercept the call to the this method and depending on bean scope configuration it will either return the existing bean in the application context or create a new one.

```
@Configuration
//@ComponentScan("javaConfig.coach")
//@ComponentScan("javaConfig.fortune")
@PropertySource("classpath:sport.properties")
public class JavaConfig {

	@Bean
	public Coach trackCoach() {
		Coach coach = new TrackCoach(javaConfigFortuneService());
		return coach;
	}
	
	@Bean
	public FortuneService javaConfigFortuneService() {
		return new JavaConfigFortune();
	}
}
```

Then in the main method for the application we call `AnnotationConfigApplicationContext` which reads spring configuration from java source code and returns an application context object which can then be used similarly to the ClassPathXmlApplicationContext object.
`AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);`