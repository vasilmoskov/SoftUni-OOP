package rpg_lab;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AxeTest {

    @Test
    public void testDurabilityLossAfterAttackShouldLoseExactlyOnePoint() {
        //3A Pattern

        //A - Arrange
        Axe axe = new Axe(0, 10);
        Dummy dummy = new Dummy(100, 100);

        //A - Act
        axe.attack(dummy);

        //A - Assert
        int actualPoints = axe.getDurabilityPoints();
        int expectedPoints = 9;

        assertEquals(expectedPoints, actualPoints);
    }

    @Test (expected = IllegalStateException.class)
    public void testAttackingWithBrokenWeaponShouldThrowIllegalStateException() {
        Axe axe = new Axe(10, 0);
        Dummy dummy = new Dummy(100, 100);
        axe.attack(dummy);
    }

    @Test
    public void testGetAttackPointsShouldReturnPoints () {
        Axe axe = new Axe(10, 0);
        int actual = axe.getAttackPoints();

        Assert.assertEquals(10, actual);
    }

}
