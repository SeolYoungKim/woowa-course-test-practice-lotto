package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "로또 번호가 1~45가 아닌 숫자가 포함되면 예외가 발생한다. 입력: {0}")
    @ValueSource(ints = {-1, 0, 46, 50})
    void createLottoByNumbersHasNotValidRange(int number) {
        assertThatThrownBy(() -> new Lotto(List.of(number, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "다른 로또와 매치되는 번호의 개수를 센다. 매치 개수: {1}")
    @MethodSource("provideOtherLotto")
    void matchCounts(Lotto other, int expected) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int actual = lotto.matchCounts(other);

        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideOtherLotto() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 6),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)), 5),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 8, 7)), 4),
                Arguments.of(new Lotto(List.of(1, 2, 3, 9, 8, 7)), 3),
                Arguments.of(new Lotto(List.of(1, 2, 10, 9, 8, 7)), 2),
                Arguments.of(new Lotto(List.of(1, 11, 10, 9, 8, 7)), 1),
                Arguments.of(new Lotto(List.of(12, 11, 10, 9, 8, 7)), 0)
        );
    }
}
