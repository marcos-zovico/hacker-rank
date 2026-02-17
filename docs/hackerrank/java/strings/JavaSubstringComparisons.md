# Java String Compare

**Problem:** [Java String Compare](https://www.hackerrank.com/challenges/java-string-compare/problem)

## Summary

Given string s and length k, find the lexicographically smallest and largest substring of length k. Output "smallest\nlargest".

## Approach

Iterate over every substring of length k (indices 0..length-k). Track smallest and largest by string compare; return both.

## Solution Details

```java
String smallest = s.substring(0, k);
String largest = smallest;
for (int i = 0; i < s.length() - k + 1; i++) {
    String sub = s.substring(i, i + k);
    if (sub.compareTo(smallest) < 0) smallest = sub;
    if (sub.compareTo(largest) > 0) largest = sub;
}
return smallest + "\n" + largest;
```

## Time and Space Complexity

- **Time:** O(n · k), n = s.length()
- **Space:** O(k)

## Example

| Input | Output |
|-------|--------|
| welcometojava 3 | ava<br>wel |
