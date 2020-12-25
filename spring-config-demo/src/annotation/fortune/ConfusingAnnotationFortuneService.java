package annotation.fortune;

import org.springframework.stereotype.Component;

@Component
public class ConfusingAnnotationFortuneService implements AnnotationFortuneService {

	private String[] fortunes = {
			"... ?",
			"Have a ",
			"Fortune not found"
	}; 
	
	@Override
	public String getFortune() {
		return fortunes[ (int) (Math.random() * fortunes.length) ];
	}

}
