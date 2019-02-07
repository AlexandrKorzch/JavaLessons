import exception.ElementNotFoundException;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] sortedArray = new int[]{1, 2, 3, 4, 5, 6, 8, 12, 13, 22, 94, 123, 789, 1056, 1748, 2635};
        System.out.println(Arrays.toString(sortedArray));

        foundIndexIfElementExistInArray(sortedArray);

        foundIndexIfElementNotExists(sortedArray);
    }


    /**
     * Method for test. We try to find index of element in sorted array in case array doesn't have this element
     * */
    private static void foundIndexIfElementNotExists(int[] sortedArray) {
        int startArrayIndex = 0;
        int foundedElement = 7;
        int index = getIndex(sortedArray, startArrayIndex, foundedElement);
        System.out.println(index);
    }

    /**
     * Method for test. We try to find index of element in sorted array in case element exists in this array
     * */
    private static void foundIndexIfElementExistInArray(int[] sortedArray) {
        int startArrayIndex = 0;
        for (int i = 0; i < sortedArray.length; i++) {
            int elementFromArray = sortedArray[i];
            int index = getIndex(sortedArray, startArrayIndex, elementFromArray);
            System.out.println("element - " + elementFromArray + ", i - " + i + ", index - " + index);
        }
    }

    /**
     * Method for getting index from sorted array
     * */
    private static int getIndex(int[] sortedArray, int startArrayIndex, int foundedElement) {
        int index = -1;
        try {
            index = getElementIndex(foundedElement, sortedArray, startArrayIndex);
        } catch (ElementNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return index;
    }

    /**
     * Implementation of binary search with recursion
     * */
    private static int getElementIndex(int element, int[] array, int startArrayIndex) throws ElementNotFoundException {
        int supportIndex = array.length / 2;
        if (array.length == 1 && element != array[supportIndex]) {
            throw new ElementNotFoundException();
        } else if (element > array[supportIndex]) {
            array = Arrays.copyOfRange(array, supportIndex, array.length);
            startArrayIndex += supportIndex;
        } else if (element < array[supportIndex]) {
            array = Arrays.copyOfRange(array, 0, supportIndex);
        } else if (element == array[supportIndex]) {
            return supportIndex + startArrayIndex;
        }
        return getElementIndex(element, array, startArrayIndex);
    }
}