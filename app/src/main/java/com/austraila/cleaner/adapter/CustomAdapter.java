package com.austraila.cleaner.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.austraila.cleaner.R;
import com.austraila.cleaner.config.Config;
import com.austraila.cleaner.models.BinModel;

import java.util.ArrayList;

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
        TextView binday, binmonth;
        ImageView image1, image2, image3;
        int monthNum;
        String image_1;
        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.listview_item, null);
        binday = v.findViewById(R.id.binday);
        binmonth = v.findViewById(R.id.binmonth);
        image1 = v.findViewById(R.id.image1);
        image2 = v.findViewById(R.id.image2);
        image3 = v.findViewById(R.id.image3);

        String[] separated = model.getBindate().split("-");
        binday.setText(separated[2]);
        Config config = new Config();
        image_1 = config.bin_image_array[Integer.parseInt(model.getBinImage1())];
        monthNum = Integer.parseInt(separated[1]);
        binmonth.setText(config.month_array[monthNum]);
        image1.setImageResource(R.drawable.red_bin);

        return v;

    }

}