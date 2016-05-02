package com.homehunter0224902.daniel.homehunter11;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.inputmethodservice.Keyboard;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
    Button submit, preferencesBtn,restartBtn;
    String name, email, salary;
    Boolean firstTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextSalary = (EditText) findViewById(R.id.editTextSalary);
        textView=(TextView) findViewById(R.id.textView);
        submit=(Button) findViewById(R.id.submit);
        preferencesBtn=(Button) findViewById(R.id.preferencesBtn);
        restartBtn=(Button)findViewById(R.id.restartBtn);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        name = preferences.getString("Name", "");
        email=preferences.getString("Email","");
        salary=preferences.getString("Salary","");

        if(!name.equals("")||!email.equals("")||!salary.equals("")){
            firstTime=false;
        }else{
         firstTime=true;
        }
        if(firstTime){
            preferencesBtn.setVisibility(View.INVISIBLE);
            restartBtn.setVisibility(View.INVISIBLE);
        }else{
            editTextEmail.setVisibility(View.INVISIBLE);
            editTextName.setVisibility(View.INVISIBLE);
            editTextSalary.setVisibility(View.INVISIBLE);
            submit.setVisibility(View.INVISIBLE);
        }



    }
    public void click(View v) {

                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = preferences.edit();

                name = editTextName.getText().toString();
                editor.putString("Name", name);
                editor.apply();

                email = editTextEmail.getText().toString();
                editor.putString("Email", email);
                editor.apply();

                salary = editTextSalary.getText().toString();
                editor.putString("Salary", salary);
                editor.apply();
                textView.setText(name + "\n" + email + "\n" + salary);


                Intent i = new Intent(RegistrationActivity.this, SearchActivity.class);
//                i.putExtra("name", name);
//                i.putExtra("email", email);
//                try {
//                    i.putExtra("salary", salary);
//                    startActivity(i);
//                } catch (Exception e) {
//                    Log.d("_dan", e.getMessage());
//                    textView.setText("Enter valid salary");
//                }

                startActivity(i);
//            } else if (v.getId() == R.id.restartBtn) {
//                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
//                SharedPreferences.Editor editor = preferences.edit();
//                Intent i = getIntent();
//                name = editTextName.getText().toString();
//                editor.putString("Name", "");
//                editor.apply();
//
//                email = editTextEmail.getText().toString();
//                editor.putString("Email", "");
//                editor.apply();
//
//                salary = editTextSalary.getText().toString();
//                editor.putString("Salary", "");
//                editor.apply();
//
//                startActivity(i);
//
//            }
//        }catch (Exception e){
//            Log.d("_dan click", e.getMessage());
//        }
        }
    public void click2 (View v){
        Intent i = new Intent(RegistrationActivity.this, SearchActivity.class);
//                i.putExtra("name", name);
//                i.putExtra("email", email);
//        try {
//            i.putExtra("salary", salary);
//            startActivity(i);
//        } catch (Exception e) {
//            Log.d("_dan", e.getMessage());
//            textView.setText("Enter valid salary");
//        }
        startActivity(i);
    }

    public void click3(View v){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        Intent i = getIntent();
        name = editTextName.getText().toString();
        editor.putString("Name", "");
        editor.apply();

        email = editTextEmail.getText().toString();
        editor.putString("Email", "");
        editor.apply();

        salary = editTextSalary.getText().toString();
        editor.putString("Salary", "");
        editor.apply();

        startActivity(i);
    }
}
