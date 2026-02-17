# Java SHA-256

**Problem:** [Java SHA-256](https://www.hackerrank.com/challenges/sha-256/problem)

## Summary

Given a string, compute its SHA-256 hash and print the hash as a 64-character hexadecimal string.

## Approach

Use MessageDigest.getInstance("SHA-256"). Digest the string bytes, then convert the digest to hex (two hex chars per byte, 64 chars total).

## Solution Details

- MessageDigest md = MessageDigest.getInstance("SHA-256"); byte[] digest = md.digest(s.getBytes(StandardCharsets.UTF_8)); StringBuilder hex = new StringBuilder(); for (byte b : digest) hex.append(String.format("%02x", b)); System.out.println(hex);

## Time and Space Complexity

- **Time:** O(n)
- **Space:** O(1) for digest

## Example

| Input | Output |
|-------|--------|
| HelloWorld | 872e4e50ce9990d8b041330c47c9ddd11bec6b503ae9386a99da8584e9bb12c4 |
