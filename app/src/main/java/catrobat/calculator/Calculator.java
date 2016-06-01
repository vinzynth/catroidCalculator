package catrobat.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;

public class Calculator extends Activity implements OnClickListener {

    private Button buttonPlus, buttonMinus, buttonDivide, buttonMultiply, buttonClear, buttonEquals;
    private Collection<Button> numberButtons;
    private TextView textViewCalculation;
    private TextView textViewResult;
    private boolean lastInputIsNumber = false;
    private boolean lastInputIsOperator = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        buttonPlus = (Button) findViewById(R.id.button_add);
        buttonMinus = (Button) findViewById(R.id.button_sub);
        buttonDivide = (Button) findViewById(R.id.button_div);
        buttonMultiply = (Button) findViewById(R.id.button_mul);
        buttonClear = (Button) findViewById(R.id.button_c);
        buttonEquals = (Button) findViewById(R.id.button_eq);

        buttonPlus.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonClear.setOnClickListener(this);
        buttonEquals.setOnClickListener(this);

        numberButtons = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            String buttonName = "button_" + i;
            int id = getResources().getIdentifier(buttonName, "id", R.class.getPackage().getName());
            Button button = (Button) findViewById(id);
            final int number = i;
            button.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    numberClicked(number);
                }
            });
            numberButtons.add(button);
        }

        textViewCalculation = (TextView) findViewById(R.id.calculation);
        textViewResult = (TextView) findViewById(R.id.res);

    }


    public void numberClicked(int i) {
        boolean empty = textViewCalculation.getText().length() <= 0;
        if (i == 0 && (empty || !lastInputIsNumber))
            return;
        textViewCalculation.append(Integer.toString(i));
        lastInputIsNumber = true;
        lastInputIsOperator = false;

    }


    @Override
    public void onClick(View view) {
        lastInputIsNumber = false;
        Button button = (Button) view;

        switch (button.getId()) {
            case R.id.button_c:
                clearTextField();
                break;
            case R.id.button_eq:
                computeResult();
                break;
            default:
                if (!lastInputIsOperator) {
                    textViewCalculation.append(button.getText());
                    lastInputIsOperator = true;
                    break;
                }
        }

    }

    private void computeResult() {
    }

    private void clearTextField() {
        textViewCalculation.setText("");
        textViewResult.setText("");
    }

}
