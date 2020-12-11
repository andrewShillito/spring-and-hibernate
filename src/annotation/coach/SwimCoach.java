package annotation.coach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import annotation.fortune.AnnotationFortuneService;

@Component
public class SwimCoach implements AnnotationCoach {

	private AnnotationFortuneService fortuneService;
	
	@Autowired
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
}
