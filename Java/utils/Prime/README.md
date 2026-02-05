# PrimeNumber

Description

- Utility class `PrimeNumber` provides a simple method to check primeness and print the result.

Public API

- `void printPrimeStatus(int number)` — prints whether the given integer is prime or not to standard output.

Usage

```java
import utils.Prime.PrimeNumber;

PrimeNumber.printPrimeStatus(17); // prints "17 is a prime number."
```

Recommendations / Improvements

- **Return boolean:** provide `boolean isPrime(int n)` instead of printing, so callers can decide how to present results and it's easier to test.
- **Avoid repeated sqrt computation:** use `for (int i = 2; i * i <= number; i++)` to avoid floating-point calls and rounding issues.
- **Support larger inputs:** consider `long` or `BigInteger` variants for big numbers.
- **Unit tests:** add tests for edge values (<=1, small primes, large composites).
- **Performance:** for repeated checks, consider caching primes or using a sieve for ranges.
