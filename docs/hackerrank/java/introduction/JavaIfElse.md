# Java If-Else

**Problem:** [Java If-Else](https://www.hackerrank.com/challenges/java-if-else/problem)

## Summary

Given an integer N, print "Weird" or "Not Weird" based on parity and range: odd → Weird; even and in [2,5] → Not Weird; even and in [6,20] → Weird; even and > 20 → Not Weird.

## Approach

Branch on N: check odd first, then even with ranges [2,5], [6,20], or > 20.

## Solution Details

```java
boolean isOdd = N % 2 != 0;
boolean isBtw_2_5 = N >= 2 && N <= 5;
boolean isBtw_6_20 = N >= 6 && N <= 20;
boolean isGth_20 = N > 20;

if (isOdd) System.out.println("Weird");
else if (isBtw_2_5) System.out.println("Not Weird");
else if (isBtw_6_20) System.out.println("Weird");
else if (isGth_20) System.out.println("Not Weird");
```

## Time and Space Complexity

- **Time:** O(1)
- **Space:** O(1)

## Example

| Input | Output |
|-------|--------|
| 3 | Weird |
| 24 | Not Weird |
