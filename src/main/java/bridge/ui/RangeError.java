package bridge.ui;

import bridge.domain.Error;

public class RangeError implements ErrorType{
    @Override
    public boolean condition(String input) {
        int length = Integer.parseInt(input);
        return length < 3 || length > 20;
    }

    @Override
    public Error errorType() {
        return Error.LENGTH_ERROR;
    }
}
