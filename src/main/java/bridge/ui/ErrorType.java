package bridge.ui;

import bridge.domain.Error;

public interface ErrorType {
    boolean condition(String input);
    Error errorType();
}
