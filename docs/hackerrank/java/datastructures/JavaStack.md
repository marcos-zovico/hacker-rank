# Java Stack

**Problem:** [Java Stack](https://www.hackerrank.com/challenges/java-stack/problem)

## Summary

For each string of parentheses (only () [] {}), determine if it is balanced. Print true or false.

## Approach

Use a stack. Scan left to right: for opening bracket, push; for closing bracket, pop and check it matches. Balanced if stack is empty at the end and we never tried to pop when empty or got a mismatch.

## Solution Details

- Stack<Character>. For char c: if c is opening, push(c). If c is closing: if stack empty return false; if pop() doesn't match c return false. After loop, return stack.isEmpty().

## Time and Space Complexity

- **Time:** O(n) per string
- **Space:** O(n)

## Example

| Input | Output |
|-------|--------|
| ([]) | true |
| ([)] | false |
