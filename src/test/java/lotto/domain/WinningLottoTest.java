package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @DisplayName("당첨 번호 안에 보너스 숫자가 포함된 경우 예외를 발생시킨다.")
    @Test
    void createByWinningNumbersContainsBonusNumber() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(6);

        assertThatThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호와 보너스 숫자는 중복될 수 없습니다.");
    }
}