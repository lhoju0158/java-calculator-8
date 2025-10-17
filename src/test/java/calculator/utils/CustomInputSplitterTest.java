package calculator.utils;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.utils.splitter.CustomInputSplitter;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CustomInputSplitterTest {
    private CustomInputSplitter splitter = new CustomInputSplitter();

    @Test
    public void 구분자_문자열_분리() {
        // given
        String input = "//;\\n1;2;3";

        // when
        List<String> result = splitter.split(input);

        // then
        assertThat(result).containsExactly("//;\\n", "1;2;3");
    }

    @Test
    public void 옳지_않은_입력_1() {
        // given
        String input = "1;2;3//;\\n";

        // when
        List<String> result = splitter.split(input);

        // then
        assertThat(result).containsExactly("1;2;3//;\\n", "");
    }

    @Test
    public void 옳지_않은_입력_2() {
        // given
        String input = "helloIAmDongju";

        // when
        List<String> result = splitter.split(input);

        // then
        assertThat(result).containsExactly("", "helloIAmDongju");
    }
}
