package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidateInputTest {
    @Test
    void validateCarNameBlank_유효성검사_성공_테스트() {
        String input = "red";

        Application.validateCarNameBlank(input);
    }

    @Test
    void validateCarNameBlank_유효성검사_실패_테스트() {
        String input = "";

        assertThatThrownBy(() -> Application.validateCarNameBlank(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateCarListInputBlank_유효성검사_성공_테스트() {
        List<String> inputList = Arrays.asList("red", "green", "blue");

        Application.validateCarListInputBlank(inputList);
    }

    @Test
    void validateCarListInputBlank_유효성검사_실패_테스트() {
        List<String> inputList = Arrays.asList("", "red", "green");

        assertThatThrownBy(() -> Application.validateCarListInputBlank(inputList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateCarNameLength_유효성검사_성공_테스트() {
        String input = "abcde";

        Application.validateCarNameLength(input);
    }

    @Test
    void validateCarNameLength_유효성검사_실패_테스트() {
        String input = "abcdef";

        assertThatThrownBy(() -> Application.validateCarNameLength(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateCarListInputLength_유효성검사_성공_테스트() {
        List<String> inputList = Arrays.asList("red", "green", "blue");

        Application.validateCarListInputLength(inputList);
    }

    @Test
    void validateCarListInputLength_유효성검사_실패_테스트() {
        List<String> inputList = Arrays.asList("red", "purple", "yellow");

        assertThatThrownBy(() -> Application.validateCarListInputLength(inputList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateCarListInputUnique_유효성검사_성공_테스트() {
        List<String> inputList = Arrays.asList("red", "green", "blue");

        Application.validateCarListInputUnique(inputList);
    }

    @Test
    void validateCarListInputUnique_유효성검사_실패_테스트() {
        List<String> inputList = Arrays.asList("red", "green", "red");

        assertThatThrownBy(() -> Application.validateCarListInputUnique(inputList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateCarListInput_유효성검사_성공_테스트() {
        String input = "red,green,blue";

        Application.validateCarListInput(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "red,", "red,yellow", "red,red,green"})
    void validateCarListInput_유효성검사_실패_테스트(String input) {
        assertThatThrownBy(() -> Application.validateCarListInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateNumber_유효성검사_성공_테스트() {
        String input = "32";

        Application.validateNumber(input);
    }

    @Test
    void validateNumber_유효성검사_실패_테스트() {
        String input = "red";

        assertThatThrownBy(() -> Application.validateNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validatePositiveNumber_유효성검사_성공_테스트() {
        String input = "32";

        Application.validatePositiveNumber(input);
    }

    @Test
    void validatePositiveNumber_유효성검사_실패_테스트() {
        String input = "-3";

        assertThatThrownBy(() -> Application.validatePositiveNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
