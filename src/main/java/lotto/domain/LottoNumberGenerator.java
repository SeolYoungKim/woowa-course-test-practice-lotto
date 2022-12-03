package lotto.domain;

import static camp.nextstep.edu.missionutils.Randoms.*;
import static lotto.domain.Lotto.*;

import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {

    public List<Integer> lottoNumbers() {
        List<Integer> randomNumbers = pickUniqueNumbersInRange(MIN_NUMBER_OF_LOTTO,
                MAX_NUMBER_OF_LOTTO, SIZE_OF_LOTTO_NUMBERS);

        return Collections.unmodifiableList(randomNumbers);
    }
}
