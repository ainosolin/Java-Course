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

    bottledisp.addMoney(); /* money = 1 */
    bottledisp.buyBottle(); /* money = 0 */

    /* pullo tulee maatista */

    bottledisp.buyBottle(); /* money = 0, bottle = 4 */

    /* if lause herjaa "Add money first!" */

    bottledisp.addMoney(); /* money = 1 */
    bottledisp.addMoney(); /* money = 2 */
    bottledisp.buyBottle(); /* bottle = 3 */
    
    /* pullo tulee maatista */
    
    bottledisp.returnMoney(); 
    
    /* palauta rahat */
    
    }
    
}
