import sorting.ISorting;
import sorting.Sorting;
import util.Print;

public class Main {

    public static void main(String[] args) {

        int[] array = new int[]{6, 4, 5, 3, 8, 1, 1056, 22, 94, 2, 5, 12, 123, 789, 13};
        System.out.println("input array - "+ Print.toString(array));

        ISorting sorting = new Sorting();

//        System.out.println("selectionSortedArray - " + Print.toString(sorting.selectionSort(array)));
//        System.out.println("insertionSortedArray - " + Print.toString(sorting.insertionSort(array)));
//        System.out.println("bubbleSortedArray - " + Print.toString(sorting.bubbleSort(array)));
//        System.out.println("mergeSortedArray - " + Print.toString(sorting.mergeSort(array)));
//        System.out.println("quickSortedArray - " + Print.toString(sorting.quickSort(array)));
    }
}