package lotto;

import lotto.controller.LottoMachine;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.LottoStore;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputFormatter;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine(
                new InputView(),
                new OutputView(new OutputFormatter()),
                new LottoService(new LottoStore(new LottoNumberGenerator()))
        );

        lottoMachine.lottery();
    }
}
