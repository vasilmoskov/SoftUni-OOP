package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTest {

    private ListIterator listIterator;

    @Before
    public void createListIterator() throws OperationNotSupportedException {
        this.listIterator = new ListIterator("Hey", "Hi", "Hello");
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testConstructorShouldThrowWhenNullPassed() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator(null);
    }

    @Test
    public void testMoveShouldReturnTrueIfSuccessfullyGoesToNextIndex () {
        Assert.assertTrue(listIterator.move());
    }

    @Test
    public void testMoveShouldReturnFalseWhenAllStringsIterated () {
        listIterator.move();
        listIterator.move();
        Assert.assertFalse(listIterator.move());
    }

    @Test
    public void testHasNextWhenThereIsNext() {
        Assert.assertTrue(listIterator.hasNext());
    }

    @Test
    public void testHasNextWhenThereIsNoNext() {
        listIterator.hasNext();
        listIterator.move();
        listIterator.hasNext();
        listIterator.move();
        Assert.assertFalse(listIterator.hasNext());
    }

    @Test
    public void testPrintingFirstElement() {
        String actual = listIterator.print();
        Assert.assertEquals("Hey", actual);
    }

    @Test
    public void testPrintingLastElement() {
        listIterator.move();
        listIterator.move();
        String actual = listIterator.print();
        Assert.assertEquals("Hello", actual);
    }

    // Throws OperationNotSupportedException and not IllegalStateException. REDO!
    @Test (expected = IllegalStateException.class)
    public void testPrintingWithNoElementsShouldThrow() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator();
        listIterator.print();
    }
}
