package Player;

import Armour.Armour;
import Interfaces.IFight;
import Interfaces.IObject;
import Interfaces.IPickUpObject;
import Rooms.Room;
import Rooms.TreasureRoom;
import Weapons.Weapon;

public class Tank extends Player implements IFight, IPickUpObject {

    private Weapon weapon;
    private Armour armour;

    public Tank(String type,Weapon weapon,Armour armour){
        super(type);
        this.weapon = weapon;
        this.armour = armour;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armour getArmour() {
        return armour;
    }

    public void setArmour(Armour armour) {
        this.armour = armour;
    }

    public int totalAttack(){
        return this.attack + this.weapon.getAttack();
    }

    public int totalDefence(){
        return this.defence + this.armour.getDefence();
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public String pickUpObject(Room room){
        IObject object = room.getObject();
        if (object instanceof Weapon && (((Weapon) object).getAttack()) > this.getWeapon().getAttack()){
            setWeapon((Weapon) object);
            return object.getType() + "Equipped!";
        }
        if (object instanceof Armour && (((Armour) object).getDefence()) > this.getArmour().getDefence()){
            setArmour((Armour) object);
            return object.getType() + "Equipped!";
        }
        return "Cannot pick up" + object.getType();
    }


}
