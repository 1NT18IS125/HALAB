package com.example.pooja_lab2_28_10_21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent it= getIntent();
        String s= it.getStringExtra("sum");
        TextView t2= findViewById(R.id.res2);
        t2.setText("Result is: "+ s);
    }
}