import Armour.Armour;
import Pets.Pet;
import Player.Player;
import Player.Tank;
import Player.Mage;
import Player.Healer;
import Potions.Potion;
import Rooms.Room;
import Rooms.TreasureRoom;
import Spells.Spell;
import Weapons.Weapon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    Tank tank;
    Mage mage;
    Healer healer;

    Armour armour;
    Armour armourUp;
    Armour armourDown;
    Potion healPotion;
    Potion attackPotion;
    Potion defencePotion;
    Weapon weapon;
    Weapon weaponUp;
    Weapon weaponDown;
    Pet pet;
    Spell fireball;
    Spell iceBlast;
    Spell blaze;

    TreasureRoom room;

    @Before
    public void before(){
        ArrayList<Potion> potions = new ArrayList<>();
        armour = new Armour("Iron",6);
        armourUp = new Armour("Mithril",12);
        armourDown = new Armour("Bronze",3);
        weapon = new Weapon("Axe",10);
        weaponUp = new Weapon("Sword",15);
        weaponDown = new Weapon("Dagger", 5);
        healPotion = new Potion("Heal", 25);
        attackPotion = new Potion("Attack", 2);
        defencePotion = new Potion("Defence", 2);
        potions.add(healPotion);
        potions.add(attackPotion);
        potions.add(defencePotion);

        pet = new Pet(50,"Dragon",6,6);
        fireball = new Spell("FireBall",10);
        iceBlast = new Spell("IceBlast",15);
        blaze = new Spell("Blaze",5);

        tank = new Tank("Knight",weapon,armour);
        mage = new Mage("Wizard",fireball,pet);
        healer = new Healer("Cleric",potions);

        room = new TreasureRoom(iceBlast, 33);
    }


    @Test
    public void canGetHp(){
        assertEquals(100,this.tank.getHp());
        assertEquals(100,this.mage.getHp());
        assertEquals(100,this.healer.getHp());
    }

    @Test
    public void canGetAttackTank(){
        int result = this.tank.totalAttack();
        assertEquals(11,result);
    }

    @Test
    public void canGetDefenceTank(){
        int result = this.tank.totalDefence();
        assertEquals(7,result);
    }

    @Test
    public void canGetAttackMage(){
        int result = this.mage.totalAttack();
        assertEquals(11,result);
    }

    @Test
    public void canGetDefenceMage(){
        int result = this.mage.totalDefence();
        assertEquals(7,result);
    }

    @Test
    public void canGetPetAttack(){
        int result = this.mage.petAttack();
        assertEquals(6,result);
    }

    @Test
    public void canGetAttackHealer(){
        int result = this.healer.totalAttack();
        assertEquals(1,result);
    }

    @Test
    public void canGetDefenceHealer(){
        int result = this.healer.totalDefence();
        assertEquals(1,result);
    }

    @Test
    public void canHealPlayer(){
        String result = healer.useHealPotion(1, mage);
        assertEquals(120, mage.getHp());
        assertEquals("Wizard Gained 20 HealthPoints", result);
    }

    @Test
    public void canIncreasePlayerAttack(){
        String result = healer.useAttackPotion(4, healer);
        assertEquals(9, healer.totalAttack());
        assertEquals("Cleric Gained 8 Attack Points", result);
    }

    @Test
    public void canIncreasePlayerDefence(){
//        assertEquals(7,tank.getDefence());
        String result = healer.useDefencePotion(2, tank);
        assertEquals(11, tank.totalDefence());
        assertEquals("Knight Gained 4 Defence Points", result);
    }

    @Test
    public void mageCanPickUpSpell(){
        mage.pickUpObject(room);
        assertEquals(iceBlast, mage.getSpell());
    }

    @Test
    public void mageCannotPickUpObject(){
        Room room1 = new TreasureRoom(blaze, 34);
        Room room2 = new TreasureRoom(armour, 34);
        Room room3 = new TreasureRoom(weapon, 34);
        Room room4 = new TreasureRoom(healPotion, 34);
        mage.pickUpObject(room1);
        assertEquals(fireball, mage.getSpell());
        mage.pickUpObject(room2);
        assertEquals(fireball, mage.getSpell());
        mage.pickUpObject(room3);
        assertEquals(fireball, mage.getSpell());
        mage.pickUpObject(room4);
        assertEquals(fireball, mage.getSpell());
    }

    @Test
    public void tankCanPickUpWeapon(){
        Room room = new TreasureRoom(weaponUp, 43);
        tank.pickUpObject(room);
        assertEquals(weaponUp, tank.getWeapon());
    }

    @Test
    public void tankCannotPickUpObject(){
        Room room1 = new TreasureRoom(weaponDown, 54);
        Room room2 = new TreasureRoom(fireball, 54);
        Room room3 = new TreasureRoom(healPotion, 54);
        tank.pickUpObject(room1);
        assertEquals(weapon, tank.getWeapon());
        tank.pickUpObject(room2);
        assertEquals(weapon, tank.getWeapon());
        tank.pickUpObject(room3);
        assertEquals(weapon, tank.getWeapon());
    }

    @Test
    public void tankCanPickUpArmour(){
        Room room = new TreasureRoom(armourUp, 43);
        tank.pickUpObject(room);
        assertEquals(armourUp, tank.getArmour());
    }

    @Test
    public void tankCannotPickUpWeakerObject(){
        Room room1 = new TreasureRoom(armourDown, 43);
        Room room2 = new TreasureRoom(fireball, 43);
        Room room3 = new TreasureRoom(healPotion, 43);
        tank.pickUpObject(room1);
        assertEquals(armour, tank.getArmour());
        tank.pickUpObject(room2);
        assertEquals(armour, tank.getArmour());
        tank.pickUpObject(room3);
        assertEquals(armour, tank.getArmour());
    }

    @Test
    public void healerCanPickUpPotion(){
        Room room = new TreasureRoom(healPotion, 22);
        healer.pickUpObject(room);
        assertEquals(4, healer.getPotions().size());
    }

    @Test
    public void healerCannotPickUpObject(){
        Room room1 = new TreasureRoom(blaze, 34);
        Room room2 = new TreasureRoom(armour, 34);
        Room room3 = new TreasureRoom(weapon, 34);
        healer.pickUpObject(room1);
        assertEquals(3, healer.getPotions().size());
        healer.pickUpObject(room2);
        assertEquals(3, healer.getPotions().size());
        healer.pickUpObject(room3);
        assertEquals(3, healer.getPotions().size());
    }

    @Test
    public void tankCanPickUpTreasure(){
        tank.pickUpTreasure(room);
        assertEquals(33, tank.getTreasure());
    }

    @Test
    public void mageCanPickUpTreasure(){
        mage.pickUpTreasure(room);
        assertEquals(33, mage.getTreasure());
    }

    @Test
    public void healerCanPickUpTreasure(){
        healer.pickUpTreasure(room);
        assertEquals(33, healer.getTreasure());
    }

}
