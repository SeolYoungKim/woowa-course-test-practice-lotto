package lotto.service;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoResults;
import lotto.domain.LottoStore;
import lotto.domain.LottoTickets;
import lotto.domain.WinningLotto;
import lotto.domain.WinningStatistics;
import lotto.dto.WinningNumbersDto;

public class LottoService {

    private final LottoStore lottoStore;

    public LottoService(LottoStore lottoStore) {
        this.lottoStore = lottoStore;
    }

    public LottoTickets lottoTickets(int money) {
        return lottoStore.lottoTickets(money);
    }

    public WinningLotto winningLotto(WinningNumbersDto dto, int bonusNumberInt) {
        Lotto lotto = new Lotto(dto.winningNumbers());
        BonusNumber bonusNumber = new BonusNumber(bonusNumberInt);

        return new WinningLotto(lotto, bonusNumber);
    }

    public WinningStatistics winningStatistics(LottoTickets lottoTickets,
            LottoResults lottoResults) {
        return new WinningStatistics(lottoTickets, lottoResults);
    }
}
