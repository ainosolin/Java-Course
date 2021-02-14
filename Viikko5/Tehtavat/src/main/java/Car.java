
import java.util.*;


/**
 * Class Car
 */
class Car {

  private String LicensePlate;
  private String Model;
  int numberofWheels;
  ArrayList<String> carParts;

  public Car () { 
      carParts = new ArrayList<String>();
      Chassis chassis = new Chassis();
      Body body = new Body();
      Engine engine = new Engine();
      Wheel wheel = new Wheel();
      
      carParts.add(chassis.getName());
      carParts.add(body.getName());
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
      System.out.println("Car parts");
      /* for i in arraylist of car parts print /t and part name with getter */
      System.out.println("/t");
      System.out.println("/t");
      System.out.println("/t");
      System.out.println("/t");
  }
  
}
