package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private final BridgeGame bridgeGame;

    public OutputView(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    interface SetUpOrDown {
        String set();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String printMap(String[] pathInfo) {
        String map = "";
        map = String.join("", map, drawBridge(pathInfo, () -> "U"));
        map = String.join("", map, "\n");
        map = String.join("", map, drawBridge(pathInfo, () -> "D"));
        return map;
//        System.out.println();
//        drawBridge(pathInfo, () -> "D");
    }

    private String drawBridge(String[] pathInfo, SetUpOrDown setUpOrDown) {
        String completeBridge = "";
//        System.out.print("[ ");
        completeBridge = String.join("", "[ ", completeBridge);
        for (int i = 0; i < bridgeGame.getPointer(); i++) {
            completeBridge = String.join("", completeBridge, formatBridge(pathInfo[i], setUpOrDown.set(), i));
//            System.out.print(formatBridge(pathInfo[i], setUpOrDown.set(), i));
//            System.out.println(completeBridge);
        }
        completeBridge = String.join("", completeBridge, " ]");
//        System.out.print(" ]");
//        System.out.println(completeBridge);
        return completeBridge;
    }

    private String formatBridge(String bridgeState, String position, int location) {
        String step = " ";

        if (bridgeGame.getBridge().get(location).equals(position))
            step = bridgeState;
        if (location != bridgeGame.getPointer() - 1)
            step = String.join("", step, " | ");

        return step;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
