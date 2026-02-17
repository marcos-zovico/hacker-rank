# Java Output Formatting

**Problem:** [Java Output Formatting](https://www.hackerrank.com/challenges/java-output-formatting/problem)

## Summary

Print three lines of "string int" so that the string is left-justified in 15 characters and the int is zero-padded to 3 digits. Add a header and footer of "================================".

## Approach

Use `printf`: `%-15s` for left-justified string, `%03d` for 3-digit zero-padded integer.

## Solution Details

```java
System.out.println("================================");
System.out.printf("%-15s%03d\n", scanner.next(), scanner.nextInt());
System.out.printf("%-15s%03d\n", scanner.next(), scanner.nextInt());
System.out.printf("%-15s%03d\n", scanner.next(), scanner.nextInt());
System.out.println("================================");
```

- **%-15s:** String, left-aligned, width 15. **%03d:** Integer, at least 3 digits, zero-padded.

## Time and Space Complexity

- **Time:** O(1)
- **Space:** O(1)

## Example

| Input | Output |
|-------|--------|
| java 100<br>cpp 65<br>python 50 | ================================<br>java           100<br>cpp            065<br>python         050<br>================================ |
