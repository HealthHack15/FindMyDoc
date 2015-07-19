package com.healthhack.m_doctorapp;

import java.util.Locale;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;



public class HospitalActivity extends Activity {

    Button btnapp, btndoc;


    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */

    /**
     * The {@link ViewPager} that will host the section contents.
     */





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);

        btnapp=(Button)findViewById(R.id.btnappointment);

        btndoc=(Button)findViewById(R.id.btndoctor);

        btnapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent appoint=new Intent(HospitalActivity.this,Appointments.class);
                startActivity(appoint);
            }
        });
        btndoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent doc=new Intent(HospitalActivity.this,CustomizedListView.class);
                startActivity(doc);
            }
        });
    }




/*

    //TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
        Resources resources=getResources();
        TabHost tabHost = getTabHost();
        System.out.println(tabHost);
        TabHost.TabSpec tab1 = tabHost.newTabSpec("Appointments");
        TabHost.TabSpec tab2 = tabHost.newTabSpec("Doctors");

        // Set the Tab name and Activity
        // that will be opened when particular Tab will be selected
        tab1.setIndicator("Appointments");
        tab1.setContent(new Intent(this, Appointments.class));

        tab2.setIndicator("Doctors");

        tab2.setContent(new Intent(this, CustomizedListView.class));



        */
/** Add the tabs to the TabHost to display. *//*

        tabHost.addTab(tab1);
        tabHost.addTab(tab2);

    }
*/

}
