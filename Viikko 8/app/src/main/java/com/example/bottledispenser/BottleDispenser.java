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

import java.util.ArrayList;

public class BottleDispenser {
    private Context context;
    private int bottles;
    private double money = 0;
    private ArrayList<Bottle> bottleList = new ArrayList<Bottle>();
    private ArrayAdapter<Bottle> adapter;
    private static BottleDispenser bottleDisp = null;
    public static BottleDispenser getInstance(Context context, Spinner spinner) {
        if (bottleDisp==null){
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

    public double getMoney(){
        return money;
    }


    public Bottle buyBottle(String bName, double size) {
        int i = 0;
        Bottle bottle1 = bottleList.get(i);

        double hinta = bottle1.getPrice();

        if (money < hinta){
            System.out.println("Add money first!");
        }
        else if (bottleList.size() <= 0){
            System.out.println("No bottles left... Filling the machine...");
            bottles += 5;
        }
        else{
            money -= hinta;
            System.out.println("KACHUNK! " +  bottle1.getName() + " came out of"
                    + " the dispenser!");
            deleteBottle(bottle1);
        }
        return bottle1;
    }

    public double returnMoney() {
        double change = money;
        money = 0;
        return change;
    }

    public void listBottles(TextView infoBox2){
        Integer ind = 0;
        infoBox2.findViewById(R.id.infoBox2);
        infoBox2.setText("");
        for (Bottle bottle : bottleList){
            ind ++;
            String text = ind.toString() + "." + bottle.getName() + " \t" + bottle.getPrice() + "€ \n";
            infoBox2.append(text);
        }

    }

    public void deleteBottle(Bottle bottle)
    {
        bottleList.remove(bottle);
    }
}