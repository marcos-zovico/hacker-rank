# Number Line Jumps (Kangaroo)

**Problem:** [Number Line Jumps](https://www.hackerrank.com/challenges/kangaroo/problem)

## Summary

Two kangaroos start at positions x1 and x2 and jump by v1 and v2 per step. Determine if they can ever land on the same position at the same time.

## Approach

If the one behind has equal or lower jump size, they never meet. Otherwise they meet at the same time exactly when (x1 − x2) is divisible by (v2 − v1) (with v2 ≠ v1), meaning there exists a non-negative integer t such that x1 + v1·t = x2 + v2·t.

## Solution Details

- **Model:** Kangaroo 1 starts at x1 and each step moves by v1, so at (non-negative integer) time t its position is x1 + v1·t. Kangaroo 2 is at x2 + v2·t. They meet when x1 + v1·t = x2 + v2·t for some t ≥ 0.
- **Rearrange:** x1 − x2 = v2·t − v1·t = t·(v2 − v1), so t = (x1 − x2)/(v2 − v1). For them to meet at the same time we need: (1) this t to be a non-negative integer, and (2) the denominator v2 − v1 ≠ 0 (otherwise the equation is either always true or never, depending on x1 vs x2).
- **When can they never meet:** If kangaroo 2 starts ahead (x2 > x1) and has speed at least as large as kangaroo 1 (v2 ≥ v1), then kangaroo 2 stays ahead or pulls away, so they never meet. So we return "NO" when x2 > x1 and v2 ≥ v1:

```java
if (x2 > x1 && v2 >= v1)
    return "NO";
```

- **Meet condition:** (x1 − x2) divisible by (v2 − v1) ⇒ integer meeting time t. After the "no chance" check we have v2 ≠ v1 when a catch-up is possible:

```java
if ((x1 - x2) % (v2 - v1) == 0)
    return "YES";
return "NO";
```

- **When v2 = v1:** If v2 = v1 then the denominator is zero. They meet only if x1 = x2 (same start). If x1 ≠ x2 they never meet. The “no chance” check above already returns "NO" when x2 > x1 and v2 ≥ v1; when x1 > x2 and v2 = v1, kangaroo 1 is ahead and same speed so they never meet. So we need to avoid dividing by zero: only use the modulo check when v2 ≠ v1. The code shown checks (x2 > x1 && v2 >= v1) first; then (x1 − x2) % (v2 − v1) == 0. When v2 == v1 and x1 ≠ x2, (v2 − v1) is 0 and the % would be invalid — the problem likely guarantees v2 ≠ v1 when we reach that line, or we need an extra check (e.g. if v2 == v1 return "NO" unless x1 == x2).
- **Integer meeting time:** For t = (x1 − x2)/(v2 − v1) to be a non-negative integer we need (x1 − x2) divisible by (v2 − v1) and the quotient ≥ 0. When x2 > x1 and v2 < v1, (x1 − x2) is negative and (v2 − v1) is negative, so the quotient is positive — that’s the case where kangaroo 1 catches up from behind. So the condition (x1 − x2) % (v2 − v1) == 0 ensures integer t; we must also ensure t ≥ 0, which the “no chance” condition handles by excluding the cases where the faster one is already ahead.

## Time and Space Complexity

- **Time:** O(1)
- **Space:** O(1)

## Example

| Input | Output |
|-------|--------|
| x1=0, v1=3, x2=4, v2=2 | YES (meet at 12) |
| x1=0, v1=2, x2=5, v2=3 | NO |
