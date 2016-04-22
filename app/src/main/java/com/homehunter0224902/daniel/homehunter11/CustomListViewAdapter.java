package com.homehunter0224902.daniel.homehunter11;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Daniel on 4/21/2016.
 */
public class CustomListViewAdapter extends ArrayAdapter<Property> {


    Context context; // save context reference

    public CustomListViewAdapter(Context context, int resourceId, //resourceId=your layout
                                 List<Property> items) {
        super(context, resourceId, items);
        this.context = context;
    }

    /*private view holder class*/
    private class ViewHolder {
        TextView address;
        ImageView pic;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        Property property = getItem(position);

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        // if the view is not created, create it
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_layout1,
                    null); // inflate the layout programmatically to create in memory model
            holder = new ViewHolder();
            holder.pic = (ImageView) convertView.findViewById(R.id.imageView);
            holder.address = (TextView) convertView.findViewById(R.id.textView3);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag(); // when view is getting reused
        }


        holder.address.setText(property.getAddress()+property.getRent().toString()+property.getPayPeriod()+property.getBeds()+"br"+property.getBaths()+"ba");
        holder.pic.setImageDrawable(property.getPic());

        return convertView;
    }
}
