package tn.banque.Entities;

public enum Gender {
	  MALE(3),FEMALE(5);
		private int score;
		public int getScore()
		{
		    return this.score;
		}

		private Gender(int score) {
			this.score = score;
		}

}
