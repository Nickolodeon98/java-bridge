package bridge.ui;

import bridge.domain.Error;

public class EndingError implements ErrorType{

    @Override
    public boolean condition(String input) {
        return !input.matches("[R|Q]");
    }

    @Override
    public Error errorType() {
        return Error.ENDING_ERROR;
    }
}
