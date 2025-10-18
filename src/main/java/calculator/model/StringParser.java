package calculator.model;

import calculator.constant.DelimiterConstant;
import java.util.regex.Matcher;

public class StringParser {

    public String[] parse(String input) {
        String[] delimiterAndNumbers = new String[2];
        if (input.startsWith("//") && input.contains("\\n")) {
            delimiterAndNumbers = parseDelimiter(input);
        }
        return delimiterAndNumbers;
    }

    private String[] parseDelimiter(String input) {
        Matcher matcher = DelimiterConstant.CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String numbers = matcher.group(2);
            validateCustomDelimiter(customDelimiter);
            return new String[]{customDelimiter, numbers};
        }
        return new String[]{null, input};
    }

    private void validateCustomDelimiter(String customDelimiter) {
        if (customDelimiter.isBlank()) {
            throw new IllegalArgumentException("커스텀 문자는 null이거나 공백일 수 없습니다.");
        }
        if (DelimiterConstant.INVALID_DELIMITER_CHARS.matcher(customDelimiter).find()) {
            throw new IllegalArgumentException("커스텀 문자는 .을 제외한 특수문자 혹은 알파벳으로만 구성될 수 있습니다.");
        }
    }
}
