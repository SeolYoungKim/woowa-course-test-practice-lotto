package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {

    private LottoTickets lottoTickets;

    @BeforeEach
    void setUp() {
        lottoTickets = new LottoTickets(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                new Lotto(List.of(1, 2, 3, 4, 8, 7)),
                new Lotto(List.of(1, 2, 3, 9, 8, 7))
        ));
    }

    @DisplayName("WinningNumbers와 BonusNumber를 입력 받아 결과를 반환 해준다.")
    @Test
    void lottoResults() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);

        LottoResults lottoResults = lottoTickets.lottoResults(winningNumbers, bonusNumber);
        Map<Ranking, Integer> actual = lottoResults.results();

        Map<Ranking, Integer> expected = Map.of(
                Ranking.FIFTH, 1,
                Ranking.FORTH, 1,
                Ranking.THIRD, 1,
                Ranking.SECOND, 1,
                Ranking.FIRST, 1
        );
        assertThat(actual).containsExactlyEntriesOf(expected);
    }
}