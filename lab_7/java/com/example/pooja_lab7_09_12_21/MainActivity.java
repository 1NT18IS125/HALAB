package com.example.pooja_lab7_09_12_21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        int images[] = {R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5,R.drawable.image6};
        Button next= (Button)findViewById(R.id.next);
        Button back= (Button) findViewById(R.id.back);
        ImageView iv= (ImageView) findViewById(R.id.image);
        iv.setImageResource(images[i]);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;
                if(i==6) {
                    i = 0;
                }
                iv.setImageResource(images[i]);

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i--;
                if(i==-1){
                    i=5;
                }
                iv.setImageResource(images[i]);

            }
        });

    }
}