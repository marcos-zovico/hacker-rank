# Insertion Sort Part 1

**Problem:** [Insertion Sort Part 1](https://www.hackerrank.com/challenges/insertionsort1/problem)

## Summary

Perform one step of insertion sort: insert the last element of the array into the sorted prefix to its left, shifting elements right as needed, and print the array after the insertion.

## Approach

Take the rightmost element as the value to insert. Scan from right to left; whenever the value is less than the current element, shift that element right and print. When we find a smaller-or-equal element or reach the start, place the value and print.

## Solution Details

- **Context:** We assume the prefix arr[0..n−2] is already sorted. The last element arr[n−1] is the one we “insert” into that prefix. This is exactly one step of insertion sort: take the rightmost element and merge it into the sorted region to its left.
- **Result.insertionSort1:**

```java
public static void insertionSort1(int n, List<Integer> arr) {
    Integer rightmost = arr.get(n - 1);

    for (int i = n - 1; i >= 0; i--) {

        int num = i > 0 ? arr.get(i - 1) : arr.get(i);

        if (rightmost < num) {
            arr.set(i, num);

            if (i == 0) {
                arr.set(i, rightmost);
                printList(arr);
                break;
            }
            printList(arr);
        }

        if (rightmost > num) {
            arr.set(i, rightmost);
            printList(arr);
            break;
        }
    }
}
```

- **Loop invariant:** We traverse from index n−1 down to 0. At each index i we consider the element to the left (at i−1), or at i=0 we have no left neighbor. The idea: if `rightmost` is less than the element at i−1, that element belongs to the right of the correct position for `rightmost`, so we copy it into cell i (shifting right) and print. If `rightmost` is greater or equal, we have found the insertion point: put `rightmost` at i and stop.
- **Shifting:** When rightmost < arr[i-1], we set arr[i] = arr[i-1], so the larger value moves one step right. We then print the array (as required by the problem). We continue with i moving left; effectively we are opening a “hole” that moves left until we find where rightmost fits.
- **Insertion:** When we find arr[i-1] ≤ rightmost (or we reach i=0), the correct place for rightmost is index i. Set arr[i] = rightmost and print. If we reach i=0 and rightmost is still smaller than all, we set arr[0] = rightmost and print.
- **Output:** The problem asks to print the array after each “shift” and after the final insertion, so we print whenever we modify the array.

## Time and Space Complexity

- **Time:** O(n)
- **Space:** O(1)

## Example

| Input | Output |
|-------|--------|
| n=5, arr=[2,4,6,8,3] | Printed arrays ending with [2,3,4,6,8] |
