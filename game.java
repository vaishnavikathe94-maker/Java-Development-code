import java.util.Random;
import java.util.Scanner;

class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int rounds = 3;                 // You can change number of rounds
        int score = 0;                  // Total score

        System.out.println("===== NUMBER GUESSING GAME =====");
        System.out.println("You have to guess a number between 1 and 100.");

        for (int round = 1; round <= rounds; round++) {

            int randomNumber = rand.nextInt(100) + 1;  // Random number 1–100
            int attempts = 5;                          // Limit number of attempts
            int userGuess = 0;
            boolean guessedCorrectly = false;

            System.out.println("\n--- ROUND " + round + " ---");
            System.out.println("You have " + attempts + " attempts.");

            while (attempts > 0) {

                System.out.print("\nEnter your guess: ");
                userGuess = sc.nextInt();
                attempts--;

                if (userGuess == randomNumber) {
                    System.out.println("🎉 Correct! You guessed the number!");

                    // Points based on attempts left
                    int pointsEarned = attempts + 1;
                    score += pointsEarned;

                    System.out.println("Points for this round: " + pointsEarned);
                    guessedCorrectly = true;
                    break;

                } else if (userGuess > randomNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Too low! Try again.");
                }

                System.out.println("Attempts left: " + attempts);
            }

            if (!guessedCorrectly) {
                System.out.println("\n❌ Out of attempts! The correct number was: " + randomNumber);
            }
        }

        System.out.println("\n===== GAME OVER =====");
        System.out.println("Your final score: " + score);
        System.out.println("Thank you for playing!");
        sc.close();
    }
}
