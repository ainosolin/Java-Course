/**
 * @author asoli
 */

/**
 * Class Wheel
 */
public class Wheel {

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
