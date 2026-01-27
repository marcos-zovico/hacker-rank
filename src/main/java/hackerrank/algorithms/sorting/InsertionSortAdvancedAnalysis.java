package hackerrank.algorithms.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class InsertionSortAdvancedAnalysis {


    class Result {

        /*
         * Complete the 'insertionSort' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts INTEGER_ARRAY arr as parameter.
         */

        private static final int MAXVAL = 10000000;
        private static int[] fenwickTree = new int[MAXVAL + 1];

        public static long insertionSort(List<Integer> arr) {
            int size = arr.size();
            if (size <= 1) {
                return 0;
            }

            Arrays.fill(fenwickTree, 0);
            long sum = 0;
            
            for (int i = 0; i < size; i++) {
                int value = arr.get(i);
                int count = read(value);
                update(value);
                sum += (i - count);
            }
            
            return sum;
        }

        private static int read(int x) {
            int result = 0;
            while (x > 0) {
                result += fenwickTree[x];
                x -= (x & (-x));
            }
            return result;
        }

        private static void update(int x) {
            while (x <= MAXVAL) {
                fenwickTree[x]++;
                x += (x & (-x));
            }
        }

    }


    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int t = Integer.parseInt(bufferedReader.readLine().trim());

            IntStream.range(0, t).forEach(tItr -> {
                try {
                    int n = Integer.parseInt(bufferedReader.readLine().trim());

                    List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                            .map(Integer::parseInt)
                            .collect(toList());
                    if (arr.size() != n) {
                        throw new IllegalArgumentException("Invalid input length");
                    }

                    long result = Result.insertionSort(arr);

                    System.out.println(result);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

            bufferedReader.close();
        }
    }
}
