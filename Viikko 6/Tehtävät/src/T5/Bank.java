/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package T5;

/*
 *
 * @author asoli
 */

import java.util.*;

public class Bank {

  public String Name;
  private ArrayList<Account> listOfAccounts;
  
  public Bank () { 
      listOfAccounts = new ArrayList<Account>();
  };

  public void getListOfAccounts () {
      System.out.println("All accounts:");
        for(Account a : listOfAccounts){
        if (a instanceof DebitAccount){
            System.out.println("Account number: " + a.getAccountNumber() + 
                               " Amount of money: " + a.getBalance());
        }
        if (a instanceof CreditAccount){
            System.out.println("Account number: " + a.getAccountNumber() + 
                   " Amount of money: " + a.getBalance()+
                   " Credit limit: " + ((CreditAccount) a).getCreditAmt());
        }
        }
  }

  public void addDebitAccount(String accountNumber, int accountBalance){
      Account temp = new DebitAccount(accountNumber, accountBalance);
      listOfAccounts.add(temp);
      System.out.println("Account created.");
  }
  
  public void addCreditAccount(String accountNumber, int accountBalance, int creditAmt){
      Account temp = new CreditAccount(accountNumber, accountBalance, creditAmt);
      listOfAccounts.add(temp);
      System.out.println("Account created.");
  }

  public Account findAccount(String accountNumber){
      
      System.out.print("Searching for account: ");
      
      if (listOfAccounts.isEmpty()){
          return null;
      }
      for (Account a : listOfAccounts){
        if (a.getAccountNumber().equals(accountNumber)){
            System.out.print(a.getAccountNumber());
            return a;
        } else {
            System.out.println("No account found.");
            return null;
        }
    }
    return null;
  }
  
  public void deleteAccount(String accountNumber){
      for (Account a : listOfAccounts){
          if (a.getAccountNumber().equals(accountNumber)){
                listOfAccounts.remove(a);
                System.out.println("Account removed.");
          }
          else {
              System.out.println("No account found");
          }
      }
  }
  
  public void addMoney(String accountNumber, int amtMoney){
      for (Account a : listOfAccounts){
          if (a.getAccountNumber().equals(accountNumber)){
              a.addBalance(amtMoney);
          }
      }
  }

  public void takeMoney(String accountNumber, int amtMoney){
      for (Account a : listOfAccounts){
          if (a.getAccountNumber().equals(accountNumber)){
              a.takeBalance(amtMoney);
          }
      }
  }
     
  public void setName (String newVar) {
    Name = newVar;
  }

  public String getName () {
    return Name;
  }

}