package annotation.coach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import annotation.fortune.AnnotationFortuneService;

@Component
@Scope("prototype")
public class TennisCoach implements AnnotationCoach {

	@Value("${coach.otherMessage}")
	private String otherMessage;
	
	private AnnotationFortuneService fortuneService;
	
	@Autowired
	public TennisCoach(@Qualifier("confusingAnnotationFortuneService") AnnotationFortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice backhand volley";
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
