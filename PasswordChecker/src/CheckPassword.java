import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class CheckPassword {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private CheckPassword() {
    }

    /**
     * Checks whether the given String satisfies the OSU criteria for a valid
     * password. Prints an appropriate message to the given output stream.
     *
     * @param s
     *            the String to check
     * @param out
     *            the output stream
     */
    private static void checkPassword(String s, SimpleWriter out) {
        //at least 8 characters
        if (s.length() < 8) {
            out.println("Password must be at least 8 characters");

        }
        if (!containsUpperCaseLetter(s)) {
            out.println("Password must contain at least 1 upper case letter");
        }
        if (!containsLowerCaseLetter(s)) {
            out.println("Password must contain at least 1 lower case letter");
        }
        if (!containsDigit(s)) {
            out.println("Password must contain at least 1 digit");
        }

    }

    /**
     * Checks if the given String contains an upper case letter.
     *
     * @param s
     *            the String to check
     * @return true if s contains an upper case letter, false otherwise
     */
    private static boolean containsUpperCaseLetter(String s) {
        boolean upperCaseFlag = false;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                upperCaseFlag = true;
            }
        }
        return upperCaseFlag;
    }

    /**
     * Checks if the given String contains a lower case letter.
     *
     * @param s
     *            the String to check
     * @return true if s contains a lower case letter, false otherwise
     */
    private static boolean containsLowerCaseLetter(String s) {
        boolean lowerCaseFlag = false;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLowerCase(s.charAt(i))) {
                lowerCaseFlag = true;
            }
        }
        return lowerCaseFlag;
    }

    /**
     * Checks if the given String contains a digit.
     *
     * @param s
     *            the String to check
     * @return true if s contains a digit, false otherwise
     */
    private static boolean containsDigit(String s) {
        boolean digitFlag = false;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                digitFlag = true;
            }
        }
        return digitFlag;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        /*
         * Put your main program code here; it may call myMethod as shown
         */
        String userPassword;

        out.println("Enter a password:");
        userPassword = in.nextLine();

        checkPassword(userPassword, out);
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
