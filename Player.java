import java.util.*;

public class Player {
	public int projectGoal;
	public String[] titles;
	public String[] effects;
	public Card[] cards;
	public Random random;

	public Player(int goal, String[] titles, String[] effects) {
		this.projectGoal = goal;
		this.titles = titles;
		this.effects = effects;
		this.cards = new Card[titles.length];
		this.random = new Random();
		for (int i = 0; i < titles.length; i++) {
			cards[i] = new Card("Projects", titles[i], effects[i]);
		}
	}

	public Card playCard() {
		if (cards == null || cards.length == 0) {
			return null;
		}

		int randomIndex = this.random.nextInt(cards.length);
		return cards[randomIndex];
	}

}
