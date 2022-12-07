package lotto.domain;

import static lotto.domain.Lotto.MAX_NUMBER_OF_LOTTO;
import static lotto.domain.Lotto.MIN_NUMBER_OF_LOTTO;

import java.util.List;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validateRangeOfNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateRangeOfNumber(int bonusNumber) {
        if (bonusNumber < MIN_NUMBER_OF_LOTTO || MAX_NUMBER_OF_LOTTO < bonusNumber) {
            throw new IllegalArgumentException("숫자의 범위는 1~45여야 합니다.");
        }
    }

    public boolean isIn(List<Integer> numbers) {
        return numbers.contains(bonusNumber);
    }
}
