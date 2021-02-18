/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package T3;

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
  }

  public void addDebitAccount(String accountNumber, int accountBalance){
      Account temp = new DebitAccount(accountNumber, accountBalance);
      listOfAccounts.add(temp);
      System.out.println("Adding to bank: " + accountNumber + "," + accountBalance); 
  }
  
  public void addCreditAccount(String accountNumber, int accountBalance, int creditAmt){
      Account temp = new CreditAccount(accountNumber, accountBalance, creditAmt);
      listOfAccounts.add(temp);
      System.out.println("Adding to bank: " + accountNumber + "," + accountBalance + "," + creditAmt); 
  }

  public void findAccount(String accountNumber){
      System.out.println("Searching for account: " + accountNumber);
  }
  
  public void deleteAccount(String accountNumber){
      System.out.println("Account removed.");
  }
  
  public void addMoney(String accountNumber, int amtMoney){
      System.out.println("Depositing to the account: " + accountNumber +
                " the amount " + amtMoney);
  }

  public void takeMoney(String accountNumber, int amtMoney){
      System.out.println("Withdrawing from the account: " + accountNumber +
                " the amount " + amtMoney);
  }
  
}

class Account {
    
    String accountNumber;
    int accountBalance;
    
    public Account(String aN, int aB){
        this.accountNumber = aN;
        this.accountBalance = aB;
    }
    
    public String getAccountNumber(){
        return accountNumber;
    }
    
    public int getBalance(){
        return accountBalance;
    }
    
    public void addBalance(int c){
        this.accountBalance += c;
    }
    
    public void takeBalance(int c){
        this.accountBalance -= c;
    }

}

class DebitAccount extends Account{
    
    String aN;
    int aB;
    
    DebitAccount(String aN, int aB) {
        super(aN, aB);
    }
       
}

class CreditAccount extends Account{
    
    String aN;
    int aB;
    int creditAmt;
    
    CreditAccount(String aN, int aB, int credit) {
        super(aN, aB);
        creditAmt = credit;
            }
}
