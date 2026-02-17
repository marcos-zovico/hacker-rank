# Java Exception Handling

**Problem:** [Java Exception Handling](https://www.hackerrank.com/challenges/java-exception-handling/problem)

## Summary

Implement a method long power(int n, int p) that returns n^p. If n or p is negative, throw an exception with message "n or p should not be negative." If both are zero, throw with "n and p should not be zero." Otherwise return n^p.

## Approach

Validate n and p. If either negative, throw Exception with the first message; if both zero, throw with the second. Otherwise compute n^p (use loop or Math.pow and cast to long).

## Solution Details

- if (n < 0 || p < 0) throw new Exception("n or p should not be negative."); if (n == 0 && p == 0) throw new Exception("n and p should not be zero."); long result = 1; for (int i = 0; i < p; i++) result *= n; return result;

## Time and Space Complexity

- **Time:** O(p)
- **Space:** O(1)

## Example

| Input | Output |
|-------|--------|
| 3 4 | 81 |
| -1 2 | Exception: n or p should not be negative. |
