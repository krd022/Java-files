import java.util.Scanner;

public class Loops {
    public static void main(String[] args) {

        // a loop that displays a string 99 times
        for (int i = 0; i < 99; i++) {
            System.out.println("This is loop #: " + i);
        }

        // loop displays every odd number from 0 to 99
        for (int i = 1; i <= 99; i += 2) {
            System.out.println("Here is every odd number: " + i);
        }
        // loop that displays every even number from 0 to 99
        for (int i = 0; i <= 99; i += 2) {
            System.out.println("Here is every even number: " + i);
        }
        // Same loop as 3, but in a different way
        for (int i = 0; i <= 99; i++) {
            if (i % 2 == 0) {
                System.out.println("same but different please: " + i);
            }
        }
        // loop that will sum up th odd numbers from 0 to 99, print
        int sumOfOdds = 0;
        for (int i = 1; i <= 99; i += 2) {
            sumOfOdds += i;
        }
        System.out.println("Sum of odd numbers from 0 to 99: " + sumOfOdds);

        // loop that will sum up the even numbers from 0 to 99, print
        int sumOfEvens = 0;
        for (int i = 0; i <= 99; i += 2) {
            sumOfEvens += i;
        }
        System.out.println("Sum of even numbers from 0 to 99: " + sumOfEvens);

        // loop that finds sum of the numbers between two numbers that are given by
        // user, inclusive
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int firstNumber = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int secondNumber = scanner.nextInt();

        int sumBetween = 0;

        for (int i = firstNumber; i <= secondNumber; i++) {
            sumBetween += i;
        }

        System.out.println("Sum of numbers between " + firstNumber + " and " + secondNumber + " is: " + sumBetween);

        scanner.close();

    }

}
