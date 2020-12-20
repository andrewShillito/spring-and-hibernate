package javaConfig.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import coach.Coach;
import fortune.FortuneService;
import javaConfig.coach.TrackCoach;
import javaConfig.fortune.JavaConfigFortune;

@Configuration
@ComponentScan("javaConfig.coach")
@ComponentScan("javaConfig.fortune")
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
