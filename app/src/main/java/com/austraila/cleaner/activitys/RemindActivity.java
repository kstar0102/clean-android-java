package com.austraila.cleaner.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.austraila.cleaner.R;

public class RemindActivity extends AppCompatActivity {
    Button btnbefore, btnon;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminde);
        getSupportActionBar().hide();
        btnbefore = findViewById(R.id.beforeDay);
        btnon = findViewById(R.id.onday);
        btnbefore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RemindActivity.this, ScheduleActivity.class);
                startActivity(intent);
            }
        });
        btnon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RemindActivity.this, ScheduleActivity.class);
                startActivity(intent);
            }
        });
    }
}
