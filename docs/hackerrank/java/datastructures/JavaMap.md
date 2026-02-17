# Java Map

**Problem:** [Java Map](https://www.hackerrank.com/challenges/phone-book/problem)

## Summary

Build a phone book: n entries (name, phone number). Then for each query name, print "name=phone" or "Not found".

## Approach

Use a `Map<String, String>` (or Map<String, Long>). Put each name-number pair. For each query, if map.containsKey(name), print name=map.get(name); else print "Not found".

## Solution Details

- `Map<String, String> phoneBook = new HashMap<>();` Read n pairs, put(name, phone). For each query name, get(name) and print or "Not found".

## Time and Space Complexity

- **Time:** O(n + q) average
- **Space:** O(n)

## Example

| Input | Output |
|-------|--------|
| 3<br>uncle sam 999<br>tom 123<br>harry 456<br>uncle sam<br>tom | uncle sam=999<br>tom=123 |
