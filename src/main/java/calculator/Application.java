package calculator;

import calculator.controller.Orchestrator;
import calculator.model.Calculator;
import calculator.model.StringParser;
import calculator.model.Validator;

public class Application {
    public static void main(String[] args) {
        Orchestrator orchestrator = new Orchestrator(
                new Validator(),
                new Calculator(),
                new StringParser()
        );
        orchestrator.calculate();
    }
}
