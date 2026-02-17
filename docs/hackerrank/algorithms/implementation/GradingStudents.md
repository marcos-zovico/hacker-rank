# Grading Students

**Problem:** [Grading Students](https://www.hackerrank.com/challenges/grading/problem)

## Summary

Round each grade: if the grade is at least 38 and the difference to the next multiple of 5 is at most 2, round up to that multiple; otherwise leave the grade unchanged.

## Approach

For each grade, if it is &lt; 38 return it as is. Otherwise find the next multiple of 5; if the difference is ≤ 2, return that multiple, else return the original grade.

## Solution Details

- **Rule:** Grade &lt; 38 → no round. Grade ≥ 38 → round to next multiple of 5 only if the difference is ≤ 2 (e.g. 38→40, 73→75; 76 stays 76).

- **Entry:** Only grades ≥ 38 go through rounding:

```java
return grades.stream()
        .map(grade -> grade >= 38 ? round(grade) : grade)
        .collect(toList());
```

- **Finding next multiple and steps:** Increment until we hit a multiple of 5 and count steps; round only if steps ≤ 2:

```java
private static Integer round(Integer grade) {
    int roundedGrade = grade;
    int count = 0;
    while (roundedGrade % 5 != 0) {
        roundedGrade++;
        count++;
    }
    if (count <= 2) return roundedGrade;
    return grade;
}
```

- **Behavior:** 38,39 → 40 (1–2 steps); 40 → 40 (0 steps); 73,74 → 75; 76 → 76 (4 steps). No grade is ever lowered.

## Time and Space Complexity

- **Time:** O(n)
- **Space:** O(n) for the result list

## Example

| Input | Output |
|-------|--------|
| [73, 67, 38, 33] | [75, 67, 40, 33] |
