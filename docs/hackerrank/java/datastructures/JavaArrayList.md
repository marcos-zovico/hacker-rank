# Java Arraylist

**Problem:** [Java Arraylist](https://www.hackerrank.com/challenges/java-arraylist/problem)

## Summary

Store n lines of variable-length lists of integers. Answer queries: given (x, y), print the element at position y in the x-th line, or "ERROR!" if out of bounds.

## Approach

Use `ArrayList<ArrayList<Integer>>` or `List<List<Integer>>`. For each query, if line index and element index are valid, print the element; else print "ERROR!".

## Solution Details

- Read n, then n lines of space-separated integers into a list of lists. For each query (x, y), check 1 ≤ x ≤ n and 1 ≤ y ≤ list.get(x-1).size(); then print list.get(x-1).get(y-1).

## Time and Space Complexity

- **Time:** O(1) per query
- **Space:** O(total elements)

## Example

| Input | Output |
|-------|--------|
| 2<br>1 2<br>3 4 5<br>2<br>1 1<br>2 3 | 1<br>5 |
