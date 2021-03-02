package com.example.bottledispenser;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView infoBox;
    TextView InfoBox2;
    TextView addMoney;
    TextView retMoney;
    TextView curMoney;

    SeekBar moneySlider;
    int amt = 0;

    BottleDispenser bottleDisp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottleDisp = BottleDispenser.getInstance();

        TextView infoBox = (TextView) findViewById(R.id.infoBox);
        infoBox.setText("BOTTLE DISPENSER");
        TextView infoBox2 = (TextView) findViewById(R.id.infoBox2);
        infoBox2.setText("BOTTLE DISPENSER");

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
                seekBar.setProgress(1);
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

    }

    private void returnMoney() {
        // Get money and set text to infobox
        double change = bottleDisp.returnMoney();
        TextView infoBox2 = (TextView) findViewById(R.id.infoBox2);
        String text = String.format("Klink klink. Money came out! You got %.2f back", change);
        infoBox2.setText(text);
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

        // Reset slider progress and set current amount to 1€

        moneySlider.setProgress(0);
        curMoney.setText("1€");
    }


}