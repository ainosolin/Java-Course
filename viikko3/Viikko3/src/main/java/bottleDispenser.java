/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asoli
 */
public class BottleDispenser {
    private int bottles;
    // The array for the Bottle-objects
    private Bottle[] bottle_array;
    private int money;
    
    public BottleDispenser() {
        bottles = 50;
        money = 0;
        
        // Initialize the array
        bottle_array = new Bottle[bottles];
        // Add Bottle-objects to the array
        for(int i = 0;i<bottles;i++) {
            // Use the default constructor to create new Bottles
            bottle_array[i] = new Bottle();
        }
    }
    
    public void addMoney() {
        money += 1;
        System.out.println("Klink! Added more money!");
    }
    
    public void buyBottle() {
        
        Bottle bottle1 = new Bottle();
        double hinta = bottle1.getPrice();
        
        if (money < hinta){
            System.out.println("Add money first!");
        }
        else if (bottles < 0){
            System.out.println("No bottles left, cannot buy bottles.");
        }
        else {
            bottles -= 1;
            money -= hinta;
            System.out.println("KACHUNK! " +  bottle1.getName() + " came out of"
                    + " the dispenser!");
            
            
        }
    }
    
    public void returnMoney() {
        money = 0;
        System.out.println("Klink klink. Money came out!");
    }
}
