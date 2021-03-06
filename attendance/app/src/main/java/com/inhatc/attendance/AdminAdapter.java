package com.inhatc.attendance;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class AdminAdapter extends BaseAdapter {

    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    ArrayList<SampleData> sample;

    public AdminAdapter(Context context, ArrayList<SampleData> data) {
        mContext = context;
        sample = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return sample.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public SampleData getItem(int position) {
        return sample.get(position);
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        View view = mLayoutInflater.inflate(R.layout.layout_admin_list, null);

        TextView movieName = (TextView)view.findViewById(R.id.movieName);
        TextView grade = (TextView)view.findViewById(R.id.grade);
        TextView userPhone = (TextView)view.findViewById(R.id.userPhone);

        movieName.setText(sample.get(position).getStart());
        if(movieName.getText().toString().equals("9200")){
            movieName.setTextColor(Color.parseColor("#FF0000"));
        }
        grade.setText(sample.get(position).getEnd());

        userPhone.setText("핸드폰 뒤 4자리 : " + sample.get(position).getPhone().substring(7, 11));

        return view;
    }
}