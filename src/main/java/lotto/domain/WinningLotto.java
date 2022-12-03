package lotto.domain;

import lotto.dto.WinningNumbersDto;

public class WinningLotto {

    private final Lotto winningNumbers;
    private final BonusNumber bonusNumber;

    public WinningLotto(WinningNumbersDto dto, BonusNumber bonusNumber) {
        this.winningNumbers = new Lotto(dto.winningNumbers());
        this.bonusNumber = bonusNumber;
    }
}
