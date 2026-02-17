# Java Varargs - Simple Addition

**Problem:** [Java Varargs - Simple Addition](https://www.hackerrank.com/challenges/simple-addition-varargs/problem)

## Summary

Create a class Add with a method add that accepts a variable number of int arguments and prints "n1+n2+n3+...=sum" (e.g. "1+2+3=6").

## Approach

Use varargs: int... numbers. Build the expression string and sum the values. Print "numbers joined by +=result".

## Solution Details

- void add(int... numbers) { int sum = 0; StringBuilder sb = new StringBuilder(); for (int i = 0; i < numbers.length; i++) { if (i > 0) sb.append("+"); sb.append(numbers[i]); sum += numbers[i]; } sb.append("=").append(sum); System.out.println(sb); }

## Time and Space Complexity

- **Time:** O(k), k = number of arguments
- **Space:** O(k)

## Example

| Input | Output |
|-------|--------|
| 1 2 3 | 1+2+3=6 |
