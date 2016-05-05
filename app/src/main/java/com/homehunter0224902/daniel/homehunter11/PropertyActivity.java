package com.homehunter0224902.daniel.homehunter11;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
    TextView addressTextView, descriptionTextView, longTextView, guarantorTextView, couplesTextView, petsTextView, smokingTextView,sqftTextView;
    Button scheduleShowingBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_property);
        try {
            imageButton = (ImageButton) findViewById(R.id.imageButton);
            imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
            imageButton3 = (ImageButton) findViewById(R.id.imageButton3);
            imageButton4 = (ImageButton) findViewById(R.id.imageButton4);
            scheduleShowingBtn=(Button) findViewById(R.id.scheduleShowingBtn);

            addressTextView = (TextView) findViewById(R.id.addressTextView);
            descriptionTextView = (TextView) findViewById(R.id.descriptionTextView);
            longTextView = (TextView) findViewById(R.id.longTextView);
            guarantorTextView = (TextView) findViewById(R.id.guarantorTextView);
            couplesTextView = (TextView) findViewById(R.id.couplesTextView);
            petsTextView = (TextView) findViewById(R.id.petsTextView);
            smokingTextView = (TextView) findViewById(R.id.smokingTextView);
            sqftTextView = (TextView) findViewById(R.id.sqftTextView);

            properties = new ArrayList<Property>();
            Property prop1 = new Property("125 W 21 Street, New York, New York", ResourcesCompat.getDrawable(getResources(), R.drawable.nyny_125w21st, null), 6700, "mo", 300000);
            prop1.setBeds(2.0);
            prop1.setBaths(2.0);
            prop1.setGuarantor(true);
            prop1.setCouples(true);
            prop1.setSmoking(false);
            prop1.setPets(true);
            prop1.setSqft(1115.4);
            prop1.setShortBlurb("Downtown Luxury Condominium");
            prop1.setBigBlurb("Deluxe corner apartment in beautiful pre-war building");
            properties.add(prop1);

            Property prop2 = new Property("620 E 20th Street, New York, New York", ResourcesCompat.getDrawable(getResources(), R.drawable.nyny_620e20th, null), 3348, "mo", 200000);

            prop2.setBeds(2.0);
            prop2.setBaths(2.0);
            properties.add(prop2);


            propertyNumber = getIntent().getIntExtra("propertyNumber", 0);
            selection = properties.get(propertyNumber);
            selection.setPic2(selection.getPic());
            selection.setPic3(selection.getPic());
            selection.setPic4(selection.getPic());
            imageButton.setImageDrawable(selection.getPic());
            imageButton2.setImageDrawable(selection.getPic2());
            imageButton3.setImageDrawable(selection.getPic3());
            imageButton4.setImageDrawable(selection.getPic4());
            addressTextView.setText(selection.getAddress());
            descriptionTextView.setText(selection.getBeds() + " Br, " + selection.getBaths() + " Ba, " + selection.getShortBlurb() + " " + selection.getRent() + "/" + selection.getPayPeriod());
            longTextView.setText(selection.getBigBlurb());
            sqftTextView.setText(selection.getSqft() + "");
            if (selection.getGuarantor()) {
                guarantorTextView.setText("Guarantors Allowed");
            } else {
                guarantorTextView.setText("Guarantors NOT Allowed");
            }

            if (selection.getCouples()) {
                couplesTextView.setText("Couples Welcome");
            } else {
                couplesTextView.setText("No couples");
            }

            if (selection.getPets()) {
                petsTextView.setText("Pets OK");
            } else {
                petsTextView.setText("No Pets");
            }

            if (selection.getSmoking()) {
                smokingTextView.setText("Smoking OK");
            } else {
                smokingTextView.setText("No Smoking");
            }
        }catch (Exception e){
            Log.d(e.getMessage(),"_dan Exception");
        }
    }

    public void scheduleShowing(View v){
        Intent i = new Intent(PropertyActivity.this, AppointmentActivity.class);
        i.putExtra("address", selection.getAddress());
        startActivity(i);
    }

}
