package lotto.domain;

import static camp.nextstep.edu.missionutils.Randoms.*;
import static lotto.domain.Lotto.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator {

    public List<Integer> randomNumbers() {
        List<Integer> randomNumbers = pickUniqueNumbersInRange(MIN_NUMBER_OF_LOTTO,
                MAX_NUMBER_OF_LOTTO, SIZE_OF_LOTTO_NUMBERS);

        return Collections.unmodifiableList(randomNumbers);
    }
}
