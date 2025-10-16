package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.error.ErrorMessage;
import calculator.service.AddCalculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AddCalculatorTest {
    private final Integer EXPECTED_RESULT = 6;
    private final String EXPECTED_DIVIDER_MESSAGE = ErrorMessage.INVALID_DIVIDERS.getMessage();
    private final String EXPECTED_NUMBER_MESSAGE = ErrorMessage.INVALID_NUMBERS.getMessage();
    private AddCalculator addCalculator;

    @BeforeEach
    public void setUp() {
        addCalculator = new AddCalculator();
    }

    @AfterEach
    public void tearDown() {
        addCalculator = null;
    }

    @Test
    public void 문자열_계산기_테스트() {
        // given
        String input = "//;\\n1;2;3";

        // when
        Integer result = addCalculator.calculate(input);

        // then
        assertThat(result).isEqualTo(EXPECTED_RESULT);
    }

    @Test
    public void 옳지_않은_순서() {
        // given
        String input = "1;2;3//;\\n";

        // when, then
        assertThatThrownBy(() -> addCalculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EXPECTED_DIVIDER_MESSAGE);
    }

    @Test
    public void 커스텀_길이_구문자_최대길이_초과() {
        // given
        String input = "//;*\\n1;2*3";

        // when, then
        assertThatThrownBy(() -> addCalculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EXPECTED_DIVIDER_MESSAGE);
    }

    @Test
    public void 커스텀_구분자_길이_2이상_입력() {
        // given
        String input = "//;\\n//*\\n1;2*3";

        // when
        Integer result = addCalculator.calculate(input);

        // then
        assertThat(result).isEqualTo(EXPECTED_RESULT);
    }

    @Test
    public void 커스텀_구분자_없는_입력() {
        // given
        String input = "1,2,3";

        // when
        Integer result = addCalculator.calculate(input);

        // then
        assertThat(result).isEqualTo(EXPECTED_RESULT);
    }

    @Test
    public void 커스텀_구분자로_숫자_입력() {
        // given
        String input = "//2\\n12223";

        // when, then
        assertThatThrownBy(() -> addCalculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EXPECTED_DIVIDER_MESSAGE);
    }

    @Test
    public void 커스텀_구분자로_공백_입력() {
        // given
        String input = "// \\n1 2 3";

        // when, then
        assertThatThrownBy(() -> addCalculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EXPECTED_DIVIDER_MESSAGE);
    }

    @Test
    public void 음수_수열_입력() {
        // given
        String input = "//-\\n1,-2,-3";

        // when
        Integer result = addCalculator.calculate(input);

        // then
        assertThat(result).isEqualTo(EXPECTED_RESULT);
    }

}
