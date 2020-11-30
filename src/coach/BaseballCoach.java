package coach;

import fortune.FortuneService;

public class BaseballCoach implements Coach {

	private FortuneService fortuneService;
	
	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	public String getDailyWorkout() {
		return "Spend 30 minutes in the batting cage";
	}
	
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
