package domain.winning;

public enum WinningStatus {
    FIRST(2000000000L, 6),
    SECOND(30000000L, 5),
    THIRD(1500000L, 5),
    FOURTH(50000L, 4),
    FIFTH(5000L, 3),
    FAIL(0L, 0)
    ;

    private final long prize;
    private final int matchCount;

    WinningStatus(long prize, int matchCount) {
        this.prize = prize;
        this.matchCount = matchCount;
    }

    public long prize() {
        return prize;
    }

    public int matchCount() {
        return matchCount;
    }

    public static WinningStatus valueOf(int count, boolean containsBonus) {
        if (count == 6) return FIRST;
        if (count == 5) return containsBonus ? SECOND : THIRD;
        if (count == 4) return FOURTH;
        if (count == 3) return FIFTH;
        return FAIL;
    }
}
