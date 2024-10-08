package hackerrank.java.bignumber;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class JavaPrimalityTest {

    public class Solution {
        public static void main(String[] args) throws Exception {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String n = bufferedReader.readLine();

            BigInteger bi = new BigInteger(n);
            System.out.println(bi.isProbablePrime(1) ? "prime" : "not prime");

            bufferedReader.close();
        }
    }
}
