package net.joedoe.concatenation;

public class UtilStringConcat {
    private static final int LINE_WIDTH = 10;

    public static String fixed(int numItems) {
        StringBuilder b = new StringBuilder(numItems * LINE_WIDTH);
        for (int i = 0; i < numItems; i++) b.append(lineForItem(i));
        return b.toString();
    }


    // Inappropriate use of string concatenation - Performs poorly!
    public static String inappropriate(int numItems) {
        String result = "";
        for (int i = 0; i < numItems; i++) result += lineForItem(i);
        return result;
    }

    private static String lineForItem(int i) {
        return String.valueOf(i);
    }
}
