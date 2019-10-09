package com.example.firstui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    RadioGroup rg1;
    RadioButton rb1, rb2;
    TextView t1;
    Button b3, b4, b5;
    String r1;
    Thread t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().setTitle("Activity 2");

        rg1 = findViewById(R.id.rg1);
        rb1 = findViewById(R.id.radioButton);
        rb2 = findViewById(R.id.radioButton2);
        t1 = findViewById(R.id.textView2);
        b3 = findViewById(R.id.button2);
        b4 = findViewById(R.id.button3);
        b5 = findViewById(R.id.button4);
        
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int r = rg1.getCheckedRadioButtonId();
                if (r == R.id.radioButton) {
                    r1 = rb1.getText().toString();

                } else if (r == R.id.radioButton2) {
                    r1 = rb2.getText().toString();
                }
                t1.setText(r1);
                Toast.makeText(getApplicationContext(), r1, Toast.LENGTH_SHORT).show();
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, Main4Activity.class);
                startActivity(intent);
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                startActivity(intent);
            }
        });

    }
}