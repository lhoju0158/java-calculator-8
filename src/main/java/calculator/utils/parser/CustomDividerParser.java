package calculator.utils.parser;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDividerParser implements DividerParser {
    private final List<Character> BASIC_DIVIDERS = Arrays.asList(new Character[]{',', ':'});
    private final Pattern VALID_DIVIDER_PATTERN = Pattern.compile("^(//([^\\d\\s])\\\\n)*$");
    private final Pattern DIVIDER_PATTERN = Pattern.compile("//([^\\d\\s])\\\\n");

    @Override
    public HashSet<Character> dividerParsing(String input) {
        HashSet<Character> dividers = new HashSet<>(BASIC_DIVIDERS);
        if (input.isEmpty()) {
            return dividers;
        }
        Matcher matcher = DIVIDER_PATTERN.matcher(input);
        while (matcher.find()) {
            dividers.add(matcher.group(1).charAt(0));
        }
        return dividers;
    }

    @Override
    public boolean isValid(String input) {
        if (VALID_DIVIDER_PATTERN.matcher(input).matches()) {
            return true;
        }
        return false;
    }
}
