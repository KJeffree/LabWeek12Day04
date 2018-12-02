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

    public Game(ArrayList<Monster> monsters,ArrayList<IObject> objects){
        this.monsters = monsters;
        this.objects = objects;
    }

    public String attack(IFight attacker, IFight defender){
        int damage = ((attacker.totalAttack()*3 - defender.totalDefence()*2)/2);
        if( damage <= 0 ){
            damage = 1;
        }
        defender.setHp(defender.getHp()-damage);
        return attacker.getType() + " Dealt " + damage + " Damage!";
    }

    public Room generateRandomRoom(){
        Random rand = new Random();
        int roomType= rand.nextInt(2);
        int monsterIndex = rand.nextInt(5);
        int objectIndex = rand.nextInt(5);
        int treasureAmount = rand.nextInt(100)+10;
        if(roomType == 0){
            Room room = new MonsterRoom(this.objects.get(objectIndex),this.monsters.get(monsterIndex));
            return room;
        }
        else{
            Room room = new TreasureRoom(this.objects.get(objectIndex),treasureAmount);
            return room;
        }
    }
}
