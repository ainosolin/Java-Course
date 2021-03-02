package com.example.bottledispenser;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView infoBox;
    TextView getInfoBox2;
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

    }

    private void returnMoney() {
        double change = bottleDisp.returnMoney();
        String m = String.format("%.2f", change);
        infoBox.findViewById(R.id.infoBox);
        infoBox.setText("Klink klink. Money came out! You got " + m + "€ back");
    }

    public void addMoney() {
        moneySlider = (SeekBar) findViewById(R.id.moneySlider);
        infoBox = (TextView) findViewById(R.id.infoBox);
        bottleDisp.addMoney(amt);
        double curBalance = bottleDisp.getMoney();
        String text = String.format("Current balance: %.2f€.", curBalance);
        infoBox.setText(text);
    }


}