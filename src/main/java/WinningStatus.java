public enum WinningStatus {
    FIRST,
    SECOND,
    THIRD,
    FORTH,
    FIFTH,
    FAIL
    ;

    public static WinningStatus valueOf(int count, boolean containsBonus) {
        if (count == 6) return FIRST;
        if (count == 5) return containsBonus ? SECOND : THIRD;
        if (count == 4) return FORTH;
        if (count == 3) return FIFTH;
        return FAIL;
    }
}
