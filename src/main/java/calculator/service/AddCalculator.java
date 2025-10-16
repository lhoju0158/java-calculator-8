package calculator.service;

import calculator.utils.parser.CustomDividerParser;
import calculator.utils.parser.CustomNumberParser;
import calculator.utils.parser.DividerParser;
import calculator.utils.parser.NumberParser;
import calculator.utils.splitter.CustomInputSplitter;
import calculator.utils.splitter.InputSplitter;
import java.util.List;

public class AddCalculatorService extends Calculator {
    public AddCalculatorService(List<Integer> numbers) {
        super(numbers);
    }

    @Override
    public Long calculate() {

    }

    public AddCalculatorService getAddCalculatorService(String input) {
        InputSplitter inputSplitter = new CustomInputSplitter();
        List<String> dividersAndNumbers = inputSplitter.split(input);
        String dividers = dividersAndNumbers.get(0);
        String numbers = dividersAndNumbers.get(1);
        DividerParser dividerParser = new CustomDividerParser();
        NumberParser numberParser = new CustomNumberParser(dividerParser.dividerParsing(dividers));
        List<Integer> inputs = numberParser.numberParsing(numbers);
        return new AddCalculatorService(inputs);
    }
}
