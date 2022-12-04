package lotto.domain;

import static lotto.domain.Lotto.LOTTO_MAX_NUMBER_INCLUSIVE;
import static lotto.domain.Lotto.LOTTO_MIN_NUMBER_INCLUSIVE;
import static lotto.domain.Lotto.LOTTO_NUMBER_COUNT;

import java.util.List;

public class WinningNumbers {

    private final List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        validateWinningNumbersSize(winningNumbers);
        validateWinningNumbersRange(winningNumbers);

        this.winningNumbers = winningNumbers;
    }

    private void validateWinningNumbersSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(
                    String.format("당첨번호의 개수는 %d여야 합니다.", LOTTO_NUMBER_COUNT));
        }
    }

    private void validateWinningNumbersRange(List<Integer> winningNumbers) {
        winningNumbers.forEach(this::validateWinningNumberRange);
    }

    private void validateWinningNumberRange(int winningNumber) {
        if (LOTTO_MIN_NUMBER_INCLUSIVE > winningNumber
                || winningNumber > LOTTO_MAX_NUMBER_INCLUSIVE) {
            throw new IllegalArgumentException(String.format("당첨번호는 %d부터 %d사이의 정수여야 합니다.",
                    LOTTO_MIN_NUMBER_INCLUSIVE, LOTTO_MAX_NUMBER_INCLUSIVE));
        }
    }

    public int matchCount(Lotto lotto) {
        return (int) winningNumbers.stream()
                .filter(lotto::contains)
                .count();
    }

    @Override
    public String toString() {
        return "WinningNumbers{" +
                "winningNumbers=" + winningNumbers +
                '}';
    }
}
