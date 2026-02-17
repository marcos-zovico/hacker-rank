# Java Annotations

**Problem:** [Java Annotations](https://www.hackerrank.com/challenges/java-annotations/problem)

## Summary

Use the @FamilyBudget annotation (with userRole and budgetLimit) to restrict access: if the user role does not match the annotation and the budget is exceeded, print "Budget Limit Over". Otherwise allow the operation.

## Approach

Define the annotation FamilyBudget with userRole and budgetLimit. In the family method (or where the annotation is applied), use reflection to get the annotation and check the current user role and spent amount against the limit.

## Solution Details

- @interface FamilyBudget { String userRole() default "GUEST"; int budgetLimit() default 0; } On the method, getAnnotation(FamilyBudget.class) and compare role and limit with the input.

## Time and Space Complexity

- **Time:** O(1)
- **Space:** O(1)

## Example

| Input | Output |
|-------|--------|
| SENIOR 75 | (allow or Budget Limit Over per rules) |
