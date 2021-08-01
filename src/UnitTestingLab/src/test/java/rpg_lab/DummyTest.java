package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DummyTest {

    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;
    private static final int DUMMY_HEALTH = 10;
    private static final int DUMMY_XP = 10;
    private static final int EXPECTED_DURABILITY = AXE_DURABILITY - 1;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void initializeTestObjects() {
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_XP);
    }

    @Test
    public void testGetHealthShouldReturnExpectedHealth() {
        int actual = this.dummy.getHealth();

        Assert.assertEquals(DUMMY_HEALTH, actual);
    }

    @Test
    public void testDummyShouldLoseHealthWhenAttacked () {

        //Dummy dummy = new Dummy(100, 100);
        //Axe axe = new Axe(50, 50);

        dummy.takeAttack(axe.getAttackPoints());

        Assert.assertEquals(0, dummy.getHealth());
    }

    @Test (expected = IllegalStateException.class)
    public void testDeadDummyShouldThrowExceptionWhenAttacked () {
        Dummy dummy = new Dummy(0, 100);
        Axe axe = new Axe(50, 50);

        dummy.takeAttack(axe.getAttackPoints());
    }

    @Test
    public void testDeadDummyShouldGiveXP() {
        Dummy dummy = new Dummy(0, 100);

        int actualXPGiven = dummy.giveExperience();

        Assert.assertEquals(100, actualXPGiven);
    }

    @Test (expected = IllegalStateException.class)
    public void testAliveDummyShouldNotGiveXP() {
        Dummy dummy = new Dummy(100, 100);

        dummy.giveExperience();
    }
}
