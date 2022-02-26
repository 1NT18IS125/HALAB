package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText number1,number2;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number1=findViewById(R.id.num1);
        number2=findViewById(R.id.num2);
        add=findViewById(R.id.add);

        Intent result=new Intent(this, MainActivity2.class);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a=Integer.parseInt(number1.getText().toString());
                int b=Integer.parseInt(number2.getText().toString());
                int Sum=a+b;

                result.putExtra("result",Integer.toString(Sum));
                startActivity(result);

            }
        });

    }
}