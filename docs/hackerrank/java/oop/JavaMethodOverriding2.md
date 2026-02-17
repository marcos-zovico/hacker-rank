# Java Method Overriding 2 (Super Keyword)

**Problem:** [Java Method Overriding 2 (Super Keyword)](https://www.hackerrank.com/challenges/java-method-overriding-2-super-keyword/problem)

## Summary

Create a MotorCycle class that extends BiCycle. Override the method that returns the string so it returns "Hello I am a motorcycle, I am a cycle with an engine." using super to get the cycle part.

## Approach

MotorCycle extends BiCycle. Override the method (e.g. define()) to return the required string, using super.define() or similar to include the parent message.

## Solution Details

- return "Hello I am a motorcycle, " + super.define(); (or equivalent so the output matches the problem).

## Time and Space Complexity

- **Time:** O(1)
- **Space:** O(1)

## Example

| Input | Output |
|-------|--------|
| (none) | Hello I am a motorcycle, I am a cycle with an engine. |
