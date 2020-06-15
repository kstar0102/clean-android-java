package com.austraila.cleaner.activitys;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.austraila.cleaner.R;
import com.austraila.cleaner.database.DataBaseHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
                if(cycleNum == 0){
                    savedata(7);
                }
                if(cycleNum == 1){
                    savedata(14);
                }
                if(cycleNum == 2){
                    savedata(21);
                }
                if(cycleNum == 3){
                    savedata(28);
                }

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
        });
    }
    public void savedata(int i){
        db = openHelper.getWritableDatabase();

        Date pindate = new Date();
        String dtStart = binDate;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            pindate = format.parse(dtStart);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat dateFormat0 = new SimpleDateFormat("yyyy-MM-dd");
        Date date0 = pindate;
        String dateTime0 = dateFormat0.format(date0);
        insertData(dateTime0,selectedColour,cycleNum);

        if(i == 7){
            while(i<121){
                Date newDate = addDays(pindate, i);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = newDate;
                String dateTime = dateFormat.format(date);
                insertData(dateTime,selectedColour,cycleNum);
                i+=7;
            }
        }
        if(i == 14){
            while(i<121){
                Date newDate = addDays(pindate, i);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = newDate;
                String dateTime = dateFormat.format(date);
                insertData(dateTime,selectedColour,cycleNum);
                i+=14;
            }
        }
        if(i == 21){
            while(i<121){
                Date newDate = addDays(pindate, i);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = newDate;
                String dateTime = dateFormat.format(date);
                insertData(dateTime,selectedColour,cycleNum);
                i+=21;
            }
        }
        if(i == 28){
            while(i<121){
                Date newDate = addDays(pindate, i);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = newDate;
                String dateTime = dateFormat.format(date);
                insertData(dateTime,selectedColour,cycleNum);
                i+=28;
            }
        }

    }

    public void insertData(String binDate, int selectedColour, int cycleNum) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DataBaseHelper.COL_2,cycleNum);
        contentValues.put(DataBaseHelper.COL_3,selectedColour);
        contentValues.put(DataBaseHelper.COL_4,binDate);
        db.insert(DataBaseHelper.TABLE_NAME,null,contentValues);
    }

    public static Date addDays(Date date, int days) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }
}
