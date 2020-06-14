package com.austraila.cleaner.activitys;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.austraila.cleaner.R;
import com.austraila.cleaner.database.DataBaseHelper;

import java.util.Calendar;
import java.util.Date;

public class CollectionActivity extends AppCompatActivity {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    Button backBtn, nextBtn;
    DatePicker datePicker;
    TextView binNumber;
    int total;
    int startNum;
    int selectedColour;
    int cycleNum;
    String binDate;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);

        getSupportActionBar().hide();

        openHelper = new DataBaseHelper(this);

        // from the CycleActivity data
        total = getIntent().getExtras().getInt("total");
        startNum = getIntent().getExtras().getInt("startNum");
        selectedColour = getIntent().getExtras().getInt("selectedColour");
        cycleNum = getIntent().getExtras().getInt("cycleNum");

        // today date
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int day = c.get(Calendar.DAY_OF_MONTH);
        binDate = String.valueOf(year) +"-"+ String.valueOf(month) +"-"+ String.valueOf(day);

        // get the date from datepicker
        datePicker = findViewById(R.id.datePicker);
        datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                binDate = (new StringBuilder().append(year).append("-").append(monthOfYear + 1).append("-").append(dayOfMonth).append("")).toString();
            }
        });

        // selected bin Number
        binNumber = findViewById(R.id.binNumber);
        binNumber.setText(String.valueOf(startNum + 1));

        // go back the CycleActivity
        backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CollectionActivity.super.onBackPressed();
            }
        });

        // go next the SetupActivity
        nextBtn = findViewById(R.id.next_button);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = openHelper.getWritableDatabase();
                insertData(binDate,selectedColour,cycleNum);

                if(startNum < total) {
                    startNum += 1;
                    total -= 1;
                    Intent intent = new Intent(CollectionActivity.this, BinColourActivity.class);
                    intent.putExtra("startnum", startNum);
                    intent.putExtra("total", total);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(CollectionActivity.this, SetupActivity.class);
                    startActivity(intent);
                }
            }

            private void insertData(String binDate, int selectedColour, int cycleNum) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(String.valueOf(DataBaseHelper.COL_2),cycleNum);
                contentValues.put(String.valueOf(DataBaseHelper.COL_3),selectedColour);
                contentValues.put(DataBaseHelper.COL_4,binDate);
                Log.d("contentvalues", String.valueOf(contentValues));
                db.insert(DataBaseHelper.TABLE_NAME,null,contentValues);
            }
        });
    }
}
