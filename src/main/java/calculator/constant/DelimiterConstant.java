package calculator.constant;

import java.util.regex.Pattern;

public class DelimiterConstant {

    private DelimiterConstant() {}

    public static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("^//(.*?)\\\\n(.*)$");
    public static final Pattern INVALID_DELIMITER_CHARS = Pattern.compile("[0-9\\.]");
}
