import java.util.Scanner;

public class creative {
    public static void main(String[] args) {
        // Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        
        // enter a boolean value
        System.out.print("Enter a boolean value (true or false): ");
        
        // Read boolean input
        boolean userInput = scanner.nextBoolean();
        
        // Display input
        System.out.println("You entered: " + userInput);
        
        // negate the boolean value
        boolean negatedValue =  !userInput;
        
        // Display result
        System.out.println("Slept Great: " + negatedValue);
        
        // Close the scanner
        scanner.close();
    }
}