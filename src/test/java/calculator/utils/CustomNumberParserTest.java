package calculator.utils;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.utils.parser.CustomNumberParser;
import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomNumberParserTest {
    private CustomNumberParser customNumberParser;
    private HashSet<Character> dividers;

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
        boolean isValid = customNumberParser.isValid(input);

        // then
        assertThat(isValid).isTrue();
        assertThat(resultNumbers).containsExactly(1, 2, 3);
    }

    @Test
    public void 수열_파싱_테스트_허용되지않은_구분자() {
        // given
        String input = "1+2+3";

        // when
        boolean isValid = customNumberParser.isValid(input);

        // then
        assertThat(isValid).isFalse();
    }

    @Test
    public void 수열_파싱_테스트_공백입력() {
        // given
        String input = "1,2,,3";

        // when
        List<Integer> resultNumbers = customNumberParser.numberParsing(input);
        boolean isValid = customNumberParser.isValid(input);

        // then
        assertThat(isValid).isTrue();
        assertThat(resultNumbers).containsExactly(1, 2, 3);
    }

    @Test
    public void 수열_파싱_테스트_음수입력() {
        // given
        String input = "-1,-2,-3";

        // when
        List<Integer> resultNumbers = customNumberParser.numberParsing(input);
        boolean isValid = customNumberParser.isValid(input);

        // then
        assertThat(isValid).isFalse();
    }

}
