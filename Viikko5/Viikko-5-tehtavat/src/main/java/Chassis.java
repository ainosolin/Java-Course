/**
 * @author asoli
 */

/**
 * Class Chassis
 */
public class Chassis {

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