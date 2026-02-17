# Breaking the Records

**Problem:** [Breaking the Records](https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem)

## Summary

Given a list of scores in order, count how many times the highest score is broken and how many times the lowest score is broken.

## Approach

Walk through the scores once, keeping current min and max. When a score is greater than the current max, increment "max breaks"; when a score is less than the current min, increment "min breaks" and update the record.

## Solution Details

- **Meaning of “break”:** First score sets both records. Later: strictly greater than current max → break high; strictly less than current min → break low. Ties do not count.

- **State:** We keep current min, max, and two break counters. Update logic:

```java
void update(int score) {
    if (score > max) {
        max = score;
        maxBreaks++;
    }
    if (score < min) {
        min = score;
        minBreaks++;
    }
}
```

- **Initialization:** First score defines both records; break counts start at 0:

```java
private RecordState(int firstScore) {
    this.min = firstScore;
    this.max = firstScore;
    this.minBreaks = 0;
    this.maxBreaks = 0;
}
```

- **Single pass:** Iterate over scores, update state, then return [maxBreaks, minBreaks]:

```java
RecordState state = RecordState.init(iterator.next());
while (iterator.hasNext()) {
    state.update(iterator.next());
}
return List.of(state.maxBreaks(), state.minBreaks());
```

- **Edge cases:** null, empty, or size 1 → return `List.of(0, 0)`.

## Time and Space Complexity

- **Time:** O(n)
- **Space:** O(1)

## Example

| Input | Output |
|-------|--------|
| [10, 5, 20, 20, 4, 5, 2, 25] | [2, 4] |
