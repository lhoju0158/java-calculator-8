package calculator.utils.parser;

import java.util.HashSet;

public interface DividerParser {
    public HashSet<Character> dividerParsing(String input);

    public boolean isValid(String input);
}
