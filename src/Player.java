
public class Player {
	int[] deck;
	int points;

	public int[] getDeck() {
		return deck;
	}

	public void setDeck(int playerDeckSize) {
		this.deck = new int[playerDeckSize];
	}

	public void addCard(int slot, int card) {
		this.deck[slot] = card;
	}

	public void addPoint() {
		this.points++;
	}

	public int getPoints() {
		return points;
	}

	public int getCard(int slot) {
		return this.deck[slot];
	}
}
