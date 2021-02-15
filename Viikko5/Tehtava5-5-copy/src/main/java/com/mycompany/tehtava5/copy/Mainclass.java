/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tehtava5.copy;

import java.util.Scanner;

/**
 *
 * @author asoli
 */
public class Mainclass {

    public static void main(String[] args) {
                
    // Initialize values
        
    Scanner scanner = new Scanner(System.in);
    int weapon_choice = 0;
    int character_choice = 0;

        while (true) {
            System.out.println("*** BATTLE SIMULATOR ***\n" +
                    "1) Create a character\n" +
                    "2) Fight with a character\n" +
                    "0) Quit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
                                    
            switch (choice) {
                case 1:
                    {
                        System.out.print("Choose your character: ");
                        System.out.println("1) King\n" +
                                            "2) Knight\n" +
                                            "3) Queen\n"+
                                            "4) Troll");
                        System.out.println("Your choice: ");
                        character_choice = scanner.nextInt();
                        System.out.println("Choose your weapon: ");
                        System.out.println("1) Knife\n" +
                                            "2) Axe\n" +
                                            "3) Sword\n"+
                                            "4) Club");
                        System.out.print("Your choice: ");
                        weapon_choice = scanner.nextInt();
                        break;
                    }
                case 2:
                    // Choose King as character
                    if (character_choice == 1){
                        King selected_character = new King(weapon_choice);
                        selected_character.fight();
                    }
                    // Choose Knight as character
                    if (character_choice == 2){
                        Knight selected_character = new Knight(weapon_choice);
                        selected_character.fight();
                    }
                    // Choose Queen as character
                    if (character_choice == 3){
                        Queen selected_character = new Queen(weapon_choice);
                        selected_character.fight();
                    }
                    // Choose Troll as character
                    if (character_choice == 4){
                        Troll selected_character = new Troll(weapon_choice);
                        selected_character.fight();
                    }
                    break;
                case 0:
                    {
                        System.exit(0);
                        scanner.close();
                        break;
                    }
                default:
                    System.out.println("Could not recognize selection, please "
                            + "try again.");
                    break;
            }
        }

    
    }
    
}
