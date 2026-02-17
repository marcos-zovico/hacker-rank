# Count Strings

**Problem:** [Count Strings](https://www.hackerrank.com/challenges/count-strings/problem)

## Summary

Given a regular expression over {a, b} (with concatenation, |, and *) and a length n, count how many strings of length n the regex matches. Output modulo 10^9+7.

## Approach

Parse the regex into an NFA (Thompson construction: symbol, concatenation, |, *). Convert NFA to DFA by subset construction. Count walks of length n in the DFA from start to any accept state using matrix exponentiation: the number of paths is (M^n)[start][accept] summed over accept states.

## Solution Details

- **NFA:** States and transitions; symbol 'a' or 'b' gives a two-state NFA. Or, concat, star combine NFAs with epsilon transitions. parse(regex) builds the NFA recursively.

- **DFA:** Subset construction: each DFA state is a set of NFA states. Start = epsilon-closure({nfa.start}). For each DFA state and symbol c, move = epsilon-closure(move(set, c)). Build transition table next[state][a] and next[state][b].

- **Count:** Let M be the transition matrix (M[i][j] = number of edges from state i to state j). (M^n)[start][j] summed over accept j gives the answer. Use binary exponentiation for M^n modulo MOD.

- **Result.countStrings:**

```java
public static long countStrings(String regex, int len) {
    int[] pos = {0};
    NFA nfa = parse(regex, pos);
    DFA dfa = toDFA(nfa);
    return dfa.count(len);
}
```

## Time and Space Complexity

- **Time:** Depends on regex size and n; matrix exponentiation O(|DFA|^3 log n)
- **Space:** O(|DFA|^2)

## Example

| Input | Output |
|-------|--------|
| ((a\|b)*) 5 | 32 |
