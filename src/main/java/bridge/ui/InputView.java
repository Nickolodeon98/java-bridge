package bridge.ui;

import bridge.domain.Error;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private void errorHandling(String input, ErrorType errorType) {
        if (errorType.condition(input)) {
            System.out.println(Error.ERROR.getValue() + " " + errorType.errorType().getValue());
            throw new IllegalArgumentException();
        }
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String size = Console.readLine();
        errorHandling(size, new NumericError());
        errorHandling(size, new RangeError());
        return Integer.parseInt(size);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String option = Console.readLine();
        errorHandling(option, new OptionError());
        return option;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String option = Console.readLine();
        errorHandling(option, new EndingError());
        return option;
    }
}
