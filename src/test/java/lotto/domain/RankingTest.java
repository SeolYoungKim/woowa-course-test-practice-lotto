package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class RankingTest {

    @ParameterizedTest(name = "SECOND 제외 | matchCount가{0}이면 Ranking.{1}을 반환한다.")
    @MethodSource("provideMatchCountAndRanking")
    void ofSuccess(int matchCount, Ranking expected) {
        Ranking actual = Ranking.of(matchCount);
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideMatchCountAndRanking() {
        return Stream.of(
                Arguments.of(3, Ranking.FIFTH),
                Arguments.of(4, Ranking.FORTH),
                Arguments.of(5, Ranking.THIRD),
                Arguments.of(6, Ranking.FIRST)
        );
    }

    @ParameterizedTest(name = "입력된 matchCount가 Ranking 상수들 중에 없으면 예외를 발생시킨다. 입력: {0}")
    @ValueSource(ints = {1, 2, 7})
    void ofFail(int illegalMatchCount) {
        assertThatThrownBy(() -> Ranking.of(illegalMatchCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("순위에 없습니다.");
    }
}