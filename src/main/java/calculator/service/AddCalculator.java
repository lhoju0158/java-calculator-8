package calculator.service;

import calculator.utils.parser.CustomDividerParser;
import calculator.utils.parser.CustomNumberParser;
import calculator.utils.parser.DividerParser;
import calculator.utils.parser.NumberParser;
import calculator.utils.splitter.CustomInputSplitter;
import calculator.utils.splitter.InputSplitter;
import java.util.List;

public class AddCalculator implements Calculator {
    private final InputSplitter inputSplitter;
    private final DividerParser dividerParser;

    public AddCalculator() {
        inputSplitter = new CustomInputSplitter();
        dividerParser = new CustomDividerParser();
    }

    @Override
    public Integer calculate(String input) {
        List<String> dividersAndNumbers = inputSplitter.split(input);
        String dividers = dividersAndNumbers.get(0);
        String numbers = dividersAndNumbers.get(1);
        NumberParser numberParser = new CustomNumberParser(dividerParser.dividerParsing(dividers));
        List<Integer> inputs = numberParser.numberParsing(numbers);
        return inputs.stream().mapToInt(Integer::valueOf).sum();
    }

}
