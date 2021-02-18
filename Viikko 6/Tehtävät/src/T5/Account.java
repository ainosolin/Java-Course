/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package T5;

/**
 *
 * @author asoli
 */
public class Account {
    
    String accountNumber;
    int accountBalance;
    
    protected Account(String aN, int aB){
        this.accountNumber = aN;
        this.accountBalance = aB;
    }
    
    protected String getAccountNumber(){
        return accountNumber;
    }
    
    protected int getBalance(){
        return accountBalance;
    }
    
    protected void addBalance(int c){
        this.accountBalance += c;
    }
    
    protected void takeBalance(int c){
        if (accountBalance >= c & accountBalance > 0){
            this.accountBalance -= c;
        }
        else {
            System.out.println("Insufficient funds");
        }
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
        aB += credit;
    }
    
    protected int getCreditAmt(){
        return creditAmt;
    }
}
