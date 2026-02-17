# Java Factory Pattern

**Problem:** [Java Factory Pattern](https://www.hackerrank.com/challenges/java-factory/problem)

## Summary

Implement a FoodFactory that returns a Food (Pizza or Cake) based on a string "pizza" or "cake". The getFood method returns the appropriate type.

## Approach

FoodFactory.getFood(String type): if "pizza" return new Pizza(); if "cake" return new Cake(); else return null or throw. Food is an interface; Pizza and Cake implement it.

## Solution Details

- class Pizza implements Food { } class Cake implements Food { }. FoodFactory.getFood(String type) { if ("pizza".equals(type)) return new Pizza(); if ("cake".equals(type)) return new Cake(); return null; }

## Time and Space Complexity

- **Time:** O(1)
- **Space:** O(1)

## Example

| Input | Output |
|-------|--------|
| pizza | Factory returned Pizza |
