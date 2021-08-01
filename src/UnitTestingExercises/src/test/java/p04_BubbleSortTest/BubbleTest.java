package p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BubbleTest {

    private int[] arr;

    @Before
    public void createBubble() {
        this.arr = new int[]{9, 5, 8, 0, -1, 5, -4, -8, -2, 8, 4, 7, 1};
        Bubble.sort(arr);
    }


    @Test
    public void testSortShouldHaveSmallestElementInTheBeginningOfArray() {
        int smallestElement = arr[0];

        Assert.assertEquals(-8, smallestElement);
    }

    @Test
    public void testSortShouldHaveBiggestElementInTheEndOfArray() {
        int biggestElement = arr[arr.length - 1];

        Assert.assertEquals(9, biggestElement);
    }

    @Test
    public void testSortShouldMakeArrayElementsInIncreasingOrder() {
        int[] expected = new int[]{-8, -4, -2, -1, 0, 1, 4, 5, 5, 7, 8, 8, 9};

        Assert.assertArrayEquals(expected, this.arr);
    }
}
