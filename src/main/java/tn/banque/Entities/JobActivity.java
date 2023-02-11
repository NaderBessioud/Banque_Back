package tn.banque.Entities;

public enum JobActivity {
	AGRICULTURE(4),TRADING(5),PRODUCTION(3),SERVICES(2),CRAFTSMANSHIP(2),UNEMPLOYED(0);

	// declaring private variable for getting values
	private int score;

	// getter method
	public int getScore()
	{
	    return this.score;
	}

	private JobActivity(int score) {
		this.score = score;
	}

}
