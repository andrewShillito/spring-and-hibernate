package javaConfig.coach;

import coach.Coach;
import fortune.FortuneService;

public class TrackCoach implements Coach {
	
	FortuneService fortuneService;

	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Track coach daily workout";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
