# Java Singleton Pattern

**Problem:** [Java Singleton Pattern](https://www.hackerrank.com/challenges/java-singleton/problem)

## Summary

Implement a singleton class Singleton. The only instance must be obtainable via getSingleInstance(). The constructor must be private.

## Approach

Private static Singleton instance; private constructor; public static getSingleInstance() returns instance, creating it lazily if null (synchronized or double-check locking if required for the problem).

## Solution Details

- private static Singleton instance; private Singleton() {} public static Singleton getSingleInstance() { if (instance == null) instance = new Singleton(); return instance; }

## Time and Space Complexity

- **Time:** O(1)
- **Space:** O(1)

## Example

| Input | Output |
|-------|--------|
| (none) | Same instance from getSingleInstance() |
