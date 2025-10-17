package calculator.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.Test;

public class CustomCalculatorView implements CalculatorView {
    private final String INPUT_FORM = "덧셈할 문자열을 입력해 주세요.";
    private final String OUTPUT_FORM = "결과 : %d";

    @Override
    public String InputForm() {
        System.out.println(INPUT_FORM);
        return Console.readLine();
    }

    @Override
    public void OutputForm(Integer result) {
        System.out.printf(OUTPUT_FORM, result);
    }
}
