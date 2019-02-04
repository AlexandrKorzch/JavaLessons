import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[]{6, 4, 5, 3, 8, 1, 1056, 22, 94, 2, 5, 12, 123, 789, 13};
        System.out.println(Arrays.toString(mergeSort(array)));
    }

    private static int[] mergeSort(int[] array) {
        if (array.length == 1) {
            return array;
        } else {
            int divInd = array.length / 2;
            int[] firstPart = mergeSort(Arrays.copyOfRange(array, 0, divInd));
            int[] secondPart = mergeSort(Arrays.copyOfRange(array, divInd, array.length));

            int[] result = new int[firstPart.length + secondPart.length];
            int firstIndex = 0;
            int secondIndex = 0;

            for (int i = 0; i < result.length; i++) {
                if (firstIndex > firstPart.length - 1 && !(secondIndex > secondPart.length - 1)) {
                    result[i] = secondPart[secondIndex];
                    secondIndex += 1;
                } else if (secondIndex > secondPart.length - 1 && !(firstIndex > firstPart.length - 1)) {
                    result[i] = firstPart[firstIndex];
                    firstIndex += 1;
                } else {
                    int first = firstPart[firstIndex];
                    int second = secondPart[secondIndex];
                    if (first < second) {
                        result[i] = first;
                        firstIndex += 1;
                    } else {
                        result[i] = second;
                        secondIndex += 1;
                    }
                }
            }
            return result;
        }
    }
}