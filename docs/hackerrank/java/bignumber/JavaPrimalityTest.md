# Java Primality Test

**Problem:** [Java Primality Test](https://www.hackerrank.com/challenges/java-primality-test/problem)

## Summary

Given a large integer n, determine if it is prime. Print "prime" or "not prime".

## Approach

Use `BigInteger.isProbablePrime(certainty)`. A certainty of 1 is sufficient for the problem’s constraints (no false positives for primes under the given size).

## Solution Details

```java
BigInteger bi = new BigInteger(n);
System.out.println(bi.isProbablePrime(1) ? "prime" : "not prime");
```

- **isProbablePrime(1):** Miller-Rabin style test; 1 gives a fast check that is reliable for the input range.

## Time and Space Complexity

- **Time:** O(log n) or similar for the probabilistic test
- **Space:** O(log n) for the BigInteger

## Example

| Input | Output |
|-------|--------|
| 13 | prime |
| 24 | not prime |
