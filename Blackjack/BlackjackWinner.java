package CompScience;

public class BlackjackWinner {
	private int play1;
	private int play2;
	private int play3;
	
	public int getPlay1() {
		return play1;
	}
	public void setPlay1(int play1) {
		this.play1 = play1;
	}
	public int getPlay2() {
		return play2;
	}
	public void setPlay2(int play2) {
		this.play2 = play2;
	}
	public int getPlay3() {
		return play3;
	}
	public void setPlay3(int play3) {
		this.play3 = play3;
	}
	public int determineWinner(int play1, int play2, int play3) {
		int counter1 = 0;
		int counter2 = 0;
		int counter3 = 0;
		
		if(play1 <= 21) {
			counter1 = 21 - play1;
			
		}
		if(play2 <= 21) {
			counter2 = 21 - play2;
			
		}
		if(play3 <= 21) {
			counter3 = 21 - play3;
			
		}
		if(play1 > 21) {
			counter1 = 30;// 30 means that the player lost because he or she is above 21
		}
		if(play2 > 21) {
			counter2 = 30;
		}
		if(play3 > 21) {
			counter3 = 30;
		}
		if(play3 == play1 || play3 == play2) {
			return 5;// 5 means that the game was tied, and tied games means no one won.
		}
		if(play2 == play3 || play2 == play1) {
			return 5;
		}
		if(play1 == play3 && play1 == play2) {
			return 5;
		}
		if(counter1 == 30 && counter2 == 30 && counter3 != 30) {
			return 3;	
		}
		if(counter2 == 30 && counter3 == 30 && counter1 != 30) {
			return 1;
		}
		if(counter3 == 30 && counter1 == 30 && counter2 != 30) {
			return 2;
		}
		if(counter1 < counter2 || counter1 < counter3) {
			return 1;
		}
		if(counter2 < counter1 || counter2 < counter3) {
			return 2;
		}
			return 3;
		  
		}
	
	
	
}
