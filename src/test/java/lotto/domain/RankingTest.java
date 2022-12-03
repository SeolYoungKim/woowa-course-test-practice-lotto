package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RankingTest {

    @ParameterizedTest(name = "count={0}, hasBonusNumber={1}을 입력 받으면 Rankings.{2}를 반환한다.")
    @MethodSource("provideCountAndHasBonusNumberAndRanking")
    void rankingTest(int count, boolean hasBonusNumber, Ranking expected) {
        Ranking actual = Ranking.ranking(count, hasBonusNumber);
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideCountAndHasBonusNumberAndRanking() {
        return Stream.of(
                Arguments.of(3, false, Ranking.FIFTH),
                Arguments.of(4, false, Ranking.FORTH),
                Arguments.of(5, false, Ranking.THIRD),
                Arguments.of(5, true, Ranking.SECOND),
                Arguments.of(6, false, Ranking.FIRST)
        );
    }
}