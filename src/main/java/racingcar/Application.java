package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static void validateCarListInput(String input) {
        List<String> inputList = List.of(input.split(",", -1));
        validateCarListInputBlank(inputList);
        validateCarListInputLength(inputList);
        validateCarListInputUnique(inputList);
    }

    public static void validateCarListInputBlank(List<String> inputList) {
        for (String name : inputList) {
            validateCarNameBlank(name);
        }
    }

    public static void validateCarNameBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차의 이름은 비어있을 수 없습니다.");
        }
    }

    public static void validateCarListInputLength(List<String> inputList) {
        for (String name : inputList) {
            validateCarNameLength(name);
        }
    }

    public static void validateCarNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateCarListInputUnique(List<String> inputList) {
        Set<String> seen = new HashSet<>();
        for (String name : inputList) {
            if (seen.contains(name)) {
                throw new IllegalArgumentException();
            }
            seen.add(name);
        }
    }

    public static void validateAttemptInput(String input) {
        validatePositiveNumber(input);
    }

    public static void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void validatePositiveNumber(String input) {
        validateNumber(input);
        if (Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
