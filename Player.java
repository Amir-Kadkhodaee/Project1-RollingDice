import java.util.Random;
import java.util.Scanner;
public class Player {

    int DieType; //Pre-defined number of sides for the dice
    int DieValue; //Current value of the dice
    int guessValue = 0; //The value guessed by the player
    int numberOfTurns = 0; //Number of turns taken by the player
    int n = 0; //Counter for the number of turns taken by the player

    Random Random = new Random();

    public String playerName;
    public int playerScore;
    public int typeOfDice;
    

    public Player(String playerName, int playerScore, int typeOfDice) {

        this.playerName = playerName;
        this.playerScore = playerScore;
        this.typeOfDice = typeOfDice;

    }

    public String getPlayerName(){

        Scanner scanner = new Scanner (System.in);
        System.out.print("Please enter player name: ");
        this.playerName = scanner.nextLine();
        scanner.close();
        return this.playerName;

    }

    public int getPlayerScore(){

        return this.playerScore;

    }

    public int getTypeOfDice(){

        Scanner scanner = new Scanner (System.in);
        System.out.print("Please enter type of the die: ");
        this.typeOfDice = scanner.nextInt();
        scanner.close();

        return this.typeOfDice;
    }

    public void setPlayerScore (int playerScore) {

        this.playerScore = playerScore;

    }

    // In case we want to have more than one player, this methos shall be updated to roll the dice for each player.

    public void rollDice() {

        Scanner scanner = new Scanner (System.in);
        do {

            System.out.println("Guess what can be rolled on the dice (1 to " + this.typeOfDice + "): ");
            guessValue = scanner.nextInt();
            scanner.close();

        } while (guessValue < 1 || guessValue > this.typeOfDice); 
        try {

            if (guessValue < 1 || guessValue > this.typeOfDice) {

                throw new IllegalArgumentException("Invalid guess. Please enter a number between 1 and " + this.typeOfDice);
            }

        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());
        }

        n+=1;
        while (n <= numberOfTurns) {

            DieValue = (int)(Math.random() * this.typeOfDice + 1); // Generate a random number between 1 and the number of sides on the die
            System.out.println("You rolled a " + DieValue);

            if (guessValue == DieValue) {

                System.out.println("Congratulations! You guessed correctly.");
                this.playerScore += 1; // Increase score by 1 for correct guess

            } else {

                System.out.println("Sorry, your guess was incorrect.");

            }

            numberOfTurns++; // Number of turns taken by the player increases by 1 if the player has guessed correct number
        }
        
    }

    public int getDieValue(int typeOfDice) {

        int DieValue = (int)(Math.random() * this.typeOfDice + 1); // Generate a random number between 1 and the number of sides on the die

        return DieValue;
    }

    public void increaseScore(int points, int guessValue) {

        if (guessValue == DieValue) {
            this.playerScore += points;
        } 
    }
}
