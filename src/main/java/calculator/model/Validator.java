package calculator.model;

public class Validator {

    public boolean validateNotBlank(String input) {
        return input != null && !input.isBlank();
    }
}
