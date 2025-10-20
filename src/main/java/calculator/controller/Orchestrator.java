package calculator.controller;

import calculator.model.Calculator;
import calculator.model.StringParser;
import calculator.model.Validator;
import calculator.view.ConsoleView;
import java.math.BigDecimal;
import java.util.List;

public class Orchestrator {

    private final Validator validator;
    private final StringParser stringParser;
    private final Calculator calculator;

    public Orchestrator(
            Validator validator,
            Calculator calculator,
            StringParser stringParser
    ) {
        this.validator = validator;
        this.calculator = calculator;
        this.stringParser = stringParser;
    }

    public void calculate() {
        String input = new ConsoleView().consoleInput();
        BigDecimal result = BigDecimal.ZERO;
        if (validator.validateNotBlank(input)) {
            List<BigDecimal> numbers = stringParser.parse(input);
            result = calculator.add(numbers);
        }
        new ConsoleView().consoleOutput(result);
    }
}
