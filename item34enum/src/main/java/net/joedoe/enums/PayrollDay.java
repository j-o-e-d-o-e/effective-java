package net.joedoe.enums;

public enum PayrollDay {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY(PayType.WEEKEND), SUNDAY(PayType.WEEKEND);
    private final PayType payType;

    PayrollDay() {                  // Default constructor
        this(PayType.WEEKDAY);
    }

    PayrollDay(PayType payType) {   // Constructor with strategy enum type
        this.payType = payType;
    }

    public int pay(int minutesWorked, int payRate) {
        return payType.pay(minutesWorked, payRate);
    }

    // Strategy enum type
    private enum PayType {
        WEEKDAY {
            int overtimePay(int minutesWorked, int payRate) {
                return minutesWorked <= MINS_PER_SHIFT ? 0 : (minutesWorked - MINS_PER_SHIFT) * payRate / 2;
            }
        },
        WEEKEND {
            int overtimePay(int minutesWorked, int payRate) {
                return minutesWorked * payRate / 2;
            }
        };
        private static final int MINS_PER_SHIFT = 8 * 60;

        abstract int overtimePay(int minutesWorked, int payRate);

        int pay(int minutesWorked, int payRate) {
            int basePay = minutesWorked * payRate;
            return basePay + overtimePay(minutesWorked, payRate);
        }
    }

    @Override
    public String toString() {
        return this.name().substring(0, 1).concat(this.name().substring(1).toLowerCase());
    }
}

