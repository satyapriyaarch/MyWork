package com.satya.mywork.mywork;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by apple on 8/4/17.
 */

public class SpinnerAdapter extends BaseAdapter {

        Activity activity;
    ArrayList<String> arrayList;

    public SpinnerAdapter(Activity activity, ArrayList arrayList) {
        this.activity = activity;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {

        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {

        return i;
    }



    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        if(view == null) {
            view = inflater.inflate(R.layout.custom_spinner_layout, null);
        }
        TextView textView = (TextView)view.findViewById(R.id.textView);
        textView.setText(arrayList.get(i));

        return view;

    }

}
