# Reader Utility Class

A Java utility class for handling various types of user input through the console.

## Package

```java
package utils;
```

## Overview

The `Reader` class provides convenient methods to read different types of user input from the console using a `Scanner` object. It supports reading single values (strings and integers) as well as arrays.

---

## Methods

### `readString(Scanner scanner, String statement)`

Reads a single string (word) from the user.

| Parameter   | Type      | Description                                 |
| ----------- | --------- | ------------------------------------------- |
| `scanner`   | `Scanner` | Scanner object for input                    |
| `statement` | `String`  | Prompt message to display (empty = default) |

**Returns:** `String` - The user's input

**Example:**

```java
Reader r = new Reader();
String name = r.readString(scanner, "Enter Your Name: ");
```

---

### `readInt(Scanner scanner, String statement)` _(static)_

Reads an integer value from the user.

| Parameter   | Type      | Description                                 |
| ----------- | --------- | ------------------------------------------- |
| `scanner`   | `Scanner` | Scanner object for input                    |
| `statement` | `String`  | Prompt message to display (empty = default) |

**Returns:** `int` - The user's integer input

**Example:**

```java
int age = Reader.readInt(scanner, "Enter Your Age: ");
```

---

### `readStringArr(Scanner scanner, String statement)` _(static)_

Reads an array of strings from the user. First prompts for the array length, then prompts for each element.

| Parameter   | Type      | Description                     |
| ----------- | --------- | ------------------------------- |
| `scanner`   | `Scanner` | Scanner object for input        |
| `statement` | `String`  | Prompt message for array length |

**Returns:** `String[]` - Array of strings entered by the user

**Example:**

```java
String[] names = Reader.readStringArr(scanner, "Enter Number of Users: ");
// User enters: 3
// Then enters each name individually
```

---

### `readIntArr(Scanner scanner, String statement)` _(static)_

Reads an array of integers from the user. First prompts for the array length, then prompts for each element.

| Parameter   | Type      | Description                     |
| ----------- | --------- | ------------------------------- |
| `scanner`   | `Scanner` | Scanner object for input        |
| `statement` | `String`  | Prompt message for array length |

**Returns:** `int[]` - Array of integers entered by the user

**Example:**

```java
int[] scores = Reader.readIntArr(scanner, "Enter Number of Scores: ");
// User enters: 5
// Then enters each score individually
```

---

## Complete Usage Example

```java
import java.util.Scanner;
import utils.Reader;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Reader r = new Reader();

            // Read a single string
            String name = r.readString(scanner, "Enter Your Name: ");
            System.out.println("Hello, " + name);

            // Read a single integer
            int age = Reader.readInt(scanner, "Enter Your Age: ");
            System.out.println("You are " + age + " years old");

            // Read an array of strings
            String[] users = Reader.readStringArr(scanner, "How many users? ");
            System.out.println("Users: " + java.util.Arrays.toString(users));

            // Read an array of integers
            int[] numbers = Reader.readIntArr(scanner, "How many numbers? ");
            System.out.println("Numbers: " + java.util.Arrays.toString(numbers));
        }
    }
}
```

---

## Notes

- All methods use a default prompt message if an empty string is provided
- Array methods return an array of size 1 if the user enters a length less than 1
- The `readString` method reads a single word (uses `scanner.next()`)
- Remember to close the `Scanner` when done (use try-with-resources)
