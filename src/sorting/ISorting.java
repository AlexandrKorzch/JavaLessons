package sorting;

public interface ISorting {

    /**
     * Sort int[] with selection sort algorithm
     * @param array int array
     * @return sorted array
     * */
    int[] selectionSort(int[] array);

    /**
     * Sort int[] with insertion sort algorithm
     * @param array int array
     * @return sorted array
     * */
    int[] insertionSort(int[] array);

    /**
     * Sort int[] with bubble sort algorithm
     * @param array int array
     * @return sorted array
     * */
    int[] bubbleSort(int[] array);

    /**
     * Sort int[] with merge sort algorithm
     * @param array int array
     * @return sorted array
     * */
    int[] mergeSort(int[] array);

    /**
     * Sort int[] with quick sort algorithm
     * @param array int array
     * @return sorted array
     * */
    int[] quickSort(int[] array);
}