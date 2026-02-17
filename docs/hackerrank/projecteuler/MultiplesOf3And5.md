# Multiples of 3 and 5

**Problem:** [Multiples of 3 and 5](https://www.hackerrank.com/challenges/euler001/problem)

## Summary

Find the sum of all positive integers below n that are multiples of 3 or 5.

## Approach

Sum multiples of 3 below n, plus sum multiples of 5 below n, minus sum multiples of 15 below n (inclusion-exclusion). Use the formula for the sum of an arithmetic progression: count = (n-1)/k multiples of k, sum = k * count * (count+1) / 2.

## Solution Details

- **Inclusion-exclusion:** Multiples of 3 or 5 = multiples of 3 + multiples of 5 - multiples of 15 (to avoid double-counting).

- **Sum of multiples of k below n:** The multiples are k, 2k, 3k, ... up to the largest &lt; n. Number of terms p = (n-1)/k. Sum = k(1+2+...+p) = k·p·(p+1)/2.

```java
private static long sumOfMultiples(int k, int n) {
    long p = (n - 1) / k;
    return k * p * (p + 1) / 2;
}
// Answer: sumOfMultiples(3, n) + sumOfMultiples(5, n) - sumOfMultiples(15, n);
```

## Time and Space Complexity

- **Time:** O(1) per test case
- **Space:** O(1)

## Example

| Input | Output |
|-------|--------|
| 10 | 23 |
| 100 | 2318 |
