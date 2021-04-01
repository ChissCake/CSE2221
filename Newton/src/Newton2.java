import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Approximate the square root of a number using the Newton method of
 * approximation.
 *
 * @author C. Zhao
 *
 */
public final class Newton2 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Newton2() {
    }

    /**
     * Computes estimate of square root of x to within relative error 0.01%.
     *
     * @param x
     *            positive number to compute square root of
     * @return estimate of square root
     */
    private static double sqrt(double x) {
        double rootEstimate = Integer.MAX_VALUE; //Large guess for x^1/2
        final double epsilon = 0.0001;

        while ((Math.abs(rootEstimate * rootEstimate - x) / x) >= epsilon
                * epsilon) {
            if (rootEstimate == 0) { //If r = 0, then x = 0, set r = x
                rootEstimate = x;
            } else {
                rootEstimate = (rootEstimate + x / rootEstimate) / 2;
            }
        }
        return rootEstimate;
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

        out.println("Would you like to approximate a square root? (y/n)");
        String userResponse = in.nextLine();

        if (userResponse.equals("y")) {
            out.println("What would you like to take the square root of? ");
            double x = in.nextDouble();
            double root = sqrt(x);
            out.println("Square root of " + x + ": " + root);
        }

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
