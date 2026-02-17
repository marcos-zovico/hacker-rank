# Java 2D Array

**Problem:** [Java 2D Array](https://www.hackerrank.com/challenges/java-2d-array/problem)

## Summary

Given a 6×6 2D array, an "hourglass" is a shape of 7 elements (3 in top row, 1 in middle, 3 in bottom row). Find the maximum sum of any hourglass.

## Approach

Iterate over all valid top-left positions (rows 0..3, cols 0..3). For each, sum the 7 elements of the hourglass. Track the maximum sum.

## Solution Details

- For (i, j) with i, j in 0..3: sum = arr[i][j]+arr[i][j+1]+arr[i][j+2] + arr[i+1][j+1] + arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2]. Return max sum.

## Time and Space Complexity

- **Time:** O(1) — fixed 6×6 and 16 hourglasses
- **Space:** O(1)

## Example

| Input | Output |
|-------|--------|
| 6×6 grid | maximum hourglass sum |
