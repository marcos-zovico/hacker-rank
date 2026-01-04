package hackerrank.algorithms.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class BreakingTheRecords {

    static class RecordState {
        private int min;
        private int max;
        private int minBreaks;
        private int maxBreaks;
        
        private RecordState(int firstScore) {
            this.min = firstScore;
            this.max = firstScore;
            this.minBreaks = 0;
            this.maxBreaks = 0;
        }
        
        static RecordState init(int firstScore) {
            return new RecordState(firstScore);
        }
        
        void update(int score) {
            if (score > max) {
                max = score;
                maxBreaks++;
            } 
            
            if (score < min) {
                min = score;
                minBreaks++;
            }
        }
        
        int minBreaks() {
            return minBreaks;
        }
        
        int maxBreaks() {
            return maxBreaks;
        }
    }

    class Result {

        /*
         * Complete the 'breakingRecords' function below.
         *
         * The function is expected to return an INTEGER_ARRAY.
         * The function accepts INTEGER_ARRAY scores as parameter.
         */

        public static List<Integer> breakingRecords(List<Integer> scores) {
            if (scores == null || scores.isEmpty() || scores.size() == 1) {
                return List.of(0, 0);
            }
            
            var iterator = scores.iterator();
            int firstScore = iterator.next();
            RecordState state = RecordState.init(firstScore);

            while (iterator.hasNext()) {
                int score = iterator.next();
                state.update(score);
            }
            
            return List.of(state.maxBreaks(), state.minBreaks());
        }

    }

    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            bufferedReader.readLine(); // Skip n, not needed

            List<Integer> scores = readLines(bufferedReader)
                    .map(Integer::parseInt)
                    .collect(toList());

            var result = Result.breakingRecords(scores)
                    .stream()
                    .map(Object::toString)
                    .collect(joining(" "));
            
            bufferedReader.close();
            System.out.println(result + "\n");
        }

        private static Stream<String> readLines(BufferedReader bufferedReader) throws IOException {
            return Stream.of(bufferedReader.readLine()
                    .replaceAll("\\s+$", "")
                    .split(" "));
        }
    }

}
