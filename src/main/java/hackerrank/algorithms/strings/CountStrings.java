package hackerrank.algorithms.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * <a href="https://www.hackerrank.com/challenges/count-strings/problem">Count Strings</a>
 * Count strings of length n recognized by a regular expression (a,b only).
 * Uses Thompson NFA construction, subset construction to DFA, and matrix exponentiation.
 */
public class CountStrings {

    private static final long MOD = 1_000_000_007;

    // NFA: list of transitions per state. Transition = (symbol, target). symbol 0 = epsilon.
    static class NFA {
        static final char EPS = 0;
        List<List<int[]>> transitions = new ArrayList<>(); // [state][i] = {symbol, target}
        int start, accept;

        NFA() {
            start = addState();
            accept = addState();
        }

        int addState() {
            int s = transitions.size();
            transitions.add(new ArrayList<>());
            return s;
        }

        void addTransition(int from, char symbol, int to) {
            transitions.get(from).add(new int[]{symbol, to});
        }

        static NFA symbol(char c) {
            NFA nfa = new NFA();
            nfa.addTransition(nfa.start, c, nfa.accept);
            return nfa;
        }

        static NFA or(NFA a, NFA b) {
            NFA nfa = new NFA();
            nfa.importStates(a, nfa);
            nfa.importStates(b, nfa);
            nfa.addTransition(nfa.start, EPS, a.start);
            nfa.addTransition(nfa.start, EPS, b.start);
            nfa.addTransition(a.accept, EPS, nfa.accept);
            nfa.addTransition(b.accept, EPS, nfa.accept);
            return nfa;
        }

        static NFA concat(NFA a, NFA b) {
            NFA nfa = new NFA();
            nfa.importStates(a, nfa);
            nfa.importStates(b, nfa);
            nfa.addTransition(nfa.start, EPS, a.start);
            nfa.addTransition(a.accept, EPS, b.start);
            nfa.addTransition(b.accept, EPS, nfa.accept);
            return nfa;
        }

        static NFA star(NFA a) {
            NFA nfa = new NFA();
            nfa.importStates(a, nfa);
            nfa.addTransition(nfa.start, EPS, nfa.accept);
            nfa.addTransition(nfa.start, EPS, a.start);
            nfa.addTransition(a.accept, EPS, a.start);
            nfa.addTransition(a.accept, EPS, nfa.accept);
            return nfa;
        }

        void importStates(NFA other, NFA into) {
            int shift = into.transitions.size();
            for (List<int[]> trans : other.transitions) {
                int s = into.addState();
                for (int[] t : trans) {
                    into.addTransition(s, (char) t[0], t[1] + shift);
                }
            }
            other.start += shift;
            other.accept += shift;
        }

        Set<Integer> epsilonClosure(Set<Integer> set) {
            Set<Integer> result = new HashSet<>(set);
            Queue<Integer> q = new ArrayDeque<>(result);
            while (!q.isEmpty()) {
                int s = q.poll();
                for (int[] t : transitions.get(s)) {
                    if (t[0] == EPS && result.add(t[1])) {
                        q.add(t[1]);
                    }
                }
            }
            return result;
        }

        Set<Integer> move(Set<Integer> set, char c) {
            Set<Integer> result = new HashSet<>();
            for (int s : set) {
                for (int[] t : transitions.get(s)) {
                    if (t[0] == c) result.add(t[1]);
                }
            }
            return epsilonClosure(result);
        }
    }

    static class DFA {
        int start;
        Set<Integer> accept = new HashSet<>();
        Map<Integer, int[]> next = new HashMap<>(); // state -> [nextA, nextB], -1 if no transition

        long count(int n) {
            List<Integer> states = new ArrayList<>(next.keySet());
            int size = states.size();
            Map<Integer, Integer> idx = new HashMap<>();
            for (int i = 0; i < size; i++) idx.put(states.get(i), i);

            long[][] M = new long[size][size];
            for (int i = 0; i < size; i++) {
                int s = states.get(i);
                int[] to = next.get(s);
                if (to[0] >= 0) M[i][idx.get(to[0])]++;
                if (to[1] >= 0) M[i][idx.get(to[1])]++;
            }

            long[][] Mn = matrixPow(M, n);
            int startIdx = idx.get(start);
            long result = 0;
            for (int a : accept) {
                if (idx.containsKey(a)) {
                    result = (result + Mn[startIdx][idx.get(a)]) % MOD;
                }
            }
            return result;
        }
    }

    static NFA parse(String s, int[] pos) {
        char c = s.charAt(pos[0]++);
        if (c == 'a') return NFA.symbol('a');
        if (c == 'b') return NFA.symbol('b');
        if (c == '(') {
            NFA first = parse(s, pos);
            c = s.charAt(pos[0]++);
            if (c == '|') {
                NFA second = parse(s, pos);
                pos[0]++; // ')'
                return NFA.or(first, second);
            }
            if (c == '*') {
                pos[0]++; // ')'
                return NFA.star(first);
            }
            pos[0]--; // put back for concat
            NFA second = parse(s, pos);
            pos[0]++; // ')'
            return NFA.concat(first, second);
        }
        throw new IllegalArgumentException("Unexpected: " + c);
    }

    static DFA toDFA(NFA nfa) {
        DFA dfa = new DFA();
        Set<Integer> startSet = nfa.epsilonClosure(Set.of(nfa.start));
        Map<Set<Integer>, Integer> stateMap = new HashMap<>();
        stateMap.put(startSet, 0);
        dfa.start = 0;

        Queue<Set<Integer>> q = new ArrayDeque<>();
        q.add(startSet);

        List<Set<Integer>> stateList = new ArrayList<>();
        stateList.add(startSet);

        int nextId = 1;
        while (!q.isEmpty()) {
            Set<Integer> cur = q.poll();
            int curId = stateMap.get(cur);
            if (cur.contains(nfa.accept)) dfa.accept.add(curId);

            Set<Integer> forA = nfa.move(cur, 'a');
            Set<Integer> forB = nfa.move(cur, 'b');

            int[] to = new int[2];
            for (int i = 0; i < 2; i++) {
                Set<Integer> target = i == 0 ? forA : forB;
                if (target.isEmpty()) {
                    to[i] = -1;
                } else {
                    Integer tid = stateMap.get(target);
                    if (tid == null) {
                        tid = nextId++;
                        stateMap.put(target, tid);
                        stateList.add(target);
                        q.add(target);
                    }
                    to[i] = tid;
                }
            }
            dfa.next.put(curId, to);
        }
        return dfa;
    }

    static long[][] matrixPow(long[][] A, int n) {
        int size = A.length;
        long[][] result = new long[size][size];
        for (int i = 0; i < size; i++) result[i][i] = 1;

        long[][] base = A;
        while (n > 0) {
            if (n % 2 == 1) result = matMul(result, base);
            base = matMul(base, base);
            n /= 2;
        }
        return result;
    }

    static long[][] matMul(long[][] A, long[][] B) {
        int n = A.length;
        long[][] C = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                long a = A[i][k];
                if (a == 0) continue;
                for (int j = 0; j < n; j++) {
                    C[i][j] = (C[i][j] + a * B[k][j]) % MOD;
                }
            }
        }
        return C;
    }

    static class Result {
        public static long countStrings(String regex, int len) {
            int[] pos = {0};
            NFA nfa = parse(regex, pos);
            DFA dfa = toDFA(nfa);
            return dfa.count(len);
        }
    }

    public static class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            for (int x = 0; x < t; x++) {
                String[] parts = br.readLine().trim().split(" ");
                String regex = parts[0];
                int len = Integer.parseInt(parts[1]);
                System.out.println(Result.countStrings(regex, len));
            }
            br.close();
        }
    }
}
