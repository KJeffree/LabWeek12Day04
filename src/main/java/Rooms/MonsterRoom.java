package Rooms;

import Game.Game;
import Interfaces.IObject;
import Monsters.Monster;

public class MonsterRoom extends Room {

    private Monster monster;

    public MonsterRoom(IObject object,Monster monster){
        super(object);
        this.monster = monster;
    }

    public Monster getMonster() {
        return monster;
    }

    public boolean isMonsterDefeated(){
        if (this.monster.getHp() > 0){
            return false;
        } else {
            return true;
        }
    }
}
