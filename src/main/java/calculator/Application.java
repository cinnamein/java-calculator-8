package calculator;

import calculator.controller.Orchestrator;

public class Application {
    public static void main(String[] args) {
        Orchestrator orchestrator = new Orchestrator();
        orchestrator.calculate();
    }
}
