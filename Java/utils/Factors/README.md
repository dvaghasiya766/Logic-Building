# Find Factors of a Number

## 📋 Problem Statement

You are given a **positive integer N**.

**Task:** Find and return all the **factors (divisors)** of N.

A **factor** of N is a number that divides N completely without leaving any remainder.

### Example

```
Input: N = 12

Factors of 12: 1, 2, 3, 4, 6, 12

Output: [1, 2, 3, 4, 6, 12]
```

### More Examples

| Input | Output               | Explanation                             |
| ----- | -------------------- | --------------------------------------- |
| 1     | [1]                  | 1 is divisible only by 1                |
| 7     | [1, 7]               | 7 is a prime number (only 1 and itself) |
| 12    | [1, 2, 3, 4, 6, 12]  | All numbers that divide 12 evenly       |
| 20    | [1, 2, 4, 5, 10, 20] | All numbers that divide 20 evenly       |

---

## 💡 Explanation

### What is a Factor?

A **factor** (or divisor) of a number N is any integer that divides N **exactly** (with no remainder).

For example, for N = 12:

- 12 ÷ 1 = 12 ✓ (no remainder, so 1 is a factor)
- 12 ÷ 2 = 6 ✓ (no remainder, so 2 is a factor)
- 12 ÷ 3 = 4 ✓ (no remainder, so 3 is a factor)
- 12 ÷ 4 = 3 ✓ (no remainder, so 4 is a factor)
- 12 ÷ 5 = 2.4 ✗ (has remainder, so 5 is NOT a factor)
- 12 ÷ 6 = 2 ✓ (no remainder, so 6 is a factor)
- 12 ÷ 7 to 11 = has remainder ✗
- 12 ÷ 12 = 1 ✓ (no remainder, so 12 is a factor)

### Key Observations

1. **1 and N are always factors** of any positive integer N
2. A **prime number** has exactly 2 factors: 1 and itself
3. We check divisibility using the **modulus operator (%)** - if `N % i == 0`, then i is a factor

---

## 🧠 Logic (Step-by-Step)

### Algorithm

1. **Initialize** a counter to track number of factors
2. **Loop from 1 to N**
3. For each number `i`, check if `N % i == 0`
   - If yes → `i` is a factor, increment counter and store it
   - If no → move to next number
4. **Return** the array of factors

### Pseudocode

```
FUNCTION findFactors(N):
    factors = empty array

    FOR i = 1 TO N:
        IF N % i == 0:
            ADD i to factors
        END IF
    END FOR

    RETURN factors
END FUNCTION
```

### Visual Walkthrough

```
Input: N = 12

i = 1:  12 % 1  = 0  ✓ Factor! → factors = [1]
i = 2:  12 % 2  = 0  ✓ Factor! → factors = [1, 2]
i = 3:  12 % 3  = 0  ✓ Factor! → factors = [1, 2, 3]
i = 4:  12 % 4  = 0  ✓ Factor! → factors = [1, 2, 3, 4]
i = 5:  12 % 5  = 2  ✗ Not a factor
i = 6:  12 % 6  = 0  ✓ Factor! → factors = [1, 2, 3, 4, 6]
i = 7:  12 % 7  = 5  ✗ Not a factor
i = 8:  12 % 8  = 4  ✗ Not a factor
i = 9:  12 % 9  = 3  ✗ Not a factor
i = 10: 12 % 10 = 2  ✗ Not a factor
i = 11: 12 % 11 = 1  ✗ Not a factor
i = 12: 12 % 12 = 0  ✓ Factor! → factors = [1, 2, 3, 4, 6, 12]

Output: [1, 2, 3, 4, 6, 12]
```

---

## 💻 Code Implementation

```java
package utils.Factors;

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

    // Main method to test
    public static void main(String[] args) {
        int number = 12;
        int[] result = Factors(number);

        System.out.print("Factors of " + number + ": ");
        System.out.println(java.util.Arrays.toString(result));
        // Output: Factors of 12: [1, 2, 3, 4, 6, 12]
    }
}
```

---

## ⏱️ Time and Space Complexity

| Complexity | Value | Explanation                                                       |
| ---------- | ----- | ----------------------------------------------------------------- |
| **Time**   | O(n)  | We iterate from 1 to N once (or twice in this implementation)     |
| **Space**  | O(k)  | Where k is the number of factors (worst case O(n) for array size) |

### Optimization Note

We can optimize to **O(√n)** by observing that factors come in pairs:

- If `i` is a factor of N, then `N/i` is also a factor
- We only need to check up to √N

---

## 🔑 Key Takeaways

1. **Modulus Operator (%)** - Returns the remainder after division
2. **Factor Definition** - A number that divides N with no remainder
3. **Loop Pattern** - Check each number from 1 to N
4. **Edge Cases** - Handle N = 1 (only factor is 1)

---

## 🎯 Practice Problems

1. Count the number of factors of N
2. Check if N is a prime number (exactly 2 factors)
3. Find the sum of all factors
4. Find all prime factors of N
5. Check if N is a perfect number (sum of factors excluding N equals N)

---

## 📚 Related Concepts

- Prime Numbers
- Greatest Common Divisor (GCD)
- Least Common Multiple (LCM)
- Prime Factorization
