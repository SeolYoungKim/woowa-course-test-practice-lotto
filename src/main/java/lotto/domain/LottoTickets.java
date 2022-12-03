package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {

    private final List<Lotto> lottoTickets;

    public LottoTickets(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public LottoResults lottoResults(Lotto winningNumbers, BonusNumber bonusNumber) {
        EnumMap<Ranking, Integer> results = initiatedRankingMap();
        List<Ranking> rankingsForResult = rankingsForResult(winningNumbers, bonusNumber);
        addResults(results, rankingsForResult);

        return new LottoResults(results);
    }

    private EnumMap<Ranking, Integer> initiatedRankingMap() {
        EnumMap<Ranking, Integer> rankings = new EnumMap<>(Ranking.class);
        Arrays.stream(Ranking.values())
                .forEach(ranking -> rankings.put(ranking, 0));

        return rankings;
    }

    private List<Ranking> rankingsForResult(Lotto winningNumbers, BonusNumber bonusNumber) {
        return candidateForWinning(winningNumbers).stream()
                .map(lotto -> {
                    int counts = lotto.matchCounts(winningNumbers);
                    boolean hasBonusNumber = lotto.contains(bonusNumber);
                    return Ranking.ranking(counts, hasBonusNumber);
                })
                .collect(Collectors.toList());
    }

    private List<Lotto> candidateForWinning(Lotto winningNumbers) {
        return lottoTickets.stream()
                .filter(lotto -> lotto.matchCounts(winningNumbers) >= 3)
                .collect(Collectors.toList());
    }

    private void addResults(EnumMap<Ranking, Integer> result, List<Ranking> rankingsForResult) {
        rankingsForResult
                .forEach(ranking -> result.put(ranking, result.get(ranking) + 1));
    }
}
