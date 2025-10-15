package calculator.utils.parser;

import java.util.HashSet;

public interface DividerParser {
    public HashSet<Character> parse(String input);

    public boolean isValid(String input);
}
