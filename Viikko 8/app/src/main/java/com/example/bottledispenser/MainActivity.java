package com.example.bottledispenser;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView infoBox;
    TextView infoBox2;
    TextView addMoney;
    TextView retMoney;
    TextView curMoney;
    Spinner spinner;
    Context context;


    SeekBar moneySlider;
    int amt = 0;
    int selecItem;

    BottleDispenser bottleDisp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();
        spinner = findViewById(R.id.spinner);

        bottleDisp = BottleDispenser.getInstance(context, spinner);

        TextView infoBox = (TextView) findViewById(R.id.infoBox);
        infoBox.setText("BOTTLE DISPENSER");

        TextView retMoney = (TextView) findViewById(R.id.retMoney);
        TextView addMoney = (TextView) findViewById(R.id.addMoney);

        SeekBar moneySlider = (SeekBar) findViewById(R.id.moneySlider);
        TextView curMoney = (TextView) findViewById(R.id.curMoney);

        moneySlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                amt = progress;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                curMoney.setText("" + seekBar.getProgress() + "€");
            }
        });


        retMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnMoney();
            }
        });

        addMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMoney();
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selecItem = spinner.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void returnMoney() {
        // Get money and set text to infobox
        double change = bottleDisp.returnMoney();
        infoBox2 = (TextView) findViewById(R.id.infoBox2);
        if (change == 0){
            String text = "No money to give! Add money to get it back...";
            infoBox2.setText(text);
        } else {
            String text = String.format("Klink klink. Money came out! You got %.2f back", change);
            infoBox2.setText(text);

            infoBox = (TextView) findViewById(R.id.infoBox);
            double curBalance = bottleDisp.getMoney();
            String text2 = String.format("Current balance: %.2f€.", curBalance);
            infoBox.append(text2);
        }
    }

    public void addMoney() {
        // Get the id's of corresponding UI elements

        moneySlider = (SeekBar) findViewById(R.id.moneySlider);
        curMoney = (TextView) findViewById(R.id.curMoney);
        infoBox = (TextView) findViewById(R.id.infoBox);

        // Add money the amt of amt (current slider progress)

        bottleDisp.addMoney(amt);

        // Get balance after adding money to machine and set to infobox.
        double curBalance = bottleDisp.getMoney();
        String text2 = String.format("Current balance: %.2f€.", curBalance);
        infoBox.setText(text2);

        // Reset slider progress and set current amount to 0€
        
        moneySlider.setProgress(0);
        curMoney.setText("0€");

        infoBox2 = (TextView) findViewById(R.id.infoBox2);
        bottleDisp.listBottles(infoBox2);
    }


}