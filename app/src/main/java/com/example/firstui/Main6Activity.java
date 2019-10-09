package com.example.firstui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main6Activity extends AppCompatActivity {
    Button button;
    View view;
    int day_night = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        button = findViewById(R.id.button);
        view= findViewById(R.id.background_view);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (day_night == 1) {
                    view.setAlpha(1f);
                    day_night++;
                }else {
                    view.setAlpha(0f);
                    day_night--;
                }
            }
        });
    }
}
