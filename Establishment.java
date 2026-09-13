import java.util.*;
public class Establishment {
    public int establishmentGoal;
    public String[] titles;
    public String[] effects;
    public Card[] cards;
    public Random random;

    public Establishment(int goal, String[] titles, String[] effects) {
        this.establishmentGoal = goal;
        this.titles = titles;
        this.effects = effects;
        this.cards = new Card[titles.length];
        this.random = new Random();
        for(int i = 0; i < titles.length; i++) {
            cards[i] = new Card("Establishment", titles[i], effects[i]);
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
