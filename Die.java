import java.util.Random;

public class Die {
    // Instance variables for die properties
    private int numberOfSides;
    private int currentValue;
    private Random rand;

public Die(int numberOfSides) {
    this.numberOfSides = numberOfSides;
    this.rand = new Random();
    this.currentValue = 1; // Default starting value before the first roll
}   // Getter method for the number of sides
public int getNumberOfSides() {
    return numberOfSides;

}   // Getter method for current face value 
public int getCurrentValue() {
    return currentValue;
}   // Method to roll the die and update the current value
public void roll() {
    // Generate a random value between 1 and numberOfSides because we don't want to start from 0.
    this.currentValue = rand.nextInt(numberOfSides) + 1;

}
}
