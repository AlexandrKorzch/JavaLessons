import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[]{6, 4, 5, 3, 8, 1, 1056, 22, 94, 2, 5, 12, 123, 789, 13};
        System.out.println(Arrays.toString(quickSort(array)));
    }

    private static  int[] quickSort(int[] array) {

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

    private static int[] convertToArray(List<Integer> list) {
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}