import java.util.Random;
import java.util.Scanner;

public class MultiplicationMission {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Display the instructions
        System.out.println("Welcome to the Times Table Game!");
        System.out.println("I will show you the multiplication table for a number of your choice.");
        System.out.println("Then, you can take a quiz to test your knowledge.");

        boolean playAgain = true;
        while (playAgain) {
            // Prompt the user for a number
            int number = getNumberFromUser(scanner);

            // Display the multiplication table
            displayMultiplicationTable(number);

            // Quiz
            System.out.println("Let's take a quiz!");
            int correctAnswers = 0;
            for (int i = 0; i < 7; i++) {
                int quizNumber = random.nextInt(10) + 1; // Generate a random number between 1 and 10
                System.out.print("What is " + number + " x " + quizNumber + "? ");
                int userAnswer = scanner.nextInt();
                int correctAnswer = number * quizNumber;
                if (userAnswer == correctAnswer) {
                    System.out.println("Correct!");
                    correctAnswers++;
                } else {
                    System.out.println("Incorrect. The correct answer is " + correctAnswer + ".");
                }
            }

            // Display quiz results
            System.out.println("You got " + correctAnswers + " out of 7 correct.");

            // Ask if the user wants to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next();
            playAgain = playAgainInput.equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing!");
    }

    private static int getNumberFromUser(Scanner scanner) {
        int number = 0;
        while (number <= 0) {
            System.out.print("Enter a number between 1 and 10: ");
            number = scanner.nextInt();
            if (number < 1 || number > 10) {
                System.out.println("Invalid input. Please enter a number between 1 and 10.");
            }
        }
        return number;
    }

    private static void displayMultiplicationTable(int number) {
        System.out.println("Multiplication table for " + number + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));
        }
    }
}