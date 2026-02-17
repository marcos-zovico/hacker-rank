# Alternating Characters

**Problem:** [Alternating Characters](https://www.hackerrank.com/challenges/alternating-characters/problem)

## Summary

Count the minimum number of character deletions so the string has no two adjacent characters that are the same.

## Approach

One pass: whenever the current character equals the previous one, count it as a deletion (we could remove it). The result is the number of consecutive duplicates.

## Solution Details

- **Idea:** We want no adjacent equal characters. So for each run of identical letters we keep one and "delete" the rest. Counting deletions is the same as counting extra consecutive duplicates.

- **Code:** Track the last character; if current equals last, increment count:

```java
char last = '\u0000';
int count = 0;
for (char c : charArray) {
    if (last == c) count++;
    last = c;
}
return count;
```

## Time and Space Complexity

- **Time:** O(n)
- **Space:** O(n) for the char array (or O(1) with charAt)

## Example

| Input | Output |
|-------|--------|
| AABAAB | 2 |
| AAAA | 3 |
