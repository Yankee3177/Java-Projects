package CompScience;

public class BlackJack {


	public static int randomNumBetween2And26(int num) {
		num = (int) (Math.random() * ((26 - 2) + 1))+ 2;
		return num;
	}
	
	public static void main(String[] args) {
		BlackjackWinner hand = new BlackjackWinner();
		int player1 = 0;
		int player2 = 0;
		int player3 = 0;
		
		int play1GamesWon = 0;
		int play2GamesWon = 0;
		int play3GamesWon = 0;
		int tieGames = 0;
		
		for(int i = 0; i < 1000; i++) {
			hand.setPlay1(randomNumBetween2And26(0));
			hand.setPlay2(randomNumBetween2And26(0));
			hand.setPlay3(randomNumBetween2And26(0));
			
			player1 = hand.getPlay1();
			player2 = hand.getPlay2();
			player3 = hand.getPlay3();
			
			 int winner = hand.determineWinner(player1, player2, player3);
			 
			 if(winner == 1) {
				 play1GamesWon ++;
			 }
			 if(winner == 2) {
				 play2GamesWon ++;
			 }
			 if(winner == 3) {
				 play3GamesWon ++;
			 }
			 if(winner == 5) {
				 tieGames ++;
			 }
			 
		}
		 System.out.println("Player 1 won " + play1GamesWon + " /1000.");
		 System.out.println("Player 2 won " + play2GamesWon + " /1000.");
		 System.out.println("Player 3 won " + play3GamesWon + " /1000.");
		 System.out.println("There were " + tieGames + " tie games.");
	}

}

	


