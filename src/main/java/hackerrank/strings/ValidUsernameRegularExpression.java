package hackerrank.strings;

import java.util.Scanner;

public class ValidUsernameRegularExpression {

    private static final Scanner scan = new Scanner(System.in);

    public static void runCode() {
        int n = Integer.parseInt(scan.nextLine());

        while (n-- != 0) {

            String userName = scan.nextLine();

            if (userName.matches(UsernameValidator.regularExpression)) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }
        }

        scan.close();
    }
}

class UsernameValidator {
    public static final String regularExpression = "^[a-zA-Z][a-zA-Z_0-9]{7,29}$";
}
