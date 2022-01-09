package net.joedoe.annotations.v1;

import net.joedoe.annotations.ExceptionTest;
import net.joedoe.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunTests1 {
    public static void main(String[] args) throws Exception {
        int tests = 0;
        int passed = 0;
        Class<?> testClass = Class.forName(args[0]);
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                tests++;
                try {
                    m.invoke(null);
                    passed++;
                } catch (InvocationTargetException wrappedExc) {
                    Throwable exc = wrappedExc.getCause();
                    System.out.println(m.getName() + " failed: " + exc);
                } catch (Exception exc) {
                    System.out.println("Invalid @Test: " + m.getName());
                }
            }
        }
        System.out.println("-----------------------");
        System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
    }
}
