package lotto.domain;

import java.util.Map;

public class LottoResults {

    private final Map<Ranking, Integer> results;

    public LottoResults(Map<Ranking, Integer> results) {
        this.results = results;
    }

    public long totalWinnings() {
        return results.entrySet().stream()
                .mapToLong(entry -> entry.getKey().winnings(entry.getValue()))
                .sum();
    }

    public Map<Ranking, Integer> results() {
        return Map.copyOf(results);
    }
}
