package lotto.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Ranking {
    FIFTH(3, false, 5_000),
    FORTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000),;

    private static final Map<Integer, Ranking> MATCH_COUNTS_AND_RANKINGS = Arrays.stream(values())
            .filter(ranking -> !ranking.isMatchBonusNumber)
            .collect(Collectors.toUnmodifiableMap(
                    ranking -> ranking.matchCount,
                    Function.identity()));

    public static Ranking ranking(int count, boolean hasBonusNumber) {
        if (isSecond(count, hasBonusNumber)) {
            return SECOND;
        }

        return MATCH_COUNTS_AND_RANKINGS.get(count);
    }

    private static boolean isSecond(int count, boolean hasBonusNumber) {
        final int MATCH_COUNT_OF_THIRD_OF_SECOND = 5;
        return count == MATCH_COUNT_OF_THIRD_OF_SECOND && hasBonusNumber;
    }

    private final int matchCount;
    private final boolean isMatchBonusNumber;
    private final int winnings;

    Ranking(int matchCount, boolean isMatchBonusNumber, int winnings) {
        this.matchCount = matchCount;
        this.isMatchBonusNumber = isMatchBonusNumber;
        this.winnings = winnings;
    }

    public long winnings(int count) {
        return (long) this.winnings * count;
    }
}
