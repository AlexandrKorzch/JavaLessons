import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] array = new int[]{6, 4, 5, 3, 8, 1, 1056, 22, 94, 2, 5, 12, 123, 789, 13};
        System.out.println(Arrays.toString(selectionSort(array)));

    }

    private static int[] selectionSort(int[] array) {
        int replaceable;
        int minInd;
        for (int i = 0; i < array.length; i++) {
            replaceable = array[i];
            minInd = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i] && array[j] < array[minInd]) {
                    minInd = j;
                }
            }
            array[i] = array[minInd];
            array[minInd] = replaceable;
        }
        return array;
    }
}