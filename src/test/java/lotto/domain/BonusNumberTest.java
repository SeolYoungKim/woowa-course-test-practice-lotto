package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {

    @ParameterizedTest(name = "보너스 번호가 1~45가 아닌 숫자면 예외가 발생한다. 입력: {0}")
    @ValueSource(ints = {-1, 0, 46, 50})
    void createLottoByNumbersHasNotValidRange(int number) {
        assertThatThrownBy(() -> new BonusNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}