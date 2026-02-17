# Java Subarray

**Problem:** [Java Subarray](https://www.hackerrank.com/challenges/java-negative-subarray/problem)

## Summary

Count the number of subarrays of a given array whose sum is negative.

## Approach

Enumerate all subarrays [i..j] (i ≤ j). For each, compute the sum and increment a counter if the sum is negative. Sum can be computed in O(1) per subarray using prefix sums.

## Solution Details

- Prefix sum: P[0]=0, P[i]=P[i-1]+arr[i-1]. Subarray [i,j] has sum P[j+1]-P[i]. Double loop over i, j; if P[j+1]-P[i] < 0, count++. Return count.

## Time and Space Complexity

- **Time:** O(n²)
- **Space:** O(n)

## Example

| Input | Output |
|-------|--------|
| 5<br>1 -2 4 -5 1 | 9 |
