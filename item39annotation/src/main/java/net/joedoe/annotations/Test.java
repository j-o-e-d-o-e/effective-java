package net.joedoe.annotations;

import java.lang.annotation.*;      // Marker annotation type declaration

/**
 * Indicates that the annotated method is a test method.
 * Use only on parameterless static methods (not ensured by compiler)
 */
@Retention(RetentionPolicy.RUNTIME) // retained at runtime
@Target(ElementType.METHOD)         // only on method declarations
public @interface Test {
}
