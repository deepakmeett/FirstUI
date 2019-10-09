package com.example.firstui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox c1, c2;
    TextView t1, textView, textView1;
    Button b1, b2, b3;
    String s1 = "";
    String s2 = "";
    RatingBar ratingBar;
    AutoCompleteTextView autoCompleteTextView;
    String[] inputs = {"India", "England", "Paris", "New York",
            "Dubai", "Switzerland", "Pakistan", "Iran", "China",};
    Switch switchA;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Activity 1");

        ratingBar = findViewById(R.id.rate);
        b3 = findViewById(R.id.button3);
        textView1 = findViewById(R.id.text4);
        c1 = findViewById(R.id.checkBox);
        c2 = findViewById(R.id.checkBox1);
        t1 = findViewById(R.id.textView);
        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button1);
        textView = findViewById(R.id.text3);
        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);

        textView.setText("Text Inputs:\nIndia, England, Paris, " +
                "New York, Dubai, Switzerland, Pakistan, Iran, China,");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, R.layout.support_simple_spinner_dropdown_item, inputs);
        autoCompleteTextView.setAdapter(adapter);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(in);

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (c1.isChecked()) {
                    s1 = c1.getText().toString();

                }
                if (c2.isChecked()) {
                    s2 = c2.getText().toString();

                }
                t1.setText(s1 + " " + s2);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ratingSubmit(v);
            }
        });

    }

    public void ratingSubmit(View view) {
        float rating_Value = ratingBar.getRating();

        if (rating_Value < 2) {
            textView1.setText("Rating: " + rating_Value + " Is it that worse");
        } else if (rating_Value <= 3) {
            textView1.setText("Rating: " + rating_Value + " We will try to be better");
        } else if (rating_Value <= 4) {
            textView1.setText("Rating: " + rating_Value + " That means you are having a good time :)");
        } else if (rating_Value > 4) {
            textView1.setText("Rating: " + rating_Value + " Wow! We will keep up the good work :)");
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        MenuItem item = menu.findItem(R.id.switchID);
        item.setActionView(R.layout.activity_main5);
        switchA = item.getActionView().findViewById(R.id.switchAB);

        switchA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    Toast.makeText(MainActivity.this, "IF", Toast.LENGTH_SHORT).show();
                } else {
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    Toast.makeText(MainActivity.this, "Else", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return true;
    }
}