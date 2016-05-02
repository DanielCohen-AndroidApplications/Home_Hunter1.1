package com.homehunter0224902.daniel.homehunter11;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Daniel on 5/2/2016.
 */
public class PropertyActivity extends Activity {
    ArrayList<Property> properties;
    int propertyNumber;
    Property selection;
    ImageButton imageButton, imageButton2, imageButton3, imageButton4;
    TextView addressTextView, descriptionTextView, longTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_property);

        imageButton=(ImageButton) findViewById(R.id.imageButton);
        imageButton2=(ImageButton) findViewById(R.id.imageButton2);
        imageButton3=(ImageButton) findViewById(R.id.imageButton3);
        imageButton4=(ImageButton) findViewById(R.id.imageButton4);

        addressTextView=(TextView) findViewById(R.id.addressTextView);
        descriptionTextView=(TextView)findViewById(R.id.descriptionTextView);
        longTextView=(TextView)findViewById(R.id.longTextView);
        properties = new ArrayList<Property>();
        Property prop1=new Property("125 W 21 Street, New York, New York", ResourcesCompat.getDrawable(getResources(), R.drawable.nyny_125w21st, null), 6700, "mo", 300000);
        prop1.setBeds(2.0);
        prop1.setBaths(2.0);
        prop1.setShortBlurb("Downtown Luxury Condominium");
        prop1.setBigBlurb("Deluxe corner apartment in beautiful pre-war building");
        properties.add(prop1);

        Property prop2 = new Property("620 E 20th Street, New York, New York", ResourcesCompat.getDrawable(getResources(), R.drawable.nyny_620e20th, null), 3348, "mo", 200000);

        prop2.setBeds(2.0);
        prop2.setBaths(2.0);
        properties.add(prop2);


        propertyNumber=getIntent().getIntExtra("propertyNumber",0);
        selection=properties.get(propertyNumber);
        selection.setPic2(selection.getPic());
        selection.setPic3(selection.getPic());
        selection.setPic4(selection.getPic());
        descriptionTextView.setText(selection.getBeds()+" Br, "+selection.getBaths()+" Ba, "+selection.getShortBlurb()+" "+selection.getRent()+"/"+selection.getPayPeriod());
        longTextView.setText(selection.getBigBlurb());

    }
}
