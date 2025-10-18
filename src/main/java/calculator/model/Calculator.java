package calculator.model;

import java.math.BigDecimal;
import java.util.List;

public class Calculator {

    public BigDecimal add(List<BigDecimal> numbers) {
        return numbers.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
