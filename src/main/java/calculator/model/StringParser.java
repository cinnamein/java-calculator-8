package calculator.model;

import calculator.constant.DelimiterConstant;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringParser {

    public List<BigDecimal> parse(String input) {
        String[] delimiterAndNumbers = parseDelimiter(input);
        String finalDelimiter = getDelimiterRegex(delimiterAndNumbers[0]);
        return parseNumbers(finalDelimiter, delimiterAndNumbers[1]);
    }

    private String[] parseDelimiter(String input) {
        Matcher matcher = DelimiterConstant.CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String numbers = matcher.group(2);
            validateCustomDelimiter(customDelimiter);
            return new String[]{customDelimiter, numbers};
        }
        return new String[]{"", input};
    }

    private void validateCustomDelimiter(String customDelimiter) {
        if (customDelimiter.isBlank()) {
            throw new IllegalArgumentException("커스텀 문자는 null이거나 공백일 수 없습니다.");
        }
        if (DelimiterConstant.INVALID_DELIMITER_CHARS.matcher(customDelimiter).find()) {
            throw new IllegalArgumentException("커스텀 문자는 .을 제외한 특수문자 혹은 알파벳으로만 구성될 수 있습니다.");
        }
    }

    private String getDelimiterRegex(String customDelimiter) {
        String defaultDelimiters =
                DelimiterConstant.DEFAULT_DELIMITER_COMMA + "|" + DelimiterConstant.DEFAULT_DELIMITER_COLON;
        if (customDelimiter.isBlank()) {
            return defaultDelimiters;
        } else {
            return defaultDelimiters + "|" + Pattern.quote(customDelimiter);
        }
    }

    private List<BigDecimal> parseNumbers(String delimiters, String numbersString) {
        if (numbersString.isBlank()) {
            return List.of(BigDecimal.ZERO);
        }
        String[] numbers = numbersString.split(delimiters, -1);
        return Arrays.stream(numbers)
                .map(this::parseAndValidateToken)
                .collect(Collectors.toList());
    }

    private BigDecimal parseAndValidateToken(String token) {
        if (!DelimiterConstant.VALID_NUMBER_PATTERN.matcher(token).matches()) {
            throw new IllegalArgumentException("양수만 입력할 수 있습니다.");
        }
        BigDecimal number = new BigDecimal(token);
        if (number.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("양수만 입력할 수 있습니다.");
        }
        return number;
    }
}
