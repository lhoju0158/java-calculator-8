package calculator.utils;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.utils.parser.CustomDividerParser;
import java.util.HashSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomDividerParserTest {
    private CustomDividerParser customDividerParser;


    @BeforeEach
    public void setUp() {
        customDividerParser = new CustomDividerParser();
    }

    public boolean containBasicDividers(HashSet<Character> input) {
        if (input.contains(',') && input.contains(':')) {
            return true;
        }
        return false;
    }

    @Test
    public void 커스텀_구분자_테스트() {
        // given
        String input = "//;\\n";

        // when
        HashSet<Character> resultDividers = customDividerParser.dividerParsing(input);

        // then
        assertThat(customDividerParser.isValid(input)).isTrue();
        assertThat(containBasicDividers(resultDividers)).isTrue();
        assertThat(resultDividers).contains(';');
    }

    @Test
    public void 커스텀_구분자_2개이상_테스트() {
        // given
        String input = "//;\\n//+\\n";

        // when
        HashSet<Character> resultDividers = customDividerParser.dividerParsing(input);

        // then
        assertThat(customDividerParser.isValid(input)).isTrue();
        assertThat(containBasicDividers(resultDividers)).isTrue();
        assertThat(resultDividers).contains(';');
        assertThat(resultDividers).contains('+');
    }

    @Test
    public void 커스텀_구분자_숫자입력() {
        // given
        String input = "//5\\n";

        // when
        HashSet<Character> resultDividers = customDividerParser.dividerParsing(input);

        // then
        assertThat(customDividerParser.isValid(input)).isFalse();
    }

    @Test
    public void 커스텀_구분자_공백입력() {
        // given
        String input = "// \\n";

        // when
        HashSet<Character> resultDividers = customDividerParser.dividerParsing(input);

        // then
        assertThat(customDividerParser.isValid(input)).isFalse();
    }

    @Test
    public void 커스텀_구분자_지정안함() {
        // given
        String input = "";

        // when
        HashSet<Character> resultDividers = customDividerParser.dividerParsing(input);

        // then
        assertThat(customDividerParser.isValid(input)).isTrue();
    }

    @Test
    public void 커스텀_구분자_길이_2이상_입력() {
        // given
        String input = "//-+\\n";

        // when
        HashSet<Character> resultDividers = customDividerParser.dividerParsing(input);

        // then
        assertThat(customDividerParser.isValid(input)).isFalse();
    }

    @Test
    public void 커스텀_구분자_기본_구분자_재지정() {
        // given
        String input = "//:\\n";

        // when
        HashSet<Character> resultDividers = customDividerParser.dividerParsing(input);

        // then
        assertThat(customDividerParser.isValid(input)).isTrue();
        assertThat(containBasicDividers(resultDividers)).isTrue();
        assertThat(resultDividers.size()).isEqualTo(2);
    }
}
