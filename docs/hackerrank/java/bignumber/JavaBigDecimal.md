# Java BigDecimal

**Problem:** [Java BigDecimal](https://www.hackerrank.com/challenges/java-bigdecimal/problem)

## Summary

Sort an array of decimal number strings in descending order by numeric value.

## Approach

Sort with a comparator that uses `BigDecimal` so values are compared correctly (e.g. 0.1 vs 0.10, or large decimals).

## Solution Details

```java
Arrays.sort(s, 0, n, (a, b) -> new BigDecimal(b).compareTo(new BigDecimal(a)));
```

- **Descending:** compareTo(b, a) so larger values come first.

## Time and Space Complexity

- **Time:** O(n log n) comparisons; each comparison O(length)
- **Space:** O(n)

## Example

| Input | Output |
|-------|--------|
| 9<br>0.1 0.2 0.3 | 0.3<br>0.2<br>0.1 |
