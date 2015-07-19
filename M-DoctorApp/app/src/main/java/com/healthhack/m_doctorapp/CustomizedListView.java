package com.healthhack.m_doctorapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import android.app.Activity;
import android.app.TabActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ExpandableListView;
import android.widget.ListView;

public class CustomizedListView extends Activity {
	// All static variables
	//static final String URL = "http://api.androidhive.info/music/music.xml";
	// XML node keys
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
		

		HashMap<Doctor, List<Patient>>docpatientList = new HashMap<Doctor, List<Patient>>();

        populateData();

        Hospital hospital=new Hospital(101, "Dr Seema Jains Gynae Galaxy", 18.564363, 73.774886);

        Iterator<Doctor> it = docList.iterator();
        mydocList=new ArrayList<Doctor>();
        while (it.hasNext()){
            Doctor d = (Doctor) it.next();
            if (d.getHospital_id()==101){
                mydocList.add(d);
            }
        }
		//XMLParser parser = new XMLParser();
		//String xml = parser.getXmlFromUrl(URL); // getting XML from URL
		//Document doc = parser.getDomElement(xml); // getting DOM element
		
		//NodeList nl = doc.getElementsByTagName(KEY_SONG);
		// looping through all song nodes <song>
        final HashMap<Doctor, List<Patient>> map = new HashMap<Doctor, List<Patient>>();

		for (int i = 0; i < docpatientmap.size(); i++) {
			// creating new HashMap
			// adding each child node to HashMap key => value
            for (Map.Entry<Patient, Doctor> entry : docpatientmap.entrySet())
            {
                Doctor d = entry.getValue();
                Patient p = entry.getKey();
                if (docpatientList.containsKey(d)){
                    List<Patient> existing = docpatientList.get(d);
                    existing.add(p);
                    map.put(d,existing);
                }
                else{
                    List<Patient> newlist = new ArrayList<Patient>();
                    newlist.add(p);
                    map.put(d,newlist);
                }

            }

			// adding HashList to ArrayList
            //docpatientList.add(map);
		}
        System.out.println(map);


        list=(ListView)findViewById(R.id.list);
		System.out.println(docpatientList);
		// Getting adapter by passing xml data ArrayList
        adapter=new LazyAdapter(this, mydocList);
        //list.setItemsCanFocus(false);
        //list.setChoiceMode(ExpandableListView.CHOICE_MODE_MULTIPLE);
        list.setAdapter(adapter);
        

        // Click event for single list row
        list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
                List<Patient> mypatientList=map.get(mydocList.get(position));

                LazyAdapter adapter1 = new LazyAdapter(CustomizedListView.this, mypatientList, position);
                //ListView sublist;
                ((ListView)parent).setAdapter(adapter1);
                //sublist.setAdapter(adapter);
                //super.onListItemClick(sublist, view, position, id);
            }
		});

	}


    private void populateData() {
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

    }
}

