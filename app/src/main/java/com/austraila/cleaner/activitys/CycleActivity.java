package com.austraila.cleaner.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.austraila.cleaner.R;

public class CycleActivity extends AppCompatActivity {
    Button backbtn, btn1, btn2, btn3, btn4;
    TextView binNumber;
    int total;
    int startNum;
    int selectedColour;
    int cycleNum;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cycle);

        getSupportActionBar().hide();

        // from the BinColourActivity data
        total = getIntent().getExtras().getInt("total");
        startNum = getIntent().getExtras().getInt("startNum");
        selectedColour = getIntent().getExtras().getInt("selectedColour");

        // selected bin Number
        binNumber = findViewById(R.id.binNumber);
        binNumber.setText(String.valueOf(startNum + 1));

        // go back the BinColourActivity
        backbtn = findViewById(R.id.backBtn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CycleActivity.super.onBackPressed();
            }
        });

        // bin cycle department using button
        btn1 = findViewById(R.id.weeklyBtn);
        btn2 = findViewById(R.id.twoweeklyBtn);
        btn3 = findViewById(R.id.threeweeklyBtn);
        btn4 = findViewById(R.id.fourweeklyBtn);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cycleNum = 0;
                Intent intent = new Intent(CycleActivity.this, CollectionActivity.class);
                intent.putExtra("total", total);
                intent.putExtra("selectedColour", selectedColour);
                intent.putExtra("startNum", startNum);
                intent.putExtra("cycleNum", cycleNum);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cycleNum = 1;
                Intent intent = new Intent(CycleActivity.this, CollectionActivity.class);
                intent.putExtra("total", total);
                intent.putExtra("selectedColour", selectedColour);
                intent.putExtra("startNum", startNum);
                intent.putExtra("cycleNum", cycleNum);
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cycleNum = 2;
                Intent intent = new Intent(CycleActivity.this, CollectionActivity.class);
                intent.putExtra("total", total);
                intent.putExtra("selectedColour", selectedColour);
                intent.putExtra("startNum", startNum);
                intent.putExtra("cycleNum", cycleNum);
                startActivity(intent);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cycleNum = 3;
                Intent intent = new Intent(CycleActivity.this, CollectionActivity.class);
                intent.putExtra("total", total);
                intent.putExtra("selectedColour", selectedColour);
                intent.putExtra("startNum", startNum);
                intent.putExtra("cycleNum", cycleNum);
                startActivity(intent);
            }
        });
    }
}
