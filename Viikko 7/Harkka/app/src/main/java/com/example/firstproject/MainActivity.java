package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text;
    //TextView text3;
    TextView text4;
    EditText nameInput;
    EditText updateTextRealTime;
    String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.textView);
        text4 = (TextView) findViewById(R.id.textView4);
        updateTextRealTime = (EditText) findViewById(R.id.updateTextRealTime);

        // Tehtävä 4

        updateTextRealTime.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                text4.setText(updateTextRealTime.getText().toString());
            }
        });
    }

    // Tehtävä 1 ja 2

    public void printHello (View v){

        System.out.println("Hello World!");
        text.setText("Hello World!");
    }


    /* Tehtävä 3

    public void changeTextbyInput (View s){
        text3 = (TextView) findViewById(R.id.textView3);
        nameInput = (EditText) findViewById(R.id.nameInput);
        name = nameInput.getText().toString();
        text3.setText(name);
    }*/


}