import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Program to evaluate XMLTree expressions of {@code int}.
 *
 * @author Put your name here
 *
 */
public final class XMLTreeNNExpressionEvaluator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeNNExpressionEvaluator() {
    }

    /**
     * Evaluate the given expression.
     *
     * @param exp
     *            the {@code XMLTree} representing the expression
     * @return the value of the expression
     * @requires <pre>
     * [exp is a subtree of a well-formed XML arithmetic expression]  and
     *  [the label of the root of exp is not "expression"]
     * </pre>
     * @ensures evaluate = [the value of the expression]
     */
    private static NaturalNumber evaluate(XMLTree exp) {
        assert exp != null : "Violation of: exp is not null";

        final NaturalNumber zero = new NaturalNumber2(0);
        NaturalNumber value = new NaturalNumber2(0);
        NaturalNumber childOne = new NaturalNumber2(0);
        NaturalNumber childTwo = new NaturalNumber2(0);

        if (exp.isTag()) {
            if (exp.child(0).label() != "number") {
                childOne.copyFrom(evaluate(exp.child(0)));
            } else {
                components.utilities.Reporter.assertElseFatalError(
                        childOne.canSetFromString(
                                exp.child(0).attributeValue("value")),
                        "Violation of: there exists n: NATURAL (s = TO_STRING(n))");
                childOne.setFromString(exp.child(0).attributeValue("value"));
            }
            if (exp.child(1).label() != "number") {
                childTwo.copyFrom(evaluate(exp.child(1)));
            } else {
                components.utilities.Reporter.assertElseFatalError(
                        childTwo.canSetFromString(
                                exp.child(1).attributeValue("value")),
                        "Violation of: there exists n: NATURAL (s = TO_STRING(n))");
                childTwo.setFromString(exp.child(1).attributeValue("value"));
            }
        }

        if (exp.label().contentEquals("plus")) {
            childOne.add(childTwo);
            value.copyFrom(childOne);
        }
        if (exp.label().contentEquals("minus")) {
            components.utilities.Reporter.assertElseFatalError(
                    (childOne.compareTo(childTwo) > 0), "error: this < n");
            childOne.subtract(childTwo);
            value.copyFrom(childOne);
        }
        if (exp.label().contentEquals("divide")) {
            components.utilities.Reporter.assertElseFatalError(
                    (childTwo.compareTo(zero) > 0), "Violation of divisor > 0");
            childOne.divide(childTwo);
            value.copyFrom(childOne);
        }
        if (exp.label().contentEquals("times")) {
            childOne.multiply(childTwo);
            value.copyFrom(childOne);
        }
        return value;
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

        out.print("Enter the name of an expression XML file: ");
        String file = in.nextLine();
        while (!file.equals("")) {
            XMLTree exp = new XMLTree1(file);
            out.println(evaluate(exp.child(0)));
            out.print("Enter the name of an expression XML file: ");
            file = in.nextLine();
        }

        in.close();
        out.close();
    }

}
