# PalindromicScore

Description
- Utility class `PalindromicScore` computes the number of iterations required for a positive integer to become a palindrome by repeatedly adding the number to its reverse.

Public API
- `int calculatePalindromicScore(int number)` — returns the number of addition steps until `number` becomes a palindrome. Uses internal helpers `isPalindrome` and `reverseNumber`.

Usage
```java
import utils.PalindromicScore.PalindromicScore;

int score = PalindromicScore.calculatePalindromicScore(87);
System.out.println("Palindromic score: " + score);
```

Recommendations / Improvements
- **Input validation:** handle negative numbers and zero explicitly (current method assumes positive integers).
- **Iteration limit:** add a max-iteration cap (e.g., 1000) to avoid infinite loops for potential Lychrel candidates.
- **Overflow safety:** use `long` or `BigInteger` for large inputs to prevent integer overflow when reversing/adding.
- **Return vs Print:** keep logic pure (return values) and avoid side-effect printing so behavior is testable.
- **Unit tests:** add unit tests covering edge cases (single-digit numbers, already-palindromes, likely Lychrel candidates).
- **Documentation:** add Javadoc comments to `calculatePalindromicScore`, `isPalindrome`, and `reverseNumber`.

Complexity
- Per iteration: O(d) where d = number of digits; overall depends on iterations until palindrome is reached.
