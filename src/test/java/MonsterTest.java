import Monsters.Monster;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MonsterTest {

    Monster monster;

    @Before
    public void before(){
        monster = new Monster(50, "Orc", 4, 7);
    }

    @Test
    public void canGetMonsterDetails(){
        assertEquals(50, this.monster.getHp());
        assertEquals("Orc", this.monster.getType());
        assertEquals(4, this.monster.totalAttack());
        assertEquals(7, this.monster.totalDefence());
    }
}
