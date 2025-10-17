package calculator.error;

public enum ErrorMessage {
    INVALID_DIVIDERS("유효하지 않은 구문자입니다."),
    INVALID_NUMBERS("유효하지 않은 수열입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
