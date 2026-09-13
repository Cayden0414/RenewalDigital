import java.util.*;
public class City {
	public String[] titles;
	public String[] effects;
	public Card[] cards;
	public Random random;
	public Card currentCard;

	public City(String[] titles, String[] effects) {
		this.titles = titles;
		this.effects = effects;
		this.cards = new Card[titles.length];
		this.random = new Random();
		this.currentCard = null;
		for (int i = 0; i < titles.length; i++) {
			cards[i] = new Card("City", titles[i], effects[i]);
		}
	}

	public void playTurn(){
		currentCard = null; // Discard previous card
		currentCard = playCard();
		currentCard.activateEffect();
	}

	public Card playCard() {
		if (cards == null || cards.length == 0) {
			return null;
		}

		int randomIndex = this.random.nextInt(cards.length);
		return cards[randomIndex];
	}

}
