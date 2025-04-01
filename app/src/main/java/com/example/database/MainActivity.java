package com.example.database;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btn;
        EditText etFName;
        EditText etLName;
        EditText etAdress;
        EditText etPhone;
        ListView lv;
        btn=findViewById(R.id.btn);
        etFName=findViewById(R.id.etFName);
        etLName=findViewById(R.id.etLName);
        etAdress=findViewById(R.id.etAdress);
        etPhone=findViewById(R.id.etPhone);
        lv=findViewById(R.id.lv);
        Database db=Database.getInstance(this);
        TavlaDao tavlaDao=db.TavlaDao();
        List<Tavla> all= tavlaDao.getAllInfo();
        ArrayList<String> contacts=new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contacts);
        lv.setAdapter(adapter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}