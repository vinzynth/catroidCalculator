package catrobat.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collection;

public class Calculator extends Activity implements OnClickListener {

    private Button buttonPlus, buttonMinus, buttonDivide, buttonMultiply, buttonClear, buttonEquals;
    private Collection<Button> numberButtons;

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
            button.setOnClickListener(this);
            numberButtons.add(button);
        }

    }


    @Override
    public void onClick(View view) {

    }
}
