package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SortingImpl implements Sorting {

    @Override
    public int[] selectionSort(int[] array) {
        int minIndex;
        for (int i = 0; i < array.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }

    @Override
    public int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; ++i) {
            int pickedElement = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > pickedElement) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = pickedElement;
        }
        return array;
    }

    @Override
    public int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                int previous = array[j];
                int next = array[j + 1];
                if (next < previous) {
                    array[j] = next;
                    array[j + 1] = previous;
                }
            }
        }
        return array;
    }

    @Override
    public int[] mergeSort(int[] array) {
        if (array.length == 1) {
            return array;
        } else {
            int divIndex = array.length / 2;
            int[] firstPart = mergeSort(Arrays.copyOfRange(array, 0, divIndex));
            int[] secondPart = mergeSort(Arrays.copyOfRange(array, divIndex, array.length));

            int[] result = new int[firstPart.length + secondPart.length];
            int firstIndex = 0;
            int secondIndex = 0;

            for (int i = 0; i < result.length; i++) {
                if (firstIndex > firstPart.length - 1 && secondIndex <= secondPart.length - 1) {
                    result[i] = secondPart[secondIndex];
                    secondIndex++;
                } else if (secondIndex > secondPart.length - 1 && firstIndex <= firstPart.length - 1) {
                    result[i] = firstPart[firstIndex];
                    firstIndex++;
                } else {
                    int first = firstPart[firstIndex];
                    int second = secondPart[secondIndex];
                    if (first < second) {
                        result[i] = first;
                        firstIndex++;
                    } else {
                        result[i] = second;
                        secondIndex++;
                    }
                }
            }
            return result;
        }
    }

    @Override
    public int[] quickSort(int[] array) {

        //divide on two parts and support element
        List<Integer> firstPart = new ArrayList<>();
        List<Integer> secondPart = new ArrayList<>();

        Integer supportElem = null;

        if (array.length == 2) {
            if (array[0] < array[1]) {
                firstPart.add(array[0]);
                secondPart.add(array[1]);
            } else {
                firstPart.add(array[1]);
                secondPart.add(array[0]);
            }
        } else {
            if (array.length == 3) {
                supportElem = (array[0] + array[1] + array[2]) / 3;
            } else {
                supportElem = array[array.length / 2];
            }
            boolean likeSupport = false;
            for (int i : array) {
                if (i < supportElem) {
                    firstPart.add(i);
                } else if (i > supportElem) {
                    secondPart.add(i);
                } else if (i == supportElem) {
                    if (likeSupport) {
                        secondPart.add(i);
                    }
                    likeSupport = true;
                }
            }
        }

        int[] firstArray = convertToArray(firstPart);
        int[] secondArray = convertToArray(secondPart);

        //recurs if need
        if (firstArray.length > 1) firstArray = quickSort(firstArray);
        if (secondArray.length > 1) secondArray = quickSort(secondArray);

        //concat two parts and support element for result
        int[] result = new int[array.length];

        System.arraycopy(firstArray, 0, result, 0, firstArray.length);

        if (supportElem != null) {
            result[firstArray.length] = supportElem;
        }
        for (int i = result.length - 1, j = secondArray.length - 1;
             i > (result.length - secondArray.length - 1); i--, j--) {
            result[i] = secondArray[j];
        }

        return result;
    }


    private int[] convertToArray(List<Integer> list) {
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
