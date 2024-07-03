package GuessNumber;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int rounds = 3;
        int totalScore = 0;

        System.out.println("Welcome to Guess the Number!");

        for (int round = 1; round <= rounds; round++) {
            int numberToGuess = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nRound " + round + " of " + rounds);
            System.out.println("I'm thinking of a number between " + minRange + " and " + maxRange);

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess (Attempt " + (attempts + 1) + "/" + maxAttempts + "): ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You've guessed the number!");
                    guessedCorrectly = true;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The number was: " + numberToGuess);
            }

            int roundScore = calculateScore(attempts, maxAttempts);
            totalScore += roundScore;
            System.out.println("Round score: " + roundScore);
        }

        System.out.println("\nGame Over!");
        System.out.println("Total score: " + totalScore);
        scanner.close();
    }

    private static int calculateScore(int attempts, int maxAttempts) {
        if (attempts > maxAttempts) {
            return 0;
        }
        return (maxAttempts - attempts + 1) * 10;
    }
}