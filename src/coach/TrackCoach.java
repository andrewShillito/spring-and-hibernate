package coach;

import fortune.FortuneService;

public class TrackCoach implements Coach {

	FortuneService fortuneService;
	
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}
	
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}


}
