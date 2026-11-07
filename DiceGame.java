import java.util.Scanner;
    // Main class for the dice game
public class DiceGame {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        // Gathering basic player information and game settings from the user
        System.out.print("Player name: ");
        String name = scanner.nextLine();
        // Determines and validates the size of the die
        int sides = 0;
        do {
            System.out.print("How many sides should the die have (4 to 100)? ");
            if (scanner.hasNextInt()) { // Extra security, to check if the input is a number
                sides = scanner.nextInt(); 
                scanner.nextLine(); // Removes leftover /n (Enter) character from the input buffer
                if (sides < 4 || sides > 100) {
                    System.out.println("Invalid choice! You must enter a number between 4 and 100. Please try again.");
                }
            } else {
                System.out.println("That's not a number! Please try again.");
                scanner.nextLine(); 
            }
    
        } while (sides < 4 || sides > 100);
        // Determines and validates the number of rounds that is going to be played
        int totalTurns = 0;
       do {
            System.out.print("How many rounds should be played? ");
            if (scanner.hasNextInt()) {
                totalTurns = scanner.nextInt();
            
                scanner.nextLine(); 
                if (totalTurns > 100) {

                    System.out.println("\n"+totalTurns+ " is a lot! Are you sure about the number of rounds or you want to change it?");
                    System.out.println("If you are sure, confirm it by inserting Y, otherwise insert another number.");
                    
                    String confirmationControl = scanner.nextLine();

                    if (confirmationControl.equalsIgnoreCase("Y")){
                        
                        System.out.println("You have chosen to play " + totalTurns + " rounds.");

                    } else {
                        
                        totalTurns = Integer.parseInt(confirmationControl);// Reset totalTurns to a new value based on user input
                        
    
                    }
                }
                else if (totalTurns <= 0) {
                    System.out.println("You must play at least 1 round.");
                }
            } else {
                System.out.println("That's not a number! Please try again.");
                scanner.nextLine(); 
            }
        } while (totalTurns <= 0 || totalTurns > 100);
        // Initializes the player object and build their die
        Player player = new Player(name);
        player.addDie(sides);

        System.out.println("\nWelcome " + player.getName() + "! The game starts.");
        System.out.println("----------------------------------------");
        // Main game loop for the specified number of rounds
        for (int turn = 1; turn <= totalTurns; turn++) {
            System.out.println("\n--- Round " + turn + " of " + totalTurns + " ---");
            // Loop to ensure the player makes a valid guess for the die roll
            int guessValue = 0;
            do {
                System.out.print("Guess what the die will show (1 to " + sides + "): ");
                if (scanner.hasNextInt()) {
                    guessValue = scanner.nextInt();
                    scanner.nextLine(); 
                    if (guessValue < 1 || guessValue > sides) {
                        System.out.println("Invalid guess! Please enter a number between 1 and " + sides);
                    }
                } else {
                    System.out.println("That's not a number! Please enter a valid guess.");
                    scanner.nextLine(); 
                }
            } while (guessValue < 1 || guessValue > sides);
            // Rolls the die and retrieves the rolled value
            player.rollDice();
            int rolledValue = player.getDieValue();

            System.out.println("You rolled: " + rolledValue);
            // Checks if the player's guess matches the rolled value and updates the score accordingly
            if (guessValue == rolledValue) {
                System.out.println("Congratulations! You guessed correctly.");
                player.increaseScore();
            } else {
                System.out.println("Sorry, your guess was incorrect.");
            }
            // Displays the current score after each round
            System.out.println("Current score: " + player.getScore());
        }
            // Displays the final score and ends the game
        System.out.println("\n----------------------------------------");
        System.out.println("The game is over! " + player.getName() + " scored a total of " + player.getScore() + " points.\n");
        
        scanner.close(); // Closes the scanner to prevent resource leaks
    }
}