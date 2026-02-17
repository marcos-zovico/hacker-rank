# Java HashSet

**Problem:** [Java HashSet](https://www.hackerrank.com/challenges/java-hashset/problem)

## Summary

Given n pairs (first name, last name), count the number of distinct pairs. Print the count after each pair is processed.

## Approach

Use a `Set<String>` (e.g. HashSet). For each pair, add "first last" to the set. After each add, print set.size().

## Solution Details

- `Set<String> set = new HashSet<>();` For each line, split into first and last, add first + " " + last to set, then System.out.println(set.size()).

## Time and Space Complexity

- **Time:** O(n) average
- **Space:** O(n)

## Example

| Input | Output |
|-------|--------|
| 5<br>john tom<br>john mary<br>john tom<br>mary anna<br>mary anna | 1<br>2<br>2<br>3<br>3 |
