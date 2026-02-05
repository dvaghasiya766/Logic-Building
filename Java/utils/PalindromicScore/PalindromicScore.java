package utils.PalindromicScore;

public class PalindromicScore {

    public static int calculatePalindromicScore(int number) {
        int score = 0;
        while (!isPalindrome(number)) {
            number += reverseNumber(number);
            score++;
        }
        return score;
    }

    private static boolean isPalindrome(int number) {
        int original = number;
        int reversed = 0;
        while (number > 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }
        return original == reversed;
    }

    private static int reverseNumber(int number) {
        int reversed = 0;
        while (number > 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }
        return reversed;
    }
}
