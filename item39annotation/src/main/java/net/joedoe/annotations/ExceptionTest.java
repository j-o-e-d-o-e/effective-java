package net.joedoe.annotations;

import java.lang.annotation.*;          // Annotation type with a parameter

/**
 * Indicates that the annotated method is a test method
 * that must throw the designated exception to succeed.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExceptionTest {
    Class<? extends Throwable>[] value(); // parameter for this annotation (bounded type token)
}

