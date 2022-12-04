package lotto.view;

import static java.lang.String.format;

import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import lotto.domain.LottoResults;
import lotto.domain.LottoTickets;
import lotto.domain.Ranking;
import lotto.domain.WinningStatistics;

public class OutputFormatter {

    String lottoTicketsFormat(LottoTickets lottoTickets) {
        StringJoiner stringJoiner = new StringJoiner("\n");
        stringJoiner.add(format("%d개를 구매했습니다.", lottoTickets.numberOfLottoTickets()));

        lottoTickets.lottoTickets()
                .forEach(lotto -> stringJoiner.add(lotto.numbers().toString()));

        return stringJoiner.toString();
    }

    String resultsFormat(LottoResults lottoResults) {
        Map<Ranking, Integer> results = lottoResults.results();
        return results.entrySet().stream()
                .map(entry -> resultFormat(entry.getKey(), entry.getValue()))
                .collect(Collectors.joining("\n"));
    }

    private String resultFormat(Ranking ranking, Integer count) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(format("%d개 일치", ranking.matchCount()));

        if (ranking.isSecond()) {
            stringBuilder.append(", 보너스 볼 일치");
        }

        stringBuilder.append(format(" (%,d원) - %d개", ranking.winnings(), count));
        return stringBuilder.toString();
    }

    String rateOfReturnFormat(WinningStatistics winningStatistics) {
        return format("총 수익률은 %.1f%%입니다.", winningStatistics.rateOfReturn());
    }
}
