/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asoli
 */

import java.util.ArrayList;

public class BottleDispenser {
    private int bottles;
    private double money;
    ArrayList<Bottle> bottleList;
    
    public BottleDispenser() {
        bottles = 5;
        money = 0;
        bottleList = new ArrayList<>(); 
        
        /* Add Bottle-objects to the array
        for(int i = 0; i < bottles; i++) {
            // Use the default constructor to create new Bottles
            Bottle temp = new Bottle();
            bottleList.add(temp);
        }
        */
        
        bottleList.add(new Bottle("Pepsi Max", "Pepsi", 0.3, 0.5, 1.8));
        bottleList.add(new Bottle("Pepsi Max", "Pepsi", 0.9, 1.5, 2.2));
        bottleList.add(new Bottle("Coca-Cola Zero", "Coca-Cola", 0.3, 0.5, 2.0));
        bottleList.add(new Bottle("Coca-Cola Zero", "Coca-Cola", 0.9, 1.5, 2.5));
        bottleList.add(new Bottle("Fanta Zero", "Coca-Cola", 0.3, 0.5, 1.95));
        //bottleList.add(new Bottle("Pepsi Max", "Pepsi", 0.3, 0.5, 1.8));
        //bottleList.add(new Bottle("Pepsi Max", "Pepsi", 0.3, 0.5, 1.8));
        
        
    }
    
    public void addMoney() {
        money += 1;
        System.out.println("Klink! Added more money!");
    }
    
    public Bottle buyBottle(int indeksi) {
        
        Bottle bottle1 = bottleList.get(indeksi);

        /* buybottle ottaa sisäänsä pullon indeksin mitä käyttää hakemaan 
           pullon indeksi pääclassissa kysäistä käyttäjältä numero
           buybottle aliohjelmassa pitää tarkastaa että pullo x on olemassa,
           pikkaisen muokattu ehtorakenne
           erilaiset pullot, uusia pulloja listalle, määrittää pulloille eri 
           tyypit, esim setfunktiot pulloluokkaan jotta pystyy asettaa pulloille
           arvoja. Rakentajaan laita paramtertit jolloin pulloista saa oikean tyyppiset.
        */
        
        double hinta = bottle1.getPrice();

        if (money < hinta){
            System.out.println("Add money first!");
        }
        else if (bottleList.size() < 0){
            System.out.println("No bottles left, cannot buy bottles.");
        }
        else{
            money -= hinta;
            System.out.println("KACHUNK! " +  bottle1.getName() + " came out of"
                    + " the dispenser!");
            deleteBottle(bottle1);
        }
        return bottle1;
    }
    
    public void returnMoney() {
        String m = String.format("%.2f", money);
        System.out.println("Klink klink. Money came out! You got " + m + "€ back");
    }
    
    public ArrayList<Bottle> listBottles(){
        Integer indeksi = 0;
        for (Bottle bottle : bottleList){
            indeksi ++;
            System.out.println(indeksi.toString() + "." + " Name: " 
                    + bottle.getName() +"\n\tSize: " + bottle.getSize()+ 
                    "\tPrice: " + bottle.getPrice());
        }
        return bottleList;
    }
    
    public void deleteBottle(Bottle bottle)
    {
        bottleList.remove(bottle);
    }
}
