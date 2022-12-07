package lotto.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.domain.Lotto.MAX_NUMBER_OF_LOTTO;
import static lotto.domain.Lotto.MIN_NUMBER_OF_LOTTO;
import static lotto.domain.Lotto.SIZE_OF_LOTTO_NUMBERS;

import java.util.List;

public class LottoNumberGenerator {

    public List<Integer> lottoNumbers() {
        List<Integer> randomNumbers = pickUniqueNumbersInRange(MIN_NUMBER_OF_LOTTO,
                MAX_NUMBER_OF_LOTTO, SIZE_OF_LOTTO_NUMBERS);

        return List.copyOf(randomNumbers);
    }
}
