package com.austraila.cleaner.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.NumberPicker;

import com.austraila.cleaner.R;

public class MainActivity extends AppCompatActivity {
    ImageButton nextBtn;
    NumberPicker numberPicker;
    Number totalcount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        // next button department
        nextBtn = findViewById(R.id.next_button);
        nextBtn.setBackgroundResource(R.drawable.nextarrow);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BinColourActivity.class);
                intent.putExtra("total", totalcount);
                startActivity(intent);
            }
        });

        // the number picker department
        numberPicker = findViewById(R.id.numberPicker);

        numberPicker.setMinValue(1); // min number
        numberPicker.setMaxValue(8); // max number

        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                totalcount = newVal;
            }
        });
    }
}
