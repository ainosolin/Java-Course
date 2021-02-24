package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text;
    TextView text3;
    EditText nameInput;
    String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.textView);
    }

    public void printHello (View v){

        System.out.println("Hello World!");
        text.setText("Hello World!");

    }

    public void changeTextbyInput (View s){
        text3 = (TextView) findViewById(R.id.textView3);
        nameInput = (EditText) findViewById(R.id.nameInput);
        name = nameInput.getText().toString();
        text3.setText(name);
    }

}