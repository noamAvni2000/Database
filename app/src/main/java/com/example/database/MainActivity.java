package com.example.database;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText et1, et2, et3, et4;
    ArrayList<String> arrList;
    ArrayAdapter<String> arrAdapt;
    ListView lv;
    Button btn;
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
        Database database = Database.getInstance(this);
        TavlaDao tavlaDao = database.TavlaDao();

        et1 = findViewById(R.id.etFName);
        et2 = findViewById(R.id.etLName);
        et3 = findViewById(R.id.etAdress);
        et4 = findViewById(R.id.etPhone);
        btn = findViewById(R.id.btn);
        lv = findViewById(R.id.lv);
        arrList = new ArrayList<>();
        List<Tavla> list;
        Log.d("somthing", "check 1");
        list = tavlaDao.getAllInfo();
        Log.d("somthing", "check 2");
        for(Tavla t: list){
            arrList.add(String.valueOf(t.getId()));
        }
        arrAdapt = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, arrList);
        lv.setAdapter(arrAdapt);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstName = et1.getText().toString().trim();
                String lastName = et2.getText().toString().trim();
                String adress = et3.getText().toString().trim();
                String phone = et4.getText().toString().trim();

                if (firstName.isEmpty() || lastName.isEmpty() || adress.isEmpty() || phone.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    Tavla temp = new Tavla();
                    temp.setFirstName(firstName);
                    temp.setLastName(lastName);
                    temp.setAdress(adress);
                    temp.setPhone(phone);
                    tavlaDao.insert(temp);
                    et1.setText("");
                    et2.setText("");
                    et3.setText("");
                    et4.setText("");

                    Toast.makeText(MainActivity.this, "Contact added!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}