package com.universitaskuningan.simplekalkulator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText number1, number2;
    Button addButton, subtractButton, multiplyButton, divideButton;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        addButton = findViewById(R.id.addButton);
        subtractButton = findViewById(R.id.subtractButton);
        multiplyButton = findViewById(R.id.multiplyButton);
        divideButton = findViewById(R.id.divideButton);
        result = findViewById(R.id.result);

        Button clearButton = findViewById(R.id.clearButton);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number1.setText("");
                number2.setText("");
                result.setText("");
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateNumbers()) {
                    double num1 = Double.parseDouble(number1.getText().toString());
                    double num2 = Double.parseDouble(number2.getText().toString());
                    int res = (int) (num1 + num2); // Mengonversi hasil ke integer
                    result.setText("" + res);
                }
            }
        });

        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateNumbers()) {
                    double num1 = Double.parseDouble(number1.getText().toString());
                    double num2 = Double.parseDouble(number2.getText().toString());
                    int res = (int) (num1 - num2); // Mengonversi hasil ke integer
                    result.setText("" + res);
                }
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateNumbers()) {
                    double num1 = Double.parseDouble(number1.getText().toString());
                    double num2 = Double.parseDouble(number2.getText().toString());
                    int res = (int) (num1 * num2); // Mengonversi hasil ke integer
                    result.setText("" + res);
                }
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateNumbers() && validateDivision()) {
                    double num1 = Double.parseDouble(number1.getText().toString());
                    double num2 = Double.parseDouble(number2.getText().toString());
                    double res = num1 / num2;
                    result.setText("" + res);
                }
            }
        });

    }

    private boolean validateNumbers() {
        if (TextUtils.isEmpty(number1.getText().toString()) || TextUtils.isEmpty(number2.getText().toString())) {
            Toast.makeText(MainActivity.this, "Numbers cannot be empty!", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private boolean validateDivision() {
        double num2 = Double.parseDouble(number2.getText().toString());
        if (num2 == 0) {
            Toast.makeText(MainActivity.this, "Cannot divide by zero!", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
