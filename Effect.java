import java.util.*;
public class Effect {
    private int BudgetChange;
    private Map<Card, Integer> priceChange;
    private Card playCard;

    public Effect(int budgetChange) {
        this.BudgetChange = budgetChange;
    }

    public int getBudgetChange() {
        return BudgetChange;
    }
}
