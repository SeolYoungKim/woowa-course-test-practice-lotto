package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.WinningNumbersDto;

public class InputView {
    public int money() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputValue = Console.readLine();
        validateThisIsNumber(inputValue);

        return Integer.parseInt(inputValue);
    }

    public WinningNumbersDto winningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputValue = Console.readLine();
        validateWinningNumberFormat(inputValue);

        return new WinningNumbersDto(inputValue);
    }

    public int bonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputValue = Console.readLine();
        validateThisIsNumber(inputValue);

        return Integer.parseInt(inputValue);

    }

    private void validateThisIsNumber(String input) {
        final String REGEX_FOR_NUMBER = "^\\d$";
        if (!input.matches(REGEX_FOR_NUMBER)) {
            throw new IllegalArgumentException("숫자만 입력해 주세요.");
        }
    }

    private void validateWinningNumberFormat(String inputValue) {
        final String REGEX_FOR_WINNING_NUMBER = "^(\\d+,){5}\\d+$";
        if (!inputValue.matches(REGEX_FOR_WINNING_NUMBER)) {
            throw new IllegalArgumentException("올바른 당첨 번호 포맷이 아닙니다.");
        }
    }
}
