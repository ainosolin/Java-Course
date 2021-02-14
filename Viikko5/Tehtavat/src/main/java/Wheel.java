
import java.util.*;


/**
 * Class Wheel
 */
public class Wheel {

  private String WheelType;
  private String Brand;
  private String name = "Wheel";

  public Wheel (String name) {
    System.out.println("Manufacturing: " + name);
};
  
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
