import java.util.Scanner;

public class DiceGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

     
        System.out.print("Vad heter spelaren? ");
        String name = scanner.nextLine();

        int sides = 0;
        do {
            System.out.print("Hur många sidor ska tärningen ha (4 till 100)? ");
            sides = scanner.nextInt();

            if (sides < 4 || sides > 100) {
                System.out.println("Ogiltigt val! Du måste ange ett tal mellan 4 and 100. Försök igen.");
            }
        } while (sides < 4 || sides > 100);
     

     
        System.out.print("Hur många omgångar ska spelas? ");
        int totalTurns = scanner.nextInt();

        
        Player player = new Player(name);
        player.addDie(sides);

        System.out.println("\nVälkommen " + player.getName() + "! Spelet startar.");
        System.out.println("----------------------------------------");

        for (int turn = 1; turn <= totalTurns; turn++) {
            System.out.println("\n--- Omgång " + turn + " av " + totalTurns + " ---");
            int guessValue = 0;

            do {
                System.out.print("Gissa vad tärningen kommer visa (1 till " + sides + "): ");
                guessValue = scanner.nextInt();

                if (guessValue < 1 || guessValue > sides) {
                    System.out.println("Ogiltig gissning! Ange ett tal mellan 1 och " + sides);
                }
            } while (guessValue < 1 || guessValue > sides);

            player.rollDice();
            int rolledValue = player.getDieValue();

            System.out.println("Du slog: " + rolledValue);

            if (guessValue == rolledValue) {
                System.out.println("Grattis! Du gissade rätt.");
                player.increaseScore();
            } else {
                System.out.println("Tyvärr, din gissning var fel.");
            }

            System.out.println("Nuvarande poäng: " + player.getScore());
        }

        System.out.println("\n----------------------------------------");
        System.out.println("Spelet är slut! " + player.getName() + " fick totalt " + player.getScore() + " poäng.");
        
        scanner.close();
    
    }
}