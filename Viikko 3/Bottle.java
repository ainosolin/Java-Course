/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asoli
 */
public class Bottle {
    private String name = "Pepsi Max";
    private String manufacturer = "Pepsi";
    private double total_energy = 0.3;
    private double bottle_size = 0.5;
    private double bottle_price = 1.8;
    
    public Bottle(){}
    public Bottle(String name, String manuf, double totE, double bosize,
            double boprice){
        this.name = name;
        this.manufacturer = manuf;
        this.total_energy = totE;
        this.bottle_size = bosize;
        this.bottle_price = boprice;
    }
    
    public String getName(){
        return name;
    }
    public String getManufacturer(){
        return manufacturer;
    }
    public double getEnergy(){
        return total_energy;
    }
    
    public double getPrice(){
        return bottle_price;
    }
    
    public double getSize(){
        return bottle_size;
    }
    
}