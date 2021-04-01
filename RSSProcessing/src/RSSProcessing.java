import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * This program inputs an XML RSS (version 2.0) feed from a given URL and
 * outputs various elements of the feed to the console.
 *
 * @author Chris Zhao
 *
 */
public final class RSSProcessing {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private RSSProcessing() {
    }

    /**
     * Finds the first occurrence of the given tag among the children of the
     * given {@code XMLTree} and return its index; returns -1 if not found.
     *
     * @param xml
     *            the {@code XMLTree} to search
     * @param tag
     *            the tag to look for
     * @return the index of the first child of the {@code XMLTree} matching the
     *         given tag or -1 if not found
     * @requires [the label of the root of xml is a tag]
     * @ensures <pre>
     * getChildElement =
     *  [the index of the first child of the {@code XMLTree} matching the
     *   given tag or -1 if not found]
     * </pre>
     */
    private static int getChildElement(XMLTree xml, String tag) {
        assert xml != null : "Violation of: xml is not null";
        assert tag != null : "Violation of: tag is not null";
        assert xml.isTag() : "Violation of: the label root of xml is a tag";

        int childElement = -1;
        for (int i = 0; i < xml.numberOfChildren(); i++) {
            if (xml.child(i).label().equals(tag)) {
                childElement = i;
            }
        }
        return childElement;
    }

    /**
     * Processes one news item and outputs the title, or the description if the
     * title is not present, and the link (if available) with appropriate
     * labels.
     *
     * @param item
     *            the news item
     * @param out
     *            the output stream
     * @requires [the label of the root of item is an <item> tag] and
     *           out.is_open
     * @ensures out.content = #out.content * [the title (or description) and
     *          link]
     */
    private static void processItem(XMLTree item, SimpleWriter out) {
        assert item != null : "Violation of: item is not null";
        assert out != null : "Violation of: out is not null";
        assert item.isTag() && item.label().equals("item") : ""
                + "Violation of: the label root of item is an <item> tag";
        assert out.isOpen() : "Violation of: out.is_open";

        for (int i = 0; i < item.numberOfChildren(); i++) {
            if (item.child(i).label() == "title") {
                out.println("Title: " + item.child(i).child(0).label());
            }

            if (item.child(i).label() == "description") {
                out.println("Description: " + item.child(i).child(0).label());
            }
            if (item.child(i).label() == "link") {
                out.println("Link: " + item.child(i).child(0).label());
            }
        }

    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        /*
         * Open I/O streams.
         */
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        /*
         * Input the source URL.
         */
        out.print("Enter the URL of an RSS 2.0 news feed: ");
        String url = in.nextLine();
        /*
         * Read XML input and initialize XMLTree. If input is not legal XML,
         * this statement will fail.
         */
        XMLTree xml = new XMLTree1(url);
        /*
         * Extract <channel> element.
         */
        XMLTree channel = xml.child(0);

        String title = "";
        String desc = "";
        String link = "";
        for (int i = 0; i < channel.numberOfChildren(); i++) {
            if (channel.child(i).label() == "title") {
                title = channel.child(i).child(0).label();
            }
            if (channel.child(i).label() == "link") {
                link = channel.child(i).child(0).label();
            }
            if (channel.child(i).label() == "description") {
                desc = channel.child(i).child(0).label();
            }
        }
        out.println("Title: " + title);
        out.println("Description: " + desc);
        out.println("Link: " + link);
        out.println();

        for (int i = 0; i < channel.numberOfChildren(); i++) {
            if (channel.child(i).label() == "item") {
                processItem(channel.child(i), out);
            }
        }

        /*
         * Close I/O streams.
         */
        in.close();
        out.close();
    }

}