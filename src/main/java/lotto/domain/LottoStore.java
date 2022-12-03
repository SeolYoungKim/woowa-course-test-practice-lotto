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

        // 입력받은 금액에 맞는 개수만큼 로또를 발행
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
        if (money == 0) {
            throw new IllegalArgumentException("0원은 입력할 수 없습니다.");
        }
    }

    private void validate1000Units(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("로또 금액은 1,000원 단위로 입력되어야 합니다.");
        }
    }
}
