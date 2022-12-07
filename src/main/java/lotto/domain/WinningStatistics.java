package lotto.domain;

public class WinningStatistics {
    private final LottoTickets lottoTickets;
    private final LottoResults lottoResults;

    public WinningStatistics(LottoTickets lottoTickets, LottoResults lottoResults) {
        this.lottoTickets = lottoTickets;
        this.lottoResults = lottoResults;
    }

    public double rateOfReturn() {
        int numberOfLottoTickets = lottoTickets.numberOfLottoTickets();
        int totalPrice = numberOfLottoTickets * LottoStore.LOTTO_PRICE;
        long totalWinnings = lottoResults.totalWinnings();

        return (double) totalWinnings / totalPrice * 100;
    }
}
