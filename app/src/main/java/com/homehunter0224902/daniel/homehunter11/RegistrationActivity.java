package com.homehunter0224902.daniel.homehunter11;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.inputmethodservice.Keyboard;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * Created by Daniel on 4/16/2016.
 */
public class RegistrationActivity extends Activity {
    EditText editTextName, editTextEmail, editTextSalary;
    TextView textView;
    Button submit;
    String name, email, salary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextSalary = (EditText) findViewById(R.id.editTextSalary);
        textView=(TextView) findViewById(R.id.textView);
        submit=(Button) findViewById(R.id.submit);

    }
    public void click(View v) {
        name=editTextName.getText().toString();
        email=editTextEmail.getText().toString();
        salary=editTextSalary.getText().toString();
//        textView.setText(name+"\n"+email+"\n"+salary);


        Intent i = new Intent(RegistrationActivity.this,SearchActivity.class);
        i.putExtra("name", name);
        i.putExtra("email", email);
        try {
            i.putExtra("salary", salary);
            startActivity(i);
        }catch(Exception e){
            Log.d("_dan",e.getMessage());
            textView.setText("Enter valid salary");
        }


    }
}
