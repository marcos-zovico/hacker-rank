# Palindrome Index

**Problem:** [Palindrome Index](https://www.hackerrank.com/challenges/palindrome-index/problem)

## Summary

Find the index of one character to remove so the string becomes a palindrome; if already a palindrome return −1.

## Approach

If the string is already a palindrome, return −1. Otherwise try removing each index in turn, check if the resulting string is a palindrome, and return the first index that works.

## Solution Details

- **Check:** Reverse the string and compare for equality to test palindrome. For each index i, build string without that character and test if it equals its reverse.

- **Result.palindromeIndex:**

```java
public static int palindromeIndex(String s) {
    int result = -1;
    int length = s.length();

    String reverse = new StringBuilder(s).reverse().toString();

    if (s.equals(reverse)) {
        return result;
    }

    for (int i = 0; i < length; i++) {
        StringBuilder s1 = new StringBuilder(s).deleteCharAt(i);
        StringBuilder s2 = new StringBuilder(s1).reverse();

        if (s1.toString().contentEquals(s2)) {
            return i;
        }
    }
    return result;
}
```

## Time and Space Complexity

- **Time:** O(n²) — n tries, each O(n) for delete and compare
- **Space:** O(n)

## Example

| Input | Output |
|-------|--------|
| aaab | 3 |
| baa | 0 |
