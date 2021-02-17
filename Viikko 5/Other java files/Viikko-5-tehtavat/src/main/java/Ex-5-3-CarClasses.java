/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author asoli
 */ 

import java.util.ArrayList;

class Car {

  private String LicensePlate = "TQX-264";
  private String Model = "Hyundai";
  int numberofWheels = 4;
  ArrayList<String> carParts;
  private String Body;
  private String Chassis;
  private String Wheel;
  private String Engine;

  public Car () { 
      carParts = new ArrayList<>();
	  Body body = new Body();
      Chassis chassis = new Chassis();
      Engine engine = new Engine();
      Wheel wheel = new Wheel();
      
      carParts.add(body.getName());
      carParts.add(chassis.getName());
      carParts.add(engine.getName());
      carParts.add(wheel.getName());
      
  };
  
  public void setLicensePlate (String newVar) {
    LicensePlate = newVar;
  }
  public String getLicensePlate () {
    return LicensePlate;
  }

  public void setModel (String newVar) {
    Model = newVar;
  }

  public String getModel () {
    return Model;
  }
  
  public void printMetodi() {
      System.out.println("Car parts:");
      
      /* for i in arraylist of car parts print /t and part name plus number 
      of wheels with separate if statement */
      
      for (String part : carParts){
          if (part == "Wheel"){
            System.out.println("\t" + numberofWheels + " " + part);
        } else {
            System.out.println("\t" + part);
        }
      }
  }
  
  class Body {

  private int Doors = 4;
  private String name = "Body";
  
  public Body () {
    System.out.println("Manufacturing: " + name);
  };
 
  public String getName(){
      return name;
  }
  public void setDoors (int newVar) {
    Doors = newVar;
  }

  public int getDoors () {
    return Doors;
  } 

}

class Chassis {

  private String ChassisType = "Ladder Frame Chassis";
  private String name = "Chassis";

  public Chassis () {
    System.out.println("Manufacturing: " + name);
};
  
    
  public String getName(){
      return name;
  }
  
  public void setChassisType (String newVar) {
    ChassisType = newVar;
  }

  public String getChassisType () {
    return ChassisType;
  }

}

class Wheel {

  private String WheelType = "Winter";
  private String Brand = "Michelin";
  private String name = "Wheel";

  public Wheel () {
      for (int i = 1; i < 5; ++i) {
    System.out.println("Manufacturing: " + name);
      }
}; 
  public String getName(){
      return name;
  }
  
  public void setWheelType (String newVar) {
    WheelType = newVar;
  }
  public String getWheelType () {
    return WheelType;
  }
  public void setBrand (String newVar) {
    Brand = newVar;
  }

  public String getBrand () {
    return Brand;
  }
  
}

class Engine {

  private String Brand = "Hyundai";
  private int Cylinders = 4;
  private String name = "Engine";

  
  public Engine () {
      System.out.println("Manufacturing: " + name);
};
    
  public String getName(){
      return name;
  }
  
  public void setBrand (String newVar) {
    Brand = newVar;
  }

  public String getBrand () {
    return Brand;
  }

  public void setCylinders (int newVar) {
    Cylinders = newVar;
  }

  public int getCylinders () {
    return Cylinders;
  }

}

  
}
