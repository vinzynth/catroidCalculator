package catrobat.calculator.uitest;

import android.widget.TextView;

import catrobat.calculator.R;

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
        solo.clickOnText("0");
        solo.clickOnText("0");
        for (int i = 0; i < 10; i++) {
            solo.clickOnText(Integer.toString(i));
        }
        TextView textView = (TextView) solo.getCurrentActivity().findViewById(R.id.calculation);
        solo.sleep(300);
        assertEquals("Formula not correctly represented", "123456789+123456789", textView.getText().toString());
    }


    public void testWriteFormula2() throws Exception {

        for (int i = 0; i < 3; i++) {
            solo.clickOnText(Integer.toString(i));
        }
        solo.clickOnText("+");
        solo.clickOnText("*");
        solo.clickOnText("+");
        for (int i = 0; i < 3; i++) {
            solo.clickOnText(Integer.toString(i));
        }
        TextView textView = (TextView) solo.getCurrentActivity().findViewById(R.id.calculation);
        solo.sleep(300);
        assertEquals("Formula not correctly represented", "12+12", textView.getText().toString());
    }

    public void testWriteFormula3() throws Exception {

        for (int i = 0; i < 3; i++) {
            solo.clickOnText(Integer.toString(i));
        }
        solo.clickOnText("+");
        solo.clickOnText("*");
        solo.clickOnText("-");
        for (int i = 0; i < 3; i++) {
            solo.clickOnText(Integer.toString(i));
        }
        TextView textView = (TextView) solo.getCurrentActivity().findViewById(R.id.calculation);
        solo.sleep(300);
        assertEquals("Formula not correctly represented", "12-12", textView.getText().toString());
    }


}
