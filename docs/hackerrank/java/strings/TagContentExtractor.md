# Tag Content Extractor

**Problem:** [Tag Content Extractor](https://www.hackerrank.com/challenges/tag-content-extractor/problem)

## Summary

Extract the text content between matching opening and closing XML-like tags (e.g. &lt;tag&gt;content&lt;/tag&gt;). Same tag name must open and close. Output each content on a new line; if none, output "None".

## Approach

Use regex to match &lt;tagName&gt;content&lt;/tagName&gt; where content has no &lt; or &gt;. Pattern: `&lt;(.+)\&gt;([^&lt;&gt;]+)&lt;/\1&gt;`. Group 2 is the content. Find all matches and print group(2).

## Solution Details

```java
String REGEX = "<(.+)>([^<>]+)</\\1>";
Pattern pattern = Pattern.compile(REGEX);
Matcher matcher = pattern.matcher(line);
if (!matcher.find()) {
    System.out.println("None");
} else {
    do {
        System.out.println(matcher.group(2));
    } while (matcher.find());
}
```

- **\\1:** Backreference to the first group (tag name) so closing tag must match.

## Time and Space Complexity

- **Time:** O(n) per line
- **Space:** O(n)

## Example

| Input | Output |
|-------|--------|
| &lt;h1&gt;Hello&lt;/h1&gt; | Hello |
