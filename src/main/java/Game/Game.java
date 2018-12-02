package Game;

import Interfaces.IFight;
import Interfaces.IObject;
import Monsters.Monster;
import Rooms.MonsterRoom;
import Rooms.Room;
import Rooms.TreasureRoom;

import java.util.Random;



import java.util.ArrayList;

public class Game {

    private ArrayList<Monster> monsters;
    private ArrayList<IObject> objects;
    private Room currentRoom;

    public Game(ArrayList<Monster> monsters,ArrayList<IObject> objects){
        this.monsters = monsters;
        this.objects = objects;
        this.currentRoom = null;
    }

    public String attack(IFight attacker, IFight defender){
        int damage = ((attacker.totalAttack()*3 - defender.totalDefence()*2)/2);
        if (damage > defender.getHp()){
            defender.setHp(0);
            return attacker.getType() + " Has Defeated The " + defender.getType() + "!";
        }
        if( damage <= 0 ){
            damage = 1;
        }
        defender.setHp(defender.getHp()-damage);
        return attacker.getType() + " Dealt " + damage + " Damage! " + defender.getType() + " Has " + defender.getHp() + " HealthPoints left!";
    }

    public void generateRandomRoom(){
        Random rand = new Random();
        int roomType= rand.nextInt(2);
        int monsterIndex = rand.nextInt(5);
        int objectIndex = rand.nextInt(5);
        int treasureAmount = rand.nextInt(100)+10;
        if(roomType == 0){
            Room room = new MonsterRoom(this.objects.get(objectIndex),this.monsters.get(monsterIndex));
            this.currentRoom = room;
        }
        else{
            Room room = new TreasureRoom(this.objects.get(objectIndex),treasureAmount);
            this.currentRoom = room;
        }
    }

    public void setCurrentRoom(Room room){
        this.currentRoom = room;
    }

    public String exitRoom(){
        if (this.currentRoom instanceof TreasureRoom){
            this.generateRandomRoom();
            return "You have moved to the next room";
        } else {
            boolean monsterDefeatStatus = ((MonsterRoom)this.currentRoom).isMonsterDefeated();
            if (monsterDefeatStatus){
                this.generateRandomRoom();
                return "You have moved to the next room";
            } else {
                return "You Must Defeat The Monster Before You Can Leave!";
            }
        }
    }
}
