package bridge.ui;

import bridge.domain.Error;

public class NumericError implements ErrorType{
    @Override
    public boolean condition(String input) {
        return !input.matches("[0-9]*");
    }

    @Override
    public Error errorType() {
        return Error.NUMERIC_ERROR;
    }
}
