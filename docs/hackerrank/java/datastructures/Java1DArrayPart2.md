# Java 1D Array (Part 2)

**Problem:** [Java 1D Array (Part 2)](https://www.hackerrank.com/challenges/java-1d-array/problem)

## Summary

Game on a 1D array: move forward or backward by 1, or jump forward by m. Win if you reach past the last index. Some cells are forbidden. Determine if the game can be won.

## Approach

BFS or DFS from the start index. From each cell, try moving back 1, forward 1, or forward m (if valid and not forbidden). Mark visited; if we ever reach an index ≥ n, return YES.

## Solution Details

- State: current index. Transitions: index-1, index+1, index+m (when in bounds and cell not 1). Use a queue or stack and a visited set. Goal: any position ≥ n.

## Time and Space Complexity

- **Time:** O(n)
- **Space:** O(n)

## Example

| Input | Output |
|-------|--------|
| n=5 m=3, array 0 0 0 0 0 | YES |
