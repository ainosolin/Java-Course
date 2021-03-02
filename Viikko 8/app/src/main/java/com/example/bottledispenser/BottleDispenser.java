package com.example.bottledispenser;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asoli
 */

import android.widget.TextView;

import java.util.ArrayList;

public class BottleDispenser {
    private int bottles;
    private double money = 0;
    private ArrayList<Bottle> bottleList = new ArrayList<Bottle>();
    private static BottleDispenser bottleDisp = new BottleDispenser();
    public static BottleDispenser getInstance() {
        return bottleDisp;
    }

    public BottleDispenser() {
        bottles = 6;
        bottleList.add(new Bottle("MockaCola", "Mocka-Cola", 150, 0.33, 1.5));
        bottleList.add(new Bottle("MockaCola", "Mocka-Cola", 450, 0.5, 2.5));
        bottleList.add(new Bottle("MockaZero", "Mocka-Cola", 5, 0.33, 1.0));
        bottleList.add(new Bottle("MockaZero", "Mocka-Cola", 15, 0.5, 2.0));
        bottleList.add(new Bottle("Phantasy", "Mocka-Cola", 150, 0.33, 1.75));
        bottleList.add(new Bottle("Phantasy", "Mocka-Cola", 450, 0.5, 2.75));
        listBottles();
    }

    public void addMoney(int amt) {
        money += amt;
    }

    public double getMoney(){
        return money;
    }

    public int findBottle(String bName, double size){
        int i = 0;
        for(Bottle bottle : bottleList) {
            i++;
            String s = bottleList.get(i).getName();
            double r = bottleList.get(i).getSize();
            System.out.println(r + s + i);
            //search the string
            if(bName.equals(s) && size==r) {
                return i;
            }
        }return i;
    }

    public Bottle buyBottle(String bName, double size) {

        int indeksi = findBottle(bName, size);
        indeksi += 1;
        System.out.println(indeksi);

        Bottle bottle1 = bottleList.get(indeksi);

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

    public void listBottles(){
        Integer ind = 0;
        for (Bottle bottle : bottleList){
            ind ++;
            System.out.println(ind.toString() + "." + " Name: "
                    + bottle.getName() +" Size: " + bottle.getSize()+
                    " Price: " + bottle.getPrice());
        }
    }

    public void deleteBottle(Bottle bottle)
    {
        bottleList.remove(bottle);
    }
}