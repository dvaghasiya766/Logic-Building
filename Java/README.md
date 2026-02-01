# Main.java - Entry Point for Logic Building Practice

## 📋 Overview

`Main.java` serves as the **entry point** for the Logic Building practice project. It demonstrates how to use various utility classes and methods for common programming tasks like reading user input and merging arrays.

---

## 🎯 Purpose

This file showcases:

1. **User Input Handling** - Using the `Reader` utility class
2. **Array Operations** - Using the `MergeTwoArray` utility class
3. **Resource Management** - Proper use of try-with-resources for Scanner

---

## 📦 Dependencies

The Main class imports and uses the following utilities:

| Import                              | Description                                  |
| ----------------------------------- | -------------------------------------------- |
| `java.util.Scanner`                 | Built-in Java class for reading user input   |
| `utils.MergeTwoArray.MergeTwoArray` | Custom utility for merging two sorted arrays |
| `utils.Reader`                      | Custom utility for simplified input reading  |

---

## 💻 Code Walkthrough

### 1. Scanner with Try-With-Resources

```java
try (Scanner scanner = new Scanner(System.in)) {
    // Code here
}
```

**Why?** The `try-with-resources` statement ensures the Scanner is automatically closed after use, preventing resource leaks.

---

### 2. Reading Different Input Types

#### Reading a String

```java
Reader r = new Reader();
String userStringInput = r.readString(scanner, "Enter Your Name: ");
System.out.println(userStringInput);
```

- Creates a `Reader` instance
- Prompts user for their name
- Displays the entered name

#### Reading an Integer

```java
int userIntInput = Reader.readInt(scanner, "Enter Your Age: ");
System.out.println(userIntInput);
```

- Uses **static method** `readInt()` (no instance needed)
- Prompts user for their age
- Displays the entered age

#### Reading a String Array

```java
String[] stringArray = Reader.readStringArr(scanner, "Enter Number Users: ");
System.out.println("String Array: " + java.util.Arrays.toString(stringArray));
```

- Prompts for number of elements, then reads each string
- Prints the entire array

#### Reading an Integer Array

```java
int[] intArray = Reader.readIntArr(scanner, "Enter Number Users: ");
System.out.println("Int Array: " + java.util.Arrays.toString(intArray));
```

- Prompts for number of elements, then reads each integer
- Prints the entire array

---

### 3. Merging Two Sorted Arrays

```java
int[] arr1 = {1, 3, 5, 7, 0, 0, 0};  // Sorted ascending with extra space
int[] arr2 = {2, 4, 6};              // Sorted descending

MergeTwoArray.merge(arr1, arr2, 4, 3);
```

- `arr1` has 4 actual elements + 3 empty slots
- `arr2` has 3 elements
- Merges both into `arr1` in sorted order

**Expected Output:** `[1, 2, 3, 4, 5, 6, 7]`

---

## ▶️ How to Run

### Using Command Line

```bash
# Navigate to Java folder
cd "e:\RKU\Logic Building\Java"

# Compile all Java files
javac Main.java utils/Reader.java utils/MergeTwoArray/MergeTwoArray.java

# Run the Main class
java Main
```

### Sample Execution

```
Enter Your Name: John
John
Enter Your Age: 25
25
Enter Number Users: 3
Enter user 1: Alice
Enter user 2: Bob
Enter user 3: Charlie
String Array: [Alice, Bob, Charlie]
Enter Number Users: 3
Enter number 1: 10
Enter number 2: 20
Enter number 3: 30
Int Array: [10, 20, 30]
[1, 2, 3, 4, 5, 6, 7]
```

---

## 📁 Project Structure

```
Java/
├── Main.java                          ← You are here
├── README.md
└── utils/
    ├── Reader.java                    ← Input utility class
    └── MergeTwoArray/
        ├── MergeTwoArray.java         ← Array merging utility
        └── README.md                  ← Documentation for merge
```

---

## 🔑 Key Learning Points

1. **Try-With-Resources** - Always use for closeable resources like Scanner
2. **Static vs Instance Methods** - `Reader.readInt()` vs `r.readString()`
3. **Modular Code** - Separate utilities for reusability
4. **Package Structure** - Organizing code into logical packages

---

## 📚 Related Files

- [Reader.java](utils/Reader.java) - Input utility methods
- [MergeTwoArray](utils/MergeTwoArray/) - Array merging with documentation
