package calculator;

import calculator.controller.AddCalculatorController;

public class Application {
    public static void main(String[] args) {
        AddCalculatorController addCalculatorController = new AddCalculatorController();
        addCalculatorController.start();
    }
}
