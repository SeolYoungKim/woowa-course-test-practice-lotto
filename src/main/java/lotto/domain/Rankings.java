package lotto.domain;

public enum Rankings {
    FIFTH(3, false, 5_000),
    FORTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000),;

    private final int matchCount;
    private final boolean isMatchBonusNumber;
    private final int winnings;

    Rankings(int matchCount, boolean isMatchBonusNumber, int winnings) {
        this.matchCount = matchCount;
        this.isMatchBonusNumber = isMatchBonusNumber;
        this.winnings = winnings;
    }
}
