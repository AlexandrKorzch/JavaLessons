package util;

public class Print {

    public static String toString(int[] array) {
        StringBuilder builder = new StringBuilder("[ ");
        for (int i : array) {
            builder.append(i);
            builder.append(" ");
        }
        builder.append("]");
        return builder.toString();
    }
}