package com.example.implicitdialer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    EditText phone;
    Button callB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phone=findViewById(R.id.number);
        callB=findViewById(R.id.call);
        callB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number=phone.getText().toString();
                Intent it=new Intent(Intent.ACTION_DIAL);
                it.setData(Uri.parse("tel:"+number));

                startActivity(it);
            }
        });
    }
}