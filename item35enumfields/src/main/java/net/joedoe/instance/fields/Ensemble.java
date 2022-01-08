package net.joedoe.instance.fields;

public enum Ensemble {
    SOLO(1), DUET(2), TRIO(3), QUARTET(4), QUINTET(5),
    SEXTET(6), SEPTET(7), OCTET(8), DOUBLE_QUARTET(8),
    NONET(9), DECTET(10), TRIPLE_QUARTET(12);

    private final int numberOfMusicians;

    Ensemble(int size) {
        this.numberOfMusicians = size;
    }

    public int numberOfMusicians() {
        return numberOfMusicians;
    }

    @Override
    public String toString() {
        String name = this.name().substring(0, 1);
        String[] tokens = this.name().substring(1).toLowerCase().split("_");
        for (String t : tokens) name = name.concat(t).concat(" ");
        return name.trim();
    }
}

