# Java Generics

**Problem:** [Java Generics](https://www.hackerrank.com/challenges/java-generics/problem)

## Summary

Write a single generic method that can print an array of any type (Integer, String, etc.). The method should accept an array and print each element on a new line.

## Approach

Define a generic method `public static <E> void printArray(E[] array)` and iterate over the array, printing each element.

## Solution Details

```java
public static <E> void printArray(E[] array) {
    for (E element : array) {
        System.out.println(element);
    }
}
```

## Time and Space Complexity

- **Time:** O(n)
- **Space:** O(1)

## Example

| Input | Output |
|-------|--------|
| 1 2 3 | 1<br>2<br>3 |
