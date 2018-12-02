package Monsters;

import Interfaces.IFight;

public class Monster implements IFight {

    private int hp;
    private String type;
    private int attack;
    private int defence;

    public Monster(int hp, String type, int attack, int defence){
        this.hp = hp;
        this.type = type;
        this.attack = attack;
        this.defence = defence;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getType() {
        return type;
    }

    public int totalAttack() {
        return attack;
    }

    public int totalDefence() {
        return defence;
    }
}
