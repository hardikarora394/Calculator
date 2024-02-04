package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Button b1, b2, b3, b4;
    EditText ed1, ed2;
    TextView txt1, tf;
    int num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);

        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);

        txt1 = findViewById(R.id.txt1);
        tf = findViewById(R.id.tf);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performOperation('+');
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performOperation('-');
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performOperation('*');
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performOperation('/');
            }
        });
    }

    private void performOperation(char operator) {
        int num1 = Integer.parseInt(ed1.getText().toString());
        int num2 = Integer.parseInt(ed2.getText().toString());
        int result = 0;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    tf.setText("Error: Division by zero");
                    return;
                }
                break;
        }

        tf.setText(Integer.toString(result));
    }
}
