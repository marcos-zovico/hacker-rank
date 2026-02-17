# Java List

**Problem:** [Java List](https://www.hackerrank.com/challenges/java-list/problem)

## Summary

Maintain a list of integers. Perform Insert and Delete operations at given indices, then print the final list.

## Approach

Use `ArrayList<Integer>`. For Insert, list.add(index, value). For Delete, list.remove(index). Print the list at the end.

## Solution Details

- Parse initial list. For each operation: "Insert" → list.add(i, e); "Delete" → list.remove(i). Output space-separated list.

## Time and Space Complexity

- **Time:** O(n + m·n) worst case for m operations (insert/delete can shift)
- **Space:** O(n)

## Example

| Input | Output |
|-------|--------|
| 5<br>12 0 1 78 12<br>2<br>Insert 5 23<br>Delete 0 | 0 1 78 12 23 |
