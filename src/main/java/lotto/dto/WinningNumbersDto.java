package lotto.dto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbersDto {

    private final List<Integer> winningNumbers;

    public WinningNumbersDto(String inputValue) {
        this.winningNumbers = winningNumbers(inputValue);
    }

    private List<Integer> winningNumbers(String inputValue) {
        return Arrays.stream(inputValue.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<Integer> winningNumbers() {
        return winningNumbers;
    }
}
