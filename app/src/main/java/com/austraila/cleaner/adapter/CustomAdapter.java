package com.austraila.cleaner.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.austraila.cleaner.R;
import com.austraila.cleaner.config.Config;
import com.austraila.cleaner.models.BinModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CustomAdapter extends ArrayAdapter {

    ArrayList listItem = new ArrayList<>();

    public CustomAdapter(Context context, int textViewResourceId, ArrayList objects) {
        super(context, textViewResourceId, objects);
        listItem = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        BinModel model = (BinModel) listItem.get(position);
        TextView binday, binmonth, weekday;
        ImageView image1, image2, image3;
        int monthNum;
        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.listview_item, null);

        binday = v.findViewById(R.id.binday);
        binmonth = v.findViewById(R.id.binmonth);
        weekday = v.findViewById(R.id.weekday);

        image1 = v.findViewById(R.id.image1);
        image2 = v.findViewById(R.id.image2);
        image3 = v.findViewById(R.id.image3);

        String[] separated = model.getBindate().split("-");
        binday.setText(separated[2]);

        Config config = new Config();
        monthNum = Integer.parseInt(separated[1]);
        binmonth.setText(config.month_array[monthNum]);

//        Calendar calendar = new GregorianCalendar(Integer.parseInt(separated[0])
//                , Integer.parseInt(separated[1])
//                , Integer.parseInt(separated[2]));

        String dtStart = model.getBindate();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        Date date = new Date();
        try {
            date = format.parse(dtStart);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int reslut = cal.get(Calendar.DAY_OF_WEEK);
        weekday.setText(config.bin_week_array[reslut]);

        image1.setImageResource(model.getBinImage1());
        image2.setImageResource(model.getBinImage2());
        image3.setImageResource(model.getBinImage3());

        return v;

    }

}