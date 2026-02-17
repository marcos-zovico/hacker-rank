# Java Sort

**Problem:** [Java Sort](https://www.hackerrank.com/challenges/java-sort/problem)

## Summary

Sort a list of students by CGPA descending, then by first name ascending, then by id ascending.

## Approach

Implement Comparable on the Student class or use a Comparator. Sort the list with Collections.sort or list.sort.

## Solution Details

- Comparator: compare by cgpa descending (Double.compare(b.cgpa, a.cgpa)), then by name (a.name.compareTo(b.name)), then by id (Integer.compare(a.id, b.id)). students.sort(comparator).

## Time and Space Complexity

- **Time:** O(n log n)
- **Space:** O(n)

## Example

| Input | Output |
|-------|--------|
| 5<br>name id cgpa... | Sorted list by cgpa, name, id |
