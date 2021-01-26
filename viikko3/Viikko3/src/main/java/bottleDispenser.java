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
    private int money;
    ArrayList<Bottle> bottleList;
    
    public BottleDispenser() {
        bottles = 5;
        money = 0;
        bottleList = new ArrayList<>(); 
        
        // Add Bottle-objects to the array
        for(int i = 0; i < bottles; i++) {
            // Use the default constructor to create new Bottles
            Bottle temp = new Bottle();
            bottleList.add(temp);
        }
    }
    
    public void addMoney() {
        money += 1;
        System.out.println("Klink! Added more money!");
    }
    
    public Bottle buyBottle() {
        
        int koko = bottleList.size();
        
        Bottle bottle1 = bottleList.get(koko-1);
        
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
        else if (koko < 0){
            System.out.println("No bottles left, cannot buy bottles.");
        }
        else {
            money -= hinta;
            System.out.println("KACHUNK! " +  bottle1.getName() + " came out of"
                    + " the dispenser!");
            deleteBottle(bottle1);
        }
        return bottle1;
    }
    
    public void returnMoney() {
        money = 0;
        System.out.println("Klink klink. Money came out!");
    }
    
    public ArrayList<Bottle> listBottles(){
        Integer indeksi = 0;
        for (Bottle bottle : bottleList){
            indeksi ++;
            System.out.println(indeksi.toString() + ". " + " Name: " + bottle.getName()+
                    "." + " Price: " + bottle.getPrice()+ " Size: " + bottle.getSize());
        }
        return bottleList;
    }
    
    public void deleteBottle(Bottle bottle)
    {
        bottleList.remove(bottle);
    }
}
