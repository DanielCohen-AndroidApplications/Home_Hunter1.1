package com.homehunter0224902.daniel.homehunter11;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.text.format.Time;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Daniel on 5/5/2016.
 */
public class AppointmentActivity extends Activity {
    ArrayList<Appointment> appointmentArrayList;
    String address;
    String contact;
    TextView textView4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_appointment);

        address=getIntent().getStringExtra("address");
        textView4=(TextView) findViewById(R.id.textView4);
        textView4.setText("Appointments for "+address);



        contact="Dave";

        appointmentArrayList=new ArrayList<Appointment>();

        Time time1= new Time();
        time1.set(0,0,17,4,5,2016);
        Appointment appt1 = new Appointment(address, contact, time1, ResourcesCompat.getDrawable(getResources(), R.drawable.profilepic, null));

        Time time2= new Time();
        time1.set(0,0,17,5,5,2016);
        Appointment appt2 = new Appointment(address, contact, time2, ResourcesCompat.getDrawable(getResources(), R.drawable.profilepic, null));

        appointmentArrayList.add(appt1);
        appointmentArrayList.add(appt2);

        CustomListViewAdapter2 adapter = new CustomListViewAdapter2(this,R.layout.list_layout1,appointmentArrayList);
        ListView listView = (ListView) findViewById(R.id.listView2);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }
}
