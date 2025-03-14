package com.example.database;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private TextView tv;
    private String thePer;
    private String theS;
    private int theId;
    private int theN;

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
        Database db=Database.getInstance(this);
        TavlaDao tavlaDao=db.TavlaDao();
        Random r=new Random();
        List<Tavla> all= tavlaDao.getAllInfo();

        btn=findViewById(R.id.btn);
        tv=findViewById(R.id.tv);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i=r.nextInt(40);
                thePer= all.get(i).getPer().toString();
                theS=all.get(i).getS().toString();
                theId=all.get(i).getId();
                theN=all.get(i).getN();
                tv.setText(theId+" "+theS+" "+theN+" "+thePer);

            }
        });
    }
}