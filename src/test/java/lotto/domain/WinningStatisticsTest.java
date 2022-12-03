package lotto.domain;

import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningStatisticsTest {

    @DisplayName("LottoTiket이 8개 있고, 5등에 한개 당첨됐을 때 수익률은 62.5이다.")
    @Test
    void name() {
        LottoTickets lottoTickets = new LottoTickets(List.of(
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45)))
        );

        LottoResults lottoResults = new LottoResults(Map.of(
                Ranking.FIFTH, 1,
                Ranking.FORTH, 0,
                Ranking.THIRD, 0,
                Ranking.SECOND,0,
                Ranking.FIRST, 0)
        );

        WinningStatistics winningStatistics = new WinningStatistics(lottoTickets, lottoResults);
        double actual = winningStatistics.rateOfReturn();
        double expected = 62.5;

        Assertions.assertThat(actual).isCloseTo(expected, Offset.offset(0.1));
    }
}