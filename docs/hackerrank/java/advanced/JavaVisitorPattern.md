# Java Visitor Pattern

**Problem:** [Java Visitor Pattern](https://www.hackerrank.com/challenges/java-vistor-pattern/problem)

## Summary

Tree of nodes (TreeNode): each node has a value and left/right. Implement the Visitor pattern so a visitor can compute a result (e.g. sum of values, or color count) when visiting the tree. Return the result as an int array or as required.

## Approach

Define Visitor interface with visit methods for TreeLeaf and TreeNode. TreeLeaf and TreeNode accept(Visitor v) call v.visit(this). Implement the required visitor(s) that aggregate values (e.g. sum, or count by color) and return the result array.

## Solution Details

- Visitor has visit(TreeLeaf) and visit(TreeNode). Each node type's accept(Visitor v) calls v.visit(this). The solution visitor keeps state (e.g. sum, or list of colors) and returns the required array after traversal.

## Time and Space Complexity

- **Time:** O(n), n = number of nodes
- **Space:** O(h) for recursion, or O(1) for iterative

## Example

| Input | Output |
|-------|--------|
| Tree structure | Result array per problem |
