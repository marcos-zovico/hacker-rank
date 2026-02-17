# Time Conversion

**Problem:** [Time Conversion](https://www.hackerrank.com/challenges/time-conversion/problem)

## Summary

Convert a time string from 12-hour AM/PM format to 24-hour format.

## Approach

Use `DateTimeFormatter` to parse the 12-hour string and format it in 24-hour form; midnight and noon are handled correctly by `LocalTime`.

## Solution Details

- **Why not manual math:** Doing hour ± 12 and handling 12→0 for AM/PM is error-prone (e.g. 12:00 AM vs 12:00 PM). Using the time API avoids off-by-one mistakes and keeps the logic in one place.

- **Normalize and parse:** HackerRank gives `07:05:45PM` (no space). We add a space before AM/PM so the pattern `hh:mm:ss a` matches, then parse and format:

```java
public static String timeConversion(String s) {
    s = s.replace("AM", " AM").replace("PM", " PM");
    return LocalTime.parse(s, DateTimeFormatter.ofPattern("hh:mm:ss a", Locale.US))
            .format(DateTimeFormatter.ofPattern("HH:mm:ss"));
}
```

- **Patterns:** Input `hh:mm:ss a` (12-hour); output `HH:mm:ss` (24-hour). Midnight and noon are handled correctly by `LocalTime`.

## Time and Space Complexity

- **Time:** O(1)
- **Space:** O(1)

## Example

| Input | Output |
|-------|--------|
| `07:05:45PM` | `19:05:45` |
| `12:00:00AM` | `00:00:00` |
| `12:00:00PM` | `12:00:00` |
