package com.austraila.cleaner.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.austraila.cleaner.R;

public class SetupActivity extends AppCompatActivity {
    Button setupBtn, backBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);
        getSupportActionBar().hide();
        backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetupActivity.super.onBackPressed();
            }
        });
        setupBtn = findViewById(R.id.setupBtn);
        setupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SetupActivity.this, AlarmTakenActivity.class);
                startActivity(intent);
            }
        });
    }
}
