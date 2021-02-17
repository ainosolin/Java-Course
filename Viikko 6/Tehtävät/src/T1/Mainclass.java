/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package T1;

import java.util.Scanner;

/**
 *
 * @author asoli
 */
public class Mainclass {

    public static void main(String[] args) {
            
    Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n*** BANK SYSTEM ***\n" +
                                "1) Add a regular account\n" +
                                "2) Add a credit account\n" +
                                "3) Deposit money\n" +
                                "4) Withdraw money\n" +
                                "5) Remove an account\n" +
                                "6) Print account information\n" +
                                "7) Print all accounts\n" +
                                "0) Quit");
            
            System.out.print("Your choice: ");
            
            int choice = scanner.nextInt();
            String accountNumber;
            int amtMoney;
            int creditLimit;
            
            
            
            
            switch (choice) {
                case 1:
                    {
                        System.out.print("Give an account number: ");
                        accountNumber = scanner.next();
                        System.out.print("Amount of money to deposit: ");
                        amtMoney = scanner.nextInt();
                        System.out.print("Account number: " + accountNumber + "\n");
                        System.out.print("Amount of money: " + amtMoney + "\n");
                        break; 
                    }
                case 2:
                    {
                        System.out.print("Give an account number: ");                    
                        accountNumber = scanner.next();
                        System.out.print("Amount of money to deposit: ");
                        amtMoney = scanner.nextInt();
                        System.out.print("Give a credit limit: ");
                        creditLimit = scanner.nextInt();
                        System.out.print("Account number: " + accountNumber + "\n");
                        System.out.print("Amount of money: " + amtMoney + "\n");
                        System.out.print("Credit: " + creditLimit + "\n");
                        break;
                    }
                case 3:
                    {
                        System.out.print("Give an account number: ");
                        accountNumber = scanner.next();
                        System.out.print("Amount of money to deposit: ");
                        amtMoney = scanner.nextInt();
                        System.out.print("Account number: " + accountNumber + "\n");
                        System.out.print("Amount of money: " + amtMoney + "\n");
                        break; 
                    }
                case 4:
                    {
                        System.out.print("Give an account number: ");
                        accountNumber = scanner.next();
                        System.out.print("Amount of money to withdraw: ");
                        amtMoney = scanner.nextInt();
                        System.out.print("Account number: " + accountNumber + "\n");
                        System.out.print("Amount of money: " + amtMoney + "\n");
                        break; 
                    }
                case 5:
                    {
                        System.out.print("Give the account number of the account to delete: ");
                        accountNumber = scanner.next();
                        System.out.print("Account number: " + accountNumber + "\n");
                        break; 
                    }
                case 6:
                    {
                        System.out.print("Give the account number of the account to print information from: ");
                        accountNumber = scanner.next();
                        System.out.print("Account number: " + accountNumber + "\n");
                        
                        break; 
                    }
                case 7:
                    {
                        System.out.println("Prints every account");
                        break;
                    }
                case 0:
                    {
                        System.exit(0);
                        break;
                    }
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }

    
    }
    
}
