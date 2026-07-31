import java.util.Random;

public class DiceRoll {
    private Random random;
    
    public DiceRoll() {
        this.random = new Random();
    }
    
    public int roll() {
        return random.nextInt(20) + 1;
    }
}
