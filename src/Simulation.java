
public class Simulation {
	Simulation(Player playerOne, Player playerTwo) {
		simulateRounds(playerOne, playerTwo);
		calculateWinner(playerOne, playerTwo);
	}

	private void simulateRounds(Player playerOne, Player playerTwo) {
		for (int round = 0; round < playerOne.getDeck().length; round++) {
			playRounds(round, playerOne, playerTwo);
		}
		calculateWinner(playerOne, playerTwo);
	}

	private void playRounds(int round, Player playerOne, Player playerTwo) {
		System.out.print(playerOne.getCard(round) + "-" + playerTwo.getCard(round) + " ");
		if (playerOne.getCard(round) > playerTwo.getCard(round)) {
			playerOne.addPoint();
			System.out.print("Player one gained a point");
		} else if (playerOne.getCard(round) == playerTwo.getCard(round)) {
			System.out.print("Tie");
		} else {
			playerTwo.addPoint();
			System.out.print("Player two gained a point");
		}
		System.out.print("\n");
	}

	private void calculateWinner(Player playerOne, Player playerTwo) {
		System.out.println(
				"The final score is Player One: " + playerOne.getPoints() + " - Player Two: " + playerTwo.getPoints());
		if (playerOne.getPoints() > playerTwo.getPoints()) {
			System.out.print("PLAYER ONE WON!");
		} else if (playerOne.getPoints() == playerTwo.getPoints()) {
			System.out.print("Tie");
		} else {
			System.out.print("PLAYER TWO WON!");
		}
	}
}
