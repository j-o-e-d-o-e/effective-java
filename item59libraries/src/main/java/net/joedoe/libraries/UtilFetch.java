package net.joedoe.libraries;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class UtilFetch {

    // fetches data from specified URL in args[0]
    public static void main(String[] args) throws IOException {
        try (InputStream in = new URL(args[0]).openStream()) {
            in.transferTo(System.out);
        }
    }
}
