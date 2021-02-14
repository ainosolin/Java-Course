/**
 * @author asoli
 */

/**
 * Class Body
 */
public class Body {

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
