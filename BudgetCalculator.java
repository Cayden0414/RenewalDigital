import java.util.Scanner;

public class BudgetCalculator {
    private int budget;
    private static final int PLACEHOLDER = 3; // Adjust this value later if needed.

    public BudgetCalculator() {
        this.budget = 5;
    }

    public int calculate(int input) {
        if (input < 1) {
            throw new IllegalArgumentException("Input must be greater than or equal to 1.");
        }

        DiceRoll diceRoll = new DiceRoll();
        int roll = diceRoll.roll();
        int threshold = input + PLACEHOLDER;

        if (roll >= threshold) {
            budget += input;
        } else {
            budget -= input;
        }

        return budget;
    }

    public int getBudget() {
        return budget;
    }

    public static void main(String[] args) {
        BudgetCalculator calculator = new BudgetCalculator();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer input (>= 1): ");
        int input = scanner.nextInt();

        int updatedBudget = calculator.calculate(input);
        System.out.println("New budget: " + updatedBudget);

        scanner.close();
    }
}
