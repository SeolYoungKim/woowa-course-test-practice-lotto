package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultsTest {

    @DisplayName("자신의 값으로 총 상금을 구한다.")
    @Test
    void getTotalWinnings() {
        LottoResults lottoResults = new LottoResults(Map.of(
                Ranking.FIFTH, 1,
                Ranking.FORTH, 1,
                Ranking.THIRD, 1,
                Ranking.SECOND, 1,
                Ranking.FIRST, 1)
        );

        long actual = lottoResults.totalWinnings();
        long expected = 5_000 + 50_000 + 1_500_000 + 30_000_000 + 2_000_000_000;

        assertThat(actual).isEqualTo(expected);
    }
}