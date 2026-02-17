# The Love-Letter Mystery

**Problem:** [The Love-Letter Mystery](https://www.hackerrank.com/challenges/the-love-letter-mystery/problem)

## Summary

Find the minimum number of operations to turn the string into a palindrome. Each operation is to decrease a character by one (a→z not allowed).

## Approach

Compare pairs from both ends. For each pair, the cost to make them equal is the absolute difference of their character values. Sum these costs; no need to actually change the string.

## Solution Details

- **Why absolute difference:** We can only decrease. To make two letters equal we reduce the larger one; the number of steps is |char(i) − char(j)|. We don't need to choose which one to change because we're only counting steps.

- **Result.theLoveLetterMystery:**

```java
public static int theLoveLetterMystery(String s) {
    int minOps = 0;
    String reversed = new StringBuilder(s).reverse().toString();

    if (s.equals(reversed)) {
        return minOps;
    }

    for (int i = 0, j = s.length() - 1; i < s.length() / 2; i++, j--) {
        minOps += Math.abs(s.charAt(i) - s.charAt(j));
    }
    return minOps;
}
```

## Time and Space Complexity

- **Time:** O(n)
- **Space:** O(n) for the reversed string (or O(1) if we only use indices)

## Example

| Input | Output |
|-------|--------|
| abc | 2 |
| cba | 2 |
