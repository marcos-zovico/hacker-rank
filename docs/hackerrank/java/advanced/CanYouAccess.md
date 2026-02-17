# Can You Access?

**Problem:** [Can You Access?](https://www.hackerrank.com/challenges/can-you-access/problem)

## Summary

You are given a class with a private inner class and a private method. From the main method (or another class), instantiate the inner class and call the private method (e.g. powerof2) using reflection or by implementing a required interface that the inner class exposes.

## Approach

Use reflection to get the inner class, get its constructor (which may need the outer instance), set accessible, and invoke. Or the problem may require implementing an interface that the inner class checks with instanceof.

## Solution Details

- Get declared inner class from outer Class; get constructor (Outer.class as first parameter); setAccessible(true); newInstance(outerInstance). Then get method "powerof2" and invoke. Or: create an object that implements the required interface so the inner class accepts it.

## Time and Space Complexity

- **Time:** O(1)
- **Space:** O(1)

## Example

| Input | Output |
|-------|--------|
| 8 | 8 is power of 2 |
