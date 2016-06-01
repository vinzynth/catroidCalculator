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
        solo.clickOnText("AC");
        solo.clickOnText("DEL");

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

        typeNumbers();
        TextView textView = (TextView) solo.getCurrentActivity().findViewById(R.id.calculation);
        solo.sleep(500);
        assertEquals("Formula not correctly represented", "12*-12", textView.getText().toString());
    }

    private void typeNumbers() {
        for (int i = 0; i < 3; i++) {
            solo.clickOnText(Integer.toString(i));
        }
        solo.clickOnText("+");
        solo.clickOnText("*");
        solo.clickOnText("-");
        for (int i = 0; i < 3; i++) {
            solo.clickOnText(Integer.toString(i));
        }
    }


    public void testWriteFormula4() throws Exception {

        solo.clickOnText("-");
        typeNumbers();
        TextView textView = (TextView) solo.getCurrentActivity().findViewById(R.id.calculation);
        solo.sleep(500);
        assertEquals("Formula not correctly represented", "-12*-12", textView.getText().toString());
    }


    public void testWriteFormula5() throws Exception {

        solo.clickOnText("*");
        typeNumbers();
        TextView textView = (TextView) solo.getCurrentActivity().findViewById(R.id.calculation);
        solo.sleep(500);
        assertEquals("Formula not correctly represented", "12*-12", textView.getText().toString());
    }

    public void testWriteFormula6() throws Exception {

        solo.clickOnText("+");
        typeNumbers();
        TextView textView = (TextView) solo.getCurrentActivity().findViewById(R.id.calculation);
        solo.sleep(500);
        assertEquals("Formula not correctly represented", "12*-12", textView.getText().toString());
    }

    public void testWriteFormula7() throws Exception {

        solo.clickOnText("/");
        typeNumbers();
        TextView textView = (TextView) solo.getCurrentActivity().findViewById(R.id.calculation);
        solo.sleep(500);
        assertEquals("Formula not correctly represented", "12*-12", textView.getText().toString());
    }

    public void testWriteFormula8() throws Exception {

        typeNumbers();
        solo.clickOnText("*");
        solo.clickOnText("-");
        solo.clickOnText("/");

        TextView textView = (TextView) solo.getCurrentActivity().findViewById(R.id.calculation);
        solo.sleep(500);
        assertEquals("Formula not correctly represented", "12*-12/", textView.getText().toString());
    }

    public void testCalculateAdd() throws Exception {

        for (int i = 0; i < 3; i++) {
            solo.clickOnText(Integer.toString(i));
        }
        solo.clickOnText("+");

        for (int i = 0; i < 3; i++) {
            solo.clickOnText(Integer.toString(i));
        }

        TextView textView = (TextView) solo.getCurrentActivity().findViewById(R.id.res);
        solo.sleep(500);
        assertEquals("Formula not correctly represented", "24", textView.getText().toString());
    }

    public void testDel() throws Exception {

        typeNumbers();
        solo.clickOnText("DEL");
        solo.clickOnText("DEL");
        solo.clickOnText("DEL");


        TextView textView = (TextView) solo.getCurrentActivity().findViewById(R.id.res);
        solo.sleep(500);
        assertEquals("DEL does not work", "12", textView.getText().toString());
    }

}
