# Java Priority Queue

**Problem:** [Java Priority Queue](https://www.hackerrank.com/challenges/java-priority-queue/problem)

## Summary

Process events: ENTER name priority (add student to queue; higher priority first, then name order) or SERVED (remove the highest-priority student). Print remaining students in order, or "EMPTY" if none.

## Approach

Use `PriorityQueue` with a comparator: compare by priority descending, then by name ascending. On ENTER, add; on SERVED, poll. At the end, print remaining names or "EMPTY".

## Solution Details

- Comparator: (a, b) -> if priority different then b.priority - a.priority else a.name.compareTo(b.name). After all operations, poll until empty and print names (or collect and print).

## Time and Space Complexity

- **Time:** O(k log n) for k operations, n queue size
- **Space:** O(n)

## Example

| Input | Output |
|-------|--------|
| ENTER John 3<br>SERVED<br>ENTER Mary 3 | Mary |
