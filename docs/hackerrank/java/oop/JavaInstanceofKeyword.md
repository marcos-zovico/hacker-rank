# Java Instanceof keyword

**Problem:** [Java Instanceof keyword](https://www.hackerrank.com/challenges/java-instanceof-keyword/problem)

## Summary

Count how many instances of each type (Student, Rockstar, Hacker) exist in the list. The list can contain instances of these classes and subclasses.

## Approach

Iterate over the list. Use instanceof to check each element. Increment counters for Student, Rockstar, and Hacker. Print the three counts.

## Solution Details

- for (Object o : list) { if (o instanceof Student) studentCount++; else if (o instanceof Rockstar) rockstarCount++; else if (o instanceof Hacker) hackerCount++; } Print the three counts.

## Time and Space Complexity

- **Time:** O(n)
- **Space:** O(1)

## Example

| Input | Output |
|-------|--------|
| List of mixed instances | studentCount, rockstarCount, hackerCount |
