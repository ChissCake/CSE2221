import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Program to evaluate XMLTree expressions of {@code int}.
 *
 * @author Chris Zhao
 *
 */
public final class XMLTreeIntExpressionEvaluator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeIntExpressionEvaluator() {
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
    private static int evaluate(XMLTree exp) {
        assert exp != null : "Violation of: exp is not null";
        int value = 0;
        int childOne = 0;
        int childTwo = 0;

        if (exp.isTag()) {
            if (exp.child(0).label() != "number") {
                childOne = evaluate(exp.child(0));
            } else {
                childOne = Integer
                        .parseInt(exp.child(0).attributeValue("value"));
            }
            if (exp.child(1).label() != "number") {
                childTwo = evaluate(exp.child(1));
            } else {
                childTwo = Integer
                        .parseInt(exp.child(1).attributeValue("value"));
            }
        }

        if (exp.label().contentEquals("plus")) {
            value = childOne + childTwo;
        }
        if (exp.label().contentEquals("minus")) {
            value = childOne - childTwo;
        }
        if (exp.label().contentEquals("divide")) {
            value = childOne / childTwo;
        }
        if (exp.label().contentEquals("times")) {
            value = childOne * childTwo;
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
