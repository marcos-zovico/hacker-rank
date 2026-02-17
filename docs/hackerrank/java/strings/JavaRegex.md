# Java Regex

**Problem:** [Java Regex](https://www.hackerrank.com/challenges/java-regex/problem)

## Summary

Write a regular expression that matches valid IPv4 addresses (four octets, each 0–255, dotted).

## Approach

One pattern for an octet: 0–255. Allow 1–2 digits, or 0xx/1xx, or 2[0-4]d or 25[0-5]. Repeat four times with escaped dots between.

## Solution Details

```java
// Octet: (\\d{1,2}|([01])\\d{2}|2[0-4]\\d|25[0-5])
String ZERO_TO_255 = "(\\d{1,2}|([01])\\d{2}|2[0-4]\\d|25[0-5])";
this.pattern = ZERO_TO_255 + "\\." + ZERO_TO_255 + "\\." + ZERO_TO_255 + "\\." + ZERO_TO_255;
// Use: ip.matches(pattern)
```

## Time and Space Complexity

- **Time:** O(1) per string
- **Space:** O(1)

## Example

| Input | Output |
|-------|--------|
| 000.12.12.034 | true |
| 256.1.2.3 | false |
