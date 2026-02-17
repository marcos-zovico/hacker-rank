# Java BitSet

**Problem:** [Java BitSet](https://www.hackerrank.com/challenges/java-bitset/problem)

## Summary

Maintain two BitSets of size n. Perform operations: AND, OR, XOR, FLIP, SET on one or both sets. After each operation, print the number of set bits in each BitSet.

## Approach

Use `BitSet B1` and `BitSet B2`. Parse each operation and call the corresponding BitSet method (and, or, xor, flip, set). After each, print B1.cardinality() and B2.cardinality().

## Solution Details

- AND/OR/XOR: B1.and(B2), B1.or(B2), B1.xor(B2). FLIP: B1.flip(index) or B2.flip(index). SET: B1.set(index) or B2.set(index). Cardinality = number of bits set.

## Time and Space Complexity

- **Time:** O(n) per operation
- **Space:** O(n)

## Example

| Input | Output |
|-------|--------|
| 5 4<br>AND 1 2<br>SET 1 4 | 0 0<br>1 0 |
