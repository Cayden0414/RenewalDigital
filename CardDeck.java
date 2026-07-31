import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;
import java.util.Random;

public class CardDeck {
    private Map<String, String> deck;
    private List<String> keyList;
    private Random random;
    
    public CardDeck() {
        this.deck = new HashMap<>();
        this.keyList = new ArrayList<>();
        this.random = new Random();
        initializeDeck();
        shuffleDeck();
    }
    
    private void initializeDeck() {
        // Create a list of placeholder titles the user can populate later.
        // Values are left empty for later population.
        deck.clear();
        keyList.clear();
        int placeholderCount = 20; // adjust as needed
        for (int i = 1; i <= placeholderCount; i++) {
            String title = "Placeholder Title " + i;
            deck.put(title, "");
            keyList.add(title);
        }
    }
    
    public void shuffleDeck() {
        Collections.shuffle(keyList, random);
    }
    
    public Map.Entry<String, String> selectRandomCard() {
        if (keyList.isEmpty()) return null;
        int randomIndex = random.nextInt(keyList.size());
        String title = keyList.get(randomIndex);
        return new Map.Entry<String,String>(title, deck.get(title));
    }
    
    public Map.Entry<String, String> drawCard() {
        if (keyList.isEmpty()) {
            return null;
        }
        String title = keyList.remove(0);
        String effects = deck.remove(title);
        return new Map.Entry<String, String>(title, effects);
    }
    
    public int getRemainingCards() {
        return keyList.size();
    }
    
    public void resetDeck() {
        deck.clear();
        keyList.clear();
        initializeDeck();
        shuffleDeck();
    }
}
