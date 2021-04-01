import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 *
 */

/**
 * @author CZ
 *
 */
public class NNtoStringWithCommasTest {

    /**
     * Calls the method under test.
     *
     * @param n
     *            the number to pass to the method under test
     * @return the {@code String} returned by the method under test
     * @ensures <pre>
     * redirectToMethodUnderTest = [String returned by the method under test]
     * </pre>
     */
    private static String redirectToMethodUnderTest(NaturalNumber n) {
        return NNtoStringWithCommas1.toStringWithCommas(n);
    }

    /**
     * Test NNtoStringWithCommas1 with input 0.
     */
    @Test
    public void NNtoStringWithCommas1Test1() {
        NaturalNumber n = new NaturalNumber2(0);
        String outputExpected = "0";
        String outputReal = redirectToMethodUnderTest(n);
        assertEquals(outputExpected, outputReal);
    }

    /**
     * Test NNtoStringWithCommas1 with input 1.
     */
    @Test
    public void NNtoStringWithCommas1Test2() {
        NaturalNumber n = new NaturalNumber2(1);
        String outputExpected = "1";
        String outputReal = redirectToMethodUnderTest(n);
        assertEquals(outputExpected, outputReal);
    }

    /**
     * Test NNtoStringWithCommas1 with input 100.
     */
    @Test
    public void NNtoStringWithCommas1Test3() {
        NaturalNumber n = new NaturalNumber2(100);
        String outputExpected = "100";
        String outputReal = redirectToMethodUnderTest(n);
        assertEquals(outputExpected, outputReal);
    }

    /**
     * Test NNtoStringWithCommas1 with input 1000.
     */
    @Test
    public void NNtoStringWithCommas1Test4() {
        NaturalNumber n = new NaturalNumber2(1000);
        String outputExpected = "1,000";
        String outputReal = redirectToMethodUnderTest(n);
        assertEquals(outputExpected, outputReal);
    }

    /**
     * Test NNtoStringWithCommas1 with input 1001.
     */
    @Test
    public void NNtoStringWithCommas1Test5() {
        NaturalNumber n = new NaturalNumber2(1001);
        String outputExpected = "1,001";
        String outputReal = redirectToMethodUnderTest(n);
        assertEquals(outputExpected, outputReal);
    }

    /**
     * Test NNtoStringWithCommas1 with input 1001.
     */
    @Test
    public void NNtoStringWithCommas1Test5a() {
        NaturalNumber n = new NaturalNumber2(1001);
        String outputExpected = "1,001";
        String outputReal = redirectToMethodUnderTest(n);
        assertEquals(outputExpected, outputReal);
    }

    /**
     * Test NNtoStringWithCommas1 with input 1000000000.
     */
    @Test
    public void NNtoStringWithCommas1Test6() {
        NaturalNumber n = new NaturalNumber2(1000000000);
        String outputExpected = "1,000,000,000";
        String outputReal = redirectToMethodUnderTest(n);
        assertEquals(outputExpected, outputReal);
    }

    /**
     * Test NNtoStringWithCommas1 with input 1010101010.
     */
    @Test
    public void NNtoStringWithCommas1Test7() {
        NaturalNumber n = new NaturalNumber2(1010101010);
        String outputExpected = "1,010,101,010";
        String outputReal = redirectToMethodUnderTest(n);
        assertEquals(outputExpected, outputReal);
    }

    /**
     * Test NNtoStringWithCommas1 with input 101010101.
     */
    @Test
    public void NNtoStringWithCommas1Test8() {
        NaturalNumber n = new NaturalNumber2(101010101);
        String outputExpected = "101,010,101";
        String outputReal = redirectToMethodUnderTest(n);
        assertEquals(outputExpected, outputReal);
    }

    /**
     * Test NNtoStringWithCommas1 with input 10101010.
     */
    @Test
    public void NNtoStringWithCommas1Test9() {
        NaturalNumber n = new NaturalNumber2(10101010);
        String outputExpected = "10,101,010";
        String outputReal = redirectToMethodUnderTest(n);
        assertEquals(outputExpected, outputReal);
    }

    /**
     * Test NNtoStringWithCommas1 with input 10000001.
     */
    @Test
    public void NNtoStringWithCommas1Test10() {
        NaturalNumber n = new NaturalNumber2(10000001);
        String outputExpected = "10,000,001";
        String outputReal = redirectToMethodUnderTest(n);
        assertEquals(outputExpected, outputReal);
    }

    /**
     * Test NNtoStringWithCommas1 with input 1000100101.
     */
    @Test
    public void NNtoStringWithCommas1Test11() {
        NaturalNumber n = new NaturalNumber2(1000100101);
        String outputExpected = "1,000,100,101";
        String outputReal = redirectToMethodUnderTest(n);
        assertEquals(outputExpected, outputReal);
    }

    /**
     * Test NNtoStringWithCommas1 with input 111111111.
     */
    @Test
    public void NNtoStringWithCommas1Test12() {
        NaturalNumber n = new NaturalNumber2(111111111);
        String outputExpected = "111,111,111";
        String outputReal = redirectToMethodUnderTest(n);
        assertEquals(outputExpected, outputReal);
    }

    /**
     * Test NNtoStringWithCommas1 with input 123456789.
     */
    @Test
    public void NNtoStringWithCommas1Test13() {
        NaturalNumber n = new NaturalNumber2(123456789);
        String outputExpected = "123,456,789";
        String outputReal = redirectToMethodUnderTest(n);
        assertEquals(outputExpected, outputReal);
    }

    /**
     * Test NNtoStringWithCommas1 with input 125678900.
     */
    @Test
    public void NNtoStringWithCommas1Test14() {
        NaturalNumber n = new NaturalNumber2(1235678900);
        String outputExpected = "1,235,678,900";
        String outputReal = redirectToMethodUnderTest(n);
        assertEquals(outputExpected, outputReal);
    }

    /**
     * Test NNtoStringWithCommas1 with input 123.
     */
    @Test
    public void NNtoStringWithCommas1Test15() {
        NaturalNumber n = new NaturalNumber2(123);
        String outputExpected = "123";
        String outputReal = redirectToMethodUnderTest(n);
        assertEquals(outputExpected, outputReal);
    }

}
