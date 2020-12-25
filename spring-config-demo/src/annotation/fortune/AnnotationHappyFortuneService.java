package annotation.fortune;

import org.springframework.stereotype.Component;

@Component
public class AnnotationHappyFortuneService implements AnnotationFortuneService {

	@Override
	public String getFortune() {
		return "A happy fortune";
	}

}
