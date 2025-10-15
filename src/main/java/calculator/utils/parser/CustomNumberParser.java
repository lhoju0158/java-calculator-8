package calculator.utils.parser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomNumberParser implements NumberParser {
    private final Pattern validNumberPattern;
    private final Pattern numberPattern;

    public CustomNumberParser(HashSet<Character> dividers) {
        String validNumberPatternString = generateValidNumberPattern(dividers);
        this.validNumberPattern = Pattern.compile(validNumberPatternString);
        String SplitterPatternString = generateNumberPattern(dividers);
        this.numberPattern = Pattern.compile(SplitterPatternString);
    }

    @Override
    public List<Integer> numberParsing(String input) {
        List<Integer> result = new ArrayList<>();
        String[] numbers = numberPattern.split(input);
        for (String number : numbers) {
            if (!number.isEmpty()) {
                try {
                    result.add(Integer.parseInt(number));
                } catch (NumberFormatException e) {
                }
            }
        }
        return result;
    }

    @Override
    public boolean isValid(String input) {
        if (validNumberPattern.matcher(input).matches()) {
            return true;
        }

        return false;

    }

    private String generateValidNumberPattern(HashSet<Character> dividers) {
        StringBuilder result = new StringBuilder("^((\\d*[\\s");
        for (char divider : dividers) {
            result.append(divider);
        }
        result.append("])*\\d*)*$");
        return result.toString();
    }

    private String generateNumberPattern(HashSet<Character> dividers) {
        StringBuilder result = new StringBuilder();
        for (char divider : dividers) {
            result.append("|\\").append(divider);
        }
        result.deleteCharAt(0);
        return result.toString();
    }
}
