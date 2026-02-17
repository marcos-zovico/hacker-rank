# Valid Username Regular Expression

**Problem:** [Valid Username Regular Expression](https://www.hackerrank.com/challenges/valid-username-checker/problem)

## Summary

A valid username: starts with a letter, then only letters, digits, or underscores; length 8–30 (inclusive).

## Approach

Regex: start with [a-zA-Z], then 7–29 characters from [a-zA-Z0-9_]. So total length 8–30.

## Solution Details

```java
public static final String regularExpression = "^[a-zA-Z][a-zA-Z_0-9]{7,29}$";
// Use: userName.matches(UsernameValidator.regularExpression)
```

- **^[a-zA-Z]:** First character must be a letter. **[a-zA-Z_0-9]{7,29}:** Next 7 to 29 characters. **$:** End of string.

## Time and Space Complexity

- **Time:** O(n) per username
- **Space:** O(1)

## Example

| Input | Output |
|-------|--------|
| Julia | Invalid |
| Samantha_21 | Valid |
