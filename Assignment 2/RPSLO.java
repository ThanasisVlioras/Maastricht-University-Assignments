import java.util.Random;
import java.util.Scanner;

public class RPSLO {

    // Rock = 0, Paper = 1, Scissors = 2, Lizzard = 3, Spock = 4
    // Scissors cut Paper
    // Paper covers Rock
    // Rock crushes Lizard
    // Lizard poisons Spock
    // Spock smashes Scissors
    // Scissors decapitate Lizard
    // Lizard eats Paper
    // Paper disproves Spock
    // Spock vaporizes Rock
    // Rock crushes Scissors

    public static void main(String[] args) {
        System.out.println("Enter your play: R, P, S, L, O");
        Scanner scanner = new Scanner(System.in);
        // Write your code below
        String play = scanner.nextLine();
        play = play.toUpperCase();
        handlePlay(play);
        // Write your code above
    }

    public static void handlePlay(String play) {
        int computerPlayInt = new Random().nextInt(4);
        String[] plays = { "R", "P", "S", "L", "O" };
        String computerPlay = plays[computerPlayInt];

        System.out.println("Computer play is " + computerPlay);

        if (play.equals(computerPlay)) {
            System.out.println("It is a tie!");
            return;
        }

        if (play.equals("R")) {
            if (computerPlay.equals("P"))
                System.out.println("Computer wins!");
            if (computerPlay.equals("S"))
                System.out.println("You win!");
            if (computerPlay.equals("L"))
                System.out.println("You win!");
            if (computerPlay.equals("O"))
                System.out.println("Computer wins!");

            return;
        }

        if (play.equals("P")) {
            if (computerPlay.equals("R"))
                System.out.println("You win!");
            if (computerPlay.equals("S"))
                System.out.println("Computer wins!");
            if (computerPlay.equals("L"))
                System.out.println("Computer wins!");
            if (computerPlay.equals("O"))
                System.out.println("You win!");

            return;
        }

        if (play.equals("S")) {
            if (computerPlay.equals("R"))
                System.out.println("Computer wins!");
            if (computerPlay.equals("P"))
                System.out.println("You win!");
            if (computerPlay.equals("L"))
                System.out.println("You win!");
            if (computerPlay.equals("O"))
                System.out.println("Computer wins!");

            return;
        }

        if (play.equals("L")) {
            if (computerPlay.equals("R"))
                System.out.println("Computer wins!");
            if (computerPlay.equals("P"))
                System.out.println("You win!");
            if (computerPlay.equals("S"))
                System.out.println("Computer wins!");
            if (computerPlay.equals("O"))
                System.out.println("You win!");

            return;
        }

        if (play.equals("O")) {
            if (computerPlay.equals("R"))
                System.out.println("You win!");
            if (computerPlay.equals("P"))
                System.out.println("Computer wins!");
            if (computerPlay.equals("S"))
                System.out.println("You win!");
            if (computerPlay.equals("L"))
                System.out.println("Computer wins");

            return;
        }

        System.out.println("Invalid input (valid inputs: R, P, S, L, O)");
    }
}