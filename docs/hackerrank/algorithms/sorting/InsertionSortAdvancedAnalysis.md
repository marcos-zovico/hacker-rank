# Insertion Sort Advanced Analysis

**Problem:** [Insertion Sort Advanced Analysis](https://www.hackerrank.com/challenges/insertion-sort/problem)

## Summary

Compute the number of inversions in an array (pairs (i, j) with i &lt; j and arr[i] &gt; arr[j]). This equals the number of shifts insertion sort would perform.

## Approach

Count inversions using a Fenwick tree (Binary Indexed Tree): process elements from left to right, and for each value count how many larger values have already been seen (prefix sum of "already seen" for indices &gt; value). Then add the value to the tree. The inversion count for the current element is (current index − count of elements already seen that are ≤ value).

## Solution Details

- **Inversions and insertion sort:** An inversion is a pair (i, j) with i < j and arr[i] > arr[j]. Insertion sort shifts an element left once for each larger element that was to its left. So the total number of shifts is exactly the number of inversions. We only need to count inversions.
- **Idea:** Process the array left to right. When we are at index i and value v = arr[i], any element already seen (indices 0..i−1) that is greater than v forms an inversion with (i, v). So for each i, we need to count how many of the already-seen elements have value > v. If we maintain a multiset of values seen so far, “count of elements already seen that are greater than v” is (number of elements seen) − (number of elements seen that are ≤ v). Number of elements seen is i. So we need a data structure that can quickly answer: how many of the values we’ve seen are ≤ x? Then inversions for this step = i − countSeenLeq(v).
- **Fenwick tree (BIT):** We use a Fenwick tree over the value domain [1, MAXVAL]. The tree stores frequencies: after we “add” value x, the tree records one occurrence of x. `read(x)` returns the prefix sum of frequencies for indices 1..x, i.e. how many values in the range [1, x] have been added so far. `update(x)` adds 1 to the frequency at index x (and propagates in the BIT). Both operations are O(log MAXVAL).
- **Algorithm:** Initialize the tree to zeros. For i = 0 to n−1: (1) value v = arr[i]. (2) Inversions involving index i and some j < i with arr[j] > v = number of already-seen values strictly greater than v = i − read(v). Add this to the total. (3) update(v) to record that we have seen one more occurrence of v. After processing all indices, the total is the inversion count.

- **Result.insertionSort:**

```java
public static long insertionSort(List<Integer> arr) {
    int size = arr.size();
    if (size <= 1) {
        return 0;
    }

    Arrays.fill(fenwickTree, 0);
    long sum = 0;

    for (int i = 0; i < size; i++) {
        int value = arr.get(i);
        int count = read(value);
        update(value);
        sum += (i - count);
    }

    return sum;
}
```

- **read/update:** `read(x)` = prefix sum (count of values ≤ x); `update(x)` adds 1 at x. Both use BIT step `x & (-x)`.

- **Why read(v) gives “≤ v”:** The tree stores how many times each value has been “seen.” read(v) is the sum of frequencies for indices 1..v, i.e. count of elements we’ve seen with value ≤ v. So i − read(v) is the count of elements we’ve seen with value > v, which are exactly the inversions (j, i) for j < i.
- **Value range:** The problem states array values are in a bounded range (e.g. up to 10^7). The Fenwick tree is indexed by value, so we need MAXVAL ≥ maximum possible value. The tree size is O(MAXVAL); we reuse the same tree for each test case by resetting it to zero.

## Time and Space Complexity

- **Time:** O(n log MAXVAL)
- **Space:** O(MAXVAL) for the Fenwick tree

## Example

| Input | Output |
|-------|--------|
| [2, 1, 3, 1, 2] | 4 |
