# Java Inheritance II

**Problem:** [Java Inheritance II](https://www.hackerrank.com/challenges/java-inheritance-2/problem)

## Summary

Create an Arithmetic class with a method that returns the sum of two integers. Create an Adder class that extends Arithmetic. Use Adder to compute the sum.

## Approach

Arithmetic has int add(int a, int b). Adder extends Arithmetic (inherits add). Instantiate Adder and call add.

## Solution Details

- class Arithmetic { int add(int a, int b) { return a + b; } }. class Adder extends Arithmetic { }. Main: Adder a = new Adder(); a.add(...).

## Time and Space Complexity

- **Time:** O(1)
- **Space:** O(1)

## Example

| Input | Output |
|-------|--------|
| 2 3 | 5 |
