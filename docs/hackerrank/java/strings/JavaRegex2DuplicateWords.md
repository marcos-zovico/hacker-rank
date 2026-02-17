# Java Regex 2 - Duplicate Words

**Problem:** [Java Regex 2 - Duplicate Words](https://www.hackerrank.com/challenges/duplicate-word/problem)

## Summary

Remove consecutive duplicate words (case-insensitive); keep the first occurrence of each repeated word.

## Approach

Use regex to find a word followed by one or more spaces and the same word again. Replace each such group with the single word. Pattern: `\b(word)\b(\s+\1\b)+` with case-insensitive flag.

## Solution Details

```java
String REGEX = "(?i)\\b([a-z]+)\\b(?:\\s+\\1\\b)+";
Pattern PATTERN = Pattern.compile(REGEX, Pattern.CASE_INSENSITIVE);
Matcher m = PATTERN.matcher(input);
while (m.find()) {
    input = input.replaceAll(m.group(), m.group(1));
}
```

- **Group 1:** The repeated word. Replace the full match with group(1) to leave one copy.

## Time and Space Complexity

- **Time:** O(n) per line
- **Space:** O(n)

## Example

| Input | Output |
|-------|--------|
| Goodbye bye bye world | Goodbye bye world |
