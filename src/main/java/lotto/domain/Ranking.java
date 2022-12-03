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

    public static Ranking of(int matchCount) {
        if (MATCH_COUNTS_AND_RANKINGS.containsKey(matchCount)) {
            return MATCH_COUNTS_AND_RANKINGS.get(matchCount);
        }

        throw new IllegalArgumentException("순위에 없습니다.");
    }

    private final int matchCount;
    private final boolean isMatchBonusNumber;
    private final int winnings;

    Ranking(int matchCount, boolean isMatchBonusNumber, int winnings) {
        this.matchCount = matchCount;
        this.isMatchBonusNumber = isMatchBonusNumber;
        this.winnings = winnings;
    }
}
