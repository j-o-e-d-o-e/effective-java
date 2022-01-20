package net.joedoe.app;

import net.joedoe.libraries.Util;

import java.io.IOException;

/**
 * <strong>Title</strong>: General Programming
 * <br>
 * <strong>Items</strong>: 57-68
 */
class Chapter9 {
    /**
     * Item 59: Know and use the libraries
     */
    static void item59libraries() {
        try {
            String[] args = new String[]{"https://traffic-tracker.herokuapp.com/api/days/current"};
            Util.main(args);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
