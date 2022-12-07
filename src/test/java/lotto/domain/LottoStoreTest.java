package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoStoreTest {

    private final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
    private LottoStore lottoStore;

    @BeforeEach
    void setUp() {
        lottoStore = new LottoStore(lottoNumberGenerator);
    }

    @DisplayName("0원을 입력하면 예외를 발생시킨다.")
    @Test
    void setLottoNumberGeneratorByZeroNumber() {
        final int zero = 0;
        assertThatThrownBy(() -> lottoStore.lottoTickets(zero))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0원은 입력할 수 없습니다.");
    }

    @ParameterizedTest(name = "1,000원으로 나누어 떨어지지 않는 금액이 입력되면 예외를 발생시킨다. 입력: {0}")
    @ValueSource(ints = {1100, 999, 9999})
    void generateLottoTicketsByNot1000Units(int money) {
        assertThatThrownBy(() -> lottoStore.lottoTickets(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 금액은 1,000원 단위로 입력되어야 합니다.");
    }
}