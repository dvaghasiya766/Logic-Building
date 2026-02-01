package utils.Factors;

// Factors of a Number
// You are given a positive integer N.
// Your task is to find and return all the factors (divisors) of N.
// A factor of N is a number that divides N completely without leaving any remainder.
// Prerequisite: Loops, Modulus Operator (%)
// Input: A single positive integer N
// Output: Array of integers representing all factors of N
// One-Line Summary: Find all numbers from 1 to N that divide N evenly.
public class Factors {

    /**
     * Finds all factors (divisors) of a given number.
     *
     * @param number - The positive integer to find factors for
     * @return Array containing all factors of the number
     */
    public static int[] Factors(int number) {
        // First pass: Count how many factors exist
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        // Create array of exact size needed
        int[] factors = new int[count];
        int index = 0;

        // Second pass: Store the factors
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index++] = i;
            }
        }

        return factors;
    }
}
