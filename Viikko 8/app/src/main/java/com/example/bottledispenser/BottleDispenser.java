package com.example.bottledispenser;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asoli
 */

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class BottleDispenser {
    private Context context;
    private int bottles;
    private double money = 0;
    private ArrayList<Bottle> bottleList = new ArrayList<Bottle>();
    private ArrayAdapter<Bottle> adapter;
    private static BottleDispenser bottleDisp = null;
    private String receipt;

    public static BottleDispenser getInstance(Context context, Spinner spinner) {
        if (bottleDisp == null) {
            bottleDisp = new BottleDispenser(context, spinner);
        }
        return bottleDisp;
    }

    public BottleDispenser(Context context, Spinner spinner) {
        bottles = 6;
        bottleList.add(new Bottle("Mocka Cola Small", "Mocka-Cola", 150, 0.33, 1.5));
        bottleList.add(new Bottle("Mocka Cola Big", "Mocka-Cola", 450, 0.5, 2.5));
        bottleList.add(new Bottle("Mocka Zero Small", "Mocka-Cola", 5, 0.33, 1.0));
        bottleList.add(new Bottle("Mocka Zero Big", "Mocka-Cola", 15, 0.5, 2.0));
        bottleList.add(new Bottle("Phanta Sea Small", "Mocka-Cola", 150, 0.33, 1.75));
        bottleList.add(new Bottle("Phanta Sea Big", "Mocka-Cola", 450, 0.5, 2.75));

        spinner.findViewById(R.id.spinner);

        this.context = context;

        adapter = new ArrayAdapter<Bottle>(context.getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, bottleList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

    }

    public void addMoney(int amt) {
        money += amt;
    }

    public double getMoney() {
        return money;
    }

    public void fillDisp(TextView infoBox2) {
        infoBox2.findViewById(R.id.infoBox2);
        bottleList.add(new Bottle("Mocka Cola Small", "Mocka-Cola", 150, 0.33, 1.5));
        bottleList.add(new Bottle("Mocka Cola Big", "Mocka-Cola", 450, 0.5, 2.5));
        bottleList.add(new Bottle("Mocka Zero Small", "Mocka-Cola", 5, 0.33, 1.0));
        bottleList.add(new Bottle("Mocka Zero Big", "Mocka-Cola", 15, 0.5, 2.0));
        bottleList.add(new Bottle("Phanta Sea Small", "Mocka-Cola", 150, 0.33, 1.75));
        bottleList.add(new Bottle("Phanta Sea Big", "Mocka-Cola", 450, 0.5, 2.75));
        adapter.notifyDataSetChanged();
        String text = "Machine restocked.";
        infoBox2.setText(text);
    }

    public void buyBottle(TextView infoBox, TextView infoBox2, int selecItem) {

        infoBox.findViewById(R.id.infoBox);
        infoBox2.findViewById(R.id.infoBox2);

        if (adapter.getCount() <= 0) {
            infoBox.setText("No bottles left... Please fill the machine.");
        } else {
            Bottle bottle1 = bottleList.get(selecItem);
            double hinta = bottle1.getPrice();
            if (money < hinta) {
                String text = "Insufficient funds, add more money.";
                infoBox2.setText(text);
            } else {
                money -= hinta;
                infoBox2.setText("KACHUNK! " + bottle1.getName() + " came out of"
                        + " the dispenser!");
                bottleList.remove(bottle1);
                adapter.notifyDataSetChanged();
                double curBalance = getMoney();
                String text2 = String.format("Current balance: %.2f€.", curBalance);
                infoBox.setText(text2);

                Date currentTime = Calendar.getInstance().getTime();
                receipt =   "Thank you for you purchase! \n" +
                            "Purchased item: " + bottle1.getName() + "\n" +
                            "Item price: " + bottle1.getPrice() + "€ \n" +
                            "Item size: " + bottle1.getSize() +"\n" +
                            "Time of purchase: " + currentTime + "\n";
            }
        }
    }

    public void saveReceipt(TextView infoBox){
        FileOutputStream fos = null;
        try {
            fos = context.openFileOutput("receipt.txt", context.MODE_PRIVATE);
            fos.write(receipt.getBytes());
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
        infoBox.findViewById(R.id.infoBox2);
        String text = String.format("Receipt saved!");
        infoBox.setText(text);
        System.out.println("File Saved");
    }

    public double returnMoney() {
        double change = money;
        money = 0;
        return change;
    }

    public void listBottles(TextView infoBox2) {
        Integer ind = 0;
        infoBox2.findViewById(R.id.infoBox2);
        infoBox2.setText("");
        if (bottleList.isEmpty()) {
            infoBox2.setText("No bottles left... Please fill the machine.");
        } else {
            for (Bottle bottle : bottleList) {
                ind++;
                String text = ind.toString() + "." + bottle.getName() + " \t" + bottle.getPrice() + "€ \n";
                infoBox2.append(text);
            }
        }
    }
}