
public class Player {
    // Instance variables for player 
    private String name;
    private int score;
    private Die die;

    public Player(String name) {
        this.name = name;
        this.score = 0; // Makes game start with 0 points.
        this.die = null; // This code makes no die assigned to the player until the addDie method is called.
    }
    // Getter methods for player name
    public String getName() {
        return this.name;
    }
    // Getter methods for player score
    public int getScore() {
        return this.score;
    }
    // Setter method for to manually update or reset player score if needed (not used in current game logic but included for potential future use)
    public void setScore(int score) {
        this.score = score;
    }

    public void rollDice() {
        if (this.die != null) {
            this.die.roll();
        } else {
            // In case a roll is attempted without a die (Defensive coding) currently not used
            System.out.println(name + " Have no dice to roll. Please add a die first.");
        }
    }
    // Retrieves the current value of the die after rolling. If no die is assigned, it returns 0.
    public int getDieValue() {
        if (this.die != null) {
            return this.die.getCurrentValue();
        }
        return 0; //  Returns 0 if no die is assigned. Currently not used (Defensive coding)
    }

    public void increaseScore() {
        this.score++;
    }
        // Method to add a die to the player. 
    public void addDie(int numberOfSides) {
        this.die = new Die(numberOfSides);
    }
}