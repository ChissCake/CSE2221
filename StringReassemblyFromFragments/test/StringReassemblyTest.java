import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.set.Set;
import components.set.Set1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public class StringReassemblyTest {

    @Test
    public void testPrintWithLineSeperatorsLimit() {
        String text = "test";
        String textExpected = "test";
        SimpleWriter outTest = new SimpleWriter1L("test.txt");
        StringReassembly.printWithLineSeparators(text, outTest);
        SimpleReader inTest = new SimpleReader1L("test.txt");
        StringBuffer buffer = new StringBuffer(text.length());
        while (!inTest.atEOS()) {
            buffer.append(inTest.read());
        }
        text = buffer.toString();
        assertEquals(textExpected, text);
        inTest.close();
        outTest.close();
    }

    @Test
    public void testPrintWithLineSeperatorsLimitTwo() {
        String text = "~";
        String textExpected = "\n";
        SimpleWriter outTest = new SimpleWriter1L("test.txt");
        StringReassembly.printWithLineSeparators(text, outTest);
        SimpleReader inTest = new SimpleReader1L("test.txt");
        StringBuffer buffer = new StringBuffer(text.length());
        while (!inTest.atEOS()) {
            buffer.append(inTest.read());
        }
        text = buffer.toString();
        assertEquals(textExpected, text);
        inTest.close();
        outTest.close();
    }

    @Test
    public void testPrintWithLineSeperatorsRoutine() {
        String text = "test~ttt";
        String textExpected = "test\nttt";
        SimpleWriter outTest = new SimpleWriter1L("test.txt");
        StringReassembly.printWithLineSeparators(text, outTest);
        SimpleReader inTest = new SimpleReader1L("test.txt");
        StringBuffer buffer = new StringBuffer(text.length());
        while (!inTest.atEOS()) {
            buffer.append(inTest.read());
        }
        text = buffer.toString();
        assertEquals(textExpected, text);
        inTest.close();
        outTest.close();
    }

    @Test
    public void testPrintWithLineSeperatorsChallenge() {
        String text = "~~te~st~~";
        String textExpected = "\n\nte\nst\n\n";
        SimpleWriter outTest = new SimpleWriter1L("test.txt");
        StringReassembly.printWithLineSeparators(text, outTest);
        SimpleReader inTest = new SimpleReader1L("test.txt");
        StringBuffer buffer = new StringBuffer(text.length());
        while (!inTest.atEOS()) {
            buffer.append(inTest.read());
        }
        text = buffer.toString();
        assertEquals(textExpected, text);
        inTest.close();
        outTest.close();
    }

    @Test
    public void testaddToSetAvoidingSubstringsNotContainingNumbersLimit() {
        //test the method when the string is not contained
        String str1 = "111";
        String str1Expected = "111";
        String str2 = "222";
        String str2Expected = "222";
        Set<String> test = new Set1L<String>();
        Set<String> testExpected = new Set1L<String>();
        test.add(str1);
        test.add(str2);
        String str3 = "33";
        String str3Expected = "33";
        StringReassembly.addToSetAvoidingSubstrings(test, str3);
        testExpected.add(str1);
        testExpected.add(str2);
        testExpected.add(str3);
        assertEquals(testExpected, test);
        assertEquals(str1Expected, str1);
        assertEquals(str2Expected, str2);
        assertEquals(str3Expected, str3);

    }

    @Test
    public void testaddToSetAvoidingSubstringsNotContainingStringsRoutine() {
        //test the method when the string is not contained
        String str1 = "this project";
        String str1Expected = "this project";
        String str2 = "is making me cry";
        String str2Expected = "is making me cry";
        Set<String> test = new Set1L<String>();
        Set<String> testExpected = new Set1L<String>();
        test.add(str1);
        test.add(str2);
        String str3 = "hahaha";
        String str3Expected = "hahaha";
        StringReassembly.addToSetAvoidingSubstrings(test, str3);
        testExpected.add(str1);
        testExpected.add(str2);
        testExpected.add(str3);
        assertEquals(testExpected, test);
        assertEquals(str1Expected, str1);
        assertEquals(str2Expected, str2);
        assertEquals(str3Expected, str3);

    }

    @Test
    public void testaddToSetAvoidingSubstringsContainingNumbersChallenging() {
        //test when the string is substring of an element
        String str1 = "177013";
        String str1Expected = "177013";
        String str2 = "200834";
        String str2Expected = "200834";
        Set<String> test = new Set1L<String>();
        Set<String> testExpected = new Set1L<String>();
        test.add(str1);
        test.add(str2);
        testExpected.add(str1);
        testExpected.add(str2);
        String str3 = "2";
        String str3Expected = "2";
        StringReassembly.addToSetAvoidingSubstrings(test, str3);
        assertEquals(testExpected, test);
        assertEquals(str1Expected, str1);
        assertEquals(str2Expected, str2);
        assertEquals(str3Expected, str3);

    }

    @Test
    public void testaddToSetAvoidingSubstringsContainingStringsLimit() {
        //test when the str is an element

        String str1 = "Minecraft is fun";
        String str1Expected = "Minecraft is fun";
        String str2 = "but this project isnt";
        String str2Expected = "but this project isnt";
        Set<String> test = new Set1L<String>();
        Set<String> testExpected = new Set1L<String>();
        test.add(str1);
        test.add(str2);
        testExpected.add(str1);
        testExpected.add(str2);
        String str3 = "but this project isnt";
        String str3Expected = "but this project isnt";
        StringReassembly.addToSetAvoidingSubstrings(test, str3);
        assertEquals(testExpected, test);
        assertEquals(str1Expected, str1);
        assertEquals(str2Expected, str2);
        assertEquals(str3Expected, str3);

    }

    @Test
    public void testaddToSetAvoidingSubstringsContainingStringsTwoChallenging() {
        //test when a string is substring of an element
        String str1 = "Minecraft is fun";
        String str1Expected = "Minecraft is fun";
        String str2 = "but this project isnt";
        String str2Expected = "but this project isnt";
        Set<String> test = new Set1L<String>();
        Set<String> testExpected = new Set1L<String>();
        test.add(str1);
        test.add(str2);
        testExpected.add(str1);
        testExpected.add(str2);
        String str3 = "this project";
        String str3Expected = "this project";
        StringReassembly.addToSetAvoidingSubstrings(test, str3);
        assertEquals(testExpected, test);
        assertEquals(str1Expected, str1);
        assertEquals(str2Expected, str2);
        assertEquals(str3Expected, str3);

    }

    //element is substring of str
    @Test
    public void testaddToSetAvoidingSubstringsElementIsSubstringOfString() {
        //test when a string is substring of an element
        String str1 = "Minecraft is fun";
        String str1Expected = "Minecraft is fun";
        String str2 = "this project";
        String str2Expected = "this project";
        Set<String> test = new Set1L<String>();
        Set<String> testExpected = new Set1L<String>();
        test.add(str1);
        test.add(str2);
        String str3 = "but this project isnt";
        String str3Expected = "but this project isnt";
        testExpected.add(str1);
        testExpected.add(str3);
        StringReassembly.addToSetAvoidingSubstrings(test, str3);
        assertEquals(testExpected, test);
        assertEquals(str1Expected, str1);
        assertEquals(str2Expected, str2);
        assertEquals(str3Expected, str3);

    }

    @Test
    public void testaddToSetAvoidingSubstringsElementIsSubstringOfStringTwo() {
        //test when a string is substring of an element
        String str1 = "1234";
        String str1Expected = "1234";
        String str2 = "5678";
        String str2Expected = "5678";
        Set<String> test = new Set1L<String>();
        Set<String> testExpected = new Set1L<String>();
        test.add(str1);
        test.add(str2);
        String str3 = "56789";
        String str3Expected = "56789";
        testExpected.add(str1);
        testExpected.add(str3);
        StringReassembly.addToSetAvoidingSubstrings(test, str3);
        assertEquals(testExpected, test);
        assertEquals(str1Expected, str1);
        assertEquals(str2Expected, str2);
        assertEquals(str3Expected, str3);

    }

    @Test
    public void testaddToSetAvoidingSubstringsElementIsSubstringOfStringChallenging() {
        //test when a string is substring of an element
        String str1 = "I'm having ";
        String str1Expected = "I'm having ";
        String str2 = " fun";
        String str2Expected = " fun";
        Set<String> test = new Set1L<String>();
        Set<String> testExpected = new Set1L<String>();
        test.add(str1);
        test.add(str2);
        String str3 = "no fun doing this";
        String str3Expected = "no fun doing this";
        testExpected.add(str1);
        testExpected.add(str3);
        StringReassembly.addToSetAvoidingSubstrings(test, str3);
        assertEquals(testExpected, test);
        assertEquals(str1Expected, str1);
        assertEquals(str2Expected, str2);
        assertEquals(str3Expected, str3);

    }

    @Test
    public void testCombinationOneEmptyLimit() {
        String str1 = "ugh";
        String str1Expected = "ugh";
        String str2 = "";
        String str2Expected = "";
        int overlap = 0;
        int overlapExpected = 0;
        String test = StringReassembly.combination(str1, str2, overlap);
        String test2 = StringReassembly.combination(str2, str1, 0);
        String testExpected = "ugh";
        assertEquals(testExpected, test);
        assertEquals(testExpected, test2);
        assertEquals(str1Expected, str1);
        assertEquals(str2Expected, str2);
        assertEquals(overlapExpected, overlap);
    }

    @Test
    public void testCombinationTwoEmptyChallenging() {
        String str1 = "";
        String str1Expected = "";
        String str2 = "";
        String str2Expected = "";
        int overlap = 0;
        int overlapExpected = 0;
        String test = StringReassembly.combination(str1, str2, overlap);
        String testExpected = "";
        assertEquals(testExpected, test);
        assertEquals(str1Expected, str1);
        assertEquals(str2Expected, str2);
        assertEquals(overlapExpected, overlap);
    }

    @Test
    public void testCombinationNoOverlapLimit() {
        String str1 = "wee";
        String str1Expected = "wee";
        String str2 = "woo";
        String str2Expected = "woo";
        int overlap = 0;
        int overlapExpected = 0;
        String test = StringReassembly.combination(str1, str2, overlap);
        String test2 = StringReassembly.combination(str2, str1, overlap);
        String testExpected = "weewoo";
        String testExpected2 = "woowee";
        assertEquals(testExpected, test);
        assertEquals(testExpected2, test2);
        assertEquals(str1Expected, str1);
        assertEquals(str2Expected, str2);
        assertEquals(overlapExpected, overlap);

    }

    @Test
    public void testCombinationOneOverlapRoutine() {
        String str1 = "wee";
        String str1Expected = "wee";
        String str2 = "eoo";
        String str2Expected = "eoo";
        int overlap = 1;
        int overlapExpected = 1;
        int overlap2 = 0;
        int overlapExpected2 = 0;
        String test = StringReassembly.combination(str1, str2, overlap);
        String test2 = StringReassembly.combination(str2, str1, overlap2);
        String testExpected = "weeoo";
        String testExpected2 = "eoowee";
        assertEquals(testExpected, test);
        assertEquals(testExpected2, test2);
        assertEquals(str1Expected, str1);
        assertEquals(str2Expected, str2);
        assertEquals(overlapExpected, overlap);
        assertEquals(overlapExpected2, overlap2);
    }

    @Test
    public void testCombinationTwoOverlapRoutine() {
        String str1 = "Thanks for making it this far";
        String str1Expected = "Thanks for making it this far";
        String str2 = "ar. You deserve a gold medal";
        String str2Expected = "ar. You deserve a gold medal";
        int overlap = 2;
        int overlapExpected = 2;
        String test = StringReassembly.combination(str1, str2, 2);
        String testExpected = "Thanks for making it this far. You deserve a gold medal";
        assertEquals(testExpected, test);
        assertEquals(str1Expected, str1);
        assertEquals(str2Expected, str2);
        assertEquals(overlapExpected, overlap);
    }

    @Test
    public void testCombinationTenOverlapChallenging() {
        final int ten = 10;
        String str1 = "This is the end";
        String str1Expected = "This is the end";
        String str2 = "is the end. Seeya!";
        String str2Expected = "is the end. Seeya!";
        int overlap = ten;
        int overlapExpected = overlap;
        String test = StringReassembly.combination(str1, str2, overlap);
        String testExpected = "This is the end. Seeya!";
        assertEquals(testExpected, test);
        assertEquals(str1Expected, str1);
        assertEquals(str2Expected, str2);
        assertEquals(overlapExpected, overlap);
    }
}
