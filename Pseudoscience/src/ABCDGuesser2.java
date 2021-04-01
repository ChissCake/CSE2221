import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.FormatChecker;

/**
 * Approximate any number to 1% relative error using the formula
 * (w^a*x^b*y^c*z^d) with a,b,c, and d being any numbers from the set list :
 * {-5, -4, -3, -2, -1, -1/2, -1/3, -1/4, 0, 1/4, 1/3, 1/2, 1, 2, 3, 4, 5}
 *
 * @author C. Zhao
 *
 */
public final class ABCDGuesser2 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private ABCDGuesser2() {
    }

    /**
     * Repeatedly asks the user for a positive real number until the user enters
     * one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number entered by the user
     */
    private static double getPositiveDouble(SimpleReader in, SimpleWriter out) {
        String userInput = "empty";
        while (userInput == "empty") {
            out.println("Please enter in positive value for \u03BC: ");
            String temp = in.nextLine();
            if (FormatChecker.canParseDouble(temp)
                    && Double.parseDouble(temp) > 0) {
                userInput = temp;
            } else {
                out.println("Error, please try again.");
            }
        }
        return Double.parseDouble(userInput);
    }

    /**
     * Repeatedly asks the user for a positive real number not equal to 1.0
     * until the user enters one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number not equal to 1.0 entered by the user
     */
    private static double getPositiveDoubleNotOne(SimpleReader in,
            SimpleWriter out) {
        String userInput = "empty";
        while (userInput == "empty") {
            out.println("Please enter in positive value that is not 1.0: ");
            String temp = in.nextLine();
            if (FormatChecker.canParseDouble(temp)
                    && Double.parseDouble(temp) > 1) {
                userInput = temp;
            } else {
                out.println("Error, please try again.");
            }
        }
        return Double.parseDouble(userInput);

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

        final double percConvert = 100.0;
        final double[] expList = { -5, -4, -3, -2, -1, -0.5, -1 / 3, -.25, 0,
                .25, 1 / 3, 0.5, 1, 2, 3, 4, 5 };

        /*
         * prompt user for personal numbers
         */
        double userMuVal = getPositiveDouble(in, out);
        out.print("Input personal number W. ");
        double w = getPositiveDoubleNotOne(in, out);
        out.print("Input personal number X. ");
        double x = getPositiveDoubleNotOne(in, out);
        out.print("Input personal number Y. ");
        double y = getPositiveDoubleNotOne(in, out);
        out.print("Input personal number Z. ");
        double z = getPositiveDoubleNotOne(in, out);

        double relError = 0.0;
        double estMuVal = 0.0;
        double a = 0.0, b = 0.0, c = 0.0, d = 0.0;
        int aIndex = 0, bIndex = 0, cIndex = 0, dIndex = 0;

        /*
         * estimate value of exponents through brute force iteration
         */
        for (aIndex = 0; aIndex < expList.length; aIndex++) {
            for (bIndex = 0; bIndex < expList.length; bIndex++) {
                for (cIndex = 0; cIndex < expList.length; cIndex++) {
                    for (dIndex = 0; dIndex < expList.length; dIndex++) {
                        estMuVal = (Math.pow(w, expList[aIndex])
                                * Math.pow(x, expList[bIndex])
                                * Math.pow(y, expList[cIndex])
                                * Math.pow(z, expList[dIndex]));
                        double e = (estMuVal - userMuVal) / userMuVal;
                        /*
                         * Iterate until the the relative error is less than 1%
                         */
                        if (Math.abs(e) < .001) {
                            a = expList[aIndex];
                            b = expList[bIndex];
                            c = expList[cIndex];
                            d = expList[dIndex];
                        }
                    }
                }
            }
        }
        /*
         * Display the values of A,B,C, and D, as well as the percent error and
         * the approximation
         */
        out.println("Value of A: " + a);
        out.println("Value of B: " + b);
        out.println("Value of C: " + c);
        out.println("Value of D: " + d);
        estMuVal = (Math.pow(w, a) * Math.pow(x, b) * Math.pow(y, c)
                * Math.pow(z, d));
        relError = (estMuVal - userMuVal) / userMuVal * percConvert;
        out.println("Relative Error: " + relError + "%");

        in.close();
        out.close();
    }

}
