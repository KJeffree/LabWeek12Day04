package Player;

import Interfaces.IFight;
import Interfaces.IObject;
import Interfaces.IPickUpObject;
import Pets.Pet;
import Rooms.Room;
import Spells.Spell;

public class Mage extends Player implements IFight, IPickUpObject {

    private Spell spell;
    private Pet pet;

    public Mage(String type, Spell spell, Pet pet){
        super(type);
        this.spell = spell;
        this.pet = pet;
    }

    public Spell getSpell() {
        return spell;
    }

    public void setSpell(Spell spell) {
        this.spell = spell;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public int totalAttack(){
        return this.spell.getDamage() +this.attack;
    }

    public int totalDefence(){
        return this.pet.totalDefence() + this.defence;
    }

    public int petAttack() {
        return this.pet.totalAttack();
    }

    public String pickUpObject(Room room){
        IObject object = room.getObject();
        if (object instanceof Spell && (((Spell) object).getDamage()) > this.spell.getDamage()){
            setSpell((Spell) object);
            return object.getType() + "Equipped!";
        }
        return "Cannot pick up" + object.getType();
    }
}
