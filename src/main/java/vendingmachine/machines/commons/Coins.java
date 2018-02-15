package vendingmachine.machines.commons;

/**
 * enum class with types of money (both with coins and notes)
 */
public enum Coins {
    TWO_HUNDRED_PLN(20000),
    ONE_HUNDRED_PLN(10000),
    FIFTY_PLN(5000),
    TWENTY_PLN(2000),
    TEN_PLN(1000),
    FIVE_PLN(500),
    TWO_PLN(200),
    ONE_PLN(100),
    FIFTY_GR(50),
    TWENTY_GR(20),
    TEN_GR(10),
    FIVE_GR(5),
    TWO_GR(2),
    ONE_GR(1);

    int cents;

    Coins(int cents) {
        this.cents = cents;
    }

    public int getCents() {
        return this.cents;
    }
}