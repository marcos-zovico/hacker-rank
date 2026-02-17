# Insertion Sort Part 2

**Problem:** [Insertion Sort Part 2](https://www.hackerrank.com/challenges/insertionsort2/problem)

## Summary

Sort an array using insertion sort and print the array after each element is inserted into the sorted prefix.

## Approach

For each position i from 1 to n−1, treat the prefix [0..i−1] as sorted and insert arr[i] into it (as in Part 1), then print the array. After n−1 such steps, the array is sorted.

## Solution Details

- **Invariant:** After processing index i (where i runs from 1 to n−1), the prefix arr[0..i] is sorted. So we start with arr[0] (one element, trivially sorted) and repeatedly extend the sorted prefix by one element. Code:

```java
for (int i = 1; i < n; i++) {
    sort(i, arr);   // insert arr[i] into sorted arr[0..i-1], same idea as Part 1
    printList(arr);
}
```

- **One insertion per iteration:** For each i from 1 to n−1, we insert arr[i] into the already-sorted arr[0..i−1]. This is the same “insert last element into sorted prefix” as in Part 1: the value to insert is arr[i], and the sorted region is arr[0..i−1]. We shift elements in that region right until we find the slot for arr[i], then write arr[i] there.
- **Implementation detail:** The inner loop can be implemented like Part 1: save the value at i, then from index i down to 1 compare with the element at i−1; if the saved value is smaller, copy arr[i−1] to arr[i] and move the “hole” left; when the saved value is ≥ arr[i−1], put the saved value in the current hole. After this, arr[0..i] is sorted.
- **Print:** After each full insertion (each i), print the entire array. So we see the array evolve from “only first element sorted” to “fully sorted” over n−1 steps.
- **Complexity:** Each insertion in the sorted prefix takes O(i) in the worst case, so total time is O(1 + 2 + … + (n−1)) = O(n²). Space is O(1) aside from the array.

## Time and Space Complexity

- **Time:** O(n²)
- **Space:** O(1)

## Example

| Input | Output |
|-------|--------|
| n=6, arr=[1,4,3,5,6,2] | Printed arrays after each of the 5 insertions |
