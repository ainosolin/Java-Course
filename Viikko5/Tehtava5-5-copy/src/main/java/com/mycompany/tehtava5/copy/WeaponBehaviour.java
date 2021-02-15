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

public class WeaponBehaviour {
    
    public String WeaponName;
    
    public WeaponBehaviour(int wep){
        if (wep == 1){
            // Knife
            KnifeBehaviour knife = new KnifeBehaviour();
            WeaponName = knife.getName();
        }
        if (wep == 2){
            // Axe
            AxeBehaviour axe = new AxeBehaviour();
            WeaponName = axe.getName();
        }
        if (wep == 3){
            // Sword
            SwordBehaviour  sword = new SwordBehaviour();
            WeaponName = sword.getName();
        }
        if (wep == 4){
            // Club
            ClubBehaviour club = new ClubBehaviour();
            WeaponName = club.getName();
        }
    }
    
    void useWeapon(){
        System.out.println("Use" + WeaponName);
    }

    
}

