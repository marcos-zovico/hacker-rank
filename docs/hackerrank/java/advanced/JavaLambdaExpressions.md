# Java Lambda Expressions

**Problem:** [Java Lambda Expressions](https://www.hackerrank.com/challenges/java-lambda-expressions/problem)

## Summary

Implement a method that checks numbers or strings: 1) isOdd: n is odd; 2) isPrime: n is prime; 3) isPalindrome: string equals its reverse. The solution uses lambdas that implement a common interface (e.g. performOperation).

## Approach

Define an interface with one method (e.g. boolean check(int) or check(String)). Implement with lambdas: isOdd -> n % 2 != 0; isPrime -> trial division; isPalindrome -> s.equals(new StringBuilder(s).reverse().toString()). Invoke the appropriate lambda based on input.

## Solution Details

- performOperation(1, n) -> (n % 2 != 0); performOperation(2, n) -> isPrime(n); performOperation(3, s) -> s.equals(reverse(s)). Return "EVEN/ODD", "PRIME/COMPOSITE", "PALINDROME" as required.

## Time and Space Complexity

- **Time:** O(sqrt(n)) for prime, O(n) for palindrome
- **Space:** O(1)

## Example

| Input | Output |
|-------|--------|
| 1 4 | EVEN |
| 2 5 | PRIME |
