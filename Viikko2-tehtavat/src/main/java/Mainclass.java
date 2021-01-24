/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asoli
 * 
 * 2.5. Viimeisessä tehtävässä viemme koiran älykkyyttä jo hieman tavallista 
 * pidemmälle. Teemme koirasta nyt älykön, joka osaa kertoa ihmisen antamasta
 * syötteestä, antoiko ihminen mahdollisesti kokonaisluvun tai boolean-arvon. 
 * Huomaa, että koira voi tunnistaa myös usean sanan lauseita. Tehtävä siis 
 * keskittyy vain ja ainoastaan Dog-luokan metodiin speak(), joka on muokattava
 * niin, että koira voi tunnistaa kaiken sanotun Scanner-luokan avulla. Huomaa,
 * että Scanner-luokka voi ottaa parametriksi myös merkkijonon. 


 */

import java.util.Scanner;

public class Mainclass {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        /* Constructor is a method to initialize objects, it is called when 
        an object of a class is created */
        
        Dog dog = new Dog();
        
        dog.Speak();
        
    }
    
}
        /*Scanner scanner = new Scanner(System.in);
        
        System.out.println("Give a name to the dog: ");
        
        String koirannimi = scanner.nextLine();
        
        if (koirannimi.isEmpty()){
            dog.setName("Doge");
        }
        else {
            dog.setName(koirannimi);
        }
        
        System.out.println(dog.Speak());*/
                
        
    }
    
}
/* 

Tehtävät 1-2

public class Mainclass {

    public static void main(String[] args) {
        // TODO code application logic here
        Koira dog1 = new Koira();
        dog1.setName("Rekku");
        
        Koira dog2 = new Koira();
        
        System.out.println("Hey, my name is " + dog1.Speak() + "!");
        System.out.println("Hey, my name is " + dog2.Speak() + "!");
        System.out.println(dog1.Speak()+": "+"Hau!");
        System.out.println(dog2.Speak()+": "+"Vuh!");
    }
    
}

Tehtävä 3

import java.util.Scanner;

public class Mainclass {

    
    public static void main(String[] args) {
        // TODO code application logic here
        Koira dog = new Koira();                
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Give a name to the dog: ");
        String koirannimi = scanner.nextLine();
        dog.setName(koirannimi);
        
        System.out.println("Hey, my name is " + dog.Speak() + "!");
        
        System.out.println("What does the dog say: ");
        String koiranlause = scanner.nextLine();
        
        System.out.println(dog.Speak() + ": " + koiranlause + "!");
    }
    
}

Tehtävä 4

import java.util.Scanner;

public class Mainclass {

    public static void main(String[] args) {
        // TODO code application logic here
        
        /* Constructor is a method to initialize objects, it is called when 
        an object of a class is created
        
        Koira dog = new Koira();                
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Give a name to the dog: ");
        
        String koirannimi = scanner.nextLine();
        
        if (koirannimi.isEmpty()){
            dog.setName("Doge");
        }
        else {
            dog.setName(koirannimi);
        }
        System.out.println("Hey, my name is " + dog.Speak() + "!");
        
        String koiranlause = "";
        
        while (koiranlause.trim() != null){
            
            System.out.println("What does a dog say: ");
            koiranlause = scanner.nextLine();
            
            if (koiranlause.trim().isEmpty()){
                koiranlause = "Much wow!";
                System.out.println(dog.Speak() + ": " + koiranlause);
            }
            else {
                System.out.println(dog.Speak() + ": " + koiranlause);
                break;
            }
        }
  
    }
    
}


*/