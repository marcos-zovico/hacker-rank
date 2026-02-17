# Java Method Overriding

**Problem:** [Java Method Overriding](https://www.hackerrank.com/challenges/java-method-overriding/problem)

## Summary

Override the getNumberOfTeamMembers method in the Soccer class so it prints "Each team has 11 players in a Soccer Class" (or as specified) instead of the base class message.

## Approach

Soccer extends Sports. Override getNumberOfTeamMembers() to print the required string.

## Solution Details

- class Soccer extends Sports { @Override void getNumberOfTeamMembers() { System.out.println("Each team has 11 players in a Soccer Class"); } }

## Time and Space Complexity

- **Time:** O(1)
- **Space:** O(1)

## Example

| Input | Output |
|-------|--------|
| (none) | Each team has 11 players... |
