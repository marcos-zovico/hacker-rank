# Big Sort

**Problem:** [Big Sort](https://www.hackerrank.com/challenges/big-sorting/problem)

## Summary

Sort a list of numeric strings that may be too large for primitive integers; output the sorted list.

## Approach

Sort by string length first, then by numeric value for same-length strings. Use BigInteger for correct numeric comparison when lengths are equal.

## Solution Details

- **Why not parse everything to int/long:** The numbers can have up to 10^6 digits, so they do not fit in any primitive. We must either compare as strings or use arbitrary-precision types. Comparing as strings alone is wrong: "9" vs "10" — string compare would put "9" > "10" lexicographically. So we need numeric comparison for same-length strings.
- **Two-level comparison:** (1) If the two strings have different lengths, the shorter one is the smaller number (no leading zeros in the problem). So compare by length first. (2) If the lengths are equal, the strings represent numbers of the same digit count; we must compare them numerically. Using `BigInteger(s1).compareTo(BigInteger(s2))` does exactly that and handles any length.

- **Result.bigSorting:**

```java
public static List<String> bigSorting(List<String> unsorted) {
    return unsorted.stream()
            .sorted((s1, s2) -> {
                if (s1.length() == s2.length()) {
                    return new BigInteger(s1).compareTo(new BigInteger(s2));
                }
                return s1.length() - s2.length();
            }).collect(toList());
}
```

- **Why BigInteger for same length only:** For different lengths we don’t need to parse: e.g. "100" (3 digits) is always greater than "99" (2 digits). So we avoid creating BigIntegers in the common case where lengths differ. When lengths are equal, we have no choice but to compare numerically.
- **Stability:** The problem does not require stable sort. We only need the sorted order; Java’s sort is stable but that doesn’t change the result for distinct values.
- **Edge cases:** Empty list returns empty. Single element is already sorted. Duplicate numeric strings (e.g. "3", "3") keep their relative order with stable sort; both are correct.

## Time and Space Complexity

- **Time:** O(n log n) for comparison sort; each comparison O(len) for length and O(len) for BigInteger.
- **Space:** O(n) for the sorted list; BigInteger temporaries per comparison.

## Example

| Input | Output |
|-------|--------|
| ["6", "31415926535897932384626433832795", "1", "3", "10", "3", "5"] | ["1", "3", "3", "5", "6", "10", "31415926535897932384626433832795"] |
