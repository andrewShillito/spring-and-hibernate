package annotation.coach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import annotation.fortune.AnnotationFortuneService;

@Component
public class HockeyCoach implements AnnotationCoach {

	@Value("${coach.otherMessage}")
	private String otherMessage;
	
	@Autowired
	@Qualifier("annotationHappyFortuneService")
	private AnnotationFortuneService fortuneService;
	// no need for setter method, spring will use reflection to set this field
	
	@Override
	public String getDailyWorkout() {
		return "Practice slapshot";
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
