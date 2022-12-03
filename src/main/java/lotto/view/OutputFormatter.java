package lotto.view;

import java.text.NumberFormat;
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
        stringJoiner.add(lottoTickets.numberOfLottoTickets() + "개를 구매했습니다.");

        lottoTickets.lottoTickets()
                .forEach(lotto -> stringJoiner.add(lotto.toString()));

        return stringJoiner.toString();
    }

    String resultsFormat(LottoResults lottoResults) {
        Map<Ranking, Integer> results = lottoResults.results();
        return results.entrySet().stream()
                .map(entry -> rankingFormat(entry.getKey()) + countFormat(entry.getValue()))
                .collect(Collectors.joining("\n"));
    }

    private String rankingFormat(Ranking ranking) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ranking.matchCount()).append("개 일치");

        if (ranking.isSecond()) {
            stringBuilder.append(", 보너스 볼 일치");
        }

        String formatForNumber = NumberFormat.getInstance().format(ranking.winnings());
        stringBuilder.append(" (").append(formatForNumber).append("원)");

        return stringBuilder.toString();
    }

    private String countFormat(Integer counts) {
        return " - " + counts + "개";
    }

    String rateOfReturnFormat(WinningStatistics winningStatistics) {
        return String.format("총 수익률은 %.1f%%입니다.", winningStatistics.rateOfReturn());
    }
}
