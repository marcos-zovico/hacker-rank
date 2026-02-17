# Java Comparator

**Problem:** [Java Comparator](https://www.hackerrank.com/challenges/java-comparator/problem)

## Summary

Sort an array of Player objects: first by score descending, then by name ascending when scores are equal.

## Approach

Implement a Comparator<Player>: compare scores (descending), then names (ascending). Use Arrays.sort(players, comparator).

## Solution Details

- `Comparator<Player> c = (a, b) -> { int sc = Integer.compare(b.score, a.score); if (sc != 0) return sc; return a.name.compareTo(b.name); };` Arrays.sort(players, c);

## Time and Space Complexity

- **Time:** O(n log n)
- **Space:** O(1) for sort

## Example

| Input | Output |
|-------|--------|
| 5<br>amy 100<br>david 100... | Sorted by score desc, name asc |
