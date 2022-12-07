package lotto.view;

import lotto.domain.LottoResults;
import lotto.domain.LottoTickets;
import lotto.domain.WinningStatistics;

public class OutputView {

    private final OutputFormatter formatter;

    public OutputView(OutputFormatter formatter) {
        this.formatter = formatter;
    }

    public void printLottoTickets(LottoTickets lottoTickets) {
        System.out.println(formatter.lottoTicketsFormat(lottoTickets));
    }

    public void printResults(LottoResults lottoResults, WinningStatistics statistics) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(formatter.resultsFormat(lottoResults));  // 결과
        System.out.println(formatter.rateOfReturnFormat(statistics));  // 수익률
    }
}
