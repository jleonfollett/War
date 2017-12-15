import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class Deck {
	HashMap<Integer, Integer> deck;
	int totalDeckSize;
	int playerDeckSize;
	int[] playerOneDeck;
	int[] playerTwoDeck;
	
	Player playerOne;
	Player playerTwo;
	Deck(){
		createPlayers();
		createDeck();
		setPlayerDeckSize();
		createPlayerDecks();
		System.out.println(deck.toString());
		System.out.println(totalDeckSize);
		System.out.println(playerDeckSize);
		new Simulation(playerOne,playerTwo);
	}

	private void createDeck(){
		deck = new HashMap<Integer, Integer>();
		for(int card = 1; card <= 15; card++) {
			deck.put(card, 4);
			totalDeckSize += deck.get(card);
		}
	}

	private void setPlayerDeckSize() {
		playerDeckSize = totalDeckSize/2;
	}

	private void createPlayerDecks() {
		playerOne.setDeck(playerDeckSize);
		playerTwo.setDeck(playerDeckSize);
		for(int cardsDealt = 0; cardsDealt < playerDeckSize; cardsDealt++) {
			dealCard(cardsDealt, playerOne);
			dealCard(cardsDealt, playerTwo);
			
		}
		System.out.println(Arrays.toString(playerOne.getDeck()));
		System.out.println(Arrays.toString(playerTwo.getDeck()));
	}
	
	private int pickCard() {
		Random random = new Random();
		int current = random.nextInt(15) + 1;
		return current;
	}
	
	private void dealCard(int cardsDealt, Player player) {
		int current = pickCard();
		int currentAmount = deck.get(current);
		if(currentAmount > 0) {
			player.addCard(cardsDealt, current);
			deck.put(current, currentAmount - 1);
		} else {
			dealCard(cardsDealt, player);
		}
	}
	
	private void createPlayers() {
		playerOne = new Player();
		playerTwo = new Player();
	}
	
	
}
