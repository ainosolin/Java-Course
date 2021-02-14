
import java.util.*;


/**
 * Class Engine
 */
public class Engine {

  //
  // Fields
  //

  private String Brand;
  private int Cylinders;
  private String name = "Body";

  
  public Engine (String name) {
      System.out.println("Manufacturing: " + name);
};
  

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
