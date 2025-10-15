package calculator.utils.parser;

import java.util.List;

public interface NumberParser {
    public List<Integer> numberParsing(String input);

    public boolean isValid(String input);
}
