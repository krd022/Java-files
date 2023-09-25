import java.util.Scanner;

public class FlowControl {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();

        int difference = Math.abs(num1 - num2);

        if (difference < 200) {
            // If difference is less than 200, no output, and end the program.
            System.out.println("The difference between the numbers is less than 200. Goodbye.");
        } else {
            int evenAndDivisibleBy4Sum = 0;
            int evenAndDivisibleBy8Sum = 0;
            int notEvenNotDivisibleBy5Sum = 0;

            // switch statement
            for (int i = num1; i <= num2; i++) {
                switch (i % 2) {
                    case 0:
                        // Even numbers
                        if (i % 4 == 0) {
                            evenAndDivisibleBy4Sum += i;
                        }
                        if (i % 8 == 0) {
                            evenAndDivisibleBy8Sum += i;
                        }
                        break;
                    default:
                        // Odd numbers
                        if (i % 5 != 0) {
                            notEvenNotDivisibleBy5Sum += i;
                        }
                        break;
                }
            }

            // while loop to display the sums.
            System.out.println("Sum of even and divisible by 4 numbers: " + evenAndDivisibleBy4Sum);
            System.out.println("Sum of even and divisible by 8 numbers: " + evenAndDivisibleBy8Sum);
            System.out.println("Sum of not even and not divisible by 5 numbers: " + notEvenNotDivisibleBy5Sum);

            //do-while loop to count the numbers between num1 and num2.
            int count = 0;
            int num = num1;
            do {
                count++;
                num++;
            } while (num <= num2);
            System.out.println("Count of numbers between " + num1 + " and " + num2 + ": " + count);
        }

        scanner.close();
    }
}

