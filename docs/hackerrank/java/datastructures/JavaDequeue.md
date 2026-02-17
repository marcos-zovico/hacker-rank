# Java Dequeue

**Problem:** [Java Dequeue](https://www.hackerrank.com/challenges/java-dequeue/problem)

## Summary

Given an array and a window size m, find the maximum number of unique elements in any contiguous subarray of size m.

## Approach

Sliding window of size m. Maintain a map (or multiset) of element counts in the current window. Slide the window: remove leftmost, add rightmost; track distinct count. Return the maximum distinct count over all windows.

## Solution Details

- Use ArrayDeque for the window and a Map<Integer, Integer> for counts. Add first m elements; count distinct. For each slide: decrement/remove count of element leaving, increment count of element entering; update distinct; max = max(max, distinct).

## Time and Space Complexity

- **Time:** O(n)
- **Space:** O(m)

## Example

| Input | Output |
|-------|--------|
| 6 3<br>5 3 5 2 3 2 | 3 |
