package annotation.coach;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import annotation.fortune.AnnotationFortuneService;

@Component
public class SwimCoach implements AnnotationCoach {

	@Value("${coach.otherMessage}")
	private String otherMessage;
	
	private AnnotationFortuneService fortuneService;
	
	@Autowired
	@Qualifier("annotationHappyFortuneService")
	public void setFortuneService(AnnotationFortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Swim 100 laps";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	@Override
	public String getOtherMessage() {
		return otherMessage;
	}
	
	@PostConstruct
	public void customInitializationMethod() {
		System.out.println("Inside custom initialization method of " + this.getClass().getName());
	}
	
	@PreDestroy
	public void customDestroyMethod() {
		System.out.println("Inside custom destroy method of " + this.getClass().getName());
	}
	
}
