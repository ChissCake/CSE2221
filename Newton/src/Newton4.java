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
public final class Newton4 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Newton4() {
    }

    /**
     * Computes estimate of square root of x to within relative error 0.01%.
     *
     * @param x
     *            positive number to compute square root of
     * @param epsilon
     *            percentage to which relative error will be measured to
     * @return estimate of square root
     */
    private static double sqrt(double x, double epsilon) {

        double rootEstimate = Integer.MAX_VALUE; //Large guess for x^1/2

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
        final double percentConversion = 100;

        /*
         * prompt user to input square that root will be estimated from If the
         * user inputs a negative value then the program will quit
         */
        out.println("What would you like to take the square root of? ");
        out.println("(Enter a negative value to quit).");
        double x = in.nextDouble();

        while (x >= 0) {
            /*
             * prompt user to put in epsilon value as a percent then converts to
             * decimal
             */
            out.println("What is the value of epsilon? (% accuracy)");
            double epsilon = in.nextDouble() / percentConversion;

            /*
             * outputs the estimated root
             */
            double root = sqrt(x, epsilon);
            out.println("Square root of " + x + ": " + root);

            /*
             * prompt user again to input square that root will be estimated
             * from If the user inputs a negative value then the program will
             * quit
             */
            out.println("What would you like to take the square root of? ");
            out.println("(Enter a negative value to quit).");
            x = in.nextDouble();
        }

        out.println("Goodbye");

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
