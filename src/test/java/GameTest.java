import Armour.Armour;
import Game.Game;
import Interfaces.IObject;
import Monsters.Monster;
import Pets.Pet;
import Player.Healer;
import Player.Mage;
import Player.Tank;
import Potions.Potion;
import Rooms.Room;
import Rooms.TreasureRoom;
import Spells.Spell;
import Weapons.Weapon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GameTest {

    Game game;
    Monster monster;
    Tank tank;
    Mage mage;
    Healer healer;

    Armour armour;
    Potion potion;
    Weapon weapon;
    Pet pet;
    Spell fireball;

    Monster monster1;
    Monster monster2;
    Monster monster3;
    Monster monster4;
    Monster monster5;

    Potion healPotion;
    Potion attackPotion;
    Potion defencePotion;

    @Before
    public void before(){

        monster = new Monster(50, "Orc", 4, 7);

        ArrayList<Potion> potions = new ArrayList<>();

        potion = new Potion("Heal", 25);
        potions.add(potion);

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


        pet = new Pet(50,"Dragon",6,6);
        fireball = new Spell("FireBall",10);

        tank = new Tank("Knight",weapon,armour);
        mage = new Mage("Wizard",fireball,pet);
        healer = new Healer("Cleric",potions);


        game = new Game(monsters,objects);
    }

    @Test
    public void playerCanAttackMonster(){
        String result = game.attack(tank, monster);
        assertEquals(41, this.monster.getHp());
        assertEquals("Knight Dealt 9 Damage!", result);
    }

    @Test
    public void monsterCanAttackPlayer(){
        String result = game.attack(monster, tank);
        assertEquals(99, this.tank.getHp());
        assertEquals("Orc Dealt 1 Damage!", result);
    }

//    @Test
//    public void canGetRandomRoom(){
//        Room room = game.generateRandomRoom();
//        int gold =((TreasureRoom) room).getGold();
//    }

}
