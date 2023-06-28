package com.example.calculatedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText operand1, operand2;
    Button btn_add, btn_sub, btn_mul, btn_div;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MainActivity","onCreate execute");

        operand1 = findViewById(R.id.operand1);
        operand2 = findViewById(R.id.operand2);
        btn_add = findViewById(R.id.btn_add);
        btn_sub = findViewById(R.id.btn_sub);
        btn_mul = findViewById(R.id.btn_mul);
        btn_div = findViewById(R.id.btn_div);
        result = findViewById(R.id.result);

        btn_add.setOnClickListener(this);
        btn_sub.setOnClickListener(this);
        btn_mul.setOnClickListener(this);
        btn_div.setOnClickListener(this);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        float num1 = Float.parseFloat(operand1.getText().toString());
        float num2 = Float.parseFloat(operand2.getText().toString());
        float res = 0;

        switch (v.getId()) {
            case R.id.btn_add:
                res = num1 + num2;
                break;
            case R.id.btn_sub:
                res = num1 - num2;
                break;
            case R.id.btn_mul:
                res = num1 * num2;
                break;
            case R.id.btn_div:
                if (num2 != 0) {
                    res = num1 / num2;
                } else {
                    result.setText("Error: Divide by zero");
                }
                break;
        }

        result.setText(String.valueOf(res));
    }
}