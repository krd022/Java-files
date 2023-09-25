import java.util.Scanner;

public class DataTypeOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // user input and print
        System.out.print("Enter an integer: ");
        int userInputInt = scanner.nextInt();
        System.out.println("Integer: " + userInputInt);

        // double input and print
        System.out.print("Enter a double: ");
        double userInputDouble = scanner.nextDouble();
        System.out.println("Double: " + userInputDouble);

        // char input and print
        System.out.print("Enter a character: ");
        char userInputChar = scanner.next().charAt(0);
        System.out.println("Character: " + userInputChar);
        
        // boolean input and print
        System.out.print("Enter a boolean (true or false): ");
        boolean userInputBoolean = scanner.nextBoolean();
        System.out.println("Boolean: " + userInputBoolean);

        // float input and print
        System.out.print("Enter a float value: ");
        float floatValue = scanner.nextFloat();
        System.out.println("Float: " + floatValue);

        // long input and print
        System.out.print("Enter a long value: ");
        long longValue = scanner.nextLong();
        System.out.println("You entered: " + longValue);

        // short input and print
        System.out.print("Enter a short value: ");
        short shortValue = scanner.nextShort();
        System.out.println("You entered: " + shortValue);



        // operations and input values
        int resultInt = userInputInt + 5;
        double resultDouble = userInputDouble * 2;
        char resultChar = (char) (userInputChar + 1);
        boolean resultBoolean = !userInputBoolean;

        // show results of operations
        System.out.println("Operations on the values:");
        System.out.println("Integer + 5: " + resultInt);
        System.out.println("Double * 2: " + resultDouble);
        System.out.println("Character + 1: " + resultChar);
        System.out.println("Negation of Boolean: " + resultBoolean);

        // logical, relational, and unary operators
        boolean andResult = userInputBoolean && resultBoolean;
        boolean orResult = userInputBoolean || resultBoolean;
        boolean isEqual = userInputInt == (int) userInputDouble;
        boolean notEqual = userInputInt != (int) userInputDouble;
        int unaryIncrement = ++userInputInt;
        int unaryDecrement = --userInputInt;

        // what should print from above operators
        System.out.println("Additional Operations:");
        System.out.println("Logical AND: " + andResult);
        System.out.println("Logical OR: " + orResult);
        System.out.println("Is Equal: " + isEqual);
        System.out.println("Not Equal: " + notEqual);
        System.out.println("Unary Increment: " + unaryIncrement);
        System.out.println("Unary Decrement: " + unaryDecrement);

        scanner.close();
    }
}
