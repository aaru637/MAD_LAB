package com.dk.mad_lab.twelfth;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.dk.mad_lab.R;
import com.google.android.material.button.MaterialButton;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class Experiment_12 extends AppCompatActivity implements View.OnClickListener {

    MaterialButton allclear, clear, factorial, divide;
    MaterialButton seven, eight, nine, multiply;
    MaterialButton four, five, six, sub;
    MaterialButton one, two, three, add;
    MaterialButton modulus, zero, dot, equal;

    TextView result, calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiment12);

        result = findViewById(R.id.result);
        calculate = findViewById(R.id.calculate);

        allclear = findViewById(R.id.allclear);
        allclear.setOnClickListener(this);

        clear = findViewById(R.id.clear);
        clear.setOnClickListener(this);

        factorial = findViewById(R.id.factorial);
        factorial.setOnClickListener(this);

        divide = findViewById(R.id.divide);
        divide.setOnClickListener(this);

        seven = findViewById(R.id.seven);
        seven.setOnClickListener(this);

        eight = findViewById(R.id.eight);
        eight.setOnClickListener(this);

        nine = findViewById(R.id.nine);
        nine.setOnClickListener(this);

        multiply = findViewById(R.id.multiply);
        multiply.setOnClickListener(this);

        four = findViewById(R.id.four);
        four.setOnClickListener(this);

        five = findViewById(R.id.five);
        five.setOnClickListener(this);

        six = findViewById(R.id.six);
        six.setOnClickListener(this);

        sub = findViewById(R.id.sub);
        sub.setOnClickListener(this);

        one = findViewById(R.id.one);
        one.setOnClickListener(this);

        two = findViewById(R.id.two);
        two.setOnClickListener(this);

        three = findViewById(R.id.three);
        three.setOnClickListener(this);

        add = findViewById(R.id.add);
        add.setOnClickListener(this);

        modulus = findViewById(R.id.modulus);
        modulus.setOnClickListener(this);

        zero = findViewById(R.id.zero);
        zero.setOnClickListener(this);

        dot = findViewById(R.id.dot);
        dot.setOnClickListener(this);

        equal = findViewById(R.id.equal);
        equal.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        MaterialButton button = (MaterialButton) v;
        String result1 = button.getText().toString();
        String calculate1 = calculate.getText().toString();

        if (result1.equals("AC")) {
            result.setText("");
            calculate.setText("");
            return;
        }

        if (result1.equals("=")) {
            calculate.setText(result.getText());
            return;
        }

        if(result1.equals("!")){
            try {
                result.setText(fact(Integer.parseInt(calculate1)));
                calculate1 += result1;
                calculate.setText(calculate1);
                return;
            }
            catch (Exception e){
                e.printStackTrace();
                result.setText(R.string.incorrect);
            }
        }

        if (result1.equals("C")) {
            if (calculate1.length() == 1) {
                calculate.setText("");
                result.setText("");
                return;
            }
            if (calculate1.length() > 1) {
                calculate1 = calculate1.substring(0, calculate1.length() - 1);
                calculate.setText(calculate1);
            }
            getResult(calculate1);
            calculate.setText(calculate1);
        }
        else {
            calculate1 += result1;
        }
        getResult(calculate1);
        calculate.setText(calculate1);
    }

    public void getResult(String data) {
        try {
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initStandardObjects();
            String finalResult = context.evaluateString(scriptable, data, "Javascript", 1, null).toString();
            if (result.getText().toString().length() != 0) {
                if (finalResult.endsWith(".0"))
                    finalResult = finalResult.replace(".0", "");
                result.setText(finalResult);
            }
        } catch (Exception e) {
            result.setText(R.string.incorrect);
        }
    }

    public String fact(int value){
        int factorial = 1;
        if(value == 1 || value == 0)
            return String.valueOf(1);
        else{
            for(int i = 2 ; i <= value ; i++)
                factorial *= i;
            return String.valueOf(factorial);
        }
    }
}