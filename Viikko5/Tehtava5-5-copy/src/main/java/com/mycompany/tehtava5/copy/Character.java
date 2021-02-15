/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tehtava5.copy;

/**
 *
 * @author asoli
 */
public class Character {
    
    protected String CharacterName;
    WeaponBehaviour weapon;
    
    public Character(int wep){
        this.weapon = new WeaponBehaviour(wep);
    }
        
    void fight(){
        System.out.println(CharacterName + " fights with weapon " + weapon.WeaponName);
    }
    
}
