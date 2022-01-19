package net.joedoe.varargs;

public class Varargs {
    // The right way to use varargs to pass one or more arguments
    // 1st arg for well-defined behaviour: no args at all is not permitted
    public static int min(int firstArg, int... remainingArgs) {
        int min = firstArg;
        for (int arg : remainingArgs)
            if (arg < min) min = arg;
        return min;
    }
}
