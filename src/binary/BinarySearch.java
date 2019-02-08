package binary;

import java.util.Arrays;
import java.util.NoSuchElementException;

class BinarySearch {


    /*Implementation of binary search with recursion*/
    static int getElementIndexWithRecursion(int element, int[] array, int startArrayIndex) throws NoSuchElementException {
        int supportIndex = array.length / 2;
        if (array.length == 1 && element != array[supportIndex]) {
            throw new NoSuchElementException("Element doesn't exist in this array");
        } else if (element > array[supportIndex]) {
            array = Arrays.copyOfRange(array, supportIndex, array.length);
            startArrayIndex += supportIndex;
        } else if (element < array[supportIndex]) {
            array = Arrays.copyOfRange(array, 0, supportIndex);
        } else if (element == array[supportIndex]) {
            return supportIndex + startArrayIndex;
        }
        return getElementIndexWithRecursion(element, array, startArrayIndex);
    }

    /*Implementation of binary search with cycle*/
    static int getElementIndexWithCycle(int element, int[] array) throws NoSuchElementException {
        int lastIndex = array.length - 1;
        int firstIndex = 0;
        int supportIndex = (lastIndex + 1) / 2;
        while (array[supportIndex] != element && lastIndex != supportIndex && firstIndex != supportIndex) {
            if (array[supportIndex] < element) {
                firstIndex = supportIndex;
                supportIndex = (lastIndex + firstIndex) / 2;
            } else {
                lastIndex = supportIndex;
                supportIndex = (lastIndex + firstIndex) / 2;
            }
        }
        if (array[lastIndex] == element) {
            supportIndex = lastIndex;
        } else if (array[firstIndex] == element) {
            supportIndex = firstIndex;
        }

        if(array[supportIndex] == element){
            return supportIndex;
        }else {
            throw new NoSuchElementException("Element doesn't exist in this array");
        }
    }
}
