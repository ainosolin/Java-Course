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
        System.out.println(CharacterName + " fights with " + weapon.WeaponName);
    }
    

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


class KnifeBehaviour {
    
    private String WeaponName = "Knife";
    
    String getName(){
        return WeaponName;
    }
}
    
public class AxeBehaviour {
        
    private String WeaponName = "Axe";
    
    String getName(){
        return WeaponName;
    }
}

public class SwordBehaviour {
    private String WeaponName = "Sword";
    
    String getName(){
        return WeaponName;
    }
}

public class ClubBehaviour {
       private String WeaponName = "Club";
    
    String getName(){
        return WeaponName;
    } 
}
}
}

class Queen extends Character{
    
    public Queen(int wep) {
        super(wep);
        CharacterName = "Queen";
    }
}

class King extends Character{
    
    public King(int wep) {
        super(wep);
        CharacterName = "King";
    }
 
}

class Troll extends Character{
    
    public Troll(int wep) {
        super(wep);
        CharacterName = "Troll";
    }
}

class Knight extends Character{
    
    public Knight(int wep) {
        super(wep);
        CharacterName = "Knight";
    }
}
