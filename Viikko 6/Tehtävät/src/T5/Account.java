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
public abstract class Account {
    
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
    
    protected void addBalance(int m){
        this.accountBalance += m;
    }
    
    protected void takeBalance(int m){
        if (accountBalance >= m & accountBalance > 0){
            this.accountBalance -= m;
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
    
    private String aN;
    private int aB;
    private int creditAmt;
    
    CreditAccount(String aN, int aB, int credit) {
        super(aN, aB);
        creditAmt = credit;
        aB += credit;
    }
    
    protected int getCreditAmt(){
        return creditAmt;
    }
}
