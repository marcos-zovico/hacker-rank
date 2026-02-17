# Java Reflection - Attributes

**Problem:** [Java Reflection - Attributes](https://www.hackerrank.com/challenges/java-reflection-attributes/problem)

## Summary

Use reflection to print the names of all attributes (fields and methods) of the Student class in alphabetical order.

## Approach

Get the Class object for Student. getDeclaredMethods() and getDeclaredFields(), or getMethods()/getFields() as required. Collect names, sort, print.

## Solution Details

- Class c = Student.class; Method[] methods = c.getDeclaredMethods(); Arrays.sort(methods, Comparator.comparing(Method::getName)); for (Method m : methods) System.out.println(m.getName()); Similarly for fields if needed.

## Time and Space Complexity

- **Time:** O(n log n), n = number of members
- **Space:** O(n)

## Example

| Input | Output |
|-------|--------|
| (none) | Sorted list of method/field names |
