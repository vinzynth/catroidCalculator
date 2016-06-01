package catrobat.calculator.test;

import junit.framework.TestCase;

import catrobat.calculator.Calculations;
import catrobat.calculator.Parser;

/**
 * Created by chrl on 01/06/16.
 * <p/>
 * TestClass for Calculation methods
 */
public class CalculationsTest extends TestCase {

    public void testDoAddition() {
        int result = Calculations.doAddition(4, 5);
        assertEquals(9, result);
    }

    public void testDoSubtraction() {
        int result = Calculations.doSubtraction(6, 5);
        assertEquals(1, result);
    }

    public void testDoMultiplication() {
        int result = Calculations.doMultiplication(4, 5);
        assertEquals(20, result);
    }

    public void testDoDivision() {
        int result = Calculations.doDivision(4, 2);
        assertEquals(2, result);
    }

    public void testParser() throws Exception {
        assertEquals(Parser.doCalculation("12*12"), 144);
        assertEquals(Parser.doCalculation("-12*12"), -144);
        assertEquals(Parser.doCalculation("12*-12"), -144);
        assertEquals(Parser.doCalculation("-12*-12"), 144);

        assertEquals(Parser.doCalculation("12/12"), 1);
        assertEquals(Parser.doCalculation("-12/12"), -1);
        assertEquals(Parser.doCalculation("-12/-12"), 1);

        assertEquals(Parser.doCalculation("12*12-"), 144);
        assertEquals(Parser.doCalculation("-12*12-"), -144);
        assertEquals(Parser.doCalculation("12*-12-"), -144);
        assertEquals(Parser.doCalculation("-12*-12-"), 144);
        assertEquals(Parser.doCalculation("12*12*-"), 144);
        assertEquals(Parser.doCalculation("-12*12*-"), -144);
        assertEquals(Parser.doCalculation("12*-12*-"), -144);
        assertEquals(Parser.doCalculation("-12*-12*-"), 144);
        assertEquals(Parser.doCalculation("12*12*"), 144);
        assertEquals(Parser.doCalculation("-12*12*"), -144);
        assertEquals(Parser.doCalculation("12*-12*"), -144);
        assertEquals(Parser.doCalculation("-12*-12*"), 144);


        assertEquals(Parser.doCalculation("12*12-12*12"), 0);
        assertEquals(Parser.doCalculation("12*12-12*-12"), 288);
        assertEquals(Parser.doCalculation("12*12-12*12*-"), 0);
        assertEquals(Parser.doCalculation("12*12-12*-12*-"), 288);
        assertEquals(Parser.doCalculation("12*12-12*12-"), 0);
        assertEquals(Parser.doCalculation("12*12-12*-12-"), 288);
        assertEquals(Parser.doCalculation("12*12-12*12*"), 0);
        assertEquals(Parser.doCalculation("12*12-12*-12*"), 288);

        assertEquals(Parser.doCalculation("12*12-12*-12++++++++++++++++++++////////////******************-----------------"), 288);


        assertEquals(Parser.doCalculation("3+4*5+6"), 29);
    }
}
