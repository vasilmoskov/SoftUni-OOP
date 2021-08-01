package rpg_lab;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

public class HeroTest {

    @Test
    public void attackShouldGainXPWhenTargetIsKilled () {
        Weapon weapon = Mockito.mock(Weapon.class);

        Hero hero = new Hero("Vasil", weapon);

        Target target = Mockito.mock(Target.class);

        Mockito.when(target.isDead()).thenReturn(true);
        Mockito.when(target.giveExperience()).thenReturn(100);

        hero.attack(target);

        Assert.assertEquals(100, hero.getExperience());
    }

    @Test
    public void testWhenHeroKillsTargetInventoryShouldAddNewLoot() {
        Weapon weapon = Mockito.mock(Weapon.class);

        Hero hero = new Hero("Vasil", weapon);

        Target target = Mockito.mock(Target.class);

        Mockito.when(target.isDead()).thenReturn(true);
        Mockito.when(target.getLoot()).thenReturn(new Axe(37, 43));

        hero.attack(target);

        List<Weapon> inventory = hero.getInventory();

        Assert.assertEquals(1, inventory.size());
        Weapon loot = inventory.get(0);
        Assert.assertEquals(37, loot.getAttackPoints());
        Assert.assertEquals(43, loot.getDurabilityPoints());

    }
}
