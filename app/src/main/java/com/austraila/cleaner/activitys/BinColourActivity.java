package com.austraila.cleaner.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.austraila.cleaner.R;


public class BinColourActivity extends AppCompatActivity {
    Button nextBtn, redbtn, yellowbtn, bluebtn, brownbtn, greenbtn, purplebtn, blackbtn, whitebtn;
    View colourbin;
    TextView binNumber;
    int total;
    int startNum;
    int selectedColour = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colour);

        getSupportActionBar().hide();

        // from the mainActivity data
        total = getIntent().getExtras().getInt("total");
        startNum = getIntent().getExtras().getInt("startnum");

        // selected bin colour
        colourbin = findViewById(R.id.colourview);
        colourbin.setBackgroundResource(R.color.red);

        // selected bin Number
        binNumber = findViewById(R.id.binNumber);
        binNumber.setText(String.valueOf(startNum + 1));

        // go to next CycleActivity
        nextBtn = findViewById(R.id.next_button);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BinColourActivity.this, CycleActivity.class);
                intent.putExtra("total", total);
                intent.putExtra("selectedColour", selectedColour);
                intent.putExtra("startNum", startNum);
                startActivity(intent);
            }
        });

        // the bin colour`s button department.
        redbtn = findViewById(R.id.redbtn);
        yellowbtn = findViewById(R.id.yellowbtn);
        bluebtn = findViewById(R.id.bluebtn);
        brownbtn = findViewById(R.id.brownbtn);
        greenbtn = findViewById(R.id.greenbtn);
        purplebtn = findViewById(R.id.purplebtn);
        blackbtn = findViewById(R.id.blackbtn);
        whitebtn = findViewById(R.id.whitebtn);

        redbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedColour = 0;
                colourbin.setBackgroundColor(getResources().getColor(R.color.red));
            }
        });

        yellowbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedColour = 1;
                colourbin.setBackgroundColor(getResources().getColor(R.color.yellow));
            }
        });

        greenbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedColour = 2;
                colourbin.setBackgroundColor(getResources().getColor(R.color.green));
            }
        });

        blackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedColour = 3;
                colourbin.setBackgroundColor(getResources().getColor(R.color.black));
            }
        });
        bluebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedColour = 4;
                colourbin.setBackgroundColor(getResources().getColor(R.color.blue));
            }
        });

        brownbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedColour = 5;
                colourbin.setBackgroundColor(getResources().getColor(R.color.brown));
            }
        });

        purplebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedColour = 6;
                colourbin.setBackgroundColor(getResources().getColor(R.color.purple));
            }
        });

        whitebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedColour = 7;
                colourbin.setBackgroundColor(getResources().getColor(R.color.white));
            }
        });

    }
}
