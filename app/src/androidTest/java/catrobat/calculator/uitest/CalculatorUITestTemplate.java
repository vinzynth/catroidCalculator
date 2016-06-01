package catrobat.calculator.uitest;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

import org.junit.After;
import org.junit.Before;

import catrobat.calculator.Calculator;

/**
 * Created by chrl on 01/06/16.
 *
 * Sample Testcase
 */
public class CalculatorUITestTemplate extends ActivityInstrumentationTestCase2<Calculator> {

    public CalculatorUITestTemplate() {
        super(Calculator.class);
    }

    protected Solo solo;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        solo = new Solo(getInstrumentation(), getActivity());

    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }
}