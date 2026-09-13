public class Card {
    private String deck;
    private String title;
    private String effect;

    public Card() {
        this("Default", "Placeholder Title", "Placeholder Effect");
    }

    public Card(String deck, String title, String effect) {
        this.deck = deck;
        this.title = title;
        this.effect = effect;
    }

    public static Card createPlaceholder(String deckName, int index) {
        return new Card(deckName, deckName + " Placeholder Title " + index,
                "Placeholder Effect " + index);
    }

    public String getDeck() {
        return deck;
    }

    public String getTitle() {
        return title;
    }

    public String getEffect() {
        return effect;
    }

    public void activateEffect() {
        // Implement the logic to activate the effect of the card
        
    }

    @Override
    public String toString() {
        return "Card{" +
                "deck='" + deck + '\'' +
                ", title='" + title + '\'' +
                ", effect='" + effect + '\'' +
                '}';
    }
}
