package catrobat.calculator;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.Collection;

public class Calculator extends Activity implements OnClickListener {

    private Button buttonPlus, buttonMinus, buttonDivide, buttonMultiply, buttonClear, buttonEquals;
    private Collection<Button> numberButtons;
    private TextView textViewCalculation;
    private TextView textViewResult;
    private boolean lastInputIsNumber = false;
    private boolean lastInputIsOperator = false;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

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

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
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
                } else {
                    replaceOperator(button.getText().toString());
                }
        }

    }

    private void replaceOperator(String operator) {
        String text = textViewCalculation.getText().toString();
        final String s = text.substring(0, text.length() - 1) + operator;
        textViewCalculation.setText(s);
    }

    private void computeResult() {
    }

    private void clearTextField() {
        textViewCalculation.setText("");
        textViewResult.setText("");
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Calculator Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://catrobat.calculator/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Calculator Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://catrobat.calculator/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
