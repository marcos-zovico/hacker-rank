# hacker-rank

HackerRank challenges solved in Java.

## Implementation & Testing

Each challenge is implemented in Java following the HackerRank structure. Solutions are organized in the `src/main/java` directory, with each challenge containing a `Solution` class that includes the `main` method.

Tests are written using JUnit 5 and located in `src/test/java`, mirroring the source structure. Tests simulate input via `ByteArrayInputStream` and capture output using `system-lambda`. Run all tests:

```bash
./gradlew test
```

Run a single test class:

```bash
./gradlew test --tests 'hackerrank.algorithms.strings.HackerRankInAStringTest'
```

## Algorithms

### Warmup
- [Solve Me First](https://www.hackerrank.com/challenges/solve-me-first/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/algorithms/warmup/SolveMeFirst.java#L7) | 📖 [Explanation](docs/hackerrank/algorithms/warmup/SolveMeFirst.md)
- [Time Conversion](https://www.hackerrank.com/challenges/time-conversion/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/algorithms/warmup/TimeConversion.java#L12) | 📖 [Explanation](docs/hackerrank/algorithms/warmup/TimeConversion.md)

### Implementation
- [Apple and Orange](https://www.hackerrank.com/challenges/apple-and-orange/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/algorithms/implementation/AppleAndOrange.java#L42) | 📖 [Explanation](docs/hackerrank/algorithms/implementation/AppleAndOrange.md)
- [Breaking the Records](https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/algorithms/implementation/BreakingTheRecords.java#L80) | 📖 [Explanation](docs/hackerrank/algorithms/implementation/BreakingTheRecords.md)
- [Grading Students](https://www.hackerrank.com/challenges/grading/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/algorithms/implementation/GradingStudents.java#L50) | 📖 [Explanation](docs/hackerrank/algorithms/implementation/GradingStudents.md)
- [Matrix Layer Rotation](https://www.hackerrank.com/challenges/matrix-rotation-algo/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/algorithms/implementation/MatrixLayerRotation.java#L116) | 📖 [Explanation](docs/hackerrank/algorithms/implementation/MatrixLayerRotation.md)
- [Number Line Jumps](https://www.hackerrank.com/challenges/kangaroo/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/algorithms/implementation/NumberLineJumps.java#L37) | 📖 [Explanation](docs/hackerrank/algorithms/implementation/NumberLineJumps.md)

### Sorting
- [Big Sort](https://www.hackerrank.com/challenges/big-sorting/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/algorithms/sorting/BigSort.java#L35) | 📖 [Explanation](docs/hackerrank/algorithms/sorting/BigSort.md)
- [Insertion Sort Part 1](https://www.hackerrank.com/challenges/insertionsort1/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/algorithms/sorting/InsertionSortPart1.java#L56) | 📖 [Explanation](docs/hackerrank/algorithms/sorting/InsertionSortPart1.md)
- [Insertion Sort Part 2](https://www.hackerrank.com/challenges/insertionsort2/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/algorithms/sorting/InsertionSortPart2.java#L55) | 📖 [Explanation](docs/hackerrank/algorithms/sorting/InsertionSortPart2.md)
- [Insertion Sort Advanced Analysis](https://www.hackerrank.com/challenges/insertion-sort/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/algorithms/sorting/InsertionSortAdvancedAnalysis.java#L28) | 📖 [Explanation](docs/hackerrank/algorithms/sorting/InsertionSortAdvancedAnalysis.md)

### Strings
- [Alternating Characters](https://www.hackerrank.com/challenges/alternating-characters/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/algorithms/strings/AlternatingCharacters.java#L39) | 📖 [Explanation](docs/hackerrank/algorithms/strings/AlternatingCharacters.md)
- [Ashton and String](https://www.hackerrank.com/challenges/ashton-and-string/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/algorithms/strings/AshtonAndString.java#L85) | 📖 [Explanation](docs/hackerrank/algorithms/strings/AshtonAndString.md)
- [Beautiful Binary String](https://www.hackerrank.com/challenges/beautiful-binary-string/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/algorithms/strings/BeautifulBinaryString.java#L36) | 📖 [Explanation](docs/hackerrank/algorithms/strings/BeautifulBinaryString.md)
- [Build a String](https://www.hackerrank.com/challenges/build-a-string/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/algorithms/strings/BuildAString.java#L41) | 📖 [Explanation](docs/hackerrank/algorithms/strings/BuildAString.md)
- [Count Strings](https://www.hackerrank.com/challenges/count-strings/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/algorithms/strings/CountStrings.java#L248) | 📖 [Explanation](docs/hackerrank/algorithms/strings/CountStrings.md)
- [Determining DNA Health](https://www.hackerrank.com/challenges/determining-dna-health/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/algorithms/strings/DeterminingDNAHealth.java#L74) | 📖 [Explanation](docs/hackerrank/algorithms/strings/DeterminingDNAHealth.md)
- [Gridland Provinces](https://www.hackerrank.com/challenges/gridland-provinces/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/algorithms/strings/GridlandProvinces.java#L165) | 📖 [Explanation](docs/hackerrank/algorithms/strings/GridlandProvinces.md)
- [HackerRank in a String!](https://www.hackerrank.com/challenges/hackerrank-in-a-string/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/algorithms/strings/HackerRankInAString.java#L32) | 📖 [Explanation](docs/hackerrank/algorithms/strings/HackerRankInAString.md)
- [Morgan and a String](https://www.hackerrank.com/challenges/morgan-and-a-string/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/algorithms/strings/MorganAndAString.java#L80) | 📖 [Explanation](docs/hackerrank/algorithms/strings/MorganAndAString.md)
- [Palindrome Index](https://www.hackerrank.com/challenges/palindrome-index/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/algorithms/strings/PalindromeIndex.java#L10) | 📖 [Explanation](docs/hackerrank/algorithms/strings/PalindromeIndex.md)
- [String Function Calculation](https://www.hackerrank.com/challenges/string-function-calculation/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/algorithms/strings/StringFunctionCalculation.java#L104) | 📖 [Explanation](docs/hackerrank/algorithms/strings/StringFunctionCalculation.md)
- [String Similarity](https://www.hackerrank.com/challenges/string-similarity/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/algorithms/strings/StringSimilarity.java#L48) | 📖 [Explanation](docs/hackerrank/algorithms/strings/StringSimilarity.md)
- [The Love-Letter Mystery](https://www.hackerrank.com/challenges/the-love-letter-mystery/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/algorithms/strings/TheLoveLetterMystery.java#L36) | 📖 [Explanation](docs/hackerrank/algorithms/strings/TheLoveLetterMystery.md)

## Java
- **Introduction**
  - [Welcome to Java](https://www.hackerrank.com/challenges/welcome-to-java/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/java/introduction/WelcomeToJava.java#L5) | 📖 [Explanation](docs/hackerrank/java/introduction/WelcomeToJava.md)
  - [Java If-Else](https://www.hackerrank.com/challenges/java-if-else/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/java/introduction/JavaIfElse.java#L9) | 📖 [Explanation](docs/hackerrank/java/introduction/JavaIfElse.md)
  - [Java Output Formatting](https://www.hackerrank.com/challenges/java-output-formatting/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/java/introduction/JavaOutputFormatting.java#L7) | 📖 [Explanation](docs/hackerrank/java/introduction/JavaOutputFormatting.md)

- **Strings**
  - [Java String Compare](https://www.hackerrank.com/challenges/java-string-compare/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/java/strings/JavaSubstringComparisons.java#L7) | 📖 [Explanation](docs/hackerrank/java/strings/JavaSubstringComparisons.md)
  - [Java Regex](https://www.hackerrank.com/challenges/java-regex/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/java/strings/JavaRegex.java#L7) | 📖 [Explanation](docs/hackerrank/java/strings/JavaRegex.md)
  - [Java Regex 2 - Duplicate Words](https://www.hackerrank.com/challenges/duplicate-word/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/java/strings/JavaRegex2DuplicateWords.java#L13) | 📖 [Explanation](docs/hackerrank/java/strings/JavaRegex2DuplicateWords.md)
  - [Tag Content Extractor](https://www.hackerrank.com/challenges/tag-content-extractor/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/java/strings/TagContentExtractor.java#L12) | 📖 [Explanation](docs/hackerrank/java/strings/TagContentExtractor.md)
  - [Valid Username Regular Expression](https://www.hackerrank.com/challenges/valid-username-checker/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/java/strings/ValidUsernameRegularExpression.java#L9) | 📖 [Explanation](docs/hackerrank/java/strings/ValidUsernameRegularExpression.md)

- **BigNumber**
  - [Java BigInteger](https://www.hackerrank.com/challenges/java-biginteger/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/java/bignumber/JavaBigInteger.java#L10) | 📖 [Explanation](docs/hackerrank/java/bignumber/JavaBigInteger.md)
  - [Java BigDecimal](https://www.hackerrank.com/challenges/java-bigdecimal/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/java/bignumber/JavaBigDecimal.java#L10) | 📖 [Explanation](docs/hackerrank/java/bignumber/JavaBigDecimal.md)
  - [Java Primality Test](https://www.hackerrank.com/challenges/java-primality-test/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/java/bignumber/JavaPrimalityTest.java#L9) | 📖 [Explanation](docs/hackerrank/java/bignumber/JavaPrimalityTest.md)

- **Data Structures**
  - [Java 1D Array](https://www.hackerrank.com/challenges/java-1d-array-introduction/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/java/datastructures/Java1DArray.java#L7) | 📖 [Explanation](docs/hackerrank/java/datastructures/Java1DArray.md)
  - [Java 1D Array (Part 2)](https://www.hackerrank.com/challenges/java-1d-array/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/java/datastructures/Java1DArrayPart2.java#L26) | 📖 [Explanation](docs/hackerrank/java/datastructures/Java1DArrayPart2.md)
  - [Java 2D Array](https://www.hackerrank.com/challenges/java-2d-array/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/java/datastructures/Java2DArray.java#L15) | 📖 [Explanation](docs/hackerrank/java/datastructures/Java2DArray.md)
  - [Java Subarray](https://www.hackerrank.com/challenges/java-negative-subarray/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/java/datastructures/JavaSubArray.java#L8) | 📖 [Explanation](docs/hackerrank/java/datastructures/JavaSubArray.md)
  - [Java Arraylist](https://www.hackerrank.com/challenges/java-arraylist/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/java/datastructures/JavaArrayList.java#L9) | 📖 [Explanation](docs/hackerrank/java/datastructures/JavaArrayList.md)
  - [Java List](https://www.hackerrank.com/challenges/java-list/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/java/datastructures/JavaList.java#L9) | 📖 [Explanation](docs/hackerrank/java/datastructures/JavaList.md)
  - [Java Map](https://www.hackerrank.com/challenges/phone-book/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/java/datastructures/JavaMap.java#L9) | 📖 [Explanation](docs/hackerrank/java/datastructures/JavaMap.md)
  - [Java HashSet](https://www.hackerrank.com/challenges/java-hashset/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/java/datastructures/JavaHashset.java#L9) | 📖 [Explanation](docs/hackerrank/java/datastructures/JavaHashset.md)
  - [Java Stack](https://www.hackerrank.com/challenges/java-stack/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/java/datastructures/JavaStack.java#L8) | 📖 [Explanation](docs/hackerrank/java/datastructures/JavaStack.md)
  - [Java Dequeue](https://www.hackerrank.com/challenges/java-dequeue/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/java/datastructures/JavaDequeue.java#L12) | 📖 [Explanation](docs/hackerrank/java/datastructures/JavaDequeue.md)
  - [Java BitSet](https://www.hackerrank.com/challenges/java-bitset/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/java/datastructures/JavaBitSet.java#L8) | 📖 [Explanation](docs/hackerrank/java/datastructures/JavaBitSet.md)
  - [Java Priority Queue](https://www.hackerrank.com/challenges/java-priority-queue/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/java/datastructures/JavaPriorityQueue.java#L13) | 📖 [Explanation](docs/hackerrank/java/datastructures/JavaPriorityQueue.md)
  - [Java Sort](https://www.hackerrank.com/challenges/java-sort/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/java/datastructures/JavaSort.java#L11) | 📖 [Explanation](docs/hackerrank/java/datastructures/JavaSort.md)
  - [Java Comparator](https://www.hackerrank.com/challenges/java-comparator/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/java/datastructures/JavaComparator.java#L9) | 📖 [Explanation](docs/hackerrank/java/datastructures/JavaComparator.md)
  - [Java Generics](https://www.hackerrank.com/challenges/java-generics/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/java/datastructures/JavaGenerics.java#L5) | 📖 [Explanation](docs/hackerrank/java/datastructures/JavaGenerics.md)

- **Object Oriented Programming**
  - [Java Inheritance I](https://www.hackerrank.com/challenges/java-inheritance-1/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/java/oop/JavaInheritance1.java#L5) | 📖 [Explanation](docs/hackerrank/java/oop/JavaInheritance1.md)
  - [Java Inheritance II](https://www.hackerrank.com/challenges/java-inheritance-2/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/java/oop/JavaInheritance2.java#L5) | 📖 [Explanation](docs/hackerrank/java/oop/JavaInheritance2.md)
  - [Java Abstract Class](https://www.hackerrank.com/challenges/java-abstract-class/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/java/oop/JavaAbstractClass.java#L7) | 📖 [Explanation](docs/hackerrank/java/oop/JavaAbstractClass.md)
  - [Java Interface](https://www.hackerrank.com/challenges/java-interface/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/java/oop/JavaInterface.java#L7) | 📖 [Explanation](docs/hackerrank/java/oop/JavaInterface.md)
  - [Java Method Overriding](https://www.hackerrank.com/challenges/java-method-overriding/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/java/oop/JavaMethodOverriding.java#L5) | 📖 [Explanation](docs/hackerrank/java/oop/JavaMethodOverriding.md)
  - [Java Method Overriding 2 (Super Keyword)](https://www.hackerrank.com/challenges/java-method-overriding-2-super-keyword/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/java/oop/JavaMethodOverriding2.java#L5) | 📖 [Explanation](docs/hackerrank/java/oop/JavaMethodOverriding2.md)
  - [Java Instanceof keyword](https://www.hackerrank.com/challenges/java-instanceof-keyword/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/java/oop/JavaInstanceofKeyword.java#L10) | 📖 [Explanation](docs/hackerrank/java/oop/JavaInstanceofKeyword.md)
  - [Java Iterator](https://www.hackerrank.com/challenges/java-iterator/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/java/oop/JavaIterator.java#L10) | 📖 [Explanation](docs/hackerrank/java/oop/JavaIterator.md)

- **Exception Handling**
  - [Java Exception Handling (Try-catch)](https://www.hackerrank.com/challenges/java-exception-handling-try-catch/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/java/exceptionhandling/JavaExceptionHandlingTryCatch.java#L7) | 📖 [Explanation](docs/hackerrank/java/exceptionhandling/JavaExceptionHandlingTryCatch.md)
  - [Java Exception Handling](https://www.hackerrank.com/challenges/java-exception-handling/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/java/exceptionhandling/JavaExceptionHandling.java#L7) | 📖 [Explanation](docs/hackerrank/java/exceptionhandling/JavaExceptionHandling.md)

- **Advanced**
  - [Java Varargs - Simple Addition](https://www.hackerrank.com/challenges/simple-addition-varargs/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/java/advanced/JavaVarargsSimpleAddition.java#L11) | 📖 [Explanation](docs/hackerrank/java/advanced/JavaVarargsSimpleAddition.md)
  - [Java Reflection - Attributes](https://www.hackerrank.com/challenges/java-reflection-attributes/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/java/advanced/JavaReflectionAttributes.java#L9) | 📖 [Explanation](docs/hackerrank/java/advanced/JavaReflectionAttributes.md)
  - [Can You Access?](https://www.hackerrank.com/challenges/can-you-access/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/java/advanced/CanYouAccess.java#L8) | 📖 [Explanation](docs/hackerrank/java/advanced/CanYouAccess.md)
  - [Prime Checker](https://www.hackerrank.com/challenges/prime-checker/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/java/advanced/PrimeChecker.java#L12) | 📖 [Explanation](docs/hackerrank/java/advanced/PrimeChecker.md)
  - [Java Factory Pattern](https://www.hackerrank.com/challenges/java-factory/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/java/advanced/JavaFactoryPattern.java#L7) | 📖 [Explanation](docs/hackerrank/java/advanced/JavaFactoryPattern.md)
  - [Java Singleton Pattern](https://www.hackerrank.com/challenges/java-singleton/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/java/advanced/JavaSingletonPattern.java#L7) | 📖 [Explanation](docs/hackerrank/java/advanced/JavaSingletonPattern.md)
  - [Java Visitor Pattern](https://www.hackerrank.com/challenges/java-vistor-pattern/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/java/advanced/JavaVisitorPattern.java#L12) | 📖 [Explanation](docs/hackerrank/java/advanced/JavaVisitorPattern.md)
  - [Java Annotations](https://www.hackerrank.com/challenges/java-annotations/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/java/advanced/JavaAnnotations.java#L12) | 📖 [Explanation](docs/hackerrank/java/advanced/JavaAnnotations.md)
  - [Covariant Return Types](https://www.hackerrank.com/challenges/java-covariance/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/java/advanced/CovariantReturnTypes.java#L9) | 📖 [Explanation](docs/hackerrank/java/advanced/CovariantReturnTypes.md)
  - [Java Lambda Expressions](https://www.hackerrank.com/challenges/java-lambda-expressions/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/java/advanced/JavaLambdaExpressions.java#L10) | 📖 [Explanation](docs/hackerrank/java/advanced/JavaLambdaExpressions.md)
  - [Java MD5](https://www.hackerrank.com/challenges/java-md5/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/java/advanced/JavaMD5.java#L10) | 📖 [Explanation](docs/hackerrank/java/advanced/JavaMD5.md)
  - [Java SHA-256](https://www.hackerrank.com/challenges/sha-256/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/java/advanced/JavaSHA256.java#L9) | 📖 [Explanation](docs/hackerrank/java/advanced/JavaSHA256.md)

## Project Euler
- [Multiples of 3 and 5](https://www.hackerrank.com/challenges/euler001/problem) | ⟨/⟩ [Code](src/main/java/hackerrank/projecteuler/MultiplesOf3And5.java#L7) | 📖 [Explanation](docs/hackerrank/projecteuler/MultiplesOf3And5.md)
