package Rooms;

import Game.Game;
import Interfaces.IObject;

public class TreasureRoom extends Room  {

    private int gold;

    public TreasureRoom(IObject object, int gold){
        super(object);
        this.gold = gold;
    }

    public int getGold(){
        return this.gold;
    }

    public void setGold(int gold){
        this.gold = gold;
    }
}
