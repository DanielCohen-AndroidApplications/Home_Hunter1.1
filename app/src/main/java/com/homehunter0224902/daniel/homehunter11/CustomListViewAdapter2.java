package com.homehunter0224902.daniel.homehunter11;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by Daniel on 4/21/2016.
 */
public class CustomListViewAdapter2 extends ArrayAdapter<Appointment> {


    Context context; // save context reference

    public CustomListViewAdapter2(Context context, int resourceId, //resourceId=your layout
                                 List<Appointment> items) {
        super(context, resourceId, items);
        this.context = context;
    }

    /*private view holder class*/
    private class ViewHolder {
        TextView info;
        ImageView pic;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        Appointment appointment = getItem(position);

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        // if the view is not created, create it
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_layout1,
                    null); // inflate the layout programmatically to create in memory model
            holder = new ViewHolder();
            holder.pic = (ImageView) convertView.findViewById(R.id.imageView);
            holder.info = (TextView) convertView.findViewById(R.id.textView3);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag(); // when view is getting reused
        }

        try{
            holder.info.setText("Meet with "+appointment.getContact()+" at "+appointment.getTime().toString());
            holder.pic.setImageDrawable(appointment.getPic());
        }catch(Exception e) {
            Log.d("_dan", e.getMessage());
        }
        return convertView;
    }
}
