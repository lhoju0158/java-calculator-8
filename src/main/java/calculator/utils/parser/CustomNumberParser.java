package calculator.utils.parser;

import calculator.error.ErrorMessage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

public class CustomNumberParser implements NumberParser {
    private final Pattern validNumberPattern;
    private final Pattern numberPattern;
    private final Integer MAX_VALUE = 20000000;

    public CustomNumberParser(HashSet<Character> dividers) {
        String validNumberPatternString = generateValidNumberPattern(dividers);
        this.validNumberPattern = Pattern.compile(validNumberPatternString);
        String SplitterPatternString = generateNumberPattern(dividers);
        this.numberPattern = Pattern.compile(SplitterPatternString);
    }

    @Override
    public List<Integer> numberParsing(String input) {
        isValid(input);
        List<Integer> result = new ArrayList<>();
        String[] numbers = numberPattern.split(input);
        for (String numberString : numbers) {
            if (numberString.isEmpty()) {
                continue;
            }
            int number;
            try {
                number = Integer.parseInt(numberString);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorMessage.UNEXPECTED_NUMBERS.getMessage());
            }
            if (number > MAX_VALUE) {
                throw new IllegalArgumentException(ErrorMessage.OVER_VALID_MAX_VALUE.getMessage());
            }
            result.add(number);
        }
        return result;
    }

    private void isValid(String input) {
        if (!validNumberPattern.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBERS.getMessage());
        }
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
