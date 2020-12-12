package annotation.coach;

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
	
}
