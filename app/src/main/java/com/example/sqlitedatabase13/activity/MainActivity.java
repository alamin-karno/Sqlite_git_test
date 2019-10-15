package com.example.sqlitedatabase13.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqlitedatabase13.R;
import com.example.sqlitedatabase13.database.SqliteHelper;

public class MainActivity extends AppCompatActivity {

    private EditText nameET,ageET;
    private Button insertbtn,viewBTN;
    private String name,age;
    private SqliteHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        insertbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = nameET.getText().toString();
                age = ageET.getText().toString();
                long id = helper.insertdata(name,age);
                Toast.makeText(MainActivity.this,  "Insert Data "+id, Toast.LENGTH_SHORT).show();
            }
        });

        viewBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ViewDataActivity.class));
            }
        });
    }

    private void init() {
        nameET = findViewById(R.id.nameET);
        ageET = findViewById(R.id.ageET);
        insertbtn = findViewById(R.id.isertBTn);
        viewBTN = findViewById(R.id.viewBTn);
        helper = new SqliteHelper(this);
    }
}
