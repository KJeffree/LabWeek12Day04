import Armour.Armour;
import Game.Game;
import Interfaces.IObject;
import Monsters.Monster;
import Potions.Potion;
import Rooms.MonsterRoom;
import Rooms.TreasureRoom;
import Weapons.Weapon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class RoomTest {

    MonsterRoom monsterRoom;
    TreasureRoom treasureRoom;
    Monster monster1;
    Monster monster2;
    Monster monster3;
    Monster monster4;
    Monster monster5;

    Armour armour;
    Weapon weapon;
    Potion healPotion;
    Potion attackPotion;
    Potion defencePotion;

    Game game;


    @Before
    public void before(){
        ArrayList<Monster> monsters = new ArrayList<>();
        ArrayList<IObject> objects = new ArrayList<>();


        armour = new Armour("Iron",6);
        weapon = new Weapon("Axe",10);
        healPotion = new Potion("Heal", 25);
        attackPotion = new Potion("Attack", 2);
        defencePotion = new Potion("Defence", 2);

        monster1 = new Monster(50, "Orc", 4, 7);
        monster2 = new Monster(100, "Dragon", 10, 7);
        monster3 = new Monster(75, "Troll", 6, 3);
        monster4 = new Monster(50, "Goblin", 2, 2);
        monster5 = new Monster(50, "Skeleton", 5, 1);

        monsters.add(monster1);
        monsters.add(monster2);
        monsters.add(monster3);
        monsters.add(monster4);
        monsters.add(monster5);

        objects.add(armour);
        objects.add(weapon);
        objects.add(healPotion);
        objects.add(attackPotion);
        objects.add(defencePotion);

        monsterRoom = new MonsterRoom(armour,monster1);
        treasureRoom = new TreasureRoom(healPotion,100);

        game = new Game(monsters, objects);
    }


    @Test
    public void canGetObject(){
        assertEquals(armour,this.monsterRoom.getObject());
        assertEquals(healPotion,this.treasureRoom.getObject());
    }

    @Test
    public void canGetTreasure(){
        assertEquals(100,this.treasureRoom.getGold());
    }

    @Test
    public void canGetMonster(){
        assertEquals(monster1,this.monsterRoom.getMonster());
    }

}
