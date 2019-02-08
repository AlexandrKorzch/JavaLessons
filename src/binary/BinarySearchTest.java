package binary;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    private int[] sortedArray;

    @Before
    public void setUp() {
        sortedArray = new int[]{1, 2, 3, 4, 5, 6, 8, 12, 13, 22, 94, 123, 789, 1056, 1748, 2635};
    }

    @Test
    public void getElementIndexWithRecursion() {
        int startArrayIndex = 0;
        for (int elementFromArray : sortedArray) {
            int index = BinarySearch.getElementIndexWithRecursion(elementFromArray, sortedArray, startArrayIndex);
            assertEquals(elementFromArray, sortedArray[index]);
        }
    }

    @Test
    public void getElementIndexWithCycle() {
        for (int elementFromArray : sortedArray) {
            int index = BinarySearch.getElementIndexWithCycle(elementFromArray, sortedArray);
            assertEquals(elementFromArray, sortedArray[index]);
        }
    }
}