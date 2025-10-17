package calculator.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.error.ErrorMessage;
import calculator.utils.parser.CustomNumberParser;
import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomNumberParserTest {
    private CustomNumberParser customNumberParser;
    private HashSet<Character> dividers;
    private final String EXPECTED_MESSAGE_1 = ErrorMessage.INVALID_NUMBERS.getMessage();
    private final String EXPECTED_MESSAGE_2 = ErrorMessage.UNEXPECTED_NUMBERS.getMessage();

    @BeforeEach
    public void setUp() {
        dividers = new HashSet<>();
        dividers.add(':');
        dividers.add(',');
        dividers.add(';');
        customNumberParser = new CustomNumberParser(dividers);
    }

    @Test
    public void 수열_파싱_테스트() {
        // given
        String input = "1;2:3";

        // when
        List<Integer> resultNumbers = customNumberParser.numberParsing(input);

        // then
        assertThat(resultNumbers).containsExactly(1, 2, 3);
    }

    @Test
    public void 수열_파싱_테스트_허용되지않은_구분자() {
        // given
        String input = "1+2+3";

        // when, then
        assertThatThrownBy(() -> customNumberParser.numberParsing(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXPECTED_MESSAGE_1);
    }

    @Test
    public void 수열_파싱_테스트_공백입력() {
        // given
        String input = "1,2,,3";

        // when
        List<Integer> resultNumbers = customNumberParser.numberParsing(input);

        // then
        assertThat(resultNumbers).containsExactly(1, 2, 3);
    }

    @Test
    public void 수열_파싱_테스트_띄어쓰기_입력() {
        // given
        String input = "1,2, ,3";

        // when, then
        assertThatThrownBy(() -> customNumberParser.numberParsing(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXPECTED_MESSAGE_2);
    }

    @Test
    public void 수열_파싱_테스트_음수입력() {
        // given
        String input = "-1,-2,-3";

        // when, then
        assertThatThrownBy(() -> customNumberParser.numberParsing(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXPECTED_MESSAGE_1);
    }

}
