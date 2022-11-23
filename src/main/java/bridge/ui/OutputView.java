package bridge.ui;

import bridge.service.BridgeGame;

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
    }

    private String drawBridge(String[] pathInfo, SetUpOrDown setUpOrDown) {
        String completeBridge = "";
        completeBridge = String.join("", "[ ", completeBridge);
        for (int i = 0; i < bridgeGame.getPointer(); i++) {
            completeBridge = String.join("", completeBridge, formatBridge(pathInfo[i], setUpOrDown.set(), i));
        }
        completeBridge = String.join("", completeBridge, " ]");
        return completeBridge;
    }

    /* 주어진 U 또는 D 에 대하여 만들어져 있는 다리와 비교하며 일치 여부를 검사한다.
     * 만약 일치한다면 그 자리에 프린트 해준다. 일치하지 않으면 공백으로 남긴다. */
    private String formatBridge(String bridgeState, String position, int location) {
        String step = " ";
        if (bridgeGame.getBridge().get(location).equals(position)) //
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
    public String printResult(String[] pathInfo, boolean passOrFail, int tryouts) {
        String result = String.format("최종 게임 결과\n" +
                printMap(pathInfo) + "\n\n" +
                        "게임 성공 여부: " +
                resultInKorean(passOrFail) + "\n" +
                "총 시도한 횟수: " + tryouts + "\n");

        System.out.println(result);
        return result;
    }

    private String resultInKorean(boolean passOrFail) {
        if (passOrFail) return "성공";
        return "실패";
    }

    public boolean printEndingOptions(boolean gameState, String retryOrQuit) {
        if (retryOrQuit.equals("Q")) {
            printResult(bridgeGame.getFeasibility(), gameState, bridgeGame.getCounter());
            return true;
        }
        if (retryOrQuit.equals("R")) {
            bridgeGame.retry();
        }
        return false;
    }
}
