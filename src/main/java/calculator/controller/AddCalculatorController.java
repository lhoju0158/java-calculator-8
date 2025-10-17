package calculator.controller;

import calculator.service.AddCalculator;
import calculator.service.Calculator;
import calculator.view.CalculatorView;
import calculator.view.CustomCalculatorView;

public class AddCalculatorController {
    private final CalculatorView calculatorView;
    private final Calculator calculator;

    public AddCalculatorController() {
        this.calculatorView = new CustomCalculatorView();
        this.calculator = new AddCalculator();
    }

    public void start() {
        String input = calculatorView.InputForm();
        Integer result = calculator.calculate(input);
        calculatorView.OutputForm(result);
    }
}
