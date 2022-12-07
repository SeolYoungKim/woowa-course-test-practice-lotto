package lotto.controller;

import lotto.domain.LottoResults;
import lotto.domain.LottoTickets;
import lotto.domain.WinningLotto;
import lotto.domain.WinningStatistics;
import lotto.dto.WinningNumbersDto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMachine {

    private static final String ERROR_PREFIX = "[ERROR] ";

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoMachine(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void lottery() {
        try {
            LottoTickets lottoTickets = lottoTickets();
            checkTheWinnings(lottoTickets);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_PREFIX + e.getMessage());
        }
    }

    private LottoTickets lottoTickets() {
        int money = inputView.money();
        LottoTickets lottoTickets = lottoService.lottoTickets(money);
        outputView.printLottoTickets(lottoTickets);

        return lottoTickets;
    }

    private void checkTheWinnings(LottoTickets lottoTickets) {
        WinningLotto winningLotto = winningLotto();
        LottoResults lottoResults = winningLotto.lottoResults(lottoTickets);
        WinningStatistics winningStatistics = lottoService.winningStatistics(lottoTickets,
                lottoResults);

        outputView.printResults(lottoResults, winningStatistics);
    }

    private WinningLotto winningLotto() {
        WinningNumbersDto winningNumbersDto = inputView.winningNumbers();
        int bonusNumber = inputView.bonusNumber();

        return lottoService.winningLotto(winningNumbersDto, bonusNumber);
    }
}
