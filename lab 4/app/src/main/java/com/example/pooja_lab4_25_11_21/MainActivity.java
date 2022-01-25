package com.example.pooja_lab4_25_11_21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText t1=findViewById(R.id.Number);
        Button call= findViewById(R.id.button);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num=t1.getText().toString();
                Intent it=new Intent(Intent.ACTION_DIAL);
                it.setData(Uri.parse("tel:"+num));
                startActivity(it);
            }
        });
    }
}