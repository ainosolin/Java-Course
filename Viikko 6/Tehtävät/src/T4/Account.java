/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package T4;

/**
 *
 * @author asoli
 */
public class Account {
    
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