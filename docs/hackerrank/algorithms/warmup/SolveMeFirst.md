# Solve Me First

**Problem:** [Solve Me First](https://www.hackerrank.com/challenges/solve-me-first/problem)

## Summary

Return the sum of two integers.

## Approach

Compute and return `a + b`; no extra logic is needed.

## Solution Details

The problem reduces to computing the sum of two integers. There is no constraint on sign or magnitude beyond what fits in the given type.

- **Core function:** The only logic is the sum; no branching or special cases:

```java
static int solveMeFirst(int a, int b) {
    return a + b;
}
```

- **Why this is correct:** The problem statement asks for the sum of two numbers; addition is well-defined and the answer is unique.

## Time and Space Complexity

- **Time:** O(1)
- **Space:** O(1)

## Example

| Input | Output |
|-------|--------|
| `2`, `3` | `5` |
