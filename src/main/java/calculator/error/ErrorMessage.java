package calculator.error;

public enum ErrorMessage {
    // number string error
    UNEXPECTED_NUMBERS("덧셈할 문자열은 숫자, 구분자만 포함되어야 합니다."),
    OVER_VALID_MAX_VALUE("최대 2억까지 입력 가능합니다. "),
    INVALID_NUMBERS("유효하지 않은 수열입니다."),

    // divider string error
    INVALID_DIVIDERS("유효하지 않은 구문자입니다."),
    OVER_VALID_DIVIDERS_NUMBER(":, ,를 포함한 구분자는 최대 10개까지 허용됩니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
