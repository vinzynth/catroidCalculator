package catrobat.calculator;

/**
 * Created by chrl on 01/06/16.
 * <p/>
 * Class for Calculation methods
 */
public class Calculations {
    public static int doAddition(int i, int i1) {
        return i + i1;
    }

    public static int doSubtraction(int i, int i1) {
        return i - i1;
    }

    public static int doMultiplication(int i, int i1) {
        return i * i1;
    }

    public static int doDivision(int i, int i1) {
        return i / i1;
    }

    public static int calculateBySymbol(int i1, int i2, String operand) {
        switch (operand) {
            case "+":
                return doAddition(i1, i2);
            case "-":
                return doSubtraction(i1, i2);
            case "*":
                return doMultiplication(i1, i2);
            case "/":
                return doDivision(i1, i2);
            default:
                return i1;
        }
    }
}
