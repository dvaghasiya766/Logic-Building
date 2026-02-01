
import java.util.Scanner;
import utils.Factor.Factors;
import utils.MergeTwoArray.MergeTwoArray;
import utils.Prime.PrimeNumber;
import utils.Reader;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // All your scanner usage code goes here
            // Reader r = new Reader();

            int[] arr1 = Reader.readIntArr(scanner, "Enter Number of Array 1 Elements: ");
            int[] arr2 = Reader.readIntArr(scanner, "Enter Number of Array 2 Elements: ");

            MergeTwoArray.merge(arr1, arr2, arr1.length - arr2.length, arr2.length);

            int number = Reader.readInt(scanner, "Enter a positive integer to find its factors: ");
            Factors.factor(number);

            int primeNumber = Reader.readInt(scanner, "Enter a positive integer to check if it is prime: ");
            PrimeNumber.printPrimeStatus(primeNumber);
        }
    }
}
