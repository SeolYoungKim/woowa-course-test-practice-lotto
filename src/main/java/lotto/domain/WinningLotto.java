package lotto.domain;

public class WinningLotto {

    private final Lotto winningNumbers;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto winningNumbers, BonusNumber bonusNumber) {
        validateDuplication(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoResults lottoResults(LottoTickets lottoTickets) {
        return lottoTickets.lottoResults(winningNumbers, bonusNumber);
    }

    private void validateDuplication(Lotto winningNumbers, BonusNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 숫자는 중복될 수 없습니다.");
        }
    }
}
