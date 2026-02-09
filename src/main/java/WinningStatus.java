public enum WinningStatus {
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FORTH(50000),
    FIFTH(5000),
    FAIL(0)
    ;

    private final int price;

    WinningStatus(int price) {
        this.price = price;
    }

    public static WinningStatus valueOf(int count, boolean containsBonus) {
        if (count == 6) return FIRST;
        if (count == 5) return containsBonus ? SECOND : THIRD;
        if (count == 4) return FORTH;
        if (count == 3) return FIFTH;
        return FAIL;
    }
}
