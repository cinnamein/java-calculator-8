package calculator.constant;

import java.util.regex.Pattern;

public class DelimiterConstant {

    private DelimiterConstant() {
    }

    public static final Pattern DEFAULT_DELIMITER_COMMA = Pattern.compile(",");
    public static final Pattern DEFAULT_DELIMITER_COLON = Pattern.compile(":");
    public static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("^//(.*?)\\\\n(.*)$");
    public static final Pattern INVALID_DELIMITER_CHARS = Pattern.compile("[0-9\\.]");
    public static final Pattern VALID_NUMBER_PATTERN = Pattern.compile("^-?\\d+(\\.\\d+)?$");
}
