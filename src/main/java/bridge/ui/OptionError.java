package bridge.ui;

import bridge.domain.Error;

public class OptionError implements ErrorType{

    @Override
    public boolean condition(String input) {
        return !input.matches("[U|D]");
    }

    @Override
    public Error errorType() {
        return Error.INPUT_ERROR;
    }
}
