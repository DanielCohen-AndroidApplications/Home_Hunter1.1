package com.homehunter0224902.daniel.homehunter11;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Daniel on 4/21/2016.
 */
public class SearchActivity extends Activity {
    TextView textView2;
    String name, email, salaryString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        textView2=(TextView) findViewById(R.id.textView2);
        try{
            name=getIntent().getStringExtra("name");
            email=getIntent().getStringExtra("email");
            salaryString=getIntent().getStringExtra("salary");
            textView2.setText(name+"\n"+email+"\n"+salaryString);
        }catch (Exception e){
            textView2.setText(e.getMessage());
        }

    }
}
