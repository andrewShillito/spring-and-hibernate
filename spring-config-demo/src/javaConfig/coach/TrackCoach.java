package javaConfig.coach;

import org.springframework.beans.factory.annotation.Value;

import coach.Coach;
import fortune.FortuneService;

public class TrackCoach implements Coach {
	
	@Value("${trackCoach.email}")
	private String email;
	
	@Value("${trackCoach.team}")
	private String team;
	
	@Value("${trackCoach.message}")
	private String message;
	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
