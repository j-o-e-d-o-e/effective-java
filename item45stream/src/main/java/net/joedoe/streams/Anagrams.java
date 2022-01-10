package net.joedoe.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

// Tasteful use of streams enhances clarity and conciseness
public class Anagrams {
    public static void main(String[] args) throws IOException {
        Path dictionary = Paths.get(args[0]);
        int minGroupSize = Integer.parseInt(args[1]);
        try (Stream<String> lines = Files.lines(dictionary)) {
            lines.collect(groupingBy(Anagrams::alphabetize))
                    .entrySet().stream()
                    .filter(e -> e.getValue().size() >= minGroupSize)
                    .forEach(e -> System.out.printf("%s (%d): %s%n", e.getKey(), e.getValue().size(), e.getValue()));
        }
    }

    private static String alphabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}
