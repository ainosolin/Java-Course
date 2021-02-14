
import java.util.*;


/**
 * Class Chassis
 */
public class Chassis {

  private String ChassisType;
  private String name = "Chassis";
  //
  // Constructors
  //
  public Chassis (String name) {
    System.out.println("Manufacturing: " + name);
};
  
  public void setChassisType (String newVar) {
    ChassisType = newVar;
  }

  public String getChassisType () {
    return ChassisType;
  }

}
