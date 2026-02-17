# Java Abstract Class

**Problem:** [Java Abstract Class](https://www.hackerrank.com/challenges/java-abstract-class/problem)

## Summary

Given an abstract Book class with abstract setTitle and getTitle, create a concrete MyBook that extends Book and implements setTitle. The main method reads a title and prints it via getTitle.

## Approach

Define MyBook extends Book. Implement setTitle(String) to store the title in a field. Implement getTitle() to return it (or use the abstract getter contract).

## Solution Details

- MyBook extends Book, has String title; setTitle(String s) { this.title = s; }, getTitle() { return title; }. Main: MyBook book = new MyBook(); book.setTitle(sc.nextLine()); System.out.println(book.getTitle()).

## Time and Space Complexity

- **Time:** O(1)
- **Space:** O(n) for title string

## Example

| Input | Output |
|-------|--------|
| A tale of two cities | The title is: A tale of two cities |
