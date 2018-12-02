package Player;

import Interfaces.IFight;
import Interfaces.IObject;
import Interfaces.IPickUpObject;
import Potions.Potion;
import Rooms.Room;

import java.util.ArrayList;

public class Healer extends Player implements IFight, IPickUpObject {


    private ArrayList<Potion> potions;

    public Healer(String type,ArrayList<Potion> potions){
        super(type);
        this.potions = potions;
    }

    public ArrayList<Potion> getPotions() {
        return potions;
    }

    public void setPotions(ArrayList<Potion> potions) {
        this.potions = potions;
    }

    public void addPotion(Potion potion){
        this.potions.add(potion);
    }

    public int totalAttack(){
        return this.attack;
    }

    public int totalDefence(){
        return this.defence;
    }

    public ArrayList<Potion> getPotionByType(String type){
        ArrayList<Potion> potionList = new ArrayList<>();
        for (Potion potion : this.potions){
            if (potion.getType() == type){
                potionList.add(potion);
            }
        }
        return potionList;
    }

    public int getTotalDosageOfPotion(String type){
        int totalDosage = 0;
        ArrayList<Potion> potionOfType = getPotionByType(type);
        for(Potion potion : potionOfType){
            totalDosage += potion.getDoses();
        }
        return totalDosage;
    }

    public String useHealPotion(int dosage, Player player){
        int totalDosage = getTotalDosageOfPotion("Heal");
        if (dosage <= totalDosage){
            int heal = (20 * dosage);
            player.setHp(player.getHp() + heal);
            return player.getType() + " Gained " + heal + " HealthPoints";
        }
        return "Not Enough Doses";
    }

    public String useAttackPotion(int dosage, Player player){
        int totalDosage = getTotalDosageOfPotion("Attack");
        if(dosage <= totalDosage){
            int attack = (2 * dosage);
            player.setAttack(player.getAttack() + attack);
            return player.getType() + " Gained " + attack + " Attack Points";
        }
        return "Not Enough Doses";
    }

    public String useDefencePotion(int dosage, Player player){
        int totalDosage = getTotalDosageOfPotion("Defence");
        if(dosage <= totalDosage){
            int defence = (2 * dosage);
            player.setDefence(player.getDefence() + defence);
            return player.getType() + " Gained " + defence + " Defence Points";
        }
        return "Not Enough Doses";
    }

    public String pickUpObject(Room room){
        IObject object = room.getObject();
        if (object instanceof Potion){
            this.potions.add((Potion)object);
            return object.getType() + "Picked Up!";
        }
        return "Cannot pick up " + object.getType();
    }

}
