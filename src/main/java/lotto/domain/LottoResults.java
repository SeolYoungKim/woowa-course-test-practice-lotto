package lotto.domain;

import java.util.Map;

public class LottoResults {

    private final Map<Ranking, Integer> results;

    public LottoResults(Map<Ranking, Integer> results) {
        this.results = results;
    }

    public Map<Ranking, Integer> results() {
        return Map.copyOf(results);
    }
}
