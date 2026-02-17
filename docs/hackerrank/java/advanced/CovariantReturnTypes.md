# Covariant Return Types

**Problem:** [Covariant Return Types](https://www.hackerrank.com/challenges/java-covariance/problem)

## Summary

Create a Flower class with a String whatsYourName(). Create subclasses Lily and Lotus that override whatsYourName() to return "Lily" and "Lotus". Create regions (e.g. West Bengal, Andhra Pradesh) that return the appropriate flower type.

## Approach

Region has Flower yourNationalFlower(). WestBengal extends Region and returns new Lily(); AndhraPradesh returns new Lotus(). Covariant return: the override can return a subclass of Flower.

## Solution Details

- class Lily extends Flower { String whatsYourName() { return "Lily"; } } class Lotus extends Flower { String whatsYourName() { return "Lotus"; } } WestBengal.yourNationalFlower() returns new Lily(); AndhraPradesh.yourNationalFlower() returns new Lotus(); print flower.whatsYourName().

## Time and Space Complexity

- **Time:** O(1)
- **Space:** O(1)

## Example

| Input | Output |
|-------|--------|
| West Bengal | Lily |
