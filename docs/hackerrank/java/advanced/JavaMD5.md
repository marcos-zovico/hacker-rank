# Java MD5

**Problem:** [Java MD5](https://www.hackerrank.com/challenges/java-md5/problem)

## Summary

Given a string, compute its MD5 hash and print the hash as a 32-character hexadecimal string.

## Approach

Use MessageDigest.getInstance("MD5"). Digest the string bytes, then convert the digest bytes to hex (two hex chars per byte).

## Solution Details

- MessageDigest md = MessageDigest.getInstance("MD5"); byte[] digest = md.digest(s.getBytes(StandardCharsets.UTF_8)); Convert each byte to two hex chars (e.g. String.format("%02x", b)) and concatenate. Print the 32-char hex string.

## Time and Space Complexity

- **Time:** O(n), n = input length
- **Space:** O(1) for digest

## Example

| Input | Output |
|-------|--------|
| HelloWorld | 68e109f0f40ca72a15e05cc22786f8e6 |
