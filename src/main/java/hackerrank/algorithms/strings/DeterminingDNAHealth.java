package hackerrank.algorithms.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Stream;

public class DeterminingDNAHealth {

    static class Result {

        /**
         * Returns the total health for a single DNA strand.
         * Uses Aho-Corasick for O(|d| + matches) complexity.
         */
        public static long determineDnaHealth(AhoCorasick ac, int first, int last, String d) {
            return ac.calculateHealth(first, last, d);
        }
    }

    /**
     * Aho-Corasick automaton for multi-pattern matching.
     * Complexity: O(|text| + |matches|) per strand.
     */
    static class AhoCorasick {
        private final Node root = new Node();
        private final List<String> genes;
        private final List<Integer> health;

        AhoCorasick(List<String> genes, List<Integer> health) {
            this.genes = genes;
            this.health = health;
            buildTrie();
            buildFailureLinks();
        }

        private void buildTrie() {
            for (int i = 0; i < genes.size(); i++) {
                String gene = genes.get(i);
                if (gene.isEmpty()) continue;
                Node current = root;
                for (int j = 0; j < gene.length(); j++) {
                    char c = gene.charAt(j);
                    current = current.children.computeIfAbsent(c, k -> new Node());
                }
                current.outputs.add(new int[]{i, health.get(i)});
            }
        }

        private void buildFailureLinks() {
            Queue<Node> queue = new ArrayDeque<>();
            for (Node child : root.children.values()) {
                child.fail = root;
                queue.add(child);
            }
            while (!queue.isEmpty()) {
                Node current = queue.poll();
                for (Map.Entry<Character, Node> entry : current.children.entrySet()) {
                    char c = entry.getKey();
                    Node child = entry.getValue();
                    queue.add(child);
                    Node fail = current.fail;
                    while (fail != null && !fail.children.containsKey(c)) {
                        fail = fail.fail;
                    }
                    child.fail = (fail == null) ? root : fail.children.get(c);
                    child.outputs.addAll(child.fail.outputs);
                }
            }
        }

        long calculateHealth(int first, int last, String d) {
            return calculateHealth(first, last, d.toCharArray());
        }

        long calculateHealth(int first, int last, char[] text) {
            long total = 0;
            Node current = root;
            for (char c : text) {
                while (current != null && !current.children.containsKey(c)) {
                    current = current.fail;
                }
                current = (current == null) ? root : current.children.get(c);
                for (int[] out : current.outputs) {
                    int idx = out[0];
                    if (idx >= first && idx <= last) {
                        total += out[1];
                    }
                }
            }
            return total;
        }

        static class Node {
            final Map<Character, Node> children = new HashMap<>();
            Node fail;
            final List<int[]> outputs = new ArrayList<>();
        }
    }

    public static class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            Integer.parseInt(bufferedReader.readLine().trim()); // n

            List<String> genes = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .toList();

            List<Integer> health = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .toList();

            int s = Integer.parseInt(bufferedReader.readLine().trim());

            long minHealth = Long.MAX_VALUE;
            long maxHealth = Long.MIN_VALUE;
            AhoCorasick ac = new AhoCorasick(genes, health);

            for (int i = 0; i < s; i++) {
                String[] parts = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ", 3);
                int first = Integer.parseInt(parts[0]);
                int last = Integer.parseInt(parts[1]);
                String d = parts[2];

                long h = Result.determineDnaHealth(ac, first, last, d);
                minHealth = Math.min(minHealth, h);
                maxHealth = Math.max(maxHealth, h);
            }

            System.out.println(minHealth + " " + maxHealth);

            bufferedReader.close();
        }
    }
}
