import java.util.Scanner;

/**
 *
 * @author asoli
 */
public class Mainclass {

    public static void main(String[] args) {
            
    Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n*** BATTLE SIMULATOR ***\n" +
                    "1) Create a character\n" +
                    "2) Fight a character\n" +
                    "0) Quit");
            
            System.out.print("Your choice: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    {
                        System.out.print("Choose your character: ");
                        System.out.println("1) King");
                        System.out.println("2) Knight");
                        System.out.println("3) Queen");
                        System.out.println("4) Troll");
                        int valinta = scanner.nextInt();
                        Character character = new Character(valinta);
                        break; 
                    }
                case 2:
                    {
                        System.out.print("Choose your weapon: ");
                        System.out.println("1) Knife");
                        System.out.println("2) Axe");
                        System.out.println("3) Sword");
                        System.out.println("4) Club");
                        int valinta = scanner.nextInt();
                        character.fight();
                        break;
                    }
                case 0:
                    {
                        System.exit(0);
                        break;
                    }
                default:
                    System.out.println("Could not recognize selection, please "
                            + "try again.");
                    break;
            }
        }

    
    }
    
}
