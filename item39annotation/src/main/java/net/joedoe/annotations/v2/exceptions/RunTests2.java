package net.joedoe.annotations.v2.exceptions;

import net.joedoe.annotations.ExceptionTest;
import net.joedoe.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunTests2 {
    public static void main(String[] args) throws Exception {
        int tests = 0;
        int passed = 0;
        Class<?> testClass = Class.forName(args[0]);
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(ExceptionTest.class)) {
                tests++;
                try {
                    m.invoke(null);
                    System.out.printf("Test %s failed: no exception%n", m.getName());
                } catch (Throwable wrappedExc) {
                    Throwable exc = wrappedExc.getCause();
                    int oldPassed = passed;
                    Class<? extends Throwable>[] excTypes = m.getAnnotation(ExceptionTest.class).value();
                    for (Class<? extends Throwable> excType : excTypes) {
                        if (excType.isInstance(exc)) {
                            passed++;
                            break;
                        }
                    }
                    if (passed == oldPassed) System.out.printf("Test %s failed: %s %n", m.getName(), exc);
                }
            }
        }
        System.out.println("-----------------------");
        System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
    }
}