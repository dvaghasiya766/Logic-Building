
import java.util.Scanner;
import myPackage.Reader;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // All your scanner usage code goes here
            Reader r = new Reader();

            // Read a string using the instance method
            String userStringInput = r.readString(scanner, "Enter Your Name: ");
            System.out.println(userStringInput);

            // Read an integer using the static method
            int userIntInput = Reader.readInt(scanner, "Enter Your Age: ");
            System.out.println(userIntInput);

            // Read an array of strings
            String[] stringArray = Reader.readStringArr(scanner, "Enter Number Users: ");
            System.out.println("String Array: " + java.util.Arrays.toString(stringArray));

            // Read an array of integers
            int[] intArray = Reader.readIntArr(scanner, "Enter Number Users: ");
            System.out.println("Int Array: " + java.util.Arrays.toString(intArray));
        }
    }
}
