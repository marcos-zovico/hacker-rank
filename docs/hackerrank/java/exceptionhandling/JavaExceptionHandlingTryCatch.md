# Java Exception Handling (Try-catch)

**Problem:** [Java Exception Handling (Try-catch)](https://www.hackerrank.com/challenges/java-exception-handling-try-catch/problem)

## Summary

Read two integers a and b. Compute a/b. If b is 0, catch the exception and print "java.lang.ArithmeticException: / by zero". Otherwise print the integer result.

## Approach

Use try-catch. In try: read a, b and print a/b. Catch ArithmeticException and print the required message.

## Solution Details

- try { int a = sc.nextInt(); int b = sc.nextInt(); System.out.println(a / b); } catch (ArithmeticException e) { System.out.println("java.lang.ArithmeticException: / by zero"); }

## Time and Space Complexity

- **Time:** O(1)
- **Space:** O(1)

## Example

| Input | Output |
|-------|--------|
| 10 0 | java.lang.ArithmeticException: / by zero |
