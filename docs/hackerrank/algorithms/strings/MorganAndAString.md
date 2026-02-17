# Morgan and a String

**Problem:** [Morgan and a String](https://www.hackerrank.com/challenges/morgan-and-a-string/problem)

## Summary

Merge two strings into one lexicographically smallest string by repeatedly taking one character from the front of either string (like two stacks).

## Approach

Greedy: at each step, take the character from whichever string has the smaller next character. When the next characters are equal, compare the remaining suffixes to decide which string to take from (or take in batches to avoid O(n²) when prefixes are long and equal).

## Solution Details

- **When chars differ:** Take from the string whose current character is smaller. When equal, we must look ahead: compare suffixes to see which choice leads to a smaller result. The solution uses `compareAndBatch`: find the first position where the two suffixes differ; if one is lexicographically smaller, take from that string; if one suffix is a prefix of the other, prefer the longer one. Batch multiple characters when possible to avoid quadratic behavior on long equal runs.

- **Result.morganAndString:**

```java
public static String morganAndString(String a, String b) {
    int n = a.length();
    int m = b.length();
    char[] ac = a.toCharArray();
    char[] bc = b.toCharArray();
    char[] out = new char[n + m];
    int i = 0, j = 0;
    int pos = 0;

    while (i < n || j < m) {
        if (i >= n) {
            out[pos++] = bc[j++];
        } else if (j >= m) {
            out[pos++] = ac[i++];
        } else if (ac[i] < bc[j]) {
            out[pos++] = ac[i++];
        } else if (ac[i] > bc[j]) {
            out[pos++] = bc[j++];
        } else {
            int take = compareAndBatch(ac, i, n, bc, j, m, out, pos);
            if (take > 0) {
                for (int t = 0; t < take; t++) {
                    out[pos++] = ac[i++];
                }
            } else {
                for (int t = 0; t < -take; t++) {
                    out[pos++] = bc[j++];
                }
            }
        }
    }
    return new String(out);
}
```

## Time and Space Complexity

- **Time:** O(n + m) with batching
- **Space:** O(n + m)

## Example

| Input | Output |
|-------|--------|
| JACK, DANIEL | DAJACKNIEL |
