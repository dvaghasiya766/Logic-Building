package src;
import java.util.*; // Import utility classes like Scanner

// Reader class to handle user input
class Reader {

    // Method to read a String value from the user
    // scanner   → Scanner object for input
    // statement → Message to display before taking input
    String readString(Scanner scanner, String statement) {

        // If no prompt message is provided, use a default message
        if (statement.length() == 0) {
            statement = "Enter a string: ";
        }

        // Display the prompt message
        System.out.print(statement);

        // Read a single word (string) from the user
        String data = scanner.next();

        // Return the entered string
        return data;
    }

    // Static method to read an integer value from the user
    // scanner   → Scanner object for input
    // statement → Message to display before taking input
    static int readInt(Scanner scanner, String statement) {

        // If no prompt message is provided, use a default message
        if (statement.length() == 0) {
            statement = "Enter an Int: ";
        }

        // Display the prompt message
        System.out.print(statement);

        // Read an integer from the user
        int data = scanner.nextInt();

        // Return the entered integer
        return data;
    }

    static String[] readStringArr(Scanner scanner, String statement) {

        // If no prompt message is provided, use a default message
        if (statement.length() == 0) {
            statement = "Enter a string: ";
        }

        System.out.print(statement);
        int length = scanner.nextInt();
        if (length < 1) {
            String[] arr = new String[1];
            return arr;
        } else {
            String[] arr = new String[length];
            for (int i = 0; i < length; i++) {
                statement = "Enter " + (i + 1) + " Element: ";
                String ele = new Reader().readString(scanner, statement);
                arr[i] = ele;
            }
            return arr;
        }
    }

    static int[] readIntArr(Scanner scanner, String statement) {
        // If no prompt message is provided, use a default message
        if (statement.length() == 0) {
            statement = "Enter a string: ";
        }

        System.out.print(statement);
        int length = scanner.nextInt();
        if (length < 1) {
            int[] arr = new int[1];
            return arr;
        } else {
            int[] arr = new int[length];
            for (int i = 0; i < length; i++) {
                statement = "Enter " + (i + 1) + " Element: ";
                int ele = Reader.readInt(scanner, statement);
                arr[i] = ele;
            }
            return arr;
        }
    }
}
