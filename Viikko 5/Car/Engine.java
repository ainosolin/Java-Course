/**
 * @author asoli
 */

/**
 * Class Engine
 */
public class Engine {

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
