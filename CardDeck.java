import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;

public class CardDeck {
    private static final int DEFAULT_PLACEHOLDER_COUNT = 20;
    private Map<String, List<Card>> deckData;
    private Map<String, Integer> placeholderCounts;
    private Random random;

    public CardDeck() {
        this.deckData = new HashMap<>();
        this.placeholderCounts = new HashMap<>();
        this.random = new Random();
        createDeck("Default");
        shuffleDeck("Default");
    }

    public void createDeck(String deckName) {
        initializeDeck(deckName, DEFAULT_PLACEHOLDER_COUNT);
    }

    private void initializeDeck(String deckName, int placeholderCount) {
        List<Card> cards = new ArrayList<>();
        for (int i = 1; i <= placeholderCount; i++) {
            cards.add(Card.createPlaceholder(deckName, i));
        }
        deckData.put(deckName, cards);
        placeholderCounts.put(deckName, placeholderCount);
    }

    public void shuffleDeck(String deckName) {
        List<Card> cards = deckData.get(deckName);
        if (cards == null) {
            return;
        }
        Collections.shuffle(cards, random);
    }

    public Card selectRandomCard(String deckName) {
        List<Card> cards = deckData.get(deckName);
        if (cards == null || cards.isEmpty()) {
            return null;
        }
        int randomIndex = random.nextInt(cards.size());
        return cards.get(randomIndex);
    }

    public Card drawCard(String deckName) {
        List<Card> cards = deckData.get(deckName);
        if (cards == null || cards.isEmpty()) {
            return null;
        }
        return cards.remove(0);
    }

    public int getRemainingCards(String deckName) {
        List<Card> cards = deckData.get(deckName);
        return cards == null ? 0 : cards.size();
    }

    public void resetDeck(String deckName) {
        Integer count = placeholderCounts.get(deckName);
        if (count == null) {
            return;
        }
        initializeDeck(deckName, count);
        shuffleDeck(deckName);
    }
}
