package com.austraila.cleaner.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.austraila.cleaner.R;

public class AlarmTakenActivity extends AppCompatActivity {
    Button yesbtn, nobtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        getSupportActionBar().hide();
        yesbtn = findViewById(R.id.yesBtn);
        yesbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AlarmTakenActivity.this, RemindActivity.class);
                startActivity(intent);
            }
        });
        nobtn = findViewById(R.id.noBtn);
        nobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AlarmTakenActivity.this, ScheduleActivity.class);
                startActivity(intent);
            }
        });
    }
}
