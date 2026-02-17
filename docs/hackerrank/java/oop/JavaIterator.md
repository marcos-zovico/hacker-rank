# Java Iterator

**Problem:** [Java Iterator](https://www.hackerrank.com/challenges/java-iterator/problem)

## Summary

Given a collection of Object elements, use an Iterator to scan and remove any element that is not an Integer, or that is negative. Print the remaining integers in order.

## Approach

Get an Iterator from the collection. While hasNext(), if next() is not an Integer or is negative, remove it (using iterator.remove()). Then iterate again (or use a second pass) to print the remaining elements.

## Solution Details

- Iterator it = collection.iterator(); while (it.hasNext()) { Object e = it.next(); if (!(e instanceof Integer) || (Integer)e < 0) it.remove(); } Then print each element of the collection.

## Time and Space Complexity

- **Time:** O(n)
- **Space:** O(1)

## Example

| Input | Output |
|-------|--------|
| 1 2 -1 3 abc 4 | 1 2 3 4 |
