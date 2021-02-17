/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asoli
 */
public class Character {
    
    protected String name;
    protected int HP;
    WeaponBehaviour weapon;
    
    public Character (int weaponOfChoice) {
        this.weapon = new WeaponBehaviour(weaponOfChoice);
    }
    
    public void fight(){
        System.out.println(name + "fights with weapon" + weapon.getName());
    }
    
    
    
}
