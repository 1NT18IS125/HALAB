package com.example.pooja_lab8_16_12_21;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText name,contact,age;
Button insert,delete,update,view;
DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name= findViewById(R.id.name);
        age= findViewById(R.id.age);
        contact=findViewById(R.id.contact);

        insert= findViewById(R.id.insert);
        update= findViewById(R.id.update);
        delete= findViewById(R.id.delete);
        view=findViewById(R.id.view);

        DB = new DBHelper(this);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT= name.getText().toString();
                String contactTXT= contact.getText().toString();
                String ageTXT = age.getText().toString();

//
                if (nameTXT.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter name and try again", Toast.LENGTH_SHORT).show();
                }
                else{
                    boolean qryStatus = DB.insertData(nameTXT, contactTXT, ageTXT);

                    if(qryStatus==true){
                        Toast.makeText(MainActivity.this,"New record created",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(MainActivity.this,"New record creation Failed!",Toast.LENGTH_SHORT).show();
                    }
                }

                }


        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT= name.getText().toString();
                String contactTXT= contact.getText().toString();
                String ageTXT = age.getText().toString();

                boolean qryStatus = DB.updateData(nameTXT,contactTXT,ageTXT);
                if(qryStatus==true){
                    Toast.makeText(MainActivity.this,"UPDATED SUCCESSFULLYpOO",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"Updation failed",Toast.LENGTH_SHORT).show();
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT= name.getText().toString();
                boolean qryStatus =DB.deleteData(nameTXT);

                if(qryStatus==true){
                    Toast.makeText(MainActivity.this,"Record deleted",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"No record exists to delete",Toast.LENGTH_SHORT).show();
                }
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res= DB.viewData();

                if(res.getCount()==0){
                    Toast.makeText(MainActivity.this,"No record exists",Toast.LENGTH_SHORT).show();
                }
                else{
                    StringBuffer buffer = new StringBuffer();

                    while(res.moveToNext()){
                        buffer.append("Name: "+res.getString(0)+"\n");
                        buffer.append("Mobile no: "+res.getString(1)+"\n");
                        buffer.append("Age: "+res.getString(2)+"\n");
                    }
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setCancelable(true);
                    builder.setTitle("User Data");
                    builder.setMessage(buffer.toString());
                    builder.show();
                }
            }
        });

    }
}