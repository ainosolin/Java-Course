
import java.util.*;


/**
 * Class Body
 */
public class Body {


  private int Doors = 4;
  private String name = "Body";
  
  public Body (String name) {
    System.out.println("Manufacturing: " + name);
  };
  

  /**
   * Set the value of Doors
   * @param newVar the new value of Doors
   */
  public void setDoors (int newVar) {
    Doors = newVar;
  }

  /**
   * Get the value of Doors
   * @return the value of Doors
   */
  public int getDoors () {
    return Doors;
  }

  //
  // Other methods
  //

}
