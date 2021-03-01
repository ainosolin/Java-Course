package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    /*
    TextView text;
    TextView text3;
    TextView text4;
    EditText nameInput;
    EditText updateTextRealTime;
    String name;
    */

    TextInputEditText inputField;
    EditText inputFileName;

    String userFilename;
    String userText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputFileName = (EditText) findViewById(R.id.fileName);
        inputField = (TextInputEditText) findViewById(R.id.inputField);

        /*

        text = (TextView) findViewById(R.id.textView);
        text4 = (TextView) findViewById(R.id.textView4);
        updateTextRealTime = (EditText) findViewById(R.id.updateTextRealTime);

        Tehtävä 4

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
        */

    }

    // Tehtävä 5

    public void openFile(View v){
        userFilename = inputFileName.getText().toString();
        FileInputStream fis = null;

        try {
            fis = openFileInput(userFilename);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;
            while ((text = br.readLine()) != null){
                sb.append(text).append("\n");
            }

            inputField.setText(sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("File Loaded");
    }

    public void saveFile(View v){

        String userText = inputField.getText().toString();
        userFilename = inputFileName.getText().toString();
        FileOutputStream fos = null;

        try {
            fos = openFileOutput(userFilename, MODE_PRIVATE);
            fos.write(userText.getBytes());
            inputField.getText().clear();
            Toast.makeText(this, "Saved to " + getFilesDir() + "/"
                            + userFilename, Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("File Saved");
    }


    /*

    Tehtävä 1 ja 2

    public void printHello (View v){

        System.out.println("Hello World!");
        text.setText("Hello World!");
    }


    Tehtävä 3

    public void changeTextbyInput (View s){
        text3 = (TextView) findViewById(R.id.textView3);
        nameInput = (EditText) findViewById(R.id.nameInput);
        name = nameInput.getText().toString();
        text3.setText(name);
    }*/


}