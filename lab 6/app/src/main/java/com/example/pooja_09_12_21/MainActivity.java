package com.example.pooja_09_12_21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView myList;
    String[] languages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myList= findViewById(R.id.list);
        languages=getResources().getStringArray(R.array.languages);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,languages);
        myList.setAdapter(arrayAdapter);

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {

                Toast.makeText(MainActivity.this, "You have selected "+parent.getItemAtPosition(position)+" Language", Toast.LENGTH_SHORT).show();
            }
        });
    }
}