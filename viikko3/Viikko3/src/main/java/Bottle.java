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
    private String name = "Pepsi-Max";
    private String manufacturer = "Pepsi";
    private double total_energy = 0.3;
    public Bottle(){}
    public Bottle(String name, String manuf, float totE){}
    public String getName(){
        return name;
    }
    public String getManufacturer(){
        return manufacturer;
    }
    public double getEnergy(){
        return total_energy;
    }
}