package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    static final int MIN_NUMBER_OF_LOTTO = 1;
    static final int MAX_NUMBER_OF_LOTTO = 45;
    static final int SIZE_OF_LOTTO_NUMBERS = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortedList(numbers);
    }

    private List<Integer> sortedList(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public boolean contains(BonusNumber bonusNumber) {
        return bonusNumber.isIn(numbers);
    }

    public int matchCounts(Lotto other) {
        return (int) numbers.stream()
                .filter(other.numbers::contains)
                .count();
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRangeOfNumbers(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != SIZE_OF_LOTTO_NUMBERS) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRangeOfNumbers(List<Integer> numbers) {
        long count = numbers.stream()
                .filter(this::isNotValidRange)
                .count();

        if (count != 0) {
            throw new IllegalArgumentException("숫자의 범위는 1~45여야 합니다.");
        }
    }

    private boolean isNotValidRange(Integer number) {
        return number < MIN_NUMBER_OF_LOTTO || MAX_NUMBER_OF_LOTTO < number;
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> setOfNumbers = new HashSet<>(numbers);
        if (setOfNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.");
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
