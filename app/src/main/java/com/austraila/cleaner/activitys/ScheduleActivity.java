package com.austraila.cleaner.activitys;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.austraila.cleaner.R;
import com.austraila.cleaner.adapter.CustomAdapter;
import com.austraila.cleaner.config.Config;
import com.austraila.cleaner.database.DataBaseHelper;
import com.austraila.cleaner.models.BinModel;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;

public class ScheduleActivity extends AppCompatActivity {

    private SQLiteDatabase db;
    private SQLiteOpenHelper openHelper;
    private Cursor cursor;


    ArrayList<String[]> mArrayList = new ArrayList<String[]>();
    ArrayList<String> groupkeyList = new ArrayList<String>();
    ArrayList<ArrayList<String[]>> grouplist = new ArrayList<ArrayList<String[]>>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_schedule);

        openHelper = new DataBaseHelper(this);
        db = openHelper.getReadableDatabase();

        MobileAds.initialize(this, "ca-app-pub-3940256099942544/6300978111");
        AdView adView = findViewById(R.id.adView);
        AdRequest request = new AdRequest.Builder().build();
        adView.loadAd(request);

        cursor = db.rawQuery("SELECT *FROM " + DataBaseHelper.TABLE_NAME, null);

        String[] data;
        if (cursor != null) {
            while(cursor.moveToNext()) {
                data = new String[3]; // Note this addition
                data[0] = cursor.getString(cursor.getColumnIndex("BinDate"));
                data[1] = cursor.getString(cursor.getColumnIndex("BinCycle"));
                data[2] = cursor.getString(cursor.getColumnIndex("BinColour"));
                mArrayList.add(data);
            }
            cursor.close();
        }
        for(int i = 0; i < mArrayList.size(); i ++){
            String keydate = mArrayList.get(i)[0];
            if(groupkeyList != null){
                if(!groupkeyList.contains(keydate)){
                    groupkeyList.add(keydate);
                }else{
                    continue;
                }
            }
        }

        if(groupkeyList != null) {
            for (int i = 0; i < groupkeyList.size(); i++) {
                ArrayList<String[]> BinData = new ArrayList<String[]>();
                for (int j = 0; j < mArrayList.size(); j++) {
                    if (groupkeyList.get(i).equals(mArrayList.get(j)[0])) {
                        BinData.add(mArrayList.get(j));
                        Log.e("BinData data ==", String.valueOf(BinData.size()));
                    }

                }
                grouplist.add(BinData);
            }
        }

        ArrayList mylist=new ArrayList<>();
        Config config = new Config();
        for(int i = 0; i < grouplist.size(); i ++){
            Log.e("grouplist", String.valueOf(grouplist.get(i).size()));
            if(grouplist.get(i).size() == 1){
                mylist.add(new BinModel(grouplist.get(i).get(0)[0], config.bin_image_array[Integer.parseInt(grouplist.get(i).get(0)[2])],0, 0));
            }

            if(grouplist.get(i).size() == 2){
                mylist.add(new BinModel(grouplist.get(i).get(0)[0], config.bin_image_array[Integer.parseInt(grouplist.get(i).get(0)[2])]
                        , config.bin_image_array[Integer.parseInt(grouplist.get(i).get(1)[2])], 0));
            }

            if(grouplist.get(i).size() == 3){
                mylist.add(new BinModel(grouplist.get(i).get(0)[0]
                        , config.bin_image_array[Integer.parseInt(grouplist.get(i).get(0)[2])]
                        , config.bin_image_array[Integer.parseInt(grouplist.get(i).get(1)[2])]
                        , config.bin_image_array[Integer.parseInt(grouplist.get(i).get(2)[2])]));
            }
        }
        ListView listView = findViewById(R.id.listview);
        CustomAdapter myAdapter=new CustomAdapter(ScheduleActivity.this, R.layout.listview_item, mylist);
        listView.setAdapter(myAdapter);
    }
}
