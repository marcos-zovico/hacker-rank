package hackerrank.java.bignumber;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class JavaBigDecimal {

    public class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            String[] s = new String[n + 2];

            IntStream.range(0, n).forEach(i -> s[i] = sc.next());
            sc.close();

            Arrays.sort(s, 0, n, (a, b) -> new BigDecimal(b).compareTo(new BigDecimal(a)));

            IntStream.range(0, n).forEach(i -> System.out.println(s[i]));
        }
    }
}
