package fortune;

public class RandomFortuneService implements FortuneService {

	private String[] fortunes = {
			"Random happy fortune",
			"Random confusing fortune",
			"Random other fortune"
	}; 
	
	@Override
	public String getFortune() {
		return fortunes[ (int) (Math.random() * fortunes.length) ];
	}

}
