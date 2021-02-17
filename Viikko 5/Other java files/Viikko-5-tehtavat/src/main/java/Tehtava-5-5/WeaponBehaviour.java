/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asoli
 */
public class WeaponBehaviour {
    
    protected String weaponName;
    int weaponType;
    
    public WeaponBehaviour (int weaponType){
        switch (weaponType) {
        // Knife
            case 1:
                KnifeBehaviour knife = new KnifeBehaviour();
                break;
        // Axe
            case 2:
                AxeBehaviour axe = new AxeBehaviour();
                break;
        // Sword
            case 3:
                SwordBehaviour sword = new SwordBehaviour();
                break;
        // Club
            case 4:
                ClubBehaviour club = new ClubBehaviour();
                break;
            default:
                break;
        }
    }
}
    

