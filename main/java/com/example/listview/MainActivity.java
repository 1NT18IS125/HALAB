package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView ls;
    String countryls [];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ls=findViewById(R.id.list);
        countryls=getResources().getStringArray(R.array.country);
        ArrayAdapter<String> arrayAdapter = new
                ArrayAdapter<String>(this, R.layout.textview_layout,
                countryls);
        ls.setAdapter(arrayAdapter);
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,"you hahe clicked"+adapterView.getItemAtPosition(i),Toast.LENGTH_SHORT).show();
            }
        });
    }
}