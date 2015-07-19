package com.healthhack.m_doctorapp;

import android.app.Activity;
import android.app.TabActivity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Chinmay on 12-07-2015.
 */
public class Appointments extends Activity {
    static final String KEY_SONG = "song"; // parent node
    static final String KEY_ID = "id";
    static final String KEY_TITLE = "title";
    static final String KEY_ARTIST = "artist";
    static final String KEY_DURATION = "duration";
    static final String KEY_THUMB_URL = "thumb_url";

    List<Patient> pList;
    ListView list;
    LazyAdapter adapter;
    List<Doctor>docList,mydocList;
    Hospital hospital;
    Map<Patient, Doctor> docpatientmap;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        TextView title=(TextView)findViewById(R.id.title_bar);
        title.setText("List of Patients");
        list=(ListView)findViewById(R.id.list);
        //System.out.println(docpatientList);
        // Getting adapter by passing xml data ArrayList
        List<Patient> myPatientList=new ArrayList<Patient>();
        Patient p1=new Patient("Raj",1001,"fever","weakness and unwell",1000,2000);
        Patient p3=new Patient("Shekhar",1003,"Heart disease","weakness and unwell",1000,2000);

        myPatientList.add(p1);
        myPatientList.add(p3);
        adapter=new LazyAdapter(this, myPatientList,0);
        ///list.setItemsCanFocus(false);
        //list.setChoiceMode(ExpandableListView.CHOICE_MODE_MULTIPLE);
        list.setAdapter(adapter);


        // Click event for single list row
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //List<Patient> mypatientList=map.get(mydocList.get(position));

                //adapter=new LazyAdapter(CustomizedListView.this, mypatientList,position);
                //ListView sublist;

                //sublist.setAdapter(adapter);
                //super.onListItemClick(sublist, view, position, id);
            }
        });

    }


    /*private void populateData() {
        docList=new ArrayList<Doctor>();
        String[] tag={"cough","fever","headache","stomach ache","running nose"};
        Doctor d1=new Doctor( 1001,"Doc1","physician",tag,'y',101);

        docList.add(d1);
        String[] tag1={"elbow pain","knee pain","fractures"};
        Doctor d2=new Doctor( 1002,"Doc2","orthopaedic",tag1,'y',102);

        docList.add(d2);
        String[] tag2={"skin allergy","itching","rashes"};
        Doctor d3=new Doctor( 1003,"Doc3","allergist",tag2,'y',101);
        docList.add(d3);



        Patient p1=new Patient("Raj",1001,"fever","weakness and unwell",1000,2000);
        Patient p2=new Patient("Chinmay",1002,"Cold","weakness and unwell",1000,2000);
        Patient p3=new Patient("Shekhar",1003,"Heart disease","weakness and unwell",1000,2000);
        Patient p4=new Patient("Avinash",1004,"Cancer","weakness and unwell",1000,2000);

        pList=new ArrayList<Patient>();
        pList.add(p1);
        pList.add(p2);
        pList.add(p3);
        pList.add(p4);

        docpatientmap=new HashMap<Patient,Doctor>();
        docpatientmap.put(p1,d1);
        docpatientmap.put(p2,d2);
        docpatientmap.put(p3,d1);
        docpatientmap.put(p4,d3);

    }*/
}


