package hackerrank.algorithms.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MatrixLayerRotation {

    static class Result {

        /*
         * Complete the 'matrixRotation' function below.
         *
         * The function accepts following parameters:
         *  1. 2D_INTEGER_ARRAY matrix
         *  2. INTEGER r
         */

        public static void matrixRotation(List<List<Integer>> matrix, int r) {
            int m = matrix.size();
            int n = matrix.get(0).size();
            int layers = Math.min(m, n) / 2;
            
            for (int layer = 0; layer < layers; layer++) {
                List<Integer> layerElements = extractLayer(matrix, layer);
                int layerSize = layerElements.size();
                int rotations = r % layerSize;
                
                // Rotate anti-clockwise (shift left)
                List<Integer> rotated = new ArrayList<>();
                for (int i = 0; i < layerSize; i++) {
                    rotated.add(layerElements.get((i + rotations) % layerSize));
                }
                
                placeLayer(matrix, layer, rotated);
            }
            
            printMatrix(matrix);
        }
        
        private static List<Integer> extractLayer(List<List<Integer>> matrix, int layer) {
            int m = matrix.size();
            int n = matrix.get(0).size();
            List<Integer> elements = new ArrayList<>();
            
            // Top row: left to right
            for (int j = layer; j < n - layer; j++) {
                elements.add(matrix.get(layer).get(j));
            }
            
            // Right column: top to bottom (excluding first and last element)
            for (int i = layer + 1; i < m - layer - 1; i++) {
                elements.add(matrix.get(i).get(n - layer - 1));
            }
            
            // Bottom row: right to left (if more than one row)
            if (m - layer - 1 > layer) {
                for (int j = n - layer - 1; j >= layer; j--) {
                    elements.add(matrix.get(m - layer - 1).get(j));
                }
            }
            
            // Left column: bottom to top (excluding first and last element)
            for (int i = m - layer - 2; i > layer; i--) {
                elements.add(matrix.get(i).get(layer));
            }
            
            return elements;
        }
        
        private static void placeLayer(List<List<Integer>> matrix, int layer, List<Integer> elements) {
            int m = matrix.size();
            int n = matrix.get(0).size();
            int idx = 0;
            
            // Top row: left to right
            for (int j = layer; j < n - layer; j++) {
                matrix.get(layer).set(j, elements.get(idx++));
            }
            
            // Right column: top to bottom (excluding first and last element)
            for (int i = layer + 1; i < m - layer - 1; i++) {
                matrix.get(i).set(n - layer - 1, elements.get(idx++));
            }
            
            // Bottom row: right to left (if more than one row)
            if (m - layer - 1 > layer) {
                for (int j = n - layer - 1; j >= layer; j--) {
                    matrix.get(m - layer - 1).set(j, elements.get(idx++));
                }
            }
            
            // Left column: bottom to top (excluding first and last element)
            for (int i = m - layer - 2; i > layer; i--) {
                matrix.get(i).set(layer, elements.get(idx++));
            }
        }
        
        private static void printMatrix(List<List<Integer>> matrix) {
            for (List<Integer> row : matrix) {
                System.out.println(row.stream()
                        .map(String::valueOf)
                        .collect(joining(" ")));
            }
        }

    }

    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int m = Integer.parseInt(firstMultipleInput[0]);

            int n = Integer.parseInt(firstMultipleInput[1]);

            int r = Integer.parseInt(firstMultipleInput[2]);

            List<List<Integer>> matrix = new ArrayList<>();

            IntStream.range(0, m).forEach(i -> {
                try {
                    matrix.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                    .map(Integer::parseInt)
                                    .collect(toList())
                    );
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

            Result.matrixRotation(matrix, r);

            bufferedReader.close();
        }
    }
}
