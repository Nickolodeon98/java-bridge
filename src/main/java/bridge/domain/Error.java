package bridge.domain;

public enum Error {
    ERROR("[ERROR]"),
    LENGTH_ERROR("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    INPUT_ERROR("알파벳 U 와 D 만 입력할 수 있습니다."),
    ENDING_ERROR("알파벳 R 과 Q 만 입력할 수 있습니다."),
    NUMERIC_ERROR("숫자만 입력할 수 있습니다.");

    private final String value;

    Error(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
