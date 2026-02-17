# Gridland Provinces

**Problem:** [Gridland Provinces](https://www.hackerrank.com/challenges/gridland-provinces/problem)

## Summary

A 2×n grid has two rows of characters (provinces). A knight visits every cell exactly once (Hamiltonian path). Count the number of distinct strings formed by concatenating the characters in the order of the path.

## Approach

For small n, enumerate all Hamiltonian paths with DFS and collect distinct strings. For larger n, use a double rolling hash to represent each path string and iterate over possible path shapes (starting cell and direction); compute the hash for each path and add to a set. Two hashes (different bases/mod) reduce collisions.

## Solution Details

- **Small n:** DFS from each (row, col); at each step try moving to an unvisited neighbor (knight or 4-direction depending on problem). When all 2n cells are visited, add path.toString() to a set. Return set size.

- **Large n:** Paths have a specific structure (zigzag between rows). For each starting column and direction, the path is determined. Compute polynomial rolling hash of the string: hash = sum char[i] * base^(position). Use two mods/bases and store (hash1 * MOD2 + hash2) in a set to avoid collisions. process(s1, s2, k, b) computes the hash for one path shape; result.add(...) stores the pair. Reverse rows and repeat to cover all paths.

- **Result.gridlandProvinces:**

```java
public static int gridlandProvinces(String p1, String p2) {
    int n = p1.length();
    if (n < SMALL_N_USE_DFS) {
        return gridlandProvincesDfs(p1, p2);
    }
    result = new HashSet<>();
    char[] c1 = p1.toCharArray();
    char[] c2 = p2.toCharArray();

    for (int i = 0; i < n; i++) {
        process(c1, c2, i, false);
        process(c2, c1, i, false);
        process(c1, c2, i, true);
        process(c2, c1, i, true);
    }
    reverse(c1);
    reverse(c2);
    for (int i = 0; i < n; i++) {
        process(c1, c2, i, false);
        process(c2, c1, i, false);
        process(c1, c2, i, true);
        process(c2, c1, i, true);
    }
    return result.size();
}
```

## Time and Space Complexity

- **Time:** O(2^n) for DFS when n small; O(n²) or similar for hash-based when n large
- **Space:** O(distinct paths)

## Example

| Input | Output |
|-------|--------|
| 2×2 grid with rows "ab", "cd" | number of distinct path strings |
