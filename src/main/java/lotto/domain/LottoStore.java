package lotto.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoStore {

    public static final int LOTTO_PRICE = 1_000;

    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoStore(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public LottoTickets lottoTickets(int money) {
        validateMoney(money);
        int numberOfLotto = money / LOTTO_PRICE;

        return new LottoTickets(
                IntStream.rangeClosed(1, numberOfLotto)
                        .mapToObj(i -> new Lotto(lottoNumberGenerator.lottoNumbers()))
                        .collect(Collectors.toList()));
    }

    private void validateMoney(int money) {
        validateZero(money);
        validate1000Units(money);
    }

    private void validateZero(int money) {
        if (isZero(money)) {
            throw new IllegalArgumentException("0원은 입력할 수 없습니다.");
        }
    }

    private boolean isZero(int money) {
        return money == 0;
    }

    private void validate1000Units(int money) {
        if (isNot1000Units(money)) {
            throw new IllegalArgumentException("로또 금액은 1,000원 단위로 입력되어야 합니다.");
        }
    }

    private boolean isNot1000Units(int money) {
        return money % LOTTO_PRICE != 0;
    }
}
