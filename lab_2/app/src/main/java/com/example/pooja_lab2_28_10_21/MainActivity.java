package com.example.pooja_lab2_28_10_21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText n1= findViewById(R.id.num1);
        EditText n2= findViewById(R.id.num2);
        TextView t= findViewById(R.id.res);
        Button bt= findViewById(R.id.bt);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num1= Integer.parseInt(n1.getText().toString());
                int num2= Integer.parseInt(n2.getText().toString());
             String res= String.valueOf(num1+num2);
             Intent it = new Intent(getApplicationContext(),MainActivity2.class);
             it.putExtra("sum",res);
             startActivity(it);

//                t.setText("Result is: "+res);
         }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "Activity started", Toast.LENGTH_SHORT).show();
    }

    public void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "Activity resumed", Toast.LENGTH_SHORT).show();
    }

    public void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "Activity stoped", Toast.LENGTH_SHORT).show();
    }

    public void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "Activity paused", Toast.LENGTH_SHORT).show();
    }

    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "Activity destroyed", Toast.LENGTH_SHORT).show();
    }


}