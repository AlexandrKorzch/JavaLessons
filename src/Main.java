import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[]{6, 4, 5, 3, 8, 1, 1056, 22, 94, 2, 5, 12, 123, 789, 13};
        System.out.println(Arrays.toString(bubbleSort(array)));
    }

    private static int[] bubbleSort(int[] array) {
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
}