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
    private int money;
    
    public BottleDispenser() {
        bottles = 5;
        money = 0;
    }
    
    public void addMoney() {
        money += 1;
        System.out.println("Klink! Added more money!");
    }
    
    public void buyBottle() {
        if (money == 0){
            money = 0;
            System.out.println("Add money first!");
        }
        else if (bottles < 0){
            bottles = 0;
            System.out.println("No bottles left, cannot buy bottles.");
        }
        else {
            bottles -= 1;
            money -= 1;
            System.out.println("KACHUNK! Bottle came out of the dispenser!");
        }
    }
    
    public void returnMoney() {
        money = 0;
        System.out.println("Klink klink!! All money gone!");
    }
}
