# Prime Checker

**Problem:** [Prime Checker](https://www.hackerrank.com/challenges/prime-checker/problem)

## Summary

Create a Prime class with a checkPrime method that accepts a variable number of int arguments. For each argument, print the number followed by " is prime" or " is not prime" (or similar) depending on primality.

## Approach

Varargs for the numbers. For each number, test if prime (trial division: if n<2 not prime; check divisors from 2 to sqrt(n)). Print the required output format.

## Solution Details

- void checkPrime(int... n) { for (int num : n) { if (isPrime(num)) System.out.print(num + " "); } System.out.println(); } boolean isPrime(int n) { if (n < 2) return false; for (int i = 2; i * i <= n; i++) if (n % i == 0) return false; return true; }

## Time and Space Complexity

- **Time:** O(k sqrt(max))
- **Space:** O(1)

## Example

| Input | Output |
|-------|--------|
| 2 1 3 4 5 | 2 3 5 |
