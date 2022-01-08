package net.joedoe.enums;

public enum Planet {                                // ordinals:
    MERCURY(3.302e+23, 2.439e6),        // 0
    VENUS(4.869e+24, 6.052e6),          // 1
    EARTH(5.975e+24, 6.378e6),          // 2
    MARS(6.419e+23, 3.393e6),           // ...
    JUPITER(1.899e+27, 7.149e7),
    SATURN(5.685e+26, 6.027e7),
    URANUS(8.683e+25, 2.556e7),
    NEPTUNE(1.024e+26, 2.477e7);

    private final double mass;                      // In kilograms
    private final double radius;                    // In meters
    private final double surfaceGravity;            // In m / s^2

    private static final double G = 6.67300E-11;    // Universal gravitational constant in m^3 / kg s^2

    Planet(double mass, double radius) {            // Constructor
        this.mass = mass;
        this.radius = radius;
        surfaceGravity = G * mass / (radius * radius);
    }

    public double mass() {
        return mass;
    }

    public double radius() {
        return radius;
    }

    public double surfaceGravity() {
        return surfaceGravity;
    }

    public double surfaceWeight(double mass) {
        return mass * surfaceGravity; // F = ma
    }
}
