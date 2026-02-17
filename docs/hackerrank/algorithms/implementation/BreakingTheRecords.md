# Breaking the Records

**Problem:** [Breaking the Records](https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem)

## Summary

Given a list of scores in order, count how many times the highest score is broken and how many times the lowest score is broken.

## Approach

Walk through the scores once, keeping current min and max. When a score is greater than the current max, increment "max breaks"; when a score is less than the current min, increment "min breaks" and update the record.

## Solution Details

- **Meaning of “break”:** First score sets both records. Later: strictly greater than current max → break high; strictly less than current min → break low. Ties do not count.

- **Result.breakingRecords:**

```java
public static List<Integer> breakingRecords(List<Integer> scores) {
    if (scores == null || scores.isEmpty() || scores.size() == 1) {
        return List.of(0, 0);
    }

    var iterator = scores.iterator();
    int firstScore = iterator.next();
    RecordState state = RecordState.init(firstScore);

    while (iterator.hasNext()) {
        int score = iterator.next();
        state.update(score);
    }

    return List.of(state.maxBreaks(), state.minBreaks());
}
```

## Time and Space Complexity

- **Time:** O(n)
- **Space:** O(1)

## Example

| Input | Output |
|-------|--------|
| [10, 5, 20, 20, 4, 5, 2, 25] | [2, 4] |
