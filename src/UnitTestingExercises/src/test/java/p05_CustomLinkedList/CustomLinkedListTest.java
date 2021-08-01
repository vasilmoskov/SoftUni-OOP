package p05_CustomLinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomLinkedListTest {

    private CustomLinkedList<String> customLinkedList;

    @Before
    public void createCustomLinkedList() {
        this.customLinkedList = new CustomLinkedList<>();
        customLinkedList.add("Vasil");
    }

    @Test
    public void testGetFirstElementWhenOnlyOneElementInList() {
        String actual = customLinkedList.get(0);

        Assert.assertEquals("Vasil", actual);
    }

    @Test
    public void testGetLastElementFromList() {
        customLinkedList.add("Angel");
        String actual = customLinkedList.get(1);

        Assert.assertEquals("Angel", actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetShouldThrowWhenInvalidIndexPassed() {
        String s = customLinkedList.get(2);
    }

    @Test
    public void testSetOnFirstElement() {
        customLinkedList.set(0, "Nikolay");
        String actual = customLinkedList.get(0);

        Assert.assertEquals("Nikolay", actual);
    }

    @Test
    public void testSetOnRandomIndex() {
        customLinkedList.add("Angel");
        customLinkedList.add("Sasho");
        customLinkedList.add("Gosho");
        customLinkedList.add("Pesho");

        customLinkedList.set(2, "Miro");

        String actual = customLinkedList.get(2);

        Assert.assertEquals("Miro", actual);

    }

    @Test
    public void testSetLastOnLastIndex() {
        customLinkedList.add("Angel");
        customLinkedList.add("Sasho");
        customLinkedList.add("Gosho");
        customLinkedList.add("Pesho");

        customLinkedList.set(4, "Miro");

        String actual = customLinkedList.get(4);

        Assert.assertEquals("Miro", actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidIndex() {
        customLinkedList.add("Angel");
        customLinkedList.add("Sasho");
        customLinkedList.add("Gosho");
        customLinkedList.add("Pesho");

        customLinkedList.set(5, "Miro");
    }

    @Test
    public void testAddElement() {
        customLinkedList.add("Toshko");

        String actual = customLinkedList.get(1);

        Assert.assertEquals("Toshko", actual);
    }

    @Test
    public void testRemoveAtFirstIndexShouldRemoveFirstElement () {
        String actual = customLinkedList.removeAt(0);

        Assert.assertEquals("Vasil", actual);
    }

    @Test
    public void testRemoveFirstElementsShouldPutTheSecondOneOnItsPlace() {
        this.customLinkedList.add("Toshko");
        this.customLinkedList.remove("Vasil");

        Assert.assertSame("Toshko", customLinkedList.get(0));
    }

    @Test
    public void testRemoveAtRandomIndexShouldRemoveElementOnThatIndex () {
        customLinkedList.add("Angel");
        customLinkedList.add("Gosho");
        customLinkedList.add("Sasho");
        customLinkedList.add("Pesho");

        String actual = customLinkedList.removeAt(2);

        Assert.assertEquals("Gosho", actual);
    }

    @Test
    public void testRemoveAtLastIndexShouldRemoveLastElement () {
        customLinkedList.add("Angel");
        customLinkedList.add("Gosho");
        customLinkedList.add("Sasho");
        customLinkedList.add("Pesho");

        String actual = customLinkedList.removeAt(4);

        Assert.assertEquals("Pesho", actual);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveAtInvalidIndexShouldThrow () {
        customLinkedList.add("Angel");
        customLinkedList.add("Gosho");
        customLinkedList.add("Sasho");
        customLinkedList.add("Pesho");

        String actual = customLinkedList.removeAt(5);
    }

    @Test
    public void testRemoveFirstElementShouldReturnIndexZero () {
        int actual = customLinkedList.remove("Vasil");

        Assert.assertEquals(0, actual);
    }

    @Test
    public void testRemoveElementAtRandomIndexShouldReturnThatIndex () {
        customLinkedList.add("Angel");
        customLinkedList.add("Gosho");
        customLinkedList.add("Pesho");
        customLinkedList.add("Sasho");

        int actual = customLinkedList.remove("Pesho");

        Assert.assertEquals(3, actual);
    }

    @Test
    public void testRemoveLastElementShouldReturnLastIndex () {
        customLinkedList.add("Angel");
        customLinkedList.add("Gosho");
        customLinkedList.add("Pesho");
        customLinkedList.add("Sasho");
        customLinkedList.add("Miho");

        int actual = customLinkedList.remove("Miho");

        Assert.assertEquals(5, actual);
    }

    @Test
    public void testRemoveNonExistingElementShouldReturnMinusOne() {
        customLinkedList.add("Angel");
        customLinkedList.add("Gosho");
        customLinkedList.add("Pesho");
        customLinkedList.add("Sasho");
        customLinkedList.add("Miho");

        int actual = customLinkedList.remove("Rado");

        Assert.assertEquals(-1, actual);
    }

    @Test
    public void testIndexOfShouldReturnIndexOfSearchedElement() {
        customLinkedList.add("Angel");
        customLinkedList.add("Gosho");
        customLinkedList.add("Pesho");
        customLinkedList.add("Sasho");
        customLinkedList.add("Miho");

        int actual = customLinkedList.indexOf("Gosho");

        Assert.assertEquals(2, actual);
    }

    @Test
    public void testIndexOfInvalidElementShouldReturnMinusOne() {
        customLinkedList.add("Angel");
        customLinkedList.add("Gosho");
        customLinkedList.add("Pesho");
        customLinkedList.add("Sasho");
        customLinkedList.add("Miho");

        int actual = customLinkedList.indexOf("Biser");

        Assert.assertEquals(-1, actual);
    }

    @Test
    public void testContainsShouldReturnTrueWhenElementExists() {
        boolean condition = customLinkedList.contains("Vasil");

        Assert.assertTrue(condition);
    }

    @Test
    public void testContainsShouldReturnFalseWhenElementDoesNotExist() {
        boolean condition = customLinkedList.contains("Gabriel");

        Assert.assertFalse(condition);
    }


}
