package catrobat.calculator.uitest;

/**
 * Created by chrl on 01/06/16.
 * <p/>
 * Basic Testcase
 */
public class CalculatorTest extends CalculatorUITestTemplate {

    public void testButtons() throws Exception {

        for (int i = 0; i < 10; i++) {
            solo.clickOnText(Integer.toString(i));
        }

        solo.clickOnText("+");
        solo.clickOnText("-");
        solo.clickOnText("*");
        solo.clickOnText("/");
        solo.clickOnText("C");
        solo.clickOnText("=");

    }

    public void testWriteFormula() throws Exception {

        for (int i = 0; i < 10; i++) {
            solo.clickOnText(Integer.toString(i));
        }
        solo.clickOnText("+");
        for (int i = 0; i < 10; i++) {
            solo.clickOnText(Integer.toString(i));
        }

        assertTrue("Formula not correctly represented", solo.searchText("123456789+123456789"));
    }
}
