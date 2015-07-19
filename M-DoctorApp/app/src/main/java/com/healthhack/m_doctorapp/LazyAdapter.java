package com.healthhack.m_doctorapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class LazyAdapter extends BaseAdapter {
    
    private Activity activity;
    private List<Doctor> data;
    private List<Patient> data1;
    private static LayoutInflater inflater=null;
    public ImageLoader imageLoader;
    int flag=0;
    
    public LazyAdapter(Activity a, List<Doctor> d) {
        activity = a;
        data=d;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //imageLoader=new ImageLoader(activity.getApplicationContext());
        activity.setTitle("List of Doctors");

    }

    public LazyAdapter(Activity a, List<Patient> p,int position) {
        activity = a;
        activity.setTitle("List of Patients");

        data1=p;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //imageLoader=new ImageLoader(activity.getApplicationContext());
        flag=1;
    }

    public int getCount() {
        if (flag==1)
        return data1.size();
        else
            return data.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }
    
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.list_row, null);

        TextView title = (TextView)vi.findViewById(R.id.title); // title
        TextView artist = (TextView)vi.findViewById(R.id.artist); // artist name
        TextView duration = (TextView)vi.findViewById(R.id.duration); // duration
        ImageView thumb_image=(ImageView)vi.findViewById(R.id.list_image); // thumb image
        //TextView tbar=(TextView)convertView.findViewById(R.id.title_bar);
        ///List<Patient>song = new ArrayList<Patient>();
        //song = data.get(position);
        
        // Setting all values in listview
        if (flag==1)
        {
            title.setText(data1.get(position).pat_name);
            artist.setText(data1.get(position).symptom);
            duration.setText(data1.get(position).description);
            thumb_image.setImageDrawable(vi.getContext().getResources().getDrawable(R.drawable.patient_icon));


            //tbar.setText("List of Patients");
            //imageLoader.DisplayImage("Url", thumb_image);
            return vi;

        }
        else {
            title.setText(data.get(position).doc_name);
            artist.setText(data.get(position).speciality);
            duration.setText("Distance:10km");
            thumb_image.setBackgroundResource(R.drawable.icon_doc);
            //imageLoader.DisplayImage("Url", thumb_image);

            return vi;


        }
    }
}