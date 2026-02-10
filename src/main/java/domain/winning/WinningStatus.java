public enum WinningStatus {
    FIRST(2000000000L),
    SECOND(30000000L),
    THIRD(1500000L),
    FORTH(50000L),
    FIFTH(5000L),
    FAIL(0L)
    ;

    private final long prize;

    WinningStatus(long prize) {
        this.prize = prize;
    }

    public long prize() {
        return prize;
    }

    public static WinningStatus valueOf(int count, boolean containsBonus) {
        if (count == 6) return FIRST;
        if (count == 5) return containsBonus ? SECOND : THIRD;
        if (count == 4) return FORTH;
        if (count == 3) return FIFTH;
        return FAIL;
    }
}
