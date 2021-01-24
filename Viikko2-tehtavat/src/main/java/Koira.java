
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
public class Dog {
    
    private String name = "Musti";
    
    public String Speak(){
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Give a name to the dog: ");
        
        String koirannimi = scanner.nextLine();
        
        if (koirannimi.isEmpty()){
            setName("Doge");
        }
        else {
            setName(koirannimi);
        }
        
        System.out.println("Hey, my name is " + name);
        
        Scanner lukija = new Scanner(System.in).useDelimiter("\\s+");
        
        System.out.println("What does a dog say: ");
        
                
        while(lukija.hasNext()==true){
            if (lukija.hasNextInt()==true){
                String temp = lukija.next();
                System.out.println("Such integer: " + temp);
            }
            else if (lukija.hasNextBoolean()==true){
                String temp = lukija.next();
                System.out.println("Such boolean: " + temp);                
            }
            else if (lukija.hasNextBoolean()==false) {
                String temp = lukija.next();
                System.out.println(temp);
            }                
        }
        
        return name;
    }
    
    public void setName(String n){
        name = n;
    }
}
