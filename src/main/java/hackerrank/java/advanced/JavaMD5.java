package hackerrank.java.advanced;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class JavaMD5 {

    public class Solution {

        public static void main(String[] args) throws NoSuchAlgorithmException {

            Scanner scan = new Scanner(System.in);
            String token = scan.nextLine();

            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(token.getBytes(), 0, token.length());

            byte[] digest = md.digest();

            for (byte b : digest) {
                System.out.format("%02x", b);
            }

            scan.close();
        }
    }
}
