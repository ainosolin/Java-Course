/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author asoli
 */

import java.util.ArrayList;

/**
 * Class Car
 */
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
}
