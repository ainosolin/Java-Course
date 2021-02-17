import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asoli
 */
public class Mainclass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
    BottleDispenser bottledisp = new BottleDispenser();
    
    Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n*** BOTTLE DISPENSER ***\n" +
                    "1) Add money to the machine\n" +
                    "2) Buy a bottle\n" +
                    "3) Take money out\n" +
                    "4) List bottles in the dispenser\n" +
                    "0) End");
            
            System.out.print("Your choice: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    {
                        bottledisp.addMoney();
                        break;  
                    }
                case 2:
                    {
                        bottledisp.listBottles();
                        System.out.print("Your choice: ");
                        int valinta = scanner.nextInt();
                        bottledisp.buyBottle(valinta-1);
                        break;
                    }
                case 3:
                    {
                        bottledisp.returnMoney();
                        break;
                    }
                case 4:
                    {
                        bottledisp.listBottles();
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
