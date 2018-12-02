package Rooms;

import Game.Game;
import Interfaces.IObject;

public abstract class Room {

    protected IObject object;

    public Room(IObject object){
        this.object = object;
    }

    public IObject getObject() {
        return object;
    }

}
