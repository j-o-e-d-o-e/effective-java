package net.joedoe.decimalnums;

import java.math.BigDecimal;

public class UtilDecimal {

    public static String fixed1() {
        // Note: BigDecimal’s String constructor is used rather than its double constructor
        // This is required in order to avoid introducing inaccurate values into the computation
        BigDecimal funds = new BigDecimal("1.00");
        int itemsBought = 0;
        final BigDecimal TEN_CENTS = new BigDecimal(".10");
        for (BigDecimal price = TEN_CENTS; funds.compareTo(price) >= 0; price = price.add(TEN_CENTS)) {
            funds = funds.subtract(price);
            itemsBought++;
        }
        return itemsBought + " items bought. Money left over: $" + funds;
    }

    // alternatively, use int or long and keep track of the decimal point yourself
    // to avoid less convenience and performance of `BigDecimal` in `fixed1()`
    public static String fixed2() {
        int funds = 100;
        int itemsBought = 0;
        final int TEN_CENTS = 10;
        for (int price = TEN_CENTS; funds >= price; price += TEN_CENTS) {
            funds -= price;
            itemsBought++;
        }
        return itemsBought + " items bought. Money left over: $" + funds;
    }

    // Broken - uses floating point for monetary calculation!
    public static String broken() {
        double funds = 1.00;
        int itemsBought = 0;
        final double TEN_CENTS = 0.10;
        for (double price = TEN_CENTS; funds >= price; price += TEN_CENTS) {
            funds -= price;
            itemsBought++;
        }
        return itemsBought + " items bought. Money left over: $" + funds;
    }
}
