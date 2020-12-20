package javaConfig.fortune;

import fortune.FortuneService;

public class JavaConfigFortune implements FortuneService {

	@Override
	public String getFortune() {
		return "Java spring configuration fortune service"; 
	}

}
