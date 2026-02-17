# String Function Calculation

**Problem:** [String Function Calculation](https://www.hackerrank.com/challenges/string-function-calculation/problem)

## Summary

For each substring s of the given string, define f(s) = (length of s) × (number of times s appears). Find the maximum value of f(s) over all substrings.

## Approach

Build a Suffix Automaton (SAM). Each state corresponds to a set of substrings (those sharing the same end-positions set). For each state, the longest substring has length len; the state’s count (number of occurrences) is computed by propagating counts along suffix links. The maximum of len × count over all states is the answer.

## Solution Details

- **Suffix Automaton:** States have len (length of longest string in the state) and link (suffix link). On extend(c), we create a new state and traverse suffix links to set transitions. Count is set to 1 for the state created at each position; then we sort states by len descending and add count to link state.

- **maxLengthTimesCount:** After building SAM, sort states by len (counting sort). For each state, add its count to count[link[v]]. Then max = max(len[i] * count[i]) over all states.

- **Result.maxValue:**

```java
public static int maxValue(String t) {
    int n = t.length();
    if (n == 0) return 0;
    SuffixAutomaton sam = new SuffixAutomaton(n);
    for (int i = 0; i < n; i++) {
        sam.extend(t.charAt(i) & 0xFF);
    }
    return (int) sam.maxLengthTimesCount();
}
```

## Time and Space Complexity

- **Time:** O(n)
- **Space:** O(n) — at most 2n-1 states

## Example

| Input | Output |
|-------|--------|
| aaaaaa | 12 |
| abcabcddd | 9 |
