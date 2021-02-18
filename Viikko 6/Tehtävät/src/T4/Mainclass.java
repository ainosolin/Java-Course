/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package T4;
import java.util.Scanner;

/**
 *
 * @author asoli
 */
public class Mainclass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
    Bank bank = new Bank();
        
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
                        bank.addDebitAccount(accountNumber, amtMoney);
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
                        bank.addCreditAccount(accountNumber, amtMoney, creditLimit);
                        break;
                    }
                case 3:
                    {
                        System.out.print("Give an account number: ");
                        accountNumber = scanner.next();
                        System.out.print("Amount of money to deposit: ");
                        amtMoney = scanner.nextInt();
                        bank.addMoney(accountNumber, amtMoney);
                        break;
                    }
                case 4:
                    {
                        System.out.print("Give an account number: ");
                        accountNumber = scanner.next();
                        System.out.print("Amount of money to withdraw: ");
                        amtMoney = scanner.nextInt();
                        bank.takeMoney(accountNumber, amtMoney);
                        break; 
                    }
                case 5:
                    {
                        System.out.print("Give the account number of the account to delete: ");
                        accountNumber = scanner.next();
                        bank.deleteAccount(accountNumber);
                        break; 
                    }
                case 6:
                    {
                        System.out.print("Give the account number of the account to print information from: ");
                        accountNumber = scanner.next();
                        bank.findAccount(accountNumber);
                        break; 
                    }
                case 7:
                    {
                        bank.getListOfAccounts();
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