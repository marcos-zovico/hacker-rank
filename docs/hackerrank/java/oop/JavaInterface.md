# Java Interface

**Problem:** [Java Interface](https://www.hackerrank.com/challenges/java-interface/problem)

## Summary

Implement an AdvancedArithmetic interface with a method divisorSum(int n). Create a Calculator class that implements it: divisorSum returns the sum of all divisors of n.

## Approach

Calculator implements AdvancedArithmetic. divisorSum(n): loop from 1 to n, sum all i where n % i == 0.

## Solution Details

- divisorSum(int n) { int sum = 0; for (int i = 1; i <= n; i++) if (n % i == 0) sum += i; return sum; }

## Time and Space Complexity

- **Time:** O(n)
- **Space:** O(1)

## Example

| Input | Output |
|-------|--------|
| 6 | 12 |
