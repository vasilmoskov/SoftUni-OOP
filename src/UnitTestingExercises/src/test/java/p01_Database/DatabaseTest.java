package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private Database database;

    @Before
    public void createDatabase() throws OperationNotSupportedException {
        this.database = new Database(1, 2, 3);
    }

    @Test
    public void testConstructorTakesOnlyIntegers() {
        Assert.assertSame(this.database.getElements()[0].getClass(), Integer.class);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testCreatingADatabaseWithMNoElementsShouldThrow() throws OperationNotSupportedException {
        Database database = new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testCreatingADatabaseWithMoreThanAllowedElementsShouldThrow() throws OperationNotSupportedException {
        Database database = new Database(1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8);
    }

    @Test
    public void testCreatingADatabaseWithExactCountOfAllowedElementsShouldCreateDatabase() throws OperationNotSupportedException {
        Database database = new Database(1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7);
    }

    @Test
    public void testAddedElementShouldBeInTheEndOfDatabase() throws OperationNotSupportedException {
        this.database.add(5);

        Integer[] elements = database.getElements();
        int expected = elements[3];

        Assert.assertEquals(expected, 5);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddingNullShouldThrow() throws OperationNotSupportedException {
        this.database.add(null);
    }

    @Test
    public void testAddingElementShouldIncreaseSize() throws OperationNotSupportedException {

        this.database.add(5);

        Integer[] elements = this.database.getElements();
        int size = elements.length;

        Assert.assertEquals(size, 4);
    }

    @Test
    public void testRemoveElementShouldDecreaseSize() throws OperationNotSupportedException {

        int sizeBeforeRemoval = this.database.getElements().length;

        this.database.remove();

        int sizeAfterRemoval = this.database.getElements().length;

        Assert.assertEquals(sizeAfterRemoval, sizeBeforeRemoval - 1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveElementWhenDatabaseIsEmptyShouldThrow() throws OperationNotSupportedException {

        this.database.remove();
        this.database.remove();
        this.database.remove();
        this.database.remove();
    }

    @Test
    public void testGetElementsReturnsTheSameElementsAsThoseInDatabase() {

        Integer[] actual = new Integer[]{1, 2, 3};

        Integer[] expected = this.database.getElements();

        Assert.assertArrayEquals(expected, actual);
    }
}
