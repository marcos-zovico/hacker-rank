# Java BigInteger

**Problem:** [Java BigInteger](https://www.hackerrank.com/challenges/java-biginteger/problem)

## Summary

Given two very large integers, print their sum and their product.

## Approach

Use `BigInteger` for arbitrary-precision arithmetic. Parse the two lines, then call `add` and `multiply`.

## Solution Details

```java
BigInteger a = new BigInteger(bufferedReader.readLine());
BigInteger b = new BigInteger(bufferedReader.readLine());
System.out.println(a.add(b));
System.out.println(a.multiply(b));
```

## Time and Space Complexity

- **Time:** O(n + m) for add, O(n·m) for multiply (n, m = digit counts)
- **Space:** O(n + m)

## Example

| Input | Output |
|-------|--------|
| 1234<br>20 | 1254<br>24680 |
