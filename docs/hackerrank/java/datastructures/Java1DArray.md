# Java 1D Array

**Problem:** [Java 1D Array](https://www.hackerrank.com/challenges/java-1d-array-introduction/problem)

## Summary

Create an array of n integers and print each element on a new line.

## Approach

Declare an array of size n, read n integers into it, then loop and print each element.

## Solution Details

- Use `int[] a = new int[n];`, read with Scanner/BufferedReader, then `for (int i = 0; i < n; i++) System.out.println(a[i]);`

## Time and Space Complexity

- **Time:** O(n)
- **Space:** O(n)

## Example

| Input | Output |
|-------|--------|
| 5<br>10 20 30 40 50 | 10<br>20<br>30<br>40<br>50 |
