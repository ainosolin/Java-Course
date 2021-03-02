package com.example.bottledispenser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import org.w3c.dom.Text;

import static android.widget.SeekBar.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView infoBox;
    TextView addMoney;
    TextView retMoney;
    TextView curMoney;

    TextView b1Button;
    TextView b2Button;
    TextView b3Button;
    TextView b4Button;
    TextView b5Button;
    TextView b6Button;

    TextView b1Price;
    TextView b2Price;
    TextView b3Price;
    TextView b4Price;
    TextView b5Price;
    TextView b6Price;

    SeekBar moneySlider;
    int amt = 0;

    String b1Name = "MockaCola";
    String b2Name = "MockaZero";
    String b3Name = "Phantasy";

    BottleDispenser bottleDisp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottleDisp = BottleDispenser.getInstance();

        TextView b1Button = (TextView) findViewById(R.id.b1Button);
        TextView b2Button = (TextView) findViewById(R.id.b2Button);
        TextView b3Button = (TextView) findViewById(R.id.b3Button);
        TextView b4Button = (TextView) findViewById(R.id.b4Button);
        TextView b5Button = (TextView) findViewById(R.id.b5Button);
        TextView b6Button = (TextView) findViewById(R.id.b6Button);

        b1Button.setOnClickListener(this);
        b2Button.setOnClickListener(this);
        b3Button.setOnClickListener(this);
        b4Button.setOnClickListener(this);
        b5Button.setOnClickListener(this);
        b6Button.setOnClickListener(this);

        TextView infoBox = (TextView) findViewById(R.id.infoBox);
        infoBox.setText("BOTTLE DISPENSER");

        TextView b1Price = (TextView) findViewById(R.id.b1Price);
        TextView b2Price = (TextView) findViewById(R.id.b2Price);
        TextView b3Price = (TextView) findViewById(R.id.b3Price);
        TextView b4Price = (TextView) findViewById(R.id.b4Price);
        TextView b5Price = (TextView) findViewById(R.id.b5Price);
        TextView b6Price = (TextView) findViewById(R.id.b6Price);

        b1Price.setText("1.5");
        b2Price.setText("2.5");
        b3Price.setText("1.0");
        b4Price.setText("2.0");
        b5Price.setText("1.75");
        b6Price.setText("2.75");

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
        int amt = moneySlider.getProgress();
        infoBox = (TextView) findViewById(R.id.infoBox);
        bottleDisp.addMoney(amt);
        double curBalance = bottleDisp.getMoney();
        String text = String.format("Current balance: %.2f€.", curBalance);
        infoBox.setText(text);
     }

    @Override
    public void onClick(View v) {
        TextView infoBox = (TextView) findViewById(R.id.infoBox);
        double small = 0.33;
        double big = 0.5;
        switch (v.getId()){
            case R.id.b1Button:
                Toast.makeText(this, "MockaCola (0.33 l)", Toast.LENGTH_SHORT).show();
                bottleDisp.buyBottle(b1Name, small);
                break;
            case R.id.b2Button:
                Toast.makeText(this, "MockaCola (0.5 l)", Toast.LENGTH_SHORT).show();
                bottleDisp.buyBottle(b1Name, big);
                break;
            case R.id.b3Button:
                Toast.makeText(this, "MockaZero (0.33 l)", Toast.LENGTH_SHORT).show();
                bottleDisp.buyBottle(b2Name, small);
                break;
            case R.id.b4Button:
                Toast.makeText(this, "MockaZero (0.5 l)", Toast.LENGTH_SHORT).show();
                bottleDisp.buyBottle(b2Name, big);
                break;
            case R.id.b5Button:
                Toast.makeText(this, "Phantasy (0.33 l)", Toast.LENGTH_SHORT).show();
                bottleDisp.buyBottle(b3Name, small);
                break;
            case R.id.b6Button:
                Toast.makeText(this, "Phantasy (0.5 l)", Toast.LENGTH_SHORT).show();
                bottleDisp.buyBottle(b3Name, big);
                break;

        }
    }

}