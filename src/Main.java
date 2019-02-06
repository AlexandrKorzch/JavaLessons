import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] sortedArray = new int[]{1, 2, 3, 4, 5, 5, 6, 8, 12, 13, 22, 94, 123, 789, 1056, 1748};
        System.out.println(Arrays.toString(sortedArray));


        int elementFromArray = sortedArray[3];
        int startArrayIndex = 0;
        int index = getElementIndex(elementFromArray, sortedArray, startArrayIndex);
        System.out.println(index);
    }

    private static int getElementIndex(int element, int[] array, int startArrayIndex) {//todo correct +1

        int supportIndex = array.length / 2;

        if (element > array[supportIndex]) {
            array = Arrays.copyOfRange(array, supportIndex, array.length);
            startArrayIndex += supportIndex;
        } else if (element < array[supportIndex]) {
            array = Arrays.copyOfRange(array, 0, supportIndex);
        } else {
            return supportIndex = startArrayIndex;
        }
        return getElementIndex(element, array, startArrayIndex);
    }

}