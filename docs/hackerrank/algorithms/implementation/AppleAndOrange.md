# Apple and Orange

**Problem:** [Apple and Orange](https://www.hackerrank.com/challenges/apple-and-orange/problem)

## Summary

Count how many apples and how many oranges fall on the house segment [s, t], given tree positions a and b and each fruit's fall distance.

## Approach

For each fruit, add the tree position to the fall distance to get the landing position; count how many land in [s, t]. Do this separately for apples and oranges.

## Solution Details

- **Landing position:** Apple tree at `a`, each apple falls distance `d` → lands at `a + d`. Orange tree at `b` → lands at `b + d`. House is [s, t]; we count fruits whose landing position satisfies s ≤ p ≤ t.

- **Result.countApplesAndOranges:**

```java
public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
    System.out.println(count(s, t, a, apples));
    System.out.println(count(s, t, b, oranges));
}
```

- **Edge cases:** Inclusive bounds (s and t count). Empty lists → 0.

## Time and Space Complexity

- **Time:** O(m + n), where m = apples, n = oranges
- **Space:** O(1) excluding input

## Example

| Input | Output |
|-------|--------|
| s=7, t=11, a=5, b=15, apples=[-2,2,1], oranges=[5,-6] | 1 apple, 1 orange |
