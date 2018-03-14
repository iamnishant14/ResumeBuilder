package com.example.nishant.education;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nisha on 30-12-2017.
 */

public class eduAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<eduDetails> eduList;

    public eduAdapter(Context context,ArrayList<eduDetails>list){
        this.context=context;
        this.eduList=list;
    }
    @Override
    public int getCount() {
        return eduList.size();
    }

    @Override
    public Object getItem(int position) {
        return eduList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.floodedulist ,parent,false);
        }
        eduDetails eduDetails=(eduDetails)getItem(position);
        TextView eduTextView=(TextView)convertView.findViewById(R.id.eduTextView);
        eduTextView.setText(eduDetails.getSchoolName().toString());
        Log.v("School Name is :",eduDetails.getSchoolName().toString());
        return convertView;
    }
}
