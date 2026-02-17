# Beautiful Binary String

**Problem:** [Beautiful Binary String](https://www.hackerrank.com/challenges/beautiful-binary-string/problem)

## Summary

Find the minimum number of character changes so the binary string contains no substring "010".

## Approach

Scan left to right. Whenever we see "010", change one character (e.g. the middle to '1') and skip past those three positions to avoid overlapping "010"; otherwise advance by one.

## Solution Details

- **Greedy:** Replacing the middle '1' in "010" with '0' gives "000" (no new "010"). Replacing the middle with '1' gives "011". One flip per occurrence is enough. After fixing, skip 3 positions so we don't count the same pattern again.

- **Code:**

```java
for (int i = 0; i < b.length(); ) {
    int endIndex = Math.min(i + 3, b.length());
    String sub = b.substring(i, endIndex);
    if ("010".equals(sub)) {
        minSteps++;
        i += 3;
    } else {
        i++;
    }
}
```

## Time and Space Complexity

- **Time:** O(n)
- **Space:** O(1)

## Example

| Input | Output |
|-------|--------|
| 0101010 | 2 |
| 01100 | 0 |
