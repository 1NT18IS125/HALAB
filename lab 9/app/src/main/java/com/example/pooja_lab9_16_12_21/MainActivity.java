package com.example.pooja_lab9_16_12_21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView w= (WebView)findViewById(R.id.web);
        w.loadUrl("https://www.nmit.ac.in/");
    }
}